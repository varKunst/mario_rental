package vehicle;

public class VehicleRequestDto {

	private int code, hourRate;
	private String name, cate;
	
	public VehicleRequestDto(int code, String name, String cate, int hourRate) {
		this.code = code;
		this.name = name;
		this.cate = cate;
		this.hourRate = hourRate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getHourRate() {
		return hourRate;
	}

	public void setHourRate(int hourRate) {
		this.hourRate = hourRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}
}