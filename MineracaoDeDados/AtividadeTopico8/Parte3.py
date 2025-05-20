import pandas as pd

nov2temp_df = pd.read_csv("Nov2Temp.csv")

# Amostragem de 15% dos dados, sem reposição
sample_sem_reposicao = nov2temp_df.sample(frac=0.15, replace=False, random_state=42)

# Amostragem de 20% dos dados, com reposição
sample_com_reposicao = nov2temp_df.sample(frac=0.20, replace=True, random_state=42)

# tamanhos das amostras
print(f"Tamanho total da base original: {len(nov2temp_df)}")
print(f"Amostra 15% (sem reposição): {len(sample_sem_reposicao)} linhas")
print(f"Amostra 20% (com reposição): {len(sample_com_reposicao)} linhas")

# Visualizar algumas linhas de cada amostra
print("\nAmostra sem reposição (15%):")
print(sample_sem_reposicao.head())

print("\nAmostra com reposição (20%):")
print(sample_com_reposicao.head())
