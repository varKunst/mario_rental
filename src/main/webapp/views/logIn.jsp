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
				<h2>LogIn</h2>
				<form method="post" action="LogInAction">
					<input type="text" name="id" placeholder="ID">
					<input type="password" name="password" placeholder="Password">
					<input type="submit" value="LogIn">
				</form>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>