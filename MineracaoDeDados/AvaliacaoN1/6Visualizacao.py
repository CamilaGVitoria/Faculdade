import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

retornos = pd.read_csv('retornos_mensais.csv', sep=';', parse_dates=['Date'])

import os
if not os.path.exists('graficos'):
    os.makedirs('graficos')

plt.figure(figsize=(10, 6))
sns.boxplot(x='Ação', y='Retorno', data=retornos)
plt.title('Boxplot dos Retornos Mensais - VALE3 vs PETR4')
plt.ylabel('Retorno (%)')
plt.grid(True)
plt.savefig('graficos/boxplot_retornos.png')
plt.close()

vale3 = retornos[retornos['Ação'] == 'VALE3']['Retorno']
petr4 = retornos[retornos['Ação'] == 'PETR4']['Retorno']

plt.figure(figsize=(10, 6))
sns.histplot(vale3, bins=30, kde=True, color='blue')
plt.title('Histograma dos Retornos Mensais - VALE3')
plt.xlabel('Retorno (%)')
plt.ylabel('Frequência')
plt.grid(True)
plt.savefig('graficos/histograma_vale3.png')
plt.close()

plt.figure(figsize=(10, 6))
sns.histplot(petr4, bins=30, kde=True, color='green')
plt.title('Histograma dos Retornos Mensais - PETR4')
plt.xlabel('Retorno (%)')
plt.ylabel('Frequência')
plt.grid(True)
plt.savefig('graficos/histograma_petr4.png')
plt.close()

retornos_pivot = retornos.pivot(index='Date', columns='Ação', values='Retorno')

retornos_acumulados = (1 + retornos_pivot/100).cumprod()

plt.figure(figsize=(12, 8))
plt.plot(retornos_acumulados.index, retornos_acumulados['VALE3'], label='VALE3', color='blue')
plt.plot(retornos_acumulados.index, retornos_acumulados['PETR4'], label='PETR4', color='green')
plt.title('Evolução Acumulada dos Retornos Mensais')
plt.xlabel('Data')
plt.ylabel('Retorno Acumulado')
plt.legend()
plt.grid(True)
plt.savefig('graficos/evolucao_acumulada.png')
plt.close()

print("Todos os gráficos foram gerados e salvos na pasta 'graficos'!")