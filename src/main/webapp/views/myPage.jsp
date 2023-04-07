<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/grid.css">
<title>Insert title here</title>
</head>
<body>
<%
Member member = (Member)session.getAttribute("log");

%>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<div class="myPage">
				<h2><%=member.getName() %>님 환영합니다.</h2>
				<ul>
					<li><a href="update">정보수정</a></li>
					<li><a href="reservation?mCode=<%=member.getCode() %>">예약내역확인</a></li>
				</ul>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>