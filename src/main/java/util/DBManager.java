package util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		// JNDI
		// Java Naming and Directory Interface
		
		try {
			
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/marioRental");
			conn = source.getConnection();
			System.out.println("DB connection success");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("DB connection failed");
		}
		
		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
