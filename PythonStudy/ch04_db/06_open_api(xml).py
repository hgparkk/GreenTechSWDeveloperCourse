import requests

url = 'http://apis.data.go.kr/6300000/animalDaejeonService/animalDaejeonList'

servicekey_encoding = "7iwd9W8L5Kbf0TSMmZlfTf9B4Bzi6b6KX5HkUGG0XkD19ZSr%2BIw3WD9zmD1MoXdQ7UQhPYlBK3wWkg3%2B4jSaVQ%3D%3D"
servicekey_decoding = "7iwd9W8L5Kbf0TSMmZlfTf9B4Bzi6b6KX5HkUGG0XkD19ZSr+Iw3WD9zmD1MoXdQ7UQhPYlBK3wWkg3+4jSaVQ=="

params = {'serviceKey': servicekey_decoding, 'pageNo': '1', 'numOfRows': '100'}

response = requests.get(url, params=params)

import xmltodict

# xml 데이터를 dinctionary로 바꾼다
v_xmldict = xmltodict.parse(response.text)

import pandas as pd

df = pd.DataFrame(v_xmldict["ServiceResult"]["MsgBody"]["items"])

df = df[["animalSeq","filePath","hairColor","species","regDtTm"]]

print(df)