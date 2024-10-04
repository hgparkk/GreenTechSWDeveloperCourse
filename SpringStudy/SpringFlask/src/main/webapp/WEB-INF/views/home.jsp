<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">
<head>
<title>Home</title>
</head>
<body>
	<div id="result"></div>
	<span id="iu"></span>

	<button id="flaskBtn">flask 서버 요청</button>
	<br>
	<br>
	<button id="springBtn">spring 서버 요청</button>
	<br>
	<br>
	<button id="spFlBtn">spring _ controller 서버 요청</button>
	<br>
	<br>
	<input type="text" id="inputParam">
	<button id="pathBtn">javaScriptfh flask 서버에 path variable 방식 요청</button>
	<br>
	<br>
	<button id="getBtn">javaScriptfh flask 서버에 get 방식 query string 요청</button>
	<br>
	<br>
	<input type="text" id="inputId">
	<input type="text" id="inputPw">
	<button id="postBtn">javaScriptfh flask 서버에 post 방식 query string 요청</button>
	<br>
	<br>
	<img src="http://localhost:5000/pltimg">
	<br>
	<br>
	<input type="number" id="inputHeight">
	<button id="predictBtn">발사이즈 예측</button>
	<br>
	<br>
	<span>꽃 받침 길이</span>
	<input type="number" id="inputSLength">
	<br>
	<span>꽃 받침 너비</span>
	<input type="number" id="inputSWidth">
	<br>
	<span>꽃잎 길이 </span>
	<input type="number" id="inputPLength">
	<br>
	<span>꽃잎 너비 </span>
	<input type="number" id="inputPWidth">
	<button id="predictIrisBtn">붓꽃 분류</button>
	<br>
	<br>
	<span id="irisResult" style="font-weight: bold;"></span>

	<script>
		document.getElementById("flaskBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:5000/data")
			
			v_ajax.onload = ()=>{
				console.log(JSON.parse(v_ajax.response))
			}
			
			v_ajax.send()
		})
		
		document.getElementById("springBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:9090/flask/data")
			
			v_ajax.onload = ()=>{
				console.log(JSON.parse(v_ajax.response))
			}
			
			v_ajax.send()
		})
		
		document.getElementById("spFlBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:9090/flask/flask")
			
			v_ajax.onload = ()=>{
				console.log(JSON.parse(v_ajax.response))
			}
			
			v_ajax.send()
		})
		
		document.getElementById("pathBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:5000/path/"+document.getElementById("inputParam").value)
			
			v_ajax.onload = ()=>{
				console.log(JSON.parse(v_ajax.response))
			}
			
			v_ajax.send()
		})
		
		document.getElementById("getBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:5000/get?no=34&page=3")
			
			v_ajax.onload = ()=>{
				console.log(JSON.parse(v_ajax.response))
			}
			
			v_ajax.send()
		})
		
		document.getElementById("postBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			let v_json = {
				"id":document.getElementById("inputId").value,
				"pw":document.getElementById("inputPw").value
			}
			
			v_ajax.open("POST","http://localhost:5000/post")
			
			v_ajax.setRequestHeader("Content-Type","application/json")
			
			v_ajax.onload = ()=>{
				console.log(JSON.parse(v_ajax.response))
			}
			
			v_ajax.send(JSON.stringify(v_json))
		})
		
		document.getElementById("predictBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:5000/size?height="+document.getElementById("inputHeight").value)
			
			v_ajax.onload = ()=>{
				console.log(JSON.parse(v_ajax.response))
			}
			
			v_ajax.send()
		})
		
		document.getElementById("predictIrisBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:5000/iris?s_length="
					+document.getElementById("inputSLength").value
					+"&s_width="+document.getElementById("inputSWidth").value
					+"&p_length="+document.getElementById("inputPLength").value
					+"&p_width="+document.getElementById("inputPWidth").value)
			
			v_ajax.onload = ()=>{
				resultJson = JSON.parse(v_ajax.response)
				document.getElementById("irisResult").innerHTML = resultJson["iris_class"]
			}
			
			v_ajax.send()
		})
		
	</script>
</body>
</html>
