import cx_Oracle as cx

conn = cx.connect("sqld", "sqld", "localhost:1521/xe")

cursor = conn.cursor()

inputTitle = input("제목 : ")
inputContent = input("내용 : ")

param = {"title": inputTitle, "content": inputContent}

sql = "UPDATE boards SET board_title = :title, board_content = :content WHERE board_no = 407"

cursor.execute(sql, param)

conn.commit()

cursor.close()
conn.close()
