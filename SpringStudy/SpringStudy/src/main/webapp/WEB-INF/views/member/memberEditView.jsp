<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>회원 수정</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>
</head>

<body id="page-top">
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container pt-5">
			<!-- Contact Section Heading-->
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">회원 수정</h2>
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

					<form id="contactForm" action="${pageContext.request.contextPath}/memberEditDo" method="POST">

						<!-- ID input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputId" type="text" name="id" value="${sessionScope.login.memId}" />
							<label for="inputId">아이디</label>
						</div>

						<!-- Password input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPw" type="password" name="pw" />
							<label for="inputPw">비밀번호</label>
						</div>

						<!-- Name input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputName" type="text" name="name" value="${sessionScope.login.memName}" />
							<label for="inputName">닉네임</label>
						</div>

						<!-- PhoneNumber input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPhoneNum" type="tal" name="phone" value="${sessionScope.login.memPhone}" />
							<label for="inputName">휴대폰 번호</label>
						</div>

						<!-- Email input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputEmail" type="email" name="email" value="${sessionScope.login.memEmail}" />
							<label for="inputName">이메일</label>
						</div>

						<!-- Submit Button-->
						<button class="btn btn-primary btn-xl" id="submitButton" type="submit">수정하기</button>
					</form>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>