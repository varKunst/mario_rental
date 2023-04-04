package member.controller;

import java.sql.*;
import java.util.*;
import member.*;
import util.DBManager;

public class MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	public boolean createMember(MemberRequestDto memberDto) {
		
		boolean result = false;
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "INSERT INTO members (m_id, m_password, m_name) VALUES (?, ?, ?)";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, memberDto.getId());
				this.pstmt.setString(2, memberDto.getPassword());
				this.pstmt.setString(3, memberDto.getName());
				
				System.out.println(memberDto.getId());
				System.out.println(memberDto.getPassword());
				System.out.println(memberDto.getName());
				
				this.pstmt.execute();
				
				if(memberDto!=null)
					result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
		
		return result;
	}
	
	public Member getMemberById(String id) {
		Member member = null;
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM members WHERE m_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.rs = this.pstmt.executeQuery();
				
				int code = this.rs.getInt(1);
				String password = this.rs.getString(3);
				String name = this.rs.getString(4);
				
				member = new Member(code, id, password, name, null, null);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}
	
	public ArrayList<Member> getMemberAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM members";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {					
					int code = this.rs.getInt(1);
					String id = this.rs.getString(2);
					String password = this.rs.getString(3);
					String name = this.rs.getString(4);
				
					Member member = new Member(code, id, password, name, null, null);
					list.add(member);
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
