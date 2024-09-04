<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>글 수정</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>
</head>

<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>

	<section class="page-section">
		<div class="container pt-5">
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<form action="<c:url value = "/updateBoardDo"/>" method="POST">
						<input type="hidden" name="cBoardNo" value="${keyBoard.cBoardNo}">

						<div class="mb-3">
							<input class="form-control" type="text" name="cBoardTitle" value="${keyBoard.cBoardTitle}" />
						</div>

						<div class="mb-3">
							<textarea class="form-control" name="cBoardContent" rows="10">${keyBoard.cBoardContent}</textarea>
						</div>

						<a class="btn btn-secondary me-2" href="<c:url value = "/boardView?no=${keyBoard.cBoardNo}" />">취소</a>
						<button class="btn btn-primary" type="submit">등록</button>
					</form>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>