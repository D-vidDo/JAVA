package sait.frs.manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import sait.frs.exception.*;
import sait.frs.problemdomain.Flight;
import sait.frs.problemdomain.Reservation;
/**
 * Holds the components for the reservation manager
 * 
 * @author David Do
 * @author Chris Manuel-Smith
 * @version 03/2020
 */
public class ReservationManager {
	/**
	 * global array list
	 */
	private ArrayList<Reservation> reservations;

	/**
	 * ReservationManager constructor
	 */
	public ReservationManager() {
		this.reservations = new ArrayList<Reservation>();
		this.populateFromBinary();
	}

	/**
	 * makeReservation - saves a user-selected flight into a reservations.bin file
	 * and updates information on that flight
	 * 
	 * @param flight      - user-selected flight
	 * @param name        - users name
	 * @param citizenship - users citizenship
	 * @return - returns the saved reservation
	 * @throws NullFlightException         - No flight selected
	 * @throws NoMoreSeatsException        - No more available seats on the flight
	 * @throws InvalidNameException        - Invalid name inputed
	 * @throws InvalidCitizenshipException - invalid citizenship inputed
	 */
	public Reservation makeReservation(Flight flight, String name, String citizenship)
			throws NullFlightException, NoMoreSeatsException, InvalidNameException, InvalidCitizenshipException {
		if (flight == null) {
			throw new NullFlightException();
		}
		if (this.getAvailableSeats(flight) == 0) {
			throw new NoMoreSeatsException();
		}
		Reservation reservation = new Reservation(flight, name, citizenship, this.generateReservationCode(flight));
		this.reservations.add(reservation);

		try {
			RandomAccessFile reservationFile = new RandomAccessFile("res/reservations.bin", "rw");
			reservationFile.seek(reservationFile.length());
			;// set to end of file
			reservationFile.writeBytes(
					reservation.getCode() + "," + reservation.getFlightCode() + "," + reservation.getAirline() + ","
							+ reservation.getName() + "," + reservation.getCitizenship() + "," + reservation.getCost());
			reservationFile.writeBytes(System.getProperty("line.separator"));
			reservationFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reservation;
	}

	/**
	 * findReservation - finds reservations based on user input
	 * 
	 * @param reservationCode - randomly generated reservation code that was
	 *                        generated and saved with a user-created reservation
	 * @param airline         - airline name
	 * @param name            - users name
	 * @return - the corresponding reservation
	 */
	public ArrayList<Reservation> findReservations(String reservationCode, String airline, String name) {
		ArrayList<Reservation> found = new ArrayList<Reservation>();
		if (reservationCode.contentEquals("") && airline.contentEquals("") && name.contentEquals("")) {
			return found;
		}
		for (Reservation reservation : this.reservations) {
			if (reservation.getCode().contentEquals(reservationCode)
					|| reservation.getFlightCode().contentEquals(airline)
					|| reservation.getName().contentEquals(name)) {
				found.add(reservation);
			}
		}
		return found;
	}

	/**
	 * findReservationByCode - finds reservations saved in the reservation.bin file
	 * by the user inputed reservation code
	 * 
	 * @param reservationCode - randomly generated reservation code that was
	 *                        generated and saved with a user-created reservation
	 * @return - the corresponding reservation
	 */
	public Reservation findReservationByCode(String reservationCode) {
		for (Reservation reservation : this.reservations) {
			if (reservation.getCode().equals(reservationCode)) {
				return reservation;
			}
		}
		return null;
	}

	/**
	 * persist - saves reservations to the reservations.bin file
	 */
	public void persist() {
		try {
			RandomAccessFile reservationFile = new RandomAccessFile("res/reservations.bin", "rw");
			reservationFile.seek(0);// set to start of file
			for (Reservation res : this.reservations) // rewrite the entire file with the updated data
			{
				reservationFile.writeBytes(res.getCode() + "," + res.getFlightCode() + "," + res.getAirline() + ","
						+ res.getName() + "," + res.getCitizenship() + "," + res.getCost());
				reservationFile.writeBytes(System.getProperty("line.separator"));
			}
			reservationFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * getAvailableSeats - gets and returns the amount of available seats on a
	 * selected flight
	 * 
	 * @param flight - user selected flight
	 * @return - amount of seats available
	 */
	private int getAvailableSeats(Flight flight) {
		int usedSeats = 0;
		for (Reservation reservation : this.reservations) {
			if (reservation.isActive() && reservation.getFlightCode().equals(flight.getCode())) {
				++usedSeats;
			}
		}
		return flight.getSeats() - usedSeats;
	}

	/**
	 * generateReservationCode - generates a random reservation code when a user
	 * saves a reservation
	 * 
	 * @param flight - user selected flight
	 * @return - randomly generated reservation code
	 */
	private String generateReservationCode(Flight flight) {
		char letter = flight.isDomestic() ? 'D' : 'I';
		Random rand = new Random();
		return String.format("%c%d", letter, rand.nextInt(9999) + 1000);
	}

	/**
	 * populateFromBinary - reads the reservations binary file and adds the contents
	 * to an array list
	 */
	private void populateFromBinary() {
		boolean eof = false;
		String recString = "";
		String[] split;

		try {
			RandomAccessFile reservationFile = new RandomAccessFile("res/reservations.bin", "r");
			while (!eof) {
				try {
					recString = reservationFile.readLine();
					if (!(recString == null)) {
						split = recString.split(","); // split the record string into an array
						try {
							Flight fl = FlightManager.findFlightByCode(split[1]);
							this.reservations.add(new Reservation(split[0], split[3].trim(), split[4].trim(),
									Double.parseDouble(split[5].trim()), fl.getAirline(), fl.getCode()));
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
