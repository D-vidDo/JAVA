package sait.frs.manager;

import java.io.*;
import sait.frs.exception.*;
import java.util.*;
import sait.frs.problemdomain.Reservation;
import sait.frs.problemdomain.Flights;

public class Manager {
	public static final String WEEKDAY_ANY = "Any";
	public static final String WEEKDAY_SUNDAY = "Sunday";
	public static final String WEEKDAY_MONDAY = "Monday";
	public static final String WEEKDAY_TUESDAY = "Tuesday";
	public static final String WEEKDAY_WEDNESDAY = "Wednesday";
	public static final String WEEKDAY_THURSDAY = "Thursday";
	public static final String WEEKDAY_FRIDAY = "Friday";
	public static final String WEEKDAY_SATURDAY = "Saturday";
	public static final String FLIGHTS_TEXT = "res/flights.csv";
	public static final String AIRPORTS_TEXT = "res/airports.csv";
	public static final String FLIGHTS_BINARY = "res/flights.bin";
	public static final String RESERVATIONS_BINARY = "res/reservations.bin";
	private ArrayList<Flights> flights;
	private ArrayList<String> airports;
	private ArrayList<Reservation> reservations;

	public Manager() {
		this.flights = new ArrayList<Flights>();
		this.airports = new ArrayList<String>();
		this.reservations = new ArrayList<Reservation>();
		this.populateAirports();
		this.populateFlights();
		this.populateReservationsFromBinary();
	}

	public ArrayList<String> getAirports() {
		return new ArrayList<String>(this.airports);
	}

	public ArrayList<Flights> getFlights() {
		return new ArrayList<Flights>(this.flights);
	}

	public ArrayList<Reservation> getReservations() {
		return new ArrayList<Reservation>(this.reservations);
	}

	public Flights findFlightByCode(final String flightCode) {
		for (final Flights flight : this.flights) {
			if (flight.getCode().equals(flightCode)) {
				return flight;
			}
		}
		return null;
	}

	public Reservation makeReservation(final Flights flight, final String name, final String citizenship)
			throws NullFlightException, NoMoreSeatsException, InvalidNameException, InvalidCitizenshipException {
		if (flight == null) {
			throw new NullFlightException();
		}
		if (this.getAvailableSeats(flight) == 0) {
			throw new NoMoreSeatsException();
		}
		final Reservation reservation = new Reservation(flight, name, citizenship);
		this.reservations.add(reservation);
		this.persistReservations();
		return reservation;
	}

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

	public Reservation findReservationByCode(final String reservationCode) {
		for (final Reservation reservation : this.reservations) {
			if (reservation.getCode().equals(reservationCode)) {
				return reservation;
			}
		}
		return null;
	}

	private int getAvailableSeats(final Flights flight) {
		int usedSeats = 0;
		for (final Reservation reservation : this.reservations) {
			if (reservation.isActive() && reservation.getFlight().equals(flight)) {
				++usedSeats;
			}
		}
		return flight.getSeats() - usedSeats;
	}

	private void populateFlights() {
		final File file = new File("res/flights.bin");
		if (file.exists()) {
			this.populateFlightsFromBinary();
		} else {
			this.populateFlightsFromText();
		}
	}

	private void populateFlightsFromText() {
		try {
			final BufferedReader br = new BufferedReader(new FileReader("res/flights.csv"));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				final String[] parts = line.split(",");
				final String code = parts[0];
				final String airline = parts[1];
				final String from = parts[2];
				final String to = parts[3];
				final String weekday = parts[4];
				final String time = parts[5];
				final int seatsAvailable = Integer.parseInt(parts[6]);
				final double pricePerSeat = Double.parseDouble(parts[7]);
				final Flights flight = new Flights(code, airline, from, to, weekday, time, seatsAvailable, pricePerSeat);
				this.flights.add(flight);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void populateFlightsFromBinary() {
		try {
			final RandomAccessFile raf = new RandomAccessFile("res/flights.bin", "rw");
			for (long pos = 0L; pos < raf.length(); pos += 82L) {
				final String code = raf.readUTF();
				final String airline = raf.readUTF().trim();
				final String from = raf.readUTF();
				final String to = raf.readUTF();
				final String weekday = raf.readUTF().trim();
				final String time = raf.readUTF().trim();
				final int seatsAvailable = raf.readInt();
				final double pricePerSeat = raf.readDouble();
				final Flights flight = new Flights(code, airline, from, to, weekday, time, seatsAvailable, pricePerSeat);
				this.flights.add(flight);
			}
			raf.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

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

	private void populateReservationsFromBinary() {
		try {
			final RandomAccessFile raf = new RandomAccessFile("res/reservations.bin", "rw");
			for (long pos = 0L; pos < raf.length(); pos += 171L) {
				final boolean active = raf.readBoolean();
				final String reservationCode = raf.readUTF();
				final String flightCode = raf.readUTF();
				final String name = raf.readUTF().trim();
				final String citizenship = raf.readUTF().trim();
				final Flights flight = this.findFlightByCode(flightCode);
				try {
					final Reservation reservation = new Reservation(reservationCode, flight, name, citizenship, active);
					this.reservations.add(reservation);
				} catch (InvalidNameException e) {
					e.printStackTrace();
				} catch (InvalidCitizenshipException e2) {
					e2.printStackTrace();
				} catch (NullFlightException e3) {
					e3.printStackTrace();
				}
			}
			raf.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void persist() {
		this.persistFlights();
		this.persistReservations();
	}

	private void persistFlights() {
		try {
			final RandomAccessFile raf = new RandomAccessFile("res/flights.bin", "rw");
			raf.setLength(0L);
			for (final Flights flight : this.flights) {
				raf.writeUTF(String.format("%-7s", flight.getCode()));
				raf.writeUTF(String.format("%-30s", flight.getAirline()));
				raf.writeUTF(String.format("%-3s", flight.getFrom()));
				raf.writeUTF(String.format("%-3s", flight.getTo()));
				raf.writeUTF(String.format("%-10s", flight.getWeekday()));
				raf.writeUTF(String.format("%-5s", flight.getTime()));
				raf.writeInt(flight.getSeats());
				raf.writeDouble(flight.getCostPerSeat());
			}
			raf.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void persistReservations() {
		try {
			final RandomAccessFile raf = new RandomAccessFile("res/reservations.bin", "rw");
			raf.setLength(0L);
			for (final Reservation reservation : this.reservations) {
				raf.writeBoolean(reservation.isActive());
				raf.writeUTF(reservation.getCode());
				raf.writeUTF(reservation.getFlight().getCode());
				raf.writeUTF(String.format("%-75s", reservation.getName()));
				raf.writeUTF(String.format("%-75s", reservation.getCitizenship()));
			}
			raf.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
