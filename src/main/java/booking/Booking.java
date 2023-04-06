package booking;

import java.sql.Timestamp;

public class Booking {

	private int code, mCode, vCode, vnCode, charge, period;
	Timestamp bookDate, bookSubmit;
	
	public Booking(BookingRequestDto bookingDto) {
		this.code = bookingDto.getCode();
		this.mCode = bookingDto.getmCode();
		this.vCode = bookingDto.getvCode();
		this.vnCode = bookingDto.getVnCode();
		this.charge = bookingDto.getCharge();
		this.period = bookingDto.getPeriod();
		this.bookDate = bookingDto.getBookDate();
		this.bookSubmit = bookingDto.getBookSubmit();
	}
	
	public Booking(int code, int mCode, int vCode, int vnCode, int charge, int period, 
			Timestamp bookDate, Timestamp bookSubmit) {
		this.code = code;
		this.mCode = mCode;
		this.vCode = vCode;
		this.vnCode = vnCode;
		this.charge = charge;
		this.period = period;
		this.bookDate = bookDate;
		this.bookSubmit = bookSubmit;
	}

	public int getCode() {
		return code;
	}

	public int getmCode() {
		return mCode;
	}

	public int getvCode() {
		return vCode;
	}

	public int getVnCode() {
		return vnCode;
	}

	public int getCharge() {
		return charge;
	}

	public int getPeriod() {
		return period;
	}

	public Timestamp getBookDate() {
		return bookDate;
	}

	public Timestamp getBookSubmit() {
		return bookSubmit;
	}
}
