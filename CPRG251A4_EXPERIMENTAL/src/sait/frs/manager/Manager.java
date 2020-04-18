package sait.frs.manager;

import java.io.*;
import sait.frs.exception.*;
import java.util.*;
import sait.frs.problemdomain.Reservation;
import sait.frs.problemdomain.Flights;

public class Manager {
	// static variables
	public static final String ANY = "Any";
	public static final String SUNDAY = "Sunday";
	public static final String MONDAY = "Monday";
	public static final String TUESDAY = "Tuesday";
	public static final String WEDNESDAY = "Wednesday";
	public static final String THURSDAY = "Thursday";
	public static final String FRIDAY = "Friday";
	public static final String SATURDAY = "Saturday";
	public static final String FLIGHTS_TEXT = "res/flights.csv";
	public static final String AIRPORTS_TEXT = "res/airports.csv";
	private ArrayList<Flights> flights;
	private ArrayList<String> airports;
	private ArrayList<Reservation> reservations;

	// manager constructor, creates arraylists to store things
	public Manager() {
		this.flights = new ArrayList<Flights>();
		this.airports = new ArrayList<String>();
		this.reservations = new ArrayList<Reservation>();
		this.populateAirports();
		this.populateFlights();
	}

	// get airports
	public ArrayList<String> getAirports() {
		return new ArrayList<String>(this.airports);
	}

	// get flights
	public ArrayList<Flights> getFlights() {
		return new ArrayList<Flights>(this.flights);
	}

	// get reservations
	public ArrayList<Reservation> getReservations() {
		return new ArrayList<Reservation>(this.reservations);
	}

	// find flights by searching for code
	public Flights findFlightByCode(final String flightCode) {
		for (final Flights flight : this.flights) {
			if (flight.getCode().equals(flightCode)) {
				return flight;
			}
		}
		return null;
	}

	// method to find any matching flights in the arraylist
	public ArrayList<Flights> findFlights(final String from, final String to, final String weekday) {
		final ArrayList<Flights> found = new ArrayList<Flights>();
		for (final Flights flight : this.flights) {
			if (flight.getFrom().equals(from) && flight.getTo().equals(to)
					&& (weekday.equals("Any") || flight.getWeekday().equals(weekday))) {
				found.add(flight);
			}
		}
		return found;
	}

	// method to find any matching reservations in the arraylist
	public ArrayList<Reservation> findReservations(final String reservationCode, final String airline,
			final String name) {
		final ArrayList<Reservation> found = new ArrayList<Reservation>();
		if (reservationCode.contentEquals("") && airline.contentEquals("") && name.contentEquals("")) {
			return found;
		}
		for (final Reservation reservation : this.reservations) {
			if (reservation.getCode().contains(reservationCode)
					&& reservation.getFlight().getAirline().contains(airline) && reservation.getName().contains(name)) {
				found.add(reservation);
			}
		}
		return found;
	}

	// method to find reservations searching by reservation code
	public Reservation findReservationByCode(final String reservationCode) {
		for (final Reservation reservation : this.reservations) {
			if (reservation.getCode().equals(reservationCode)) {
				return reservation;
			}
		}
		return null;
	}

	// get available seats
	private int getAvailableSeats(final Flights flight) {
		int usedSeats = 0;
		for (final Reservation reservation : this.reservations) {
			if (reservation.isActive() && reservation.getFlight().equals(flight)) {
				++usedSeats;
			}
		}
		return flight.getSeats() - usedSeats;
	}

	// if file exists, run the populate flights from text file method
	private void populateFlights() {
		final File file = new File("res/flights.bin");
		if (file.exists()) {
			this.populateFlightsFromText();
		}
	}

	// populate the flights arraylist with the flights from the csv file
	private void populateFlightsFromText() {
		try {
			final BufferedReader br = new BufferedReader(new FileReader("res/flights.csv"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				final String[] parts = line.split(",");
				final String code = parts[0];
				final String from = parts[1];
				final String to = parts[2];
				final String weekday = parts[3];
				final String time = parts[4];
				final int seatsAvailable = Integer.parseInt(parts[5]);
				final double pricePerSeat = Double.parseDouble(parts[6]);
				final Flights flight = new Flights(code, from, to, weekday, time, seatsAvailable, pricePerSeat);
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
			final BufferedReader br = new BufferedReader(new FileReader("res/airports.csv"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				final String[] parts = line.split(",");
				final String airport = parts[0];
				this.airports.add(airport);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
