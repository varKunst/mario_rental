<%@page import="Venue.Venue"%>
<%@page import="Venue.controller.VenueDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/grid.css">
<link rel="stylesheet" href="resources/vehicleList.css">
<title>Insert title here</title>
</head>
<body>
	<%
	int vnCode = Integer.parseInt(request.getParameter("vnCode"));
	VehicleDao vehicleDao = VehicleDao.getInstance();
	ArrayList<Vehicle> list = vehicleDao.getVehicleList(vnCode);
	
	VenueDao venueDao = VenueDao.getInstance();
	Venue venue = venueDao.getVenueByCode(vnCode);
	%>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<h3><%=venue.getName() %>지점 차량 리스트</h3>
			<div class="listBox">
				<%
				for(Vehicle vehicle: list) { 
					String cateName = "";
					
					if(vehicle.getCate().equals("01"))
						cateName = "SUV";
					else if(vehicle.getCate().equals("02"))
						cateName = "중형";
					else if(vehicle.getCate().equals("03"))
						cateName = "경차";
					else if(vehicle.getCate().equals("04"))
						cateName = "해치백";
				%>
					<div class="vehicleList">
						<p>차량명: <%=vehicle.getName() %></p>
						<p>차량종류: <%=cateName %></p>
						<p>시간당 요금: <%=vehicle.getHourRate() %></p>
						<p>시간당 요금: <%=vehicle.getHourRate() %></p>
					</div>
				<% } %>
			</div>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>