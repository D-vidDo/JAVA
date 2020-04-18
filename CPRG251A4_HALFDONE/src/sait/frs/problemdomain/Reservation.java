package sait.frs.problemdomain;

import java.util.*;
import sait.frs.exception.*;

public final class Reservation {
	/**
	 * global variables
	 */
	public final int RECORD_SIZE = 171;
	private String reservationCode;
	private String flightCode;
	private String airlineName;
	private String name;
	private String citizenship;
	private double cost;
	private boolean active;

	/**
	 * Reservation object
	 * 
	 * @param flight
	 * @param name
	 * @param citizenship
	 * @throws InvalidNameException
	 * @throws InvalidCitizenshipException
	 */
	public Reservation(Flight flight, String name, String citizenship)
			throws InvalidNameException, InvalidCitizenshipException {
		this.airlineName = flight.getAirline();
		this.setName(name);
		this.setCitizenship(citizenship);
		this.cost = flight.getCostPerSeat();
		this.active = true;

		String str = "";
		if (flight.getFrom().charAt(0) == 'Y' && flight.getTo().charAt(0) == 'Y')
			str += "D";
		else
			str += "I";
		Random rand = new Random();
		int randomNum = rand.nextInt(8999) + 1000;
		str += randomNum;
		this.reservationCode = str;
	}

	/**
	 * Reservation object
	 * 
	 * @param reservationCode
	 * @param flight          - flight
	 * @param name            - name
	 * @param citizenship     - citizenship
	 * @param cost            - cost of flight
	 * @param airline         - airline name
	 * @throws NullFlightException         - flight doesn't exist
	 * @throws InvalidNameException        - invalid name
	 * @throws InvalidCitizenshipException - invalid citizenship
	 */
	public Reservation(String reservationCode, Flight flight, String name, String citizenship, double cost,
			String airline) throws NullFlightException, InvalidNameException, InvalidCitizenshipException {
		this.reservationCode = reservationCode;
		this.airlineName = airline;
		this.setName(name);
		this.setCitizenship(citizenship);
		this.cost = cost;
		this.active = true;
	}

	/**
	 * getCode - gets the reservation code of the flight
	 * 
	 * @return reservation code
	 */
	public String getCode() {
		return this.reservationCode;
	}

	/**
	 * getFlightCode - gets the flight code of the flight
	 * 
	 * @return flight code
	 */
	public String getFlightCode() {
		return this.flightCode;

	}

	/**
	 * getAirline - gets the name of the airline
	 * 
	 * @return airline name
	 */
	public String getAirline() {
		return this.airlineName;
	}

	/**
	 * getName - gets the users name of the flight
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getCitizenship - gets the citizenship of the flight
	 * 
	 * @return citizenship
	 */
	public String getCitizenship() {
		return this.citizenship;
	}

	/**
	 * getCost - gets the cost of the flight
	 * 
	 * @return cost
	 */
	public double getCost() {
		return this.cost;
	}

	/**
	 * isActive - checks if reservation is active
	 * 
	 * @return true if active
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * setName - sets the name for the reservation
	 * 
	 * @param name - user inputed name
	 * @throws InvalidNameException - invalid name
	 */
	public void setName(String name) throws InvalidNameException {
		if (name == null || name.isEmpty()) {
			throw new InvalidNameException();
		}
		this.name = name;
	}

	/**
	 * setCitizenship - sets the citizenship for the reservation
	 * 
	 * @param citizenship - user inputed citizenship
	 * @throws InvalidCitizenshipException - invalid citizenship
	 */
	public void setCitizenship(String citizenship) throws InvalidCitizenshipException {
		if (citizenship == null || citizenship.isEmpty()) {
			throw new InvalidCitizenshipException();
		}
		this.citizenship = citizenship;
	}

	/**
	 * setActive - sets reservation to active
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * toString - formats the flights
	 * 
	 * @return - formatted string
	 */
	@Override
	public String toString() {
		int tempCount;
		String str = this.getCode() + "," + this.getFlightCode() + "," + this.getName();
		// fill the remaining space after the name with empty space to the size limit
		tempCount = this.getName().length();
		for (int i = 0; i < (20 - tempCount); i++) {
			str += " ";
		}
		str += "," + this.getCitizenship();
		// fill the remaining space after the citizenship with empty space
		tempCount = this.getCitizenship().length();
		for (int i = 0; i < (15 - tempCount); i++) {
			str += " ";
		}
		str += "," + this.cost;
		// fill the remaining space after the cost with empty space
		tempCount = String.valueOf(this.cost).length();
		for (int i = 0; i < (10 - tempCount); i++) {
			str += " ";
		}

		return str;
	}

}