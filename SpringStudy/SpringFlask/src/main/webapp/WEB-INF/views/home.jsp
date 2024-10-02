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

	<script>
		let iu = ${iu}
		document.getElementById("flaskBtn").addEventListener("click",()=>{
			console.log(iu)
			document.getElementById("iu").innerHTML = iu["name"] + " " + iu["age"]
		})
		
		document.getElementById("springBtn").addEventListener("click",()=>{
			let v_ajax = new XMLHttpRequest()
			
			v_ajax.open("GET","http://localhost:9090/flask/data")
			
			v_ajax.onload = ()=>{
				console.log(v_ajax.response)
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
	</script>
</body>
</html>
