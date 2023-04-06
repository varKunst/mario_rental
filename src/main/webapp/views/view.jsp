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
			BoardDao boardDao = BoardDao.getInstance();
			MemberDao memberDao = MemberDao.getInstance();
			
			int number = Integer.parseInt(request.getParameter("number"));
			String type = request.getParameter("type");
			Board board = boardDao.getBoard(number, type);
			
			int wCode = board.getWriter();
			Member member = memberDao.getMemberByCode(wCode);
			
			String back = type.equals("1")? "notice": "review";
			%>
			<table>
				<tr>
					<td>제목: <%=board.getTitle() %></td>
					<td>작성자: <%=member.getName() %></td>
				</tr>
				<tr>
					<td colspan="2"><%=board.getContent() %></td>
				</tr>
			</table>
			<button onclick="location.href='<%=back %>'">목록으로</button>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>