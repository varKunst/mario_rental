<%@page import="member.controller.MemberDao"%>
<%@page import="member.Member"%>
<%@page import="board.Board"%>
<%@page import="board.controller.BoardDao"%>
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
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<%
			Member member = (Member)session.getAttribute("log");
			int wCode = member.getCode();
			String type = request.getParameter("type");
			String back = type.equals("1")? "notice": "review";
			
			if(member==null) {
				response.sendRedirect(back);
			}
			
			%>
			<form method="post" action="service">
				<input type="hidden" name="command" value="write">
				<input type="hidden" name="type" value="<%=type %>">
				<table>
					<tr>
						<td>제목: <input type="text" name="title"></td>
						<td>작성자: <%=member.getName() %><input type="hidden" name="writer" value="<%=wCode %>"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" name="content"></td>
					</tr>
				</table>
				<input type="submit" value="Write">
			</form>
			<button onclick="location.href='<%=back %>'">목록으로</button>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
	<script type="text/javascript" src=""></script>
</body>
</html>