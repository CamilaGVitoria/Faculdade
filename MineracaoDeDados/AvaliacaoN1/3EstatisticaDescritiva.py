import pandas as pd
from scipy import stats

retornos = pd.read_csv('retornos_mensais.csv', sep=';', parse_dates=['Date'])

acoes = retornos['Ação'].unique()

resultados = []

for acao in acoes:
    dados_acao = retornos[retornos['Ação'] == acao]['Retorno']

    media = dados_acao.mean()
    mediana = dados_acao.median()
    moda = dados_acao.mode()
    if not moda.empty:
        moda_valor = moda.iloc[0]
    else:
        moda_valor = None

    desvio_padrao = dados_acao.std()
    
    q1 = dados_acao.quantile(0.25)
    q2 = dados_acao.quantile(0.50)
    q3 = dados_acao.quantile(0.75)
    iqr = q3 - q1

    minimo = dados_acao.min()
    maximo = dados_acao.max()

    resultados.append({
        'Ação': acao,
        'Média': media,
        'Mediana': mediana,
        'Moda': moda_valor,
        'Desvio Padrão': desvio_padrao,
        'Q1': q1,
        'Q2 (Mediana novamente)': q2,
        'Q3': q3,
        'IQR (Q3 - Q1)': iqr,
        'Valor Mínimo': minimo,
        'Valor Máximo': maximo
    })

estatisticas_df = pd.DataFrame(resultados)

estatisticas_df.to_csv('estatisticas_descritivas.csv', sep=';', index=False)

print("Arquivo de estatísticas descritivas gerado com sucesso!")