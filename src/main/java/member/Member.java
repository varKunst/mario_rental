package member;

import java.sql.Timestamp;

public class Member {

	private int code;
	private String id, password, name;
	private Timestamp regidate, logdate;
	
	public Member(MemberRequestDto memberDto) {
		this.id = memberDto.getId();
		this.password = memberDto.getPassword();
		this.name = memberDto.getName();
		this.regidate = memberDto.getRegidate();
	}
	
	public Member(int code, String id, String password, String name, Timestamp regidate, Timestamp logdate) {
		this.code = code;
		this.id = id;
		this.password = password;
		this.name = name;
		this.regidate = regidate;
		this.logdate = logdate;
	}

	public int getCode() {
		return code;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Timestamp getRegidate() {
		return regidate;
	}

	public Timestamp getLogdate() {
		return logdate;
	}
	
}
