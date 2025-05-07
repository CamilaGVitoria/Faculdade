import numpy as np
import skfuzzy as fuzz
import matplotlib.pyplot as plt

# Funções de pertinência para temperatura
temp_baixa = fuzz.trapmf(np.arange(250, 335, 0.1), [250, 250, 270, 290])
temp_media = fuzz.trimf(np.arange(250, 335, 0.1), [270, 290, 310])
temp_alta = fuzz.trapmf(np.arange(250, 335, 0.1), [290, 310, 335, 335])

# Funções de pertinência para pressão
pressao_baixa = fuzz.trapmf(np.arange(14.5, 16.2, 0.1), [14.5, 14.5, 15.0, 15.5])
pressao_media = fuzz.trimf(np.arange(14.5, 16.2, 0.1), [15.0, 15.5, 16.0])
pressao_alta = fuzz.trapmf(np.arange(14.5, 16.2, 0.1), [15.5, 16.0, 16.2, 16.2])

# Funções de pertinência para fluxo
fluxo_baixo = fuzz.trapmf(np.arange(0, 10, 0.1), [0, 0, 2, 4])
fluxo_medio = fuzz.trimf(np.arange(0, 10, 0.1), [2, 4, 6])
fluxo_alto = fuzz.trapmf(np.arange(0, 10, 0.1), [4, 6, 8, 10])

# Função para fuzzificar os valores de entrada
def fuzzificar(temperatura_entrada, pressao_entrada):
    temp_level_baixa = fuzz.interp_membership(np.arange(250, 335, 0.1), temp_baixa, temperatura_entrada)
    temp_level_media = fuzz.interp_membership(np.arange(250, 335, 0.1), temp_media, temperatura_entrada)
    temp_level_alta = fuzz.interp_membership(np.arange(250, 335, 0.1), temp_alta, temperatura_entrada)

    pressao_level_baixa = fuzz.interp_membership(np.arange(14.5, 16.2, 0.1), pressao_baixa, pressao_entrada)
    pressao_level_media = fuzz.interp_membership(np.arange(14.5, 16.2, 0.1), pressao_media, pressao_entrada)
    pressao_level_alta = fuzz.interp_membership(np.arange(14.5, 16.2, 0.1), pressao_alta, pressao_entrada)

    return (temp_level_baixa, temp_level_media, temp_level_alta,
            pressao_level_baixa, pressao_level_media, pressao_level_alta)

# Função para aplicar as regras fuzzy e calcular a saída
def inferencia(temp_level_baixa, temp_level_media, temp_level_alta, 
               pressao_level_baixa, pressao_level_media, pressao_level_alta):
    # Aplicando as regras de inferência fuzzy
    fluxo_baixo_level = np.fmin(temp_level_alta, pressao_level_baixa)
    fluxo_medio_level = np.fmin(temp_level_media, pressao_level_media)
    fluxo_alto_level = np.fmin(temp_level_baixa, pressao_level_alta)

    # Combinando as funções de pertinência do fluxo
    fluxo_combined = np.fmax(np.fmax(fluxo_baixo * fluxo_baixo_level, fluxo_medio * fluxo_medio_level), fluxo_alto * fluxo_alto_level)

    return fluxo_combined

# Função para defuzzificar a saída
def defuzzificar(fluxo_combined):
    fluxo_ideal = fuzz.defuzz(np.arange(0, 10, 0.1), fluxo_combined, 'centroid')
    return fluxo_ideal

# Função para gerar o gráfico
def gerar_grafico(temperatura_entrada, pressao_entrada, fluxo_ideal):
    plt.figure(figsize=(10, 8))

    # Gráfico para temperatura
    plt.subplot(3, 1, 1)
    plt.plot(np.arange(250, 335, 0.1), temp_baixa, label='Temperatura Baixa')
    plt.plot(np.arange(250, 335, 0.1), temp_media, label='Temperatura Média')
    plt.plot(np.arange(250, 335, 0.1), temp_alta, label='Temperatura Alta')
    plt.axvline(x=temperatura_entrada, color='r', linestyle='--', label=f'Temperatura Entrada: {temperatura_entrada}')
    plt.title('Funções de Pertinência - Temperatura')
    plt.xlabel('Temperatura (°C)')
    plt.ylabel('Pertinência')
    plt.legend()

    # Gráfico para pressão
    plt.subplot(3, 1, 2)
    plt.plot(np.arange(14.5, 16.2, 0.1), pressao_baixa, label='Pressão Baixa')
    plt.plot(np.arange(14.5, 16.2, 0.1), pressao_media, label='Pressão Média')
    plt.plot(np.arange(14.5, 16.2, 0.1), pressao_alta, label='Pressão Alta')
    plt.axvline(x=pressao_entrada, color='r', linestyle='--', label=f'Pressão Entrada: {pressao_entrada}')
    plt.title('Funções de Pertinência - Pressão')
    plt.xlabel('Pressão (MPa)')
    plt.ylabel('Pertinência')
    plt.legend()

    # Gráfico para fluxo
    plt.subplot(3, 1, 3)
    plt.plot(np.arange(0, 10, 0.1), fluxo_baixo, label='Fluxo Baixo')
    plt.plot(np.arange(0, 10, 0.1), fluxo_medio, label='Fluxo Médio')
    plt.plot(np.arange(0, 10, 0.1), fluxo_alto, label='Fluxo Alto')
    plt.axvline(x=fluxo_ideal, color='r', linestyle='--', label=f'Fluxo Ideal: {fluxo_ideal:.2f}')
    plt.title('Funções de Pertinência - Fluxo de Controle')
    plt.xlabel('Fluxo')
    plt.ylabel('Pertinência')
    plt.legend()

    plt.tight_layout()
    plt.show()

def sistema_fuzzy(temperatura_entrada, pressao_entrada):
    # Fuzzificação dos valores de entrada
    temp_level_baixa, temp_level_media, temp_level_alta, pressao_level_baixa, pressao_level_media, pressao_level_alta = fuzzificar(temperatura_entrada, pressao_entrada)

    # Inferência fuzzy - cálculo da saída
    fluxo_combined = inferencia(temp_level_baixa, temp_level_media, temp_level_alta, pressao_level_baixa, pressao_level_media, pressao_level_alta)

    # Defuzzificação - cálculo do valor ideal de fluxo
    fluxo_ideal = defuzzificar(fluxo_combined)

    # Exibindo a saída
    print(f"Temperatura de entrada: {temperatura_entrada}")
    print(f"Pressão de entrada: {pressao_entrada}")
    print(f"Fluxo de vazão calculado: {fluxo_ideal:.2f} unidades")

    # Gráficos
    gerar_grafico(temperatura_entrada, pressao_entrada, fluxo_ideal)

temperatura_entrada = 300 
pressao_entrada = 15.3  

# Rodando o sistema fuzzy
sistema_fuzzy(temperatura_entrada, pressao_entrada)
