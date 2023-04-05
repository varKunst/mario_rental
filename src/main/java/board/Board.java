package board;

import java.sql.Timestamp;

public class Board {

	private int code, number, writer;
	private String title, content, type;
	private Timestamp regidate, modifDate;
	
	public Board(BoardRequestDto boardDto) {
		this.number = boardDto.getNumber();
		this.title = boardDto.getTitle();
		this.content = boardDto.getContent();
		this.writer = boardDto.getWriter();
		this.type = boardDto.getType();
		this.regidate = boardDto.getRegidate();
	}
	
	public Board(int code, int number, int writer, String title, String content, 
			String type, Timestamp regidate, Timestamp modifDate) {
		this.code = code;
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.type = type;
		this.regidate = regidate;
		this.modifDate = modifDate;
	}

	public int getCode() {
		return code;
	}

	public int getNumber() {
		return number;
	}

	public int getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getRegidate() {
		return regidate;
	}

	public Timestamp getModifDate() {
		return modifDate;
	}
}
