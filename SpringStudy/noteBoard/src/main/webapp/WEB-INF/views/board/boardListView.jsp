<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>게시판</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>
</head>

<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<section class="page-section">
		<div class="container pt-5">
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">자유 게시판</h2>
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
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
									<td><a href="${pageContext.request.contextPath}/boardDetailView?no=${board.boardNo}">${board.boardTitle}</a></td>
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
</body>

</html>