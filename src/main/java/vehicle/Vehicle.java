package vehicle;

public class Vehicle {

	private int code, hourRate;
	private String name, cate;

	public Vehicle(VehicleRequestDto vehicleDto) {
		this.code = vehicleDto.getCode();
		this.name = vehicleDto.getName();
		this.cate = vehicleDto.getCate();
		this.hourRate = vehicleDto.getHourRate();
	}
	
	public Vehicle(int code, String name, String cate, int hourRate) {
		this.code = code;
		this.name = name;
		this.cate = cate;
		this.hourRate = hourRate;
	}

	public int getCode() {
		return code;
	}

	public int getHourRate() {
		return hourRate;
	}

	public String getName() {
		return name;
	}

	public String getCate() {
		return cate;
	}
}
