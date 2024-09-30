# 선형회귀 머신러닝 라이브러리 (사이킷 런)
from sklearn.linear_model import LinearRegression
import numpy as np
import matplotlib.pyplot as plt

xArray = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
yArray = np.array([1, 3, 6, 7, 8, 11, 14, 16, 17, 19])

# 선형회귀 객체 생성
model = LinearRegression()

xArray = xArray.reshape(-1, 1)
yArray = yArray.reshape(-1, 1)

# 학습시작, 모델 생성
model.fit(xArray, yArray)

x = np.array([5, 6, 100])
x = x.reshape(-1, 1)

y_pred = model.predict(x)

x = np.arange(11)
x = x.reshape(-1, 1)
y_pred = model.predict(x)

plt.scatter(xArray, yArray)
plt.plot(x, y_pred, color="red")

plt.show()
