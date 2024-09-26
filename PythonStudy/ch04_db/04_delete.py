import cx_Oracle as cx

conn = cx.connect("sqld", "sqld", "localhost:1521/xe")

cursor = conn.cursor()

sql = "DELETE FROM boards WHERE board_no = 407"

cursor.execute(sql)

conn.commit()

cursor.close()
conn.close()
