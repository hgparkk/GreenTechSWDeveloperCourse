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
					<form id="memberEditForm" action="${pageContext.request.contextPath}/memberEditDo" method="POST">

						<!-- ID input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputId" type="text" name="memId" value="${sessionScope.login.memId}" readonly />
							<label for="inputId">아이디</label>
						</div>

						<!-- Password input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPw" type="password" name="memPassword" />
							<label for="inputPw">비밀번호</label>
						</div>

						<!-- Name input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputName" type="text" name="memName" value="${sessionScope.login.memName}" />
							<label for="inputName">닉네임</label>
						</div>

						<!-- PhoneNumber input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPhoneNum" type="tal" name="memPhone" value="${sessionScope.login.memPhone}" />
							<label for="inputName">휴대폰 번호</label>
						</div>

						<!-- Email input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputEmail" type="email" name="memEmail" value="${sessionScope.login.memEmail}" />
							<label for="inputName">이메일</label>
						</div>
					</form>
					<form id="memberDeleteForm" action="${pageContext.request.contextPath}/memberDeleteDo" method="POST">
						<input type="hidden" name="memId" value="${sessionScope.login.memId}">
					</form>
					<div class="d-flex justify-content-center">
						<!-- Button-->
						<button class="btn btn-primary me-2" id="memberEditButton" type="button">수정하기</button>
						<button class="btn btn-danger ms-2" id="memberDeleteButton" type="button">회원탈퇴</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script>
		document.getElementById("memberEditButton").addEventListener("click",()=>{
			document.getElementById("memberEditForm").submit();
		})
	
		document.getElementById("memberDeleteButton").addEventListener("click",()=>{
			let v_input = prompt("정말로 탈퇴하시겠습니까?\n삭제를 원하시면 아이디를 입력해주세요.")
			if(v_input == "${sessionScope.login.memId}"){
				document.getElementById("deleteForm").submit();
			}
		})
	</script>
</body>

</html>