import pandas as pd

# base de dados
housing_df = pd.read_csv("california_housing_train.csv")

# colunas
cols = ['median_income', 'median_house_value', 'housing_median_age']

# calcular as estatísticas e detectar outliers
def analyze_column(data, col):
    stats = {
        'mean': data[col].mean(),
        'median': data[col].median(),
        'mode': data[col].mode().iloc[0],
        'std': data[col].std(),
        'min': data[col].min(),
        'max': data[col].max(),
        'Q1': data[col].quantile(0.25),
        'Q2': data[col].quantile(0.50),
        'Q3': data[col].quantile(0.75)
    }
    stats['IQR'] = stats['Q3'] - stats['Q1']
    
    # Cálculo dos limites para outliers
    lower_bound = stats['Q1'] - 1.5 * stats['IQR']
    upper_bound = stats['Q3'] + 1.5 * stats['IQR']
    
    # Contagem de outliers
    outliers = data[(data[col] < lower_bound) | (data[col] > upper_bound)]
    stats['outliers_count'] = outliers.shape[0]
    
    return pd.Series(stats)

# Aplicando a função a cada coluna e compilarando os resultados em um DataFrame
analysis_results = pd.DataFrame({col: analyze_column(housing_df, col) for col in cols})

analysis_results = analysis_results.T

# resultado
print("\nAnálise Estatística e Detecção de Outliers:\n")
print(analysis_results)
