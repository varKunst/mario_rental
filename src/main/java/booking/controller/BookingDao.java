package booking.controller;

import java.sql.*;
import java.util.*;

import booking.Booking;
import booking.BookingRequestDto;
import util.DBManager;

public class BookingDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BookingDao() {}
	private static BookingDao instance = new BookingDao();
	public static BookingDao getInstance() {
		return instance;
	}
	
	public void createBooking(BookingRequestDto bookingDto) {
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "INSERT INTO booking (m_code, v_code, vn_code, b_charge, b_period) VALUES (?, ?, ?, ?, ?)";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, bookingDto.getmCode());
				this.pstmt.setInt(2, bookingDto.getvCode());
				this.pstmt.setInt(3, bookingDto.getVnCode());
				this.pstmt.setInt(4, bookingDto.getCharge());
				this.pstmt.setInt(5, bookingDto.getPeriod());
				this.pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
	}

	public Booking getBookingByCode(int code) {
		Booking booking = null;
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM booking WHERE b_code = ?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, code);
				this.rs = this.pstmt.executeQuery();
				
				if (this.rs.next()) {
					int mCode = this.rs.getInt(2);
					int vCode = this.rs.getInt(3);
					int vnCode = this.rs.getInt(4);
					int charge = this.rs.getInt(5);
					int period = this.rs.getInt(6);
					Timestamp bookDate = this.rs.getTimestamp(7);
					Timestamp bookSubmit = this.rs.getTimestamp(8);
					
					booking = new Booking(code, mCode, vCode, vnCode, charge, period, bookDate, bookSubmit);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return booking;
	}
	
	public ArrayList<Booking> getBookingList(int mCode) {
		ArrayList<Booking> list = new ArrayList<Booking>();
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM booking WHERE m_code = ? ORDER BY b_code DESC";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, mCode);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int code = this.rs.getInt(1);
					int vCode = this.rs.getInt(3);
					int vnCode = this.rs.getInt(4);
					int charge = this.rs.getInt(5);
					int period = this.rs.getInt(6);
					Timestamp bookDate = this.rs.getTimestamp(7);
					Timestamp bookSubmit = this.rs.getTimestamp(8);
					
					Booking booking = new Booking(code, mCode, vCode, vnCode, charge, period, bookDate, bookSubmit);
					list.add(booking);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return list;
	}
}
