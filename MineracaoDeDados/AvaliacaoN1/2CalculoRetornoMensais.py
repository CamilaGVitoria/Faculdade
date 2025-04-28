import pandas as pd

dados = pd.read_csv('acoes_vale3_petr4.csv', sep=';', parse_dates=['Date'])

dados['VALE3_Close'] = pd.to_numeric(dados['VALE3_Close'], errors='coerce')
dados['PETR4_Close'] = pd.to_numeric(dados['PETR4_Close'], errors='coerce')

dados['VALE3_Retorno'] = dados['VALE3_Close'].pct_change(fill_method=None) * 100
dados['PETR4_Retorno'] = dados['PETR4_Close'].pct_change(fill_method=None) * 100

vale3_retorno = dados[['Date', 'VALE3_Retorno']].dropna()
vale3_retorno['Ação'] = 'VALE3'
vale3_retorno = vale3_retorno.rename(columns={'VALE3_Retorno': 'Retorno'})

petr4_retorno = dados[['Date', 'PETR4_Retorno']].dropna()
petr4_retorno['Ação'] = 'PETR4'
petr4_retorno = petr4_retorno.rename(columns={'PETR4_Retorno': 'Retorno'})

retornos = pd.concat([vale3_retorno, petr4_retorno], ignore_index=True)

retornos = retornos[['Date', 'Ação', 'Retorno']]

retornos.to_csv('retornos_mensais.csv', sep=';', index=False)

print("Arquivo de retornos gerado com sucesso!")
