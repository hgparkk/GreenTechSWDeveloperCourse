import numpy as np
import pandas as pd
import matplotlib.pyplot as plt


# 두 배열의 오차(x 값에 대한 y의 값의 차이)를 제곱한 후 모두 더한 후 모두 더한 값을 배열의 길이로 나눈 후 리턴
def cal_diff(arr_a, arr_b):
    diff = 0
    for i in range(len(arr_a)):
        diff += (arr_a[i] - arr_b[i]) ** 2
    diff /= len(arr_a)
    return diff


# a에 대한 편미분
def cal_slope_a(a, b, arr_x, arr_y):
    slope = 0
    for i in range(len(arr_x)):
        slope += (2 * a * arr_x[i] ** 2) + (2 * arr_x[i] * b) - (2 * arr_x[i] * arr_y[i])
    slope /= len(arr_x)
    return slope


# b에 대한 편미분
def cal_slope_b(a, b, arr_x, arr_y):
    slope = 0
    for i in range(len(arr_x)):
        slope += b + (a * arr_x[i]) - arr_y[i]
    slope *= 2
    slope /= len(arr_x)
    return slope

xArray = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
yArray = np.array([1, 3, 6, 7, 8, 11, 14, 16, 17, 19])

# 초기 a, b 설정
a = -4
b = 4

# 학습 횟수
epoch = 200

# 기울기의 값을 줄여주는 보정치
learning_rate = 0.01

for i in range(epoch):
    slopeA = cal_slope_a(a,b,xArray,yArray)
    slopeB = cal_slope_b(a,b,xArray,yArray)
    a -= slopeA * learning_rate
    b -= slopeB * learning_rate

# 오차의 기울기에 가장 근접한 값
print(a)
print(b)

model_y = a * xArray + b

plt.scatter(xArray,yArray)
plt.plot(xArray,model_y, color="red")

plt.show()

print(a * 100 + b)