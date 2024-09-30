import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split

x = np.array([1, 2, 2, 3, 3, 4, 5, 6, 6, 8, 10, 6, 12, 11, 8, 7, 9, 10, 11, 1])
y = np.array([0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0])

x = x.reshape(-1,1)

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.3)

model = LogisticRegression()
model.fit(x_train,y_train)

plt.figure(figsize=(10,6))

x_range = np.linspace(x.min(),x.max(),100).reshape(-1,1)

y_prob = model.predict_proba(x_range)[:,1]

plt.plot(x_range,y_prob,color="red")
plt.scatter(x,y,color="blue")

x_data= np.array([5,7,11])
x_data = x_data.reshape(-1,1)
y_pred = model.predict(x_data)
y_prob = model.predict_proba(x_data)
print(y_pred)
print(y_prob)

plt.show()
