<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Not Found</title>
<%@ include file="/WEB-INF/inc/header.jsp"%>
</head>

<body id="page-top">
	<%@ include file="/WEB-INF/inc/top.jsp"%>

	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<h1 class="masthead-heading text-uppercase mb-0">에러가 발생하였습니다.</h1>
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<p class="masthead-subheading font-weight-light mb-0">${errMsg}</p>
		</div>
	</header>


	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>