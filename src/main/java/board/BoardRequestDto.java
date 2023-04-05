package board;

import java.sql.Timestamp;

public class BoardRequestDto {

	private int code, number, writer;
	private String title, content, type;
	private Timestamp regidate, modifDate;

	public BoardRequestDto(int number, int writer, String title, String type, Timestamp regidate) {
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.type = type;
		this.regidate = regidate;
	}
	
	public BoardRequestDto(int number, int writer, String title, String content,
			String type, Timestamp regidate) {
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.type = type;
		this.regidate = regidate;
		this.modifDate = modifDate;
	}
	
	public BoardRequestDto(int code, int number, int writer, String title, String content, 
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

	public void setCode(int code) {
		this.code = code;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getRegidate() {
		return regidate;
	}

	public void setRegidate(Timestamp regidate) {
		this.regidate = regidate;
	}

	public Timestamp getModifDate() {
		return modifDate;
	}

	public void setModifDate(Timestamp modifDate) {
		this.modifDate = modifDate;
	}
}
