<%@page import="Venue.controller.VenueDao"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="booking.controller.BookingDao"%>
<%@page import="booking.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/grid.css">
<link rel="stylesheet" href="resources/reservation.css">
<title>Insert title here</title>
</head>
<body>
	<%
	Member member = (Member)session.getAttribute("log");
	if(member==null) {
		response.sendRedirect("logIn");
	}
	
	int mCode = Integer.parseInt(request.getParameter("mCode"));
	if(member.getCode()!=mCode) {
		response.sendRedirect("error");
	}
	VehicleDao vehicleDao = VehicleDao.getInstance();
	VenueDao venueDao = VenueDao.getInstance();
	
	BookingDao bookingDao = BookingDao.getInstance();
	ArrayList<Booking> list = bookingDao.getBookingList(mCode);
	
	%>
	<div class="root">
		<jsp:include page="header"></jsp:include>
		<section>
			<h3><%=member.getName() %>님의 예약 내역입니다.</h3>
			<%
			for(Booking booking: list) { %>
				<div class="bookingList">
					<ul>
						<li>예약번호: <%=booking.getCode() %></li>
						<li>차량종류: <%=vehicleDao.getVehicleByCode(booking.getvCode()).getName() %></li>
						<li>예약지점: <%=venueDao.getVenueByCode(booking.getVnCode()).getName() %>지점</li>
						<li>예약일시: <%=booking.getBookDate() %></li>
						<li>예약상태: <%=booking.getBookSubmit()==null? "대기": "확정" %>
						<li>대여시간: <%=booking.getPeriod() %>시간</li>
						<li>총액: ￦ <%=booking.getCharge() %></li>
					</ul>
				</div>
			<% } %>
		</section>
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>