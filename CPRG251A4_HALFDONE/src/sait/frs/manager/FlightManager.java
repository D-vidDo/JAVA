package sait.frs.manager;

import java.io.*;
import sait.frs.exception.*;
import java.util.*;
import sait.frs.problemdomain.Reservation;
import sait.frs.problemdomain.Flight;

public class FlightManager {
	/**
	 * Local global variables and array lists
	 */
	public final String ANY = "Any";
	public final String SUNDAY = "Sunday";
	public final String MONDAY = "Monday";
	public final String TUESDAY = "Tuesday";
	public final String WEDNESDAY = "Wednesday";
	public final String THURSDAY = "Thursday";
	public final String FRIDAY = "Friday";
	public final String SATURDAY = "Saturday";
	public final String FLIGHTS_TEXT = "res/flights.csv";
	public final String AIRPORTS_TEXT = "res/airports.csv";
	private static ArrayList<Flight> flights;
	private static ArrayList<String[]> airports;

	/**
	 * Flight Manager constructor
	 */
	public FlightManager() {
		this.flights = new ArrayList<Flight>();
		this.airports = new ArrayList<String[]>();
		this.populateAirports();
		this.populateFlights();
	}

	/**
	 * getAirports - stores all airports into an array and returns the list
	 * 
	 * @return - returns an array list that contains all flights
	 */
	public ArrayList<String> getAirports() {
		ArrayList<String> temp = new ArrayList<>();
		for (int i = 0; i < airports.size(); i++) {
			temp.add(airports.get(i)[0]);
		}
		return temp;
	}

	/**
	 * getFlights - returns all flights
	 * 
	 * @return - returns an array list that contains all flights
	 */
	public ArrayList<Flight> getFlights() {
		return new ArrayList<Flight>(this.flights);
	}

	/**
	 * findAirportByCode - finds and displays the airports based on the flight code
	 * that is given
	 * 
	 * @param code - flight code that corresponds with the right airports
	 * @return - returns the airports that has the corresponding flight code
	 */
	public static String findAirportByCode(String code) {
		for (Flight flight : FlightManager.flights) {
			if (flight.getCode().equals(code)) {
				return "From: " + flight.getFrom() + "To: " + flight.getTo();
			}
		}
		return null;
	}

	/**
	 * findFlightByCode - finds flights based on the flight code that is given
	 * 
	 * @param flightCode - flight code that corresponds with the right flight
	 * @return - returns the flight that has the corresponding flight code
	 */
	public static Flight findFlightByCode(String flightCode) {
		for (Flight flight : FlightManager.flights) {
			if (flight.getCode().equals(flightCode)) {
				return flight;
			}
		}
		return null;
	}

	/**
	 * findFlights - a user will input their desired locations and return results
	 * that suit their inputs
	 * 
	 * @param from    - user input for origin airport
	 * @param to      - user input for destination airport
	 * @param weekday - user input for which day they want to fly on
	 * @return a list of flights that match the user inputs
	 */
	public ArrayList<Flight> findFlights(String from, String to, String weekday) {
		ArrayList<Flight> found = new ArrayList<Flight>();
		for (final Flight flight : this.flights) {
			if (flight.getFrom().equals(from) && flight.getTo().equals(to)
					&& (weekday.equals("Any") || flight.getWeekday().equals(weekday))) {
				found.add(flight);
			}
		}
		return found;
	}

	/**
	 * populateFlights - reads the flights.csv file and populates appropriate arrays
	 * with information inside the file
	 */
	private void populateFlights() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("res/flights.csv"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] parts = line.split(",");
				String code = parts[0];
				String from = parts[1];
				String to = parts[2];
				String weekday = parts[3];
				String time = parts[4];
				int seatsAvailable = Integer.parseInt(parts[5]);
				double pricePerSeat = Double.parseDouble(parts[6]);
				Flight flight = new Flight(code, from, to, weekday, time, seatsAvailable, pricePerSeat);
				this.flights.add(flight);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * populateAirports - reads the airports.csv file and populates an array with
	 * all the airport names within the file
	 */
	private void populateAirports() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("res/airports.csv"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] parts = line.split(",");
				this.airports.add(parts);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
