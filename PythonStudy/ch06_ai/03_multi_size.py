import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import r2_score, mean_absolute_error

df = pd.read_csv("../resources/gender_height_hand_foot_size.csv")

x = df[["gender", "height"]].to_numpy()
y = df["foot_size"].to_numpy()

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.3)

model = LinearRegression()
model.fit(x_train, y_train)

print(model.predict([[1, 170]]))
print(model.predict([[0, 170]]))

y_pred = model.predict(x_test)

print(r2_score(y_test, y_pred))
print(mean_absolute_error(y_test, y_pred))