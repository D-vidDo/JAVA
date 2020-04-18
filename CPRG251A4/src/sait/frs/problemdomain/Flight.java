package sait.frs.problemdomain;

import sait.frs.exception.InvalidCitizenshipException;
import sait.frs.exception.NullFlightException;

public final class Flight {
	// variables
	public static final int RECORD_SIZE = 82;
	private String code;
	private String airlineName;
	private String from;
	private String to;
	private String weekday;
	private String time;
	private int seats;
	private double costPerSeat;

	// flights constructor
	public Flight(String code, String from, String to, String weekday, String time, int seats, double costPerSeat) {
		this.code = code;
		this.from = from;
		this.to = to;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}

	public String getCode() {
		return this.code;
	}

	public String getAirline() {
		return this.airlineName;
	}

	public String getFrom() {
		return this.from;
	}

	public String getTo() {
		return this.to;
	}

	public String getWeekday() {
		return this.weekday;
	}

	public String getTime() {
		return this.time;
	}

	public int getSeats() {
		return this.seats;
	}

	public double getCostPerSeat() {
		return this.costPerSeat;
	}

	public boolean isDomestic() {
		return this.getFrom().charAt(0) == 'Y' && this.getTo().charAt(0) == 'Y';
	}

	private void parseCode(String code) throws NullFlightException {
		String str = code;
		String[] arrOfStr = str.split("-");
		String parse = arrOfStr[0];

		if (parse == null || parse.isEmpty()) {
			throw new NullFlightException();
		} else if (parse.equals("OA")) {
			airlineName = "Otto Airlines";
		} else if (parse.equals("CA")) {
			airlineName = "Conned Air";
		} else if (parse.equals("TB")) {
			airlineName = "Try a Bus Airways";
		} else if (parse.equals("VA")) {
			airlineName = "Vertical Airways";
		}
	}

	@Override
	public String toString() {
		return String.valueOf(this.getCode()) + ", From: " + this.getFrom() + ", To: " + this.getTo() + ", Day: "
				+ this.getWeekday() + ", Cost: " + String.format("%.2f", this.getCostPerSeat());
	}
}