package sait.frs.problemdomain;

import java.util.*;
import sait.frs.exception.*;

public final class Reservation {
	// variables
	public final int RECORD_SIZE = 171;
	private String reservationCode;
	private String flightCode;
	private String airlineName;
	private String name;
	private String citizenship;
	private double cost;
	private boolean active;

	// reservation constructor
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

	public String getCode() {
		return this.reservationCode;
	}

	public String getFlightCode() {
		return this.flightCode;

	}

	public String getAirline() {
		return this.airline;
	}

	public String getName() {
		return this.name;
	}

	public String getCitizenship() {
		return this.citizenship;
	}

	public double getCost() {
		return this.cost;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setName(String name) throws InvalidNameException {
		if (name == null || name.isEmpty()) {
			throw new InvalidNameException();
		}
		this.name = name;
	}

	public void setCitizenship(String citizenship) throws InvalidCitizenshipException {
		if (citizenship == null || citizenship.isEmpty()) {
			throw new InvalidCitizenshipException();
		}
		this.citizenship = citizenship;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

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

		return this.getCode();
	}
}