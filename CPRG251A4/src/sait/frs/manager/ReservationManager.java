package sait.frs.manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import sait.frs.exception.*;
import sait.frs.problemdomain.Flight;
import sait.frs.problemdomain.Reservation;
import sait.frs.manager.FlightManager;

public class ReservationManager {

	private ArrayList<Reservation> reservations;

	public ReservationManager() {

	}

//	 method to make a new reservation and add it to the array
	public Reservation makeReservation(Flights flight, String name, String citizenship)
			throws NullFlightException, InvalidNameException, InvalidCitizenshipException {
		return new Reservation(flight, name, citizenship, flight.getCostPerSeat());
	}

//	public Reservation makeReservation(Flight flight, String name, String citizenship)
//			throws NullFlightException, NoMoreSeatsException, InvalidNameException, InvalidCitizenshipException {
//		if (flight == null) {
//			throw new NullFlightException();
//		}
//		if (this.getAvailableSeats(flight) == 0) {
//			throw new NoMoreSeatsException();
//		}
//		Reservation reservation = new Reservation(flight, name, citizenship, flight.getCostPerSeat());
//		this.reservations.add(reservation);
//		this.persist();
//		return reservation;
//	}

	// method to find any matching reservations in the arraylist
	public ArrayList<Reservation> findReservations(String reservationCode, String airline, String name) {
		ArrayList<Reservation> found = new ArrayList<Reservation>();
		if (reservationCode.contentEquals("") && airline.contentEquals("") && name.contentEquals("")) {
			return found;
		}
		for (Reservation reservation : this.reservations) {
			if (reservation.getCode().contains(reservationCode) && reservation.getFlightCode().contains(airline)
					&& reservation.getName().contains(name)) {
				found.add(reservation);
			}
		}
		return found;
	}

	// method to find reservations searching by reservation code
	public Reservation findReservationByCode(String reservationCode) {
		for (Reservation reservation : this.reservations) {
			if (reservation.getCode().equals(reservationCode)) {
				return reservation;
			}
		}
		return null;
	}

	public void persist() {
		try {
			RandomAccessFile reservationFile = new RandomAccessFile("res/reservations.txt", "rw");
			reservationFile.seek(0);// set to start of file
			for (Reservation res : this.reservations) // rewrite the entire file with the updated data
			{
				reservationFile.writeBytes(res.toString());
				reservationFile.writeBytes(System.getProperty("line.separator"));
			}
			reservationFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get available seats
	private int getAvailableSeats(Flight flight) {
		int usedSeats = 0;
		for (Reservation reservation : this.reservations) {
			if (reservation.isActive() && reservation.getFlightCode().equals(flight)) {
				++usedSeats;
			}
		}
		return flight.getSeats() - usedSeats;
	}

	// generate random reservation code
	private static String generateReservationCode(Flight flight) {
		char letter = flight.isDomestic() ? 'D' : 'I';
		Random rand = new Random();
		return String.format("%c%d", letter, rand.nextInt(9999) + 1000);
	}

	private void populateFromBinary() {
		boolean eof = false;
		String recString = "";
		String[] split;

		try {
			RandomAccessFile reservationFile = new RandomAccessFile("res/reservations.txt", "r");

			while (!eof) {
				try {
					recString = reservationFile.readLine();
					if (!(recString == null)) {
						split = recString.split(","); // split the record string into an array
						try {
							Flight fl = FlightManager.findFlightByCode(split[1]);
							reservations.add(new Reservation(split[0], fl, split[2].trim(), split[3].trim(),
									Double.parseDouble(split[4].trim()), fl.getAirline()));
						} catch (NumberFormatException | NullFlightException | InvalidNameException
								| InvalidCitizenshipException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else
						eof = true;
				} catch (EOFException e) {
					eof = true;
				}
			}
			reservationFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
