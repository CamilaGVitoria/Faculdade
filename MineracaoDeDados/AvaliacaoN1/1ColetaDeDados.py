import yfinance as yf
import pandas as pd

start_date = '2014-01-01'
end_date = '2024-01-01'

vale3 = yf.download('VALE3.SA', start=start_date, end=end_date, interval='1mo')
petr4 = yf.download('PETR4.SA', start=start_date, end=end_date, interval='1mo')

vale3_close = vale3[['Close']].rename(columns={'Close': 'VALE3_Close'})
petr4_close = petr4[['Close']].rename(columns={'Close': 'PETR4_Close'})

dados = pd.concat([vale3_close, petr4_close], axis=1)

dados = dados.reset_index() 

dados.to_csv('acoes_vale3_petr4.csv', sep=';', index=False)

print("Arquivo CSV gerado com sucesso!")
import yfinance as yf
import pandas as pd

start_date = '2014-01-01'
end_date = '2024-01-01'

vale3 = yf.download('VALE3.SA', start=start_date, end=end_date, interval='1mo')
petr4 = yf.download('PETR4.SA', start=start_date, end=end_date, interval='1mo')

vale3_close = vale3[['Close']].rename(columns={'Close': 'VALE3_Close'})
petr4_close = petr4[['Close']].rename(columns={'Close': 'PETR4_Close'})

dados = pd.concat([vale3_close, petr4_close], axis=1)

dados = dados.reset_index() 

dados.to_csv('acoes_vale3_petr4.csv', sep=';', index=False)

print("Arquivo CSV gerado com sucesso!")
