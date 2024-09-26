import math

import requests
import json
import pandas as pd

def get_all_data_to_csv(servicekey,total_row, column_list):
    def_df = pd.DataFrame(columns=column_list)
    for i in range(1,total_row+1):
        def_params = {"serviceKey": servicekey, "pageNo": str(i), "numOfRows": "100", "type": "json"}
        def_response = requests.get(url, params=def_params)
        def_v_jsondict = json.loads(def_response.text)
        for j in range(len(def_v_jsondict["body"]["items"])):
            def_df.loc[len(def_df)] = def_v_jsondict["body"]["items"][j]
        print(i)

    for d in range(len(def_df)):
        for c in column_list:
            try:
                def_df.loc[d][c] = def_df.loc[d][c].replace("\n", "")
                def_df.loc[d][c] = def_df.loc[d][c].replace("\xa0", "")
            except:
                pass

    def_df.to_csv("medicineAll.csv", index=False)

url = 'http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList'

servicekey_encoding = "7iwd9W8L5Kbf0TSMmZlfTf9B4Bzi6b6KX5HkUGG0XkD19ZSr%2BIw3WD9zmD1MoXdQ7UQhPYlBK3wWkg3%2B4jSaVQ%3D%3D"
servicekey_decoding = "7iwd9W8L5Kbf0TSMmZlfTf9B4Bzi6b6KX5HkUGG0XkD19ZSr+Iw3WD9zmD1MoXdQ7UQhPYlBK3wWkg3+4jSaVQ=="

params = {"serviceKey": servicekey_decoding, "pageNo": "1", "numOfRows": "100", "type": "json"}

response = requests.get(url, params=params)

v_jsondict = json.loads(response.text)

totalCount = v_jsondict["body"]["totalCount"]
numOfRows = 100
column = ["entpName", "itemName", "itemSeq", "efcyQesitm", "useMethodQesitm", "depositMethodQesitm", "itemImage"]

get_all_data_to_csv(servicekey_decoding,math.ceil(totalCount/numOfRows),column)