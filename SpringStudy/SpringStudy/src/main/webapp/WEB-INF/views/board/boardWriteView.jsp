<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>회원 게시판</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>

</head>

<body id="page-top">
	<%@ include file="/WEB-INF/inc/top.jsp"%>

	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container pt-5">
			<!-- Contact Section Heading-->
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">글쓰기</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Contact Section Form-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<form id="contractForm" action="${pageContext.request.contextPath}/boardWriteDo" method="POST" enctype="multipart/form-data">
						<!-- title input -->
						<div class="mb-3">
							<input class="form-control" id="inputTitle" type="text" name="boardTitle" placeholder="제목을 입력해주세요" />
						</div>
						
						<!-- content input -->
						<div class="mb-3">
							<textarea class="form-control" name="boardContent" rows="10"></textarea>
						</div>
						
						<!-- file input -->
						<div class="mb-3">
							<label for="formFileMultiple" class="form-label">파일 첨부</label>
							<input class="form-control" name="boardFile" type="file" id="formFileMultiple" multiple>
						</div>

						<!-- Submit Button-->
						<div class="d-flex justify-content-end">
							<a class="btn btn-secondary me-2" href="${pageContext.request.contextPath}/boardView">취소</a>
							<button class="btn btn-primary" id="submitButton" type="submit">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>