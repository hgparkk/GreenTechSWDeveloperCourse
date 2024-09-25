import matplotlib.pyplot as plt
import numpy as np

xList = [1, 2, 3, 4, 5]
yList = [1, 2, 3, 4, 5]

plt.plot(xList, yList)

xArray = np.array(xList)
yArray = np.array([1,3,1,4,5])

plt.plot(xArray,yArray)

plt.show()