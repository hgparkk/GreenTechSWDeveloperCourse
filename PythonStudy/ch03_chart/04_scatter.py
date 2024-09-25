import numpy as np
import pandas as pd
from matplotlib import pyplot as plt

df = pd.read_csv("../resources/gender_height_hand_foot_size.csv")

height = df["height"].to_numpy()

gender = df["gender"].to_numpy()
hand_size = df["hand_size"].to_numpy()
foot_size = df["foot_size"].to_numpy()

plt.scatter(height, foot_size, color="b", label="foot size(mm)")

redline_x = np.linspace(min(height),max(height),len(height))
redline_y = np.linspace(min(foot_size),max(foot_size),len(foot_size))

plt.plot(redline_x,redline_y, color="r", linewidth="5")

greenline_y = np.array([np.mean(foot_size)]*len(foot_size))

plt.plot(redline_x,greenline_y, color="g", linewidth="5")

plt.xlabel("height(cm)")
plt.legend()

plt.show()
