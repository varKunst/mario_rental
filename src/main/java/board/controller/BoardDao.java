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
	
	public Board getBoard(int number, String type) {
		Board board = null;
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT * FROM board WHERE board_no = ? AND board_type= ?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, number);
				this.pstmt.setString(2, type);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					int code = this.rs.getInt(1);
					String title = this.rs.getString(3);
					String content = this.rs.getString(4);
					int writer = this.rs.getInt(5);
					Timestamp regidate = this.rs.getTimestamp(7);
					Timestamp modifDate = this.rs.getTimestamp(8);
					
					board = new Board(code, number, writer, title, content, type, regidate, modifDate);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return board;
	}
	
	public ArrayList<Board> getBoardList(String type) {
		ArrayList<Board> list = new ArrayList<Board>();
		this.conn = DBManager.getConnection();
		if(this.conn!=null) {
			String sql = "SELECT board_no, m_code, board_title, board_type, regidate FROM board WHERE board_type = ? ORDER BY board_no DESC";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, type);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int number = this.rs.getInt(1);
					int writer = this.rs.getInt(2);
					String title = this.rs.getString(3);
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
	
	public void UpdateBoard(int number, String type) {
		Board board = getBoard(number, type);
		this.conn = DBManager.getConnection();
		if(board!=null && this.conn!=null) {
			String sql = "UPDATE board SET board_title = ?, board_content = ?, modif_date = current_timestamp() "
					+ "WHERE board_no = ? AND board_type = ?";
			
			String title = board.getTitle();
			String content = board.getContent();
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, title);
				this.pstmt.setString(2, content);
				this.pstmt.setInt(3, number);
				this.pstmt.setString(4, type);
				this.pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
	}
}