package member;

import java.sql.Timestamp;

public class MemberRequestDto {

	private int code;
	private String id, password, name;
	private Timestamp regidate, logdate;
	
	public MemberRequestDto(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getRegidate() {
		return regidate;
	}

	public void setRegidate(Timestamp regidate) {
		this.regidate = regidate;
	}

	public Timestamp getLogdate() {
		return logdate;
	}

	public void setLogdate(Timestamp logdate) {
		this.logdate = logdate;
	}
	
	
}
