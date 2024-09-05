<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>${keyBoard.boardTitle}</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>


<style>
.board-title {
	font-weight: bold;
	font-size: 22px;
}

.board-sub-content {
	font-size: 20px;
}

.board-content {
	min-height: 300px;
	font-size: 24px;
	font-family: "Nanum Pen Script", cursive;
	font-weight: 400;
	font-style: normal;
}

.reply-box {
	border-top: 2px solid black;
	border-bottom: 1px solid #DDDDDD;
	margin-top: 10px;
	margin-bottom: 10px;
}

.reply-box img {
	cursor: pointer;
}
</style>
</head>

<body id="page-top">
	<%@ include file="/WEB-INF/inc/top.jsp"%>

	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container pt-5">
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<div>
						<div class="border-bottom border-1 border-primary">
							<div class="board-title mb-3">${keyBoard.boardTitle}</div>
							<div class="d-flex justify-content-between mb-3">
								<div class="board-sub-content">${keyBoard.memName}</div>
								<div class="board-sub-content">${keyBoard.boardDate}</div>
							</div>
						</div>
						<pre class="board-content pt-3">${keyBoard.boardContent}</pre>
					</div>
					<div class="d-flex justify-content-end">
						<c:if test="${sessionScope.login.memId != null && keyBoard.memId == sessionScope.login.memId}">
							<form action="${pageContext.request.contextPath}/boardEditView" method="POST">
								<input type="hidden" value="${keyBoard.boardNo}" name="no">
								<button class="btn btn-warning me-2" type="submit">수정</button>
							</form>
							<form id="delForm" action="${pageContext.request.contextPath}/boardDeleteDo" method="POST">
								<input type="hidden" value="${keyBoard.boardNo}" name="no">
								<button id="delBtn" class="btn btn-danger me-2" type="button">삭제</button>
							</form>
						</c:if>
					</div>
					<div>
						<div class="reply-box">
							<c:forEach items="${keyReplyList}" var="reply">
								<div class="row pt-2 pb-2">
									<input type="hidden" value="${reply.replyNo}">
									<div class="col-2">${reply.memName}</div>
									<div class="col-7">${reply.replyContent}</div>
									<div class="col-2">${reply.replyDate}</div>
									<div class="col-1">
										<img src="${pageContext.request.contextPath}/assets/img/close.png" style="width: 20px;" onclick="f_deleteComment()">
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<form id="replyForm" action="${pageContext.request.contextPath}/replyWriteDo" method="POST">
								<input type="hidden" value="${sessionScope.login.memId}" name="memId">
								<input type="hidden" value="${keyBoard.boardNo}" name="boardNo">
								<div class="col-10">
									<input id="inputComment" class="form-control" type="text" name="replyContent">
								</div>
								<button id="submitComment" class="btn btn-primary col-2" type="button">등록</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script>
	if(document.getElementById("delBtn")){
		document.getElementById("delBtn").addEventListener("click",()=>{
			if(confirm("정말로 삭제하시겠습니까?")){
				document.getElementById("delForm").submit();
			}
		})	
	}
	
	document.getElementById("submitComment").addEventListener("click",()=>{
		if(!document.getElementById("inputComment").value){
			return
		}
		
		let v_memName = "${sessionScope.login.memName}"
			
		if(!v_memName){
			location.href="${pageContext.request.contextPath}/loginView"
			return
		}
		
		let v_form = document.getElementById("replyForm")
		
		let v_formData = $("#replyForm").serialize()
		
		let v_url = $("#replyForm").attr("action")
		
		$.ajax({
			type: 'POST',
			url: v_url,
			data: v_formData,
			success: function(resp){
				console.log(resp)
				
				let v_comment = document.createElement("div")
				v_comment.classList.add("row")
				v_comment.classList.add("pt-2")
				v_comment.classList.add("pb-2")
				
				let v_commentNo = document.createElement("input")
				v_commentNo.setAttribute("type","hidden")
				v_commentNo.value = resp["replyNo"]
				v_comment.append(v_commentNo)
				
				let v_commentId = document.createElement("div")
				v_commentId.classList.add("col-2")
				v_commentId.innerHTML = resp["memName"]
				v_comment.append(v_commentId)
				
				let v_commentMain = document.createElement("div")
				v_commentMain.classList.add("col-7")
				v_commentMain.innerHTML = resp["replyContent"]
				v_comment.append(v_commentMain)
								
				let v_commentDate = document.createElement("div")
				v_commentDate.classList.add("col-2")
				v_commentDate.innerHTML = resp["replyDate"]
				v_comment.append(v_commentDate)
				
				v_comment.innerHTML += '<div class="col-1"> <img src="${pageContext.request.contextPath}/assets/img/close.png" style="width: 20px;" onclick="f_deleteComment()"> </div>'
				
				document.querySelector(".reply-box").append(v_comment)
				
				document.getElementById("inputComment").value = ""
			}
		})
	})
	
	function f_deleteComment(){
		let v_replyNo = event.target.parentElement.parentElement.children[0].value
		let v_content = event.target.parentElement.parentElement;
		
		let v_ajax = new XMLHttpRequest()
		
		v_ajax.open('POST',"${pageContext.request.contextPath}/deleteReplyDo")
		
		let v_data = "replyNo="+v_replyNo
		
		v_ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
		
		v_ajax.onload = ()=>{
			if(v_ajax.response == "success"){
				v_content.remove()
			}
		}
		
		v_ajax.send(v_data)
	}
	
	</script>
</body>

</html>