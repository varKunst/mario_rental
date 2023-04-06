<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="Venue.Venue"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Venue.controller.VenueDao"%>
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
	if(member==null) {
		response.sendRedirect("logIn");
	}
	int vnCode = Integer.parseInt(request.getParameter("vnCode"));
	
	VehicleDao vehicleDao = VehicleDao.getInstance();
	ArrayList<Vehicle> vehicleList = vehicleDao.getVehicleList(vnCode);

	VenueDao venueDao = VenueDao.getInstance();
	Venue venue = venueDao.getVenueByCode(vnCode);
%>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<div>
				<h3><%=venue.getName() %> 지역 보유 차량</h3>
				<form method="post" action="service">
					<input type="hidden" name="command" value="rental">
					<input type="hidden" name="mCode" value="<%=member.getCode()%>">
					<select name="vCode" id="vCode">
						<%
						for(Vehicle vehicle: vehicleList) { %>
							<option value="<%=vehicle.getCode()%>"><%=vehicle.getName() %></option>						
						<% } %>
					</select>
					<select name="period">
						<option value=""></option>
					</select>
					<input type="submit" value="submit">
				</form>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
	<script type="text/javascript" src="resources/getVehicleList.js"></script>
</body>
</html>