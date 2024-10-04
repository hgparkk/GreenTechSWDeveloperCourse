import joblib
import numpy as np

model = joblib.load("../models/diabetes_model.pkl")

x = np.array([[0, 85, 80, 29, 0, 26.6, 0.351, 31]])
y_pred = model.predict_proba(x)
print("당뇨병에 걸릴 확률 : ", round(y_pred[0][1] * 100, 1), "%")

print("a")