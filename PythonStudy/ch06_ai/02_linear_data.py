import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

df = pd.read_csv("../resources/gender_height_hand_foot_size.csv")

height = df["height"].to_numpy()
foot_size = df["foot_size"].to_numpy()

plt.scatter(height, foot_size)

height = height.reshape(-1, 1)

model = LinearRegression()

model.fit(height, foot_size)

x_pred = np.linspace(min(height) - 10, max(height) + 10, 8)
x_pred = x_pred.reshape(-1, 1)
y_pred = model.predict(x_pred)

plt.plot(x_pred, y_pred, color="red")

# 보통 7 ~ 80 % 만 학습시키고
# 남은 데이터로 정확도 체크를 한다.
from sklearn.model_selection import train_test_split

x_train, x_test, y_train, y_test = train_test_split(height, foot_size, test_size=0.3)

# 정확도 체크
model.fit(x_train, y_train)

y_test_pred = model.predict(x_test)

from sklearn.metrics import r2_score, mean_absolute_error

# r2 점수
r2 = r2_score(y_test, y_test_pred)
print(r2)

# 평균 절대 오차
mae = mean_absolute_error(y_test, y_test_pred)
print(mae)

plt.show()
