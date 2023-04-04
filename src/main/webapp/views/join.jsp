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
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<div class="box">
			<h2>Join</h2>
			<form method="post" action="JoinAction">
				<input type="text" name="id" id="id" placeholder="ID">
				<input type="password" name="password" id="password" placeholder="Password">
				<input type="name" name="name" id="name" placeholder="Name">
				<input type="submit" value="Join">
			</form>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>