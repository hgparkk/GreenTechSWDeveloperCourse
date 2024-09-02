<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>로그인</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>
</head>

<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<section class="page-section">
		<div class="container pt-5">
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">로그인</h2>
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<form action="<c:url value="/loginDo" />" method="POST">
						<input type="hidden" values="${fromUrl}" name="fromUrl">

						<div class="form-floating mb-3">
							<input class="form-control" type="text" name="cMemId" value="${cookie.rememberId.value}" />
							<label for="inputId">아이디</label>
						</div>

						<div class="form-floating mb-3">
							<input class="form-control" type="password" name="cMemPw" />
							<label for="inputPw">비밀번호</label>
						</div>

						<div class="form-check mb-3">
							<input class="form-check-input" type="checkbox" id="inputRememberId" name="rememberId" ${cookie.rememberId.value == null ? "" : "checked"}>
							<label class="form-check-label" for="inputRemeberId">아이디 기억하기</label>
						</div>

						<div class="d-flex justify-content-center">
							<button class="btn btn-primary btn-xl" type="submit">로그인</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>

</html>