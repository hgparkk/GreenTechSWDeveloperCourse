import numpy as np
import pandas as pd

xArray = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
yArray = np.array([1, 3, 6, 7, 8, 11, 14, 16, 17, 19])

df = pd.DataFrame({
    "a": [],
    "b": [],
    "d": []
})

for a in np.arange(-5, 5.1, 0.1):
    a = round(a, 1)
    for b in np.arange(-5, 5.1, 0.1):
        b = round(b, 1)
        ytemp = a * xArray + b
        d = sum(abs(ytemp - yArray))

        df_row = pd.DataFrame({"a": [a], "b": [b], "d": [d]})
        df = pd.concat([df, df_row], ignore_index=True)

minIdx = df["d"].idxmin()

print(df.loc[minIdx])

a = df.loc[minIdx, "a"]
b = df.loc[minIdx, "b"]


def pred_y(x, def_a, def_b):
    return def_a * x + def_b


print("예상 Y : ", pred_y(100, a, b))
