import cx_Oracle as cx

conn = cx.connect("sqld", "sqld", "localhost:1521/xe")

cursor = conn.cursor()

inputTitle = input("제목 : ")
inputContent = input("내용 : ")

param = {"title": inputTitle, "content": inputContent}

sql = "INSERT INTO boards(board_no, board_title, mem_id,board_content, board_date, del_yn) VALUES ((SELECT COUNT(*)+1 FROM boards), :title, 'a001', :content, sysdate, 'N')"

cursor.execute(sql, param)

# insert, update, delete 문에 대해서는 commit을 해줘야 적용된다.
conn.commit()

cursor.close()
conn.close()
