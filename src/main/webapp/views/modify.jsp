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
			String type = request.getParameter("type");
			int number = Integer.parseInt(request.getParameter("number"));
			
			BoardDao boardDao = BoardDao.getInstance();
			Board board = boardDao.getBoard(number, type);
			
			Member member = (Member)session.getAttribute("log");
			int wCode = member.getCode();

			String back = type.equals("1")? "notice": "review";
			
			if(member==null || board.getWriter()!=wCode) {
				response.sendRedirect(back);
			}
			
			%>
			<form method="post" action="service">
				<input type="hidden" name="command" value="modify">
				<input type="hidden" name="number" value="<%=number %>">
				<input type="hidden" name="type" value="<%=type %>">
				<table>
					<tr>
						<td>제목: <input type="text" name="title" value="<%=board.getTitle() %>"></td>
						<td>작성자: <%=member.getName() %><input type="hidden" name="writer" value="<%=wCode %>"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" name="content" value="<%=board.getContent() %>"></td>
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