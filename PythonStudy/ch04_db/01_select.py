import cx_Oracle as cx
import pandas as pd

conn = cx.connect("sqld","sqld","localhost:1521/xe")

print("연결 성공")

cur = conn.cursor()
sql = "SELECT * FROM members"
rows = cur.execute(sql)

df = pd.DataFrame(columns=["mem_id","mem_password","mem_name","mem_phone","mem_email","mem_profile_img"])

for r in rows:
    df.loc[len(df)] = r

cur.close()
conn.close()

print(df.loc[2])

