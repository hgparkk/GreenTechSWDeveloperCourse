import cx_Oracle as cx
import pandas as pd

# 연결 정보 (아이디, 비밀번호, 연결 url)
conn = cx.connect("sqld", "sqld", "localhost:1521/xe")

print("연결 성공")

inputId = input("아이디 입력: ")

print(inputId)

# query 문에 보낼 parameter 지정
param = {"id":inputId}

cur = conn.cursor()
# sql 작성 parameter 는 : 로 시작
sql = "SELECT mem_id, mem_password, mem_name, mem_phone, mem_email, mem_profile_img FROM members WHERE mem_id = :id"
# parameter 가 있다면 뒤에 param을 붙인다
rows = cur.execute(sql, param)

df = pd.DataFrame(columns=["mem_id", "mem_password", "mem_name", "mem_phone", "mem_email", "mem_profile_img"])

# 각 행에 접근
for r in rows:
    # columns와 일치하는 column에 자동으로 입력됨
    df.loc[len(df)] = r

cur.close()
conn.close()

print(df)