import requests

url = 'http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList'

servicekey_encoding = "7iwd9W8L5Kbf0TSMmZlfTf9B4Bzi6b6KX5HkUGG0XkD19ZSr%2BIw3WD9zmD1MoXdQ7UQhPYlBK3wWkg3%2B4jSaVQ%3D%3D"
servicekey_decoding = "7iwd9W8L5Kbf0TSMmZlfTf9B4Bzi6b6KX5HkUGG0XkD19ZSr+Iw3WD9zmD1MoXdQ7UQhPYlBK3wWkg3+4jSaVQ=="

# openAPI와 통신 하기위한 parameter를 세팅
params = {"serviceKey": servicekey_decoding, "pageNo": "1", "numOfRows": "100", "type": "json"}

# openAPI와 통신
response = requests.get(url, params=params)

import json

# 결과를 string으로 바꾸고(jsonString) 그 string 을 dictionary로 바꾼다
v_jsondict = json.loads(response.text)

import pandas as pd

# dictionary 들이 자동으로 DataFrame에 맞춰진다
df = pd.DataFrame(v_jsondict["body"]["items"])

column = ["entpName", "itemName", "itemSeq", "efcyQesitm", "useMethodQesitm", "depositMethodQesitm", "itemImage"]

df = df[column]

for d in range(len(df)):
    for c in column:
        try:
            df.loc[d][c] = df.loc[d][c].replace("\n","")
            df.loc[d][c] = df.loc[d][c].replace("\xa0","")
        except:
            pass

df.to_csv("medicine.csv", index=False)

import cx_Oracle as cx

conn = cx.connect("sqld", "sqld", "localhost:1521/xe")

cursor = conn.cursor()

for i in range(len(df)):
    params = dict(df.loc[i])

sql = "INSERT INTO medicine(entp_name, item_name, item_seq, efcy_qesitm, use_method_qesitm, deposit_method_qesitm, item_image) VALUES(:entpName, :itemName, :itemSeq, :efcyQesitm, :useMethodQesitm, :depositMethodQesitm, :itemImage)"

for i in range(len(df)):
    params = dict(df.loc[i])
    cursor.execute(sql, params)

conn.commit()

cursor.close()
conn.close()