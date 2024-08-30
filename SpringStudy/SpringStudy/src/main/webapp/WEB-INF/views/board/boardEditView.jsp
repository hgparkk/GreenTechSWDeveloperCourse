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

	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container pt-5">
			<!-- Contact Section Form-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<form id="contractForm" action="${pageContext.request.contextPath}/boardEditDo" method="POST">
						<input type="hidden" name="boardNo" value="${keyBoard.boardNo}">

						<!-- title input -->
						<div class="mb-3">
							<input class="form-control" id="inputTitle" type="text" name="boardTitle" value="${keyBoard.boardTitle}" />
						</div>

						<!-- content input -->
						<div class="mb-3">
							<textarea class="form-control" name="boardContent" rows="10">${keyBoard.boardContent}</textarea>
						</div>

						<!-- Submit Button -->
						<a class="btn btn-secondary me-2" href="${pageContext.request.contextPath}/boardDetailView?no=${keyBoard.boardNo}">취소</a>
						<button class="btn btn-primary" type="submit">등록</button>
					</form>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>