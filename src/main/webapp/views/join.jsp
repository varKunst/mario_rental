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
String id = request.getParameter("id");
String name = request.getParameter("name");

%>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<div class="box">
			<h2>Join</h2>
			<form method="post" action="service">
				<input type="text" name="id" id="id" value="<%=id!=null? id: "" %>" <%=id==null? "autofocus": "" %> placeholder="ID">
				<input type="password" name="password" id="password" placeholder="Password">
				<input type="name" name="name" id="name" value="<%=name!=null? name: "" %>" <%=name==null? "autofocus": "" %> placeholder="Name">
				<input type="hidden" name="command" id="command" value="join">
				<input type="button" class="button" value="Join" onclick="checkValues(form);">
			</form>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
	<script type="text/javascript" src="resources/validation.js"></script>
</body>
</html>