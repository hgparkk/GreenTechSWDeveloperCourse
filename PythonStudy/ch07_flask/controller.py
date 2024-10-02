from flask import Flask, render_template, jsonify

# __name__ 은 시스템 변수
# 현재 파일을 실행하면 __name__ 에 __main__ 이 들어감

app = Flask(__name__)


@app.route("/")
def home():
    return render_template("./index.html")

@app.route("/data")
def data():
    v_data = {
        "name" : "아이유",
        "age" : 31
    }
    return jsonify(v_data)


if __name__ == "__main__":
    app.run()
