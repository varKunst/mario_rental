package board.controller;

import java.sql.*;
import java.util.ArrayList;

import board.Board;
import board.BoardRequestDto;
import util.DBManager;

public class BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	public void createBoard(BoardRequestDto boardDto) {
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "INSERT INTO board (board_no, board_title, board_content, m_code, board_type) "
					+ "VALUES((SELECT MAX(board_no) FROM board b WHERE board_type = ?)+1, ?, ?, ?, ?)";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, boardDto.getType());
				this.pstmt.setString(2, boardDto.getTitle());
				this.pstmt.setString(3, boardDto.getContent());
				this.pstmt.setInt(4, boardDto.getWriter());
				this.pstmt.setString(5, boardDto.getType());
				this.pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
	}
	
	public ArrayList<Board> getBoardList() {
		ArrayList<Board> list = new ArrayList<Board>();
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT board_no, m_code, board_title, board_type, regidate FROM board ORDER BY board_no DESC";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int number = this.rs.getInt(1);
					int writer = this.rs.getInt(2);
					String title = this.rs.getString(3);
					String type = this.rs.getString(4);
					Timestamp regidate = this.rs.getTimestamp(5);
					System.out.println("regDate: " + regidate);
					
					BoardRequestDto boardDto = new BoardRequestDto(number, writer, title, type, regidate);
					Board board = new Board(boardDto);
					
					list.add(board);
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
