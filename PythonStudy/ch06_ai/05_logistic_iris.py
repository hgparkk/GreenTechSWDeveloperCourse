import numpy as np
import pandas as pd
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split

df = pd.read_csv("../resources/after_iris.csv")

feature = df[["sepal_length", "sepal_width", "petal_length", "petal_width"]].to_numpy()

iris_class = df["iris_class"].to_numpy()

x_train, x_test, y_train, y_test = train_test_split(feature, iris_class, test_size=0.3)

model = LogisticRegression()

model.fit(x_train, y_train)

x1 = np.array([[6.4, 3.1, 5.9, 2.1]])
x2 = np.array([[5.8, 2.4, 3.7, 1.2]])

print(model.predict(x1))
print(model.predict(x2))
print(model.predict_proba(x2))

print(accuracy_score(y_test,model.predict(x_test)))