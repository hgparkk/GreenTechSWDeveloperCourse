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
	height: 100%;
	min-height: 300px;
	font-size: 24px;
	font-family: "Nanum Pen Script", cursive;
	font-weight: 400;
	font-style: normal;
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
					<div class="border-bottom border-1 border-primary">
						<div class="mb-3">
							<div class="board-title">${keyBoard.boardTitle}</div>
						</div>
						<div class="d-flex justify-content-between mb-3">
							<div class="board-sub-content">${keyBoard.memName}</div>
							<div class="board-sub-content">${keyBoard.boardDate}</div>
						</div>
					</div>
					<div class="pt-3 mb-3">
						<pre class="board-content">${keyBoard.boardContent}</pre>
					</div>
				</div>
				<c:if test="${keyBoard.memId == sessionScope.login.memId}">
					<div class="col-lg-8 col-xl-7">
						<div class="d-flex justify-content-end">
							<form action="${pageContext.request.contextPath}/boardEditView" method="POST">
								<input type="hidden" value="${keyBoard.boardNo}" name="boardNo">
								<button class="btn btn-warning me-2" type="submit">수정</button>
							</form>
							<form action="${pageContext.request.contextPath}/boardDeleteDo" method="POST">
								<input type="hidden" value="${keyBoard.boardNo}" name="boardNo">
								<button class="btn btn-danger me-2" type="submit">삭제</button>
							</form>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>