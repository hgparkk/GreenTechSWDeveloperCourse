import matplotlib.pyplot as plt
import numpy as np

xArray = np.arange(10)
yArray = 2 * xArray + 1

# 그래프 사이즈 변경
plt.figure(figsize=(5, 7))

# 선 색 주기
# 각 데이터 이름표 설정
plt.plot(xArray, yArray, color="#FF0000", label="2023")

# 그래프 틱
plt.xticks(np.arange(max(xArray) + 2))
plt.yticks(np.arange(0, max(yArray) + 2, 2))

# 그래프 그리드
plt.grid()

# 그래프 각 축의 화면에 보이는 범위 설정
plt.xlim([0, 9])

plt.xlabel("x data")
plt.ylabel("y data", fontsize=15)

plt.title("x-y relation", fontsize=20)

yArray2 = xArray + 2

plt.plot(xArray, yArray2, color="#0000FF", label="2024")

# 데이터 이름표도 그림
plt.legend()

plt.show()