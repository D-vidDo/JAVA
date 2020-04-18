package sait.frs.problemdomain;

import sait.frs.exception.*;
/**
 * Holds the components for the reservations
 * 
 * @author David Do
 * @author Chris Manuel-Smith
 * @version 03/2020
 */
public final class Reservation {
	/**
	 * global variables
	 */
	public final int RECORD_SIZE = 171;
	private String reservationCode;
	private String flightCode;
	private String airline;
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
	public Reservation(Flight flight, String name, String citizenship, String code)
			throws InvalidNameException, InvalidCitizenshipException {
		this.airline = flight.getAirline();
		this.setName(name);
		this.setCitizenship(citizenship);
		this.cost = flight.getCostPerSeat();
		this.active = true;
		this.flightCode = flight.getCode();
		this.reservationCode = code;
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
	public Reservation(String reservationCode, String name, String citizenship, double cost, String airline,
			String flightCode) throws NullFlightException, InvalidNameException, InvalidCitizenshipException {
		this.reservationCode = reservationCode;
		this.airline = airline;
		this.setName(name);
		this.setCitizenship(citizenship);
		this.cost = cost;
		this.active = true;
		this.flightCode = flightCode;
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
		return this.airline;
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
		return this.reservationCode;
	}

}