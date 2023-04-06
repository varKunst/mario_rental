<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.*" %>
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
	
	String linkLogIn = "<a href='logIn'>로그인</a>";
	String linkLogOut = "<a href='service?command=logOut'>로그아웃</a>";
	
	String linkJoin = "<a href='join'>회원가입</a>";
	String linkMyPage = "<a href='myPage'>마이페이지</a>";
	%>
	<header>
		<h1><a href="main">MARIO RENTAL</a></h1>
		<ul>
			<li><%=member==null? linkLogIn: linkLogOut %></li>
			<li><%=member==null? linkJoin: linkMyPage %></li>
		</ul>
	</header>
	<nav>
		<ul>
			<li><a href="select">렌터카</a></li>
			<li><a href="community">커뮤니티</a></li>
		</ul>
	</nav>

</body>
</html>