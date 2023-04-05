<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/grid.css">
<link rel="stylesheet" href="resources/form.css">
<title>Insert title here</title>
</head>
<body>
<%
Member member = (Member)session.getAttribute("log");

String id = null;
String password = null;
String name = null;

if(member!=null) {
	id = member.getId();
	password = member.getPassword();
	name = member.getName();
} else 
	response.sendRedirect("logIn");
%>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<div class="box">
			<h2>Update</h2>
			<form method="post" action="service">
				<input type="text" name="id" id="id" value="<%=id %>" readonly>
				<input type="password" name="password" id="password" value="<%=password %>">
				<input type="name" name="name" id="name" value="<%=name %>">
				<input type="hidden" name="command" value="update">
				<input type="submit" value="Update">
			</form>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>