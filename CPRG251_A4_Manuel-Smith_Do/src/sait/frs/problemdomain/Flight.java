package sait.frs.problemdomain;

import sait.frs.exception.NullFlightException;
/**
 * Holds the components for the flights
 * 
 * @author David Do
 * @author Chris Manuel-Smith
 * @version 03/2020
 */
public final class Flight {
	/**
	 * global variables
	 */
	public static final int RECORD_SIZE = 82;
	private String code;
	private String airlineName;
	private String from;
	private String to;
	private String weekday;
	private String time;
	private int seats;
	private double costPerSeat;

	/**
	 * Flight object
	 * 
	 * @param code        - flight code
	 * @param from        - origin airport
	 * @param to          - destination airport
	 * @param weekday     - flight day
	 * @param time        - flight time
	 * @param seats       - amount of seats
	 * @param costPerSeat - cost per seat
	 */
	public Flight(String code, String from, String to, String weekday, String time, int seats, double costPerSeat) {
		this.code = code;
		this.from = from;
		this.to = to;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}

	/**
	 * getCode - gets the flight code
	 * 
	 * @return flight code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * getAirline - gets the airline name of flight
	 * 
	 * @return airline name
	 */
	public String getAirline() {
		return this.airlineName;
	}

	/**
	 * getFrom - gets the origin airport
	 * 
	 * @return origin airport
	 */
	public String getFrom() {
		return this.from;
	}

	/**
	 * getTo - gets the destination airport
	 * 
	 * @return destination airport
	 */
	public String getTo() {
		return this.to;
	}

	/**
	 * getWeekday - gets the day the flight takes place
	 * 
	 * @return - the day of flight
	 */
	public String getWeekday() {
		return this.weekday;
	}

	/**
	 * getTime - gets the time of flight
	 * 
	 * @return - the time of flight
	 */
	public String getTime() {
		return this.time;
	}

	/**
	 * getSeats - gets the amount of seats on a flight
	 * 
	 * @return amount of seats on a flight
	 */
	public int getSeats() {
		return this.seats;
	}

	/**
	 * getCostPerSeat - gets the cost of a seat for a selected flight
	 * 
	 * @return cost of the seat
	 */
	public double getCostPerSeat() {
		return this.costPerSeat;
	}

	/**
	 * isDomestic - checks if flight is domestic
	 * 
	 * @return if flight is domestic, return true
	 */
	public boolean isDomestic() {
		return this.getFrom().charAt(0) == 'Y' && this.getTo().charAt(0) == 'Y';
	}

	/**
	 * parseCode - reads the first element in the flights.csv and parses the flight
	 * code to display the corresponding airline
	 * 
	 * @param code - flight code
	 * @throws NullFlightException - Flight does not exist
	 */
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

	/**
	 * toString - formats the flights
	 * 
	 * @return - formatted string
	 */
	@Override
	public String toString() {
		return String.valueOf(this.getCode()) + ", From: " + this.getFrom() + ", To: " + this.getTo() + ", Day: "
				+ this.getWeekday() + ", Cost: " + String.format("%.2f", this.getCostPerSeat());
	}

}