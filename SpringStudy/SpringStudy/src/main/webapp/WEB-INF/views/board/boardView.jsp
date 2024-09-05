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
			<div class="d-flex justify-content-end">
				<div>
					<select id="rowSizeSelect" name="rowSizePerPage">
						<option value="10" ${keySearch.rowSizePerPage == '10' ? 'selected' : ''}>10개</option>
						<option value="30" ${keySearch.rowSizePerPage == '30' ? 'selected' : ''}>30개</option>
						<option value="50" ${keySearch.rowSizePerPage == '50' ? 'selected' : ''}>50개</option>
					</select>
				</div>
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
									<td><a href="${pageContext.request.contextPath}/boardDetailView?no=${board.boardNo}">${board.boardTitle}</a></td>
									<td>${board.memName}</td>
									<td>${board.boardDate}</td>
								</tr>
							</c:forEach>
							<c:if test="${keyBoardList.size()==0}">
								<tr>
									<td colspan="4">해당 게시글이 존재하지 않습니다.</td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
				<div class="d-flex justify-content-end">
					<button id="writeBtn" class="btn btn-primary">글쓰기</button>
				</div>
				<div class="d-flex justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link ${1 == keySearch.firstPage ? 'disabled':''}" href="<c:url value="/boardView${not empty keySearch.searchWord ? ('?searchOption=' += keySearch.searchOption += '&searchWord=' += keySearch.searchWord += '&') : '?'}rowSizePerPage= ${keySearch.rowSizePerPage}&page=${keySearch.firstPage-1}"/>" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<c:forEach begin="${keySearch.firstPage}" end="${keySearch.lastPage}" var="num">
								<li class="page-item"><a class="page-link ${num == keySearch.page ? 'active':''}" href="<c:url value="/boardView${not empty keySearch.searchWord ? ('?searchOption=' += keySearch.searchOption += '&searchWord=' += keySearch.searchWord += '&') : '?'}rowSizePerPage= ${keySearch.rowSizePerPage}&page=${num}"/>">${num}</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link ${keySearch.totalPage == keySearch.lastPage ? 'disabled':''}" href="<c:url value="/boardView${not empty keySearch.searchWord ? ('?searchOption=' += keySearch.searchOption += '&searchWord=' += keySearch.searchWord += '&') : '?'}rowSizePerPage= ${keySearch.rowSizePerPage}&page=${keySearch.lastPage+1}"/>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
				<div class="d-flex justify-content-center">
					<form id="boardForm" class="d-flex" action="<c:url value="/boardView"/>" method="GET">
						<input id="rowSize" name="rowSizePerPage" type="hidden" value="${keySearch.rowSizePerPage}">
						<select class="form-select me-1" name="searchOption">
							<option value="title" ${keySearch.searchOption == 'title' ? 'selected':''}>제목</option>
							<option value="content" ${keySearch.searchOption == 'content' ? 'selected':''}>내용</option>
							<option value="name" ${keySearch.searchOption == 'name' ? 'selected':''}>작성자</option>
						</select>
						<input class="form-control me-1" type="text" name="searchWord" value="${keySearch.searchWord}">
						<button class="btn btn-primary" type="submit">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  								<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
							</svg>
						</button>
					</form>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script>
		let v_id = '${sessionScope.login.memId}'
		
		document.getElementById("rowSizeSelect").addEventListener("change",()=>{
			document.getElementById("rowSize").value = document.getElementById("rowSizeSelect").value
			document.getElementById("boardForm").submit();
		})
	
		document.getElementById("writeBtn").addEventListener("click",()=>{
			if(!v_id){
				alert('로그인 후 글쓰기가 가능합니다.\n로그인 페이지로 이동합니다.')
			}
			location.href='${pageContext.request.contextPath}/boardWriteView'
		})
	</script>
</body>

</html>