package booking.controller;

import java.sql.*;
import java.util.*;

import booking.BookingRequestDto;
import util.DBManager;

public class BookingDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
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
}
