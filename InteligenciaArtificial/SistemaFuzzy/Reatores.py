import numpy as np
import matplotlib.pyplot as plt

# Função de pertinência triangular -> a - inicio da subida / b - ponto máximo (pertinencia 1) / c - fim da descida
def triangular(x, a, b, c):
    if x <= a or x >= c:
        return 0.0
    elif a < x < b:
        return (x - a) / (b - a)
    elif b < x < c:
        return (c - x) / (c - b)
    elif x == b:
        return 1.0
    return 0.0

# Dicionários Fuzzy  
conjuntos_entrada = {
    "Temperatura": {
        "Baixa": (0, 0, 50),
        "Media": (30, 60, 90),
        "Alta":  (70, 100, 100),
    },
    "Pressao": {
        "Baixa": (0, 0, 2),
        "Media": (1, 3, 5),
        "Alta":  (4, 6, 6),
    }
}

conjunto_saida = {
    "Fechada": (0, 0, 30),
    "Parcial": (20, 50, 80),
    "Total":   (70, 100, 100),
}

# Regras Fuzzy
regras = [
    ({"Temperatura": "Baixa", "Pressao": "Baixa"}, "Fechada"),
    ({"Temperatura": "Baixa", "Pressao": "Media"}, "Parcial"),
    ({"Temperatura": "Baixa", "Pressao": "Alta"}, "Parcial"),
    ({"Temperatura": "Media", "Pressao": "Baixa"}, "Parcial"),
    ({"Temperatura": "Media", "Pressao": "Media"}, "Parcial"),
    ({"Temperatura": "Media", "Pressao": "Alta"}, "Total"),
    ({"Temperatura": "Alta", "Pressao": "Baixa"}, "Parcial"),
    ({"Temperatura": "Alta", "Pressao": "Media"}, "Total"),
    ({"Temperatura": "Alta", "Pressao": "Alta"}, "Total"),
]


# Transformando valor real em grau de pertinencia
def fuzzificar(valor, conjuntos):
    return {nome: triangular(valor, *param) for nome, param in conjuntos.items()}

# Aplicando a regra fuzzy, calculando a força da regra fuzzy
def aplicar_regras(entradas_fuzz):
    saidas = {}
    for antecedente, consequente in regras:
        forcas = []
        for var, nome_conj in antecedente.items():
            grau = entradas_fuzz[var].get(nome_conj, 0)
            forcas.append(grau)
        forca_regra = min(forcas)
        saidas[consequente] = max(saidas.get(consequente, 0), forca_regra)
    return saidas

# (Centroide) Calcula o ponto central dos triângulos
def defuzzificar(saidas_ativadas, conjuntos_saida):
    num = 0
    den = 0
    for nome, grau in saidas_ativadas.items():
        a, b, c = conjuntos_saida[nome]
        centroide = (a + b + c) / 3
        num += grau * centroide
        den += grau
    return num / den if den != 0 else 0

# Gerando os gráficos, gera 500 valores de de x, calculando a pertinência de cada ponto usando a função triangular
def plotar_conjuntos(conjuntos, valor_real=None, titulo=""):
    x_vals = np.linspace(0, 100, 500)
    plt.figure(figsize=(6, 4))
    for nome, (a, b, c) in conjuntos.items():
        y = [triangular(x, a, b, c) for x in x_vals]
        plt.plot(x_vals, y, label=nome)
    if valor_real is not None:
        plt.axvline(valor_real, color='red', linestyle='--', label=f"Valor = {valor_real}")
    plt.title(titulo)
    plt.xlabel("Valor")
    plt.ylabel("Pertinência")
    plt.legend()
    plt.grid(True)
    plt.tight_layout()
    plt.show()

# Entrada
entrada_real = {
    "Temperatura": 85.0,
    "Pressao": 5.0
}

# Faz a fuzzificação das entradas reais transformando os números em graus fuzzy
entradas_fuzzificadas = {
    var: fuzzificar(valor, conjuntos_entrada[var])
    for var, valor in entrada_real.items()
}

# Aplica as regras fuzzy usando os graus das entradas
saidas_ativadas = aplicar_regras(entradas_fuzzificadas)

# Converte os resultados fuzzy da saída para um valor contínuo 
saida_final = defuzzificar(saidas_ativadas, conjunto_saida)

# Valor final da abertura da válvula
print(f"Abertura da válvula (0 a 100): {saida_final:.2f}")

# Geram gráficos
plotar_conjuntos(conjuntos_entrada["Temperatura"], entrada_real["Temperatura"], "Temperatura")
plotar_conjuntos(conjuntos_entrada["Pressao"], entrada_real["Pressao"], "Pressão")
plotar_conjuntos(conjunto_saida, saida_final, "Abertura da Válvula (Resultado)")