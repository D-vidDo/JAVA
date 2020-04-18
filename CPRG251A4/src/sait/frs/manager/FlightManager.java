package sait.frs.manager;

import java.io.*;
import sait.frs.exception.*;
import java.util.*;
import sait.frs.problemdomain.Reservation;
import sait.frs.problemdomain.Flight;

public class FlightManager {
	// variables
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
	private static ArrayList<String> airports;
//	private Flight temp = new Flight(null, null, null, null, null, 0, 0);
	

	// manager constructor, creates arraylists to store things
	public FlightManager() {
		this.flights = new ArrayList<Flight>();
		this.airports = new ArrayList<String>();
		this.populateAirports();
		this.populateFlights();
	}

	// get airports
	public ArrayList<String> getAirports() {
		return new ArrayList<String>(this.airports);
	}

	// get flights
	public ArrayList<Flight> getFlights() {
		return new ArrayList<Flight>(this.flights);
	}

	// finds airports by code
	public static String findAirportByCode(String code) {
		for (Flight flight : FlightManager.flights) {
			if (flight.getCode().equals(code)) {
				return "From: " + flight.getFrom() + "To: " + flight.getTo(); 
			}
		}
		return null;
	}
//	for (int i = 0; i < flights.size(); i++) {
//	temp = flights.get(i);
//	if (temp.getCode().equals(code)) {
//		return "From: " + temp.getFrom() + "To: " + temp.getTo();
//	}
//}
//return null;

	// find flights by searching for code
	public static Flight findFlightByCode(String flightCode) {
		for (Flight flight : FlightManager.flights) {
			if (flight.getCode().equals(flightCode)) {
				return flight;
			}
		}
		return null;
	}

	// method to find any matching flights in the arraylist
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

	// if file exists, run the populate flights from text file method
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

	// populate the airports arraylist with airports from the csv file
	private void populateAirports() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("res/airports.csv"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] parts = line.split(",");
				String airport = parts[0];
				this.airports.add(airport);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
