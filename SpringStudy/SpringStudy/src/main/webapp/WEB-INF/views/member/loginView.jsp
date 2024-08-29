<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>게시판</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<style>
.err-msg {
	color: red;
}
</style>

</head>

<body id="page-top">
	<%@ include file="/WEB-INF/inc/top.jsp"%>

	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container pt-5">
			<!-- Contact Section Heading-->
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">로그인</h2>
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

					<form id="contactForm" action="${pageContext.request.contextPath}/loginDo" method="POST">

						<!-- ID input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputId" type="text" name="memId" value="${cookie.rememberId.value}" ${cookie.rememberId.value == null ? "autofocus" : ""} />
							<label for="inputId">아이디</label>
						</div>

						<!-- Password input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPw" type="password" name="memPassword" ${cookie.rememberId.value == null ? "" : "autofocus"} />
							<label for="inputPw">비밀번호</label>
						</div>

						<!-- remember id input -->
						<div class="form-check mb-3">
							<input class="form-check-input" type="checkbox" id="inputRemeberID" type="checkbox" name="rememberId" ${cookie.rememberId.value == null ? "" : "checked"}>
							<label class="form-check-label" for="inputRememberId">아이디 기억하기</label>
						</div>

						<!-- attribute show -->
						<div class="mb-3">
							<span class="err-msg">${failMsg}</span>
						</div>

						<!-- Submit Button-->
						<button class="btn btn-primary btn-xl" id="submitButton" type="submit">로그인</button>
					</form>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>