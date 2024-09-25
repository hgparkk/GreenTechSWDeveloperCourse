import pandas as pd

# 별도의 파라미터가 없다면 첫 번째 sheet를 가져온다
# 다른 sheet를 불러오고 싶다면 sheet_name = " sheet 이름 "을 추가한다.
df = pd.read_excel("../resources/people_size.xlsx", sheet_name="8차 직접")

print(df)

df = df.loc[6:]

print(df)

print(df[["Unnamed: 16", "Unnamed: 136"]])

df_use = df[["Unnamed: 16", "Unnamed: 136"]]

# 컬럼명 변경
df_use = df_use.rename(columns={"Unnamed: 16": "height", "Unnamed: 136": "foot_size"})

print(df_use)

df_use["height"] = df_use["height"] / 10

print(df_use)

# df_use.to_csv("../resources/height_foot_size.csv", index=False)

df_use = df[["Unnamed: 3", "Unnamed: 16", "Unnamed: 129", "Unnamed: 136"]]

df_use = df_use.rename(
    columns={"Unnamed: 3": "gender", "Unnamed: 16": "height", "Unnamed: 129": "hand_size", "Unnamed: 136": "foot_size"})

df_use.loc[df_use["gender"] == "M", "gender"] = 1
df_use.loc[df_use["gender"] == "F", "gender"] = 0
df_use["height"] = df_use["height"] / 10

print(df_use)

df_use.to_csv("../resources/gender_height_hand_foot_size.csv", index=False)
