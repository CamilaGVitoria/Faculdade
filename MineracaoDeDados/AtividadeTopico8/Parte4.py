import pandas as pd
import matplotlib.pyplot as plt

# Carregar os dados
housing_df = pd.read_csv("california_housing_train.csv")

# Calcular os quartis da coluna 'median_income'
q1 = housing_df['median_income'].quantile(0.25)
q2 = housing_df['median_income'].quantile(0.50)
q3 = housing_df['median_income'].quantile(0.75)

# Discretização com pd.cut() usando os quartis
housing_df['faixa_renda'] = pd.cut(
    housing_df['median_income'],
    bins=[-float('inf'), q1, q2, q3, float('inf')],
    labels=['Baixa renda', 'Média-baixa', 'Média-alta', 'Alta renda']
)

# Exibir amostra dos dados com a nova coluna
print("\nAmostra com faixa de renda:")
print(housing_df[['median_income', 'faixa_renda']].head())

# Gráfico de barras
plt.figure(figsize=(8, 5))
housing_df['faixa_renda'].value_counts().sort_index().plot(kind='bar', color='skyblue')
plt.title('Distribuição de Casas por Faixa de Renda')
plt.xlabel('Faixa de Renda')
plt.ylabel('Número de Casas')
plt.grid(axis='y', linestyle='--', alpha=0.7)
plt.tight_layout()
plt.show()
