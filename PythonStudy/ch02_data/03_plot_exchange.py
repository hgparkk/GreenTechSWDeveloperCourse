import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import matplotlib.font_manager as fm

font_path = "C:/Windows/Fonts/malgun.ttf"
font_name = fm.FontProperties(fname=font_path).get_name()
plt.rcParams["font.family"]=font_name

df = pd.read_csv("../resources/normal_exchange.csv")

ves = df["VES"]
krw = df["KRW"]
jpy = df["JPY"]

date = df["DATE"].to_numpy()

for i in range(len(date)):
    date[i] = date[i][2:].replace("-", "/")

plt.figure(figsize=(13, 7))

plt.plot(date, ves, label="VES", color="g")
plt.plot(date, krw, label="KRW", color="r")
plt.plot(date, jpy, label="JPY", color="b")

plt.title("환율 동향", fontsize=20)

plt.xticks(date[(np.linspace(0, len(date)-1, 20, dtype=int))], rotation=30)

plt.xlim(date[0],date[-1])

plt.legend()

plt.show()