import pandas as pd
from scipy import stats

retornos = pd.read_csv('retornos_mensais.csv', sep=';', parse_dates=['Date'])

vale3_retornos = retornos[retornos['Ação'] == 'VALE3']['Retorno']
petr4_retornos = retornos[retornos['Ação'] == 'PETR4']['Retorno']

t_stat, p_value = stats.ttest_ind(vale3_retornos, petr4_retornos, equal_var=False)  # Welch's t-test

if p_value < 0.05:
    interpretacao = "Rejeitamos H₀: Existe diferença significativa entre os retornos médios."
else:
    interpretacao = "Não rejeitamos H₀: Não há evidência de diferença significativa entre os retornos médios."

resultado = {
    'Estatística t': t_stat,
    'Valor-p': p_value,
    'Conclusão': interpretacao
}

resultado_df = pd.DataFrame([resultado])

resultado_df.to_csv('resultado_tteste.csv', sep=';', index=False)

print("Arquivo de resultado do t-teste gerado com sucesso!")
