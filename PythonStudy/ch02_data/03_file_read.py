import pandas as pd

# csv 파일 읽기
df = pd.read_csv("../resources/exchange.csv")
print(df)

# 상위 5개 보기
print(df.head())

# 상위 10개 보기
print(df.loc[:10])
print(df.iloc[:10]) # 0 부터 9 까지 (Index가 숫자가 아니여도 가능)
print(df.head(10))

# 하위 5개 보기
print(df.tail())

# 하위 10개 보기
print(df.tail(10))
print(df.loc[len(df)-10:])

# 각 환율에 대해 normalize (최소가 0 최대가 1로)

# 최대, 최소 값
print(df["KRW"].max())
print(df["KRW"].min())

# 모든 행 최댓값으로 나누기
df["KRW"] = (df["KRW"] - df["KRW"].min()) / (df["KRW"].max() - df["KRW"].min())
print(df)

df["VES"] = (df["VES"] - df["VES"].min()) / (df["VES"].max() - df["VES"].min())
df["JPY"] = (df["JPY"] - df["JPY"].min()) / (df["JPY"].max() - df["JPY"].min())
print(df)

#각 환율별 평균값 비교
print(df["KRW"].mean())
print(df["VES"].mean())
print(df["JPY"].mean())

df.to_csv("../resources/normal_exchange.csv", index=False) #index 를 저장하지 않는다