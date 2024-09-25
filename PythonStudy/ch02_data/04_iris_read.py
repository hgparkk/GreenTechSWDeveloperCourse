import pandas as pd

# sepal length : 꽃받침의 길이
# sepal width : 꽃받침의 너비
# petal length : 꽃잎의 길이
# petal width : 꽃잎의 너비
# iris class : 붓꽃의 종류

# csv 파일 읽기
df = pd.read_csv("../resources/iris.csv", header=None,  # 첫 행을 헤더로 쓰지 않는다
                 names=["sepal_length", "sepal_width", "petal_length", "petal_width",
                        "iris_class"])  # 데이터 프레임의 column 이름을 정한다.

print(df)

# iris-class 제외하고 따로 꺼내기
df_feature = df[["sepal_length", "sepal_width", "petal_length", "petal_width"]]
print(df_feature)

np_feature = df_feature.to_numpy()
np_feature = df_feature.values  # 위와 같음
print(np_feature)

# iris_class 숫자로 바꾸기
df.loc[df["iris_class"] == "Iris-setosa", "iris_class"] = 0
df.loc[df["iris_class"] == "Iris-versicolor", "iris_class"] = 1
df.loc[df["iris_class"] == "Iris-virginica", "iris_class"] = 2

print(df)

np_class = df["iris_class"].to_numpy()

print(np_class)
print(np_feature)

df.to_csv("../resources/after_iris.csv", index=False)
