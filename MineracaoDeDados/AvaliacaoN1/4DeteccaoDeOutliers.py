import pandas as pd

retornos = pd.read_csv('retornos_mensais.csv', sep=';', parse_dates=['Date'])

acoes = retornos['Ação'].unique()

outliers_lista = []

for acao in acoes:
    dados_acao = retornos[retornos['Ação'] == acao]

    q1 = dados_acao['Retorno'].quantile(0.25)
    q3 = dados_acao['Retorno'].quantile(0.75)
    iqr = q3 - q1

    limite_inferior = q1 - 1.5 * iqr
    limite_superior = q3 + 1.5 * iqr

    outliers = dados_acao[(dados_acao['Retorno'] < limite_inferior) | (dados_acao['Retorno'] > limite_superior)]

    for _, linha in outliers.iterrows():
        outliers_lista.append({
            'Data': linha['Date'].strftime('%Y-%m'),
            'Ação': linha['Ação'],
            'Retorno': linha['Retorno'],
            'Limite Inferior': limite_inferior,
            'Limite Superior': limite_superior
        })

outliers_df = pd.DataFrame(outliers_lista)

outliers_df.to_csv('outliers_retornos.csv', sep=';', index=False)

print("Arquivo de outliers gerado com sucesso!")
