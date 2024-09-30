import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import r2_score, mean_absolute_error

df = pd.read_csv("../resources/Family_Height_Data.csv")

parent = df[["Father", "Mother"]].to_numpy()
son = df["Son"].to_numpy()

x_train, x_test, y_train, y_test = train_test_split(parent, son, test_size=0.3)

model = LinearRegression()

model.fit(x_train, y_train)

y_test_pred = model.predict(x_test)

fig = plt.figure()
ax = fig.add_subplot(111,projection="3d")

father = parent[:,0]
mother = parent[:,1]
ax.scatter(father,mother,son)

ax.set_xlabel("father")
ax.set_ylabel("mothoer")
ax.set_zlabel("son")

print(model.predict([[175,165]]))

plt.show()

# r2 점수
r2 = r2_score(y_test, y_test_pred)
print(r2)

# 평균 절대 오차
mae = mean_absolute_error(y_test, y_test_pred)
print(mae)
