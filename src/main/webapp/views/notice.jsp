<%@page import="member.Member"%>
<%@page import="board.Board"%>
<%@page import="java.util.*"%>
<%@page import="member.controller.MemberDao"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/grid.css">
<link rel="stylesheet" href="resources/board.css">
<title>Insert title here</title>
</head>
<body>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<div class="board">
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성시간</th>
					</tr>
					<%
					BoardDao boardDao = BoardDao.getInstance();
					MemberDao memberDao = MemberDao.getInstance();
					String type = "1";
					
					ArrayList<Board> list = boardDao.getBoardList(type);
					
					for(Board board: list) {
						int writer = board.getWriter();
						Member member = memberDao.getMemberByCode(writer);
						String name = member.getName();
					%>
					<tr>
						<td><%=board.getNumber() %></td>
						<td><a href="view?type=<%=type %>&number=<%=board.getNumber()%>"><%=board.getTitle() %></a></td>
						<td><%=name %></td>
						<td><%=board.getRegidate() %></td>
					</tr>
					<% } %>
				</table>
				<%
				if(session.getAttribute("log")!=null) {%>
					<button class="write" onclick="location.href='write?type=<%=type %>'">Write</button>					
				<%}%>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>