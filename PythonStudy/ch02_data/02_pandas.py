import numpy as np
import pandas as pd

df = pd.DataFrame(columns=['mem_id', 'mem_password', 'mem_name', 'mem_phone'])

print(df)

df.loc[0] = ['a001', '123a', '호빵맨', '01000000000']
df.loc[1] = ('b001', '123b', '찐빵맨', '01000000000')
df.loc[2] = np.array(['c001', '123c', '식빵맨', '01000000000'])

print(df)

# 특정 행에 접근
print(df.loc[1])

# 특정 행의 컬럼에 접근
print(df.loc[1]['mem_name'])

# 특정 컬럼에 접근
print(df["mem_name"])

# 특정 컬럼에 인덱스에 접근
print(df["mem_name"][1])  # 컬럼이 하나일 때만 가능
print(df["mem_name"].loc[1])

# 두 개 이상의 컬럼에 접근
print(df[["mem_id", "mem_name"]])
print(df[["mem_id", "mem_name"]].loc[1])

# 딕셔너리로 df 만들기
v_dict = {
    "mem_id": ["a001", "b001", "c001"],
    "mem_pw": ("123a", "123b", "123c"),
    "mem_name": np.array(["호빵맨", "찐빵맨", "식빵맨"])
}

df = pd.DataFrame(v_dict)

print(df)

print(len(df))

# 데이터 추가
df.loc[len(df)] = ["d001", "123d", "꿀빵맨"]
df.loc[len(df)] = ["e001", "123e", "건빵맨"]
print(df)

# 데이터 수정
df.loc[3]["mem_pw"] = "111d"
print(df)

df.loc[4, "mem_pw"] = "111e"
print(df)

# 컬럼 추가하기
df["score"] = 0
print(df)

df["age"] = [20, 21, 22, 23, 20]  # 리스트의 길이를 df 수와 맞아야 한다.
print(df)

# 특정 행 제거
df = df.drop(2)  # 인덱스가 비게된다
print(df)

# 인덱스 재설정
df.reset_index(drop=True, inplace=True)
print(df)

# 조건에 맞는 데이터만 남기기
df_filtered = df[df["age"] >= 21]
print(df_filtered)

# 조건에 따른 데이터 수정
df.loc[df["age"]==20, "score"]=100
df.loc[df["age"]>20, "score"]=80

print(df)
