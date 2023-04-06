<%@page import="Venue.controller.VenueDao"%>
<%@page import="Venue.Venue"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.Member"%>
<%@page import="member.controller.MemberDao"%>
<%@page import="util.DBManager"%>
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
	if(member==null) {
		response.sendRedirect("logIn");
	}
%>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<h3><%=member.getName() %> 회원님이 렌트하실 지역을 선택하세요.</h3>
			<form method="post" action="rental">
				<select name="vnCode">
					<%
					VenueDao venueDao = VenueDao.getInstance();
					ArrayList<Venue> list = venueDao.getVenueList();
					
					for(Venue venue: list) { %>
						<option value="<%=venue.getCode()%>"><%=venue.getName() %></option>
					<% } %>
				</select>
				<input type="submit" value="지역 선택">
			</form>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>