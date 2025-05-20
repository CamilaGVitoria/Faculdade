import pandas as pd

# base de dados
economy_df = pd.read_csv("Economy_of_US_na.csv")

# total de valores ausentes
print("Valores ausentes por coluna:\n")
print(economy_df.isnull().sum())

# Estratégia 1: Preenchimento com a média (somente colunas numéricas)
filled_mean_df = economy_df.fillna(economy_df.mean(numeric_only=True))

# Exemplo após preenchimento
print("\nDados com preenchimento pela média (primeiras linhas):\n")
print(filled_mean_df.head())

# Estratégia 2: Remoção de linhas com muitos valores ausentes
# Mantém apenas as linhas com pelo menos 2 valores não nulos
dropped_rows_df = economy_df.dropna(thresh=2)

# Exemplo após remoção
print("\nDados após remoção de linhas com muitos valores ausentes:\n")
print(dropped_rows_df.head())