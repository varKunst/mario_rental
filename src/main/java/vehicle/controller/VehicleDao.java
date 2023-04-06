package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Venue.controller.VenueDao;
import util.DBManager;
import vehicle.Vehicle;

public class VehicleDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VehicleDao() {}
	private static VehicleDao instance = new VehicleDao();
	public static VehicleDao getInstance() {
		return instance;
	}
	
	// create
	
	public ArrayList<Vehicle> getVehicleList(int vnCode) {
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM vehicles WHERE vn_code = ?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, vnCode);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int code = this.rs.getInt(1);
					String name = this.rs.getString(2);
					String cate = this.rs.getString(3);
					int hourRate = this.rs.getInt(4);
					
					Vehicle vehicle = new Vehicle(code, name, cate, hourRate);
					list.add(vehicle);
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
