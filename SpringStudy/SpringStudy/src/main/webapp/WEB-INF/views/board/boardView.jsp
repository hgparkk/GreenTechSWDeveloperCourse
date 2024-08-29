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
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">자유 게시판</h2>
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
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">글번호</th>
								<th scope="col">글제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${keyBoardList}" var="board">
								<tr>
									<td>${board.boardNo}</td>
									<td>${board.boardTitle}</td>
									<td>${board.memName}</td>
									<td>${board.boardDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="d-flex justify-content-end">
					<button id="writeBtn" class="btn btn-primary">글쓰기</button>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script>
		let v_id = '${sessionScope.login.memId}'
	
		document.getElementById("writeBtn").addEventListener("click",()=>{
			if(!v_id){
				alert('로그인 후 글쓰기가 가능합니다.\n로그인 페이지로 이동합니다.')
			}
			location.href='${pageContext.request.contextPath}/boardWriteView'
		})
	</script>
</body>

</html>