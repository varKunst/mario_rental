package booking;

import java.sql.Timestamp;

public class BookingRequestDto {

	private int code, mCode, vCode, vnCode, charge, period;
	Timestamp bookDate, bookSubmit;
	
	public BookingRequestDto(int code, int mCode, int vCode, int vnCode, int charge, int period, 
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

	public void setCode(int code) {
		this.code = code;
	}

	public int getmCode() {
		return mCode;
	}

	public void setmCode(int mCode) {
		this.mCode = mCode;
	}

	public int getvCode() {
		return vCode;
	}

	public void setvCode(int vCode) {
		this.vCode = vCode;
	}

	public int getVnCode() {
		return vnCode;
	}

	public void setVnCode(int vnCode) {
		this.vnCode = vnCode;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Timestamp getBookDate() {
		return bookDate;
	}

	public void setBookDate(Timestamp bookDate) {
		this.bookDate = bookDate;
	}

	public Timestamp getBookSubmit() {
		return bookSubmit;
	}

	public void setBookSubmit(Timestamp bookSubmit) {
		this.bookSubmit = bookSubmit;
	}
}
