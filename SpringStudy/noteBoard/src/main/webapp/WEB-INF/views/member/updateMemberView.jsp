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
	<section class="page-section">
		<div class="container pt-5">
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">회원 수정</h2>
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<form id="updateMemberForm" action="<c:url value="/updateMemberDo" />" method="POST">

						<div class="form-floating mb-3">
							<input class="form-control" id="inputId" type="text" name="cMemId" value="${sessionScope.login.cMemId}" readonly />
							<label for="inputId">아이디</label>
						</div>

						<div class="form-floating mb-3">
							<input class="form-control" id="inputPw" type="password" name="cMemPw" />
							<label for="inputPw">비밀번호</label>
						</div>

						<div class="form-floating mb-3">
							<input class="form-control" id="inputName" type="text" name="cMemName" value="${sessionScope.login.cMemName}" />
							<label for="inputName">닉네임</label>
						</div>
						
					</form>
					<form id="deleteMemberForm" action="<c:url value="/deleteMemberDo" />" method="POST">
						<input type="hidden" name="cMemId" value="${sessionScope.login.cMemId}">
					</form>
					<div class="d-flex justify-content-center">
						<!-- Button-->
						<button class="btn btn-primary me-2" id="updateMemberButton" type="button">수정하기</button>
						<button class="btn btn-danger ms-2" id="deleteMemberButton" type="button">회원탈퇴</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script>
		document.getElementById("updateMemberButton").addEventListener("click",()=>{
			if(confirm("해당 내용으로 수정하시겠습니까?")){
				document.getElementById("updateMemberForm").submit();
			}
		})
	
		document.getElementById("deleteMemberButton").addEventListener("click",()=>{
			let v_input = prompt("정말로 탈퇴하시겠습니까?\n삭제를 원하시면 아이디를 입력해주세요.")
			if(v_input == "${sessionScope.login.cMemId}"){
				document.getElementById("deleteMemberForm").submit();
			}
		})
	</script>
</body>

</html>