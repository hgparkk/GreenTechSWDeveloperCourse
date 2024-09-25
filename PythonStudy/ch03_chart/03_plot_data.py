import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import matplotlib.font_manager as fm

# label과 title의 폰트 설정
font_path = "C:/Windows/Fonts/malgun.ttf"
font_name = fm.FontProperties(fname=font_path).get_name()
plt.rcParams["font.family"]=font_name

df = pd.read_csv("../resources/exchange.csv")

# plt에 series를 넣어도 그려진다.
date_value = df["DATE"]
krw_value = df["KRW"]

# series 일 때 yyyy-mm-dd 를 yy-mm-dd 로 바꾸기
date_value = date_value.str[2:]

date_value = df["DATE"].to_numpy()

for i in range(len(date_value)):
    date_value[i] = date_value[i][2:].replace("-", "/")

plt.figure(figsize=(13, 7))

plt.plot(date_value, krw_value)

plt.xticks(date_value[(np.linspace(0, len(date_value)-1, 20, dtype=int))], rotation=30)

plt.xlim(date_value[0],date_value[-1])

plt.show()