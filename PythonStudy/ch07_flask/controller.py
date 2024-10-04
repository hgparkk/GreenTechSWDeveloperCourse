from flask import Flask, render_template, Response, request, jsonify, send_file
from flask_cors import CORS
import json
from matplotlib.figure import Figure
from io import BytesIO
import joblib

# __name__ 은 시스템 변수
# 현재 파일을 실행하면 __name__ 에 __main__ 이 들어감

app = Flask(__name__)
CORS(app)


@app.route("/")
def home():
    return render_template("./index.html")


@app.route("/data")
def data():
    v_data = {
        "name": "아이유",
        "age": 31
    }
    resp = json.dumps(v_data, ensure_ascii=False)
    return Response(resp, content_type="application/json; charset=utf-8")


@app.route("/path/<param>")
def path(param):
    board = param + "번째 게시글"
    v_dict = {"response": board}
    resp = json.dumps(v_dict, ensure_ascii=False)
    return Response(resp, content_type="application/json; charset=utf-8")


@app.route("/get")
def get():
    print(request.args.get("no"))
    print(request.args.get("page"))
    board = request.args.get("no") + "페이지의" + request.args.get("page") + "번 게시글"
    v_dict = {"response": board}
    resp = json.dumps(v_dict, ensure_ascii=False)
    return Response(resp, content_type="application/json; charset=utf-8")


@app.route("/post", methods=["POST"])
def post():
    param = request.get_json()
    print(param)
    print(param["id"])
    print(param["pw"])
    return jsonify(param)


@app.route("/pltimg")
def pltimg():
    fig = Figure()
    ax = fig.add_subplot(1, 1, 1)

    xarray = [1, 2, 3, 4, 5]
    yarray = [3, 5, 7, 9, 11]

    ax.plot(xarray, yarray)
    output = BytesIO()

    fig.savefig(output, format="png")

    output.seek(0)
    return send_file(output, mimetype="image/png")


@app.route("/size")
def size():
    v_heignt = int(request.args.get("height"))

    model = joblib.load("../models/footsize_model.pkl")

    y_pred = model.predict([[v_heignt]])
    v_dict = {"foot_size": y_pred[0]}
    return jsonify(v_dict)


@app.route("/iris")
def iris():
    s_length = float(request.args.get("s_length"))
    s_width = float(request.args.get("s_width"))
    p_length = float(request.args.get("p_length"))
    p_width = float(request.args.get("p_width"))

    model = joblib.load("../models/iris_model.pkl")

    y_pred = model.predict([[s_length, s_width, p_length, p_width]])

    iris_name = ["Iris-Setosa", "Iris-Versicolour", "Iris-Virginica"]

    v_dict = {"iris_class": iris_name[y_pred[0]]}
    return jsonify(v_dict)


app.run(port=5000)
