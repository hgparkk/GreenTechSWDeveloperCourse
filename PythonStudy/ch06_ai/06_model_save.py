import numpy as np
import pandas as pd
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score

df = pd.read_csv("../resources/pima-indians-diabetes.csv")

feature = df[["preg", "gluc", "blood", "skin", "insulin", "bmi", "diab", "age"]].to_numpy()
outcome = df["outcome"].to_numpy()

x_train, x_test, y_train, y_test = train_test_split(feature, outcome, test_size=0.3)

model = LogisticRegression(max_iter=200)
model.fit(x_train, y_train)

y_pred = model.predict(x_test)
accuracy = accuracy_score(y_test, y_pred)
print(accuracy)

x = np.array([[0, 85, 80, 29, 0, 26.6, 0.351, 31]])
y_pred = model.predict_proba(x)
print(y_pred)
print("당뇨병에 걸릴 확률 : ", round(y_pred[0][1] * 100, 1), "%")

import joblib

joblib.dump(model,"../models/diabetes_model.pkl")
