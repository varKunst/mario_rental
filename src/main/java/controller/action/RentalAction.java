package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.BookingRequestDto;
import booking.controller.BookingDao;
import vehicle.Vehicle;
import vehicle.controller.VehicleDao;

public class RentalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mCode = Integer.parseInt(request.getParameter("mCode"));
		int vCode = Integer.parseInt(request.getParameter("vCode"));
		int vnCode = Integer.parseInt(request.getParameter("vnCode"));
		int period = Integer.parseInt(request.getParameter("period"));
		
		VehicleDao vehicleDao = VehicleDao.getInstance();
		Vehicle vehicle = vehicleDao.getVehicleByCode(vCode);
		int charge = (vehicle.getHourRate()) * period;
		
		BookingRequestDto bookingDto = new BookingRequestDto(mCode, vCode, vnCode, charge, period);
		BookingDao bookingDao = BookingDao.getInstance();
		bookingDao.createBooking(bookingDto);
		response.sendRedirect("myPage");
	}
}
