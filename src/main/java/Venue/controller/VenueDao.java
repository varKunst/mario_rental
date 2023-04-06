package Venue.controller;

import java.util.*;

import Venue.Venue;
import util.DBManager;

import java.sql.*;

public class VenueDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VenueDao() {}
	private static VenueDao instance = new VenueDao();
	public static VenueDao getInstance() {
		return instance;
	}
	
	// create
	
	// read
	public Venue getVenueByCode(int vnCode) {
		Venue venue = null;
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM venues WHERE vn_code = ?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, vnCode);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					int code = this.rs.getInt(1);
					String name = this.rs.getString(2);
					venue = new Venue(code, name);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return venue;
	}
	
	public ArrayList<Venue> getVenueList() {
		ArrayList<Venue> list = new ArrayList<Venue>();
		
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM venues";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int code = this.rs.getInt(1);
					String name = this.rs.getString(2);
					Venue venue = new Venue(code, name);
					list.add(venue);
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