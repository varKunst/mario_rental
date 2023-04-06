package Venue;

public class Venue {

	private int code;
	private String name;

	public Venue(VenueRequestDto venueDto) {
		this.code = venueDto.getCode();
		this.name = venueDto.getName();
	}
	
	public Venue(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
