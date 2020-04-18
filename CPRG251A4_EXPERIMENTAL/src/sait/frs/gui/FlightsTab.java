package sait.frs.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import sait.frs.exception.InvalidCitizenshipException;
import sait.frs.exception.InvalidNameException;
import sait.frs.exception.NoMoreSeatsException;
import sait.frs.exception.NullFlightException;
import sait.frs.manager.Manager;
import sait.frs.problemdomain.Flights;
import sait.frs.problemdomain.Reservation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Holds the components for the flights tab.
 * 
 * @author David Do
 * @author Chris Manuel-Smith
 * @version 03/06/2020
 */
public class FlightsTab extends TabBase {
	/**
	 * Instance of travel manager.
	 */
	private Manager manager;

	private ArrayList<String> airports;

	/**
	 * List of flights.
	 */
	private JList<Flights> flightsList;

	private DefaultListModel<Flights> flightsModel;
	private JTextField citzTextField, nameTextField, costTextField, timeTextField, flightTextField, airlineTextField,
			dayTextField;
	private JComboBox fromComboBox, toComboBox, dayComboBox;

	/**
	 * Creates the components for flights tab.
	 */
	public FlightsTab(Manager manager) {
		this.manager = manager;
		panel.setLayout(new BorderLayout());

		this.airports = manager.getAirports();

		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = createCenterPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * Creates the north panel.
	 * 
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() {
		JPanel panel = new JPanel();

		JLabel title = new JLabel("Flights", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title);

		return panel;
	}

	/**
	 * Creates the center panel.
	 * 
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() {
		JPanel panel = new JPanel();

		flightsModel = new DefaultListModel<>();
		flightsList = new JList<>(flightsModel);

		// User can only select one item at a time.
		flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.flightsList);

		flightsList.addListSelectionListener(new MyListSelectionListener());
		panel.setLayout(new BorderLayout(0, 0));

		panel.add(scrollPane, BorderLayout.CENTER);

		// Reservation Panel
		JPanel reservePanel = new JPanel();
		panel.add(reservePanel, BorderLayout.EAST);
		GridBagLayout gbl_reservePanel = new GridBagLayout();
		gbl_reservePanel.columnWidths = new int[] { 37, 2 };
		gbl_reservePanel.rowHeights = new int[] { 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_reservePanel.columnWeights = new double[] { 1.0, 1.0 };
		gbl_reservePanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		reservePanel.setLayout(gbl_reservePanel);

		// reserve label
		JLabel reserveTitle = new JLabel("Reserve");
		GridBagConstraints gbc_reserveTitle = new GridBagConstraints();
		gbc_reserveTitle.gridwidth = 2;
		gbc_reserveTitle.insets = new Insets(0, 0, 5, 0);
		gbc_reserveTitle.anchor = GridBagConstraints.NORTH;
		gbc_reserveTitle.gridx = 0;
		gbc_reserveTitle.gridy = 0;
		reservePanel.add(reserveTitle, gbc_reserveTitle);

		// airline text field
		airlineTextField = new JTextField();
		airlineTextField.setEditable(false);
		GridBagConstraints gbc_airlineTextField = new GridBagConstraints();
		gbc_airlineTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_airlineTextField.gridx = 1;
		gbc_airlineTextField.gridy = 3;
		reservePanel.add(airlineTextField, gbc_airlineTextField);
		airlineTextField.setColumns(10);

		// day text field
		dayTextField = new JTextField();
		dayTextField.setEditable(false);
		GridBagConstraints gbc_dayTextField = new GridBagConstraints();
		gbc_dayTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayTextField.gridx = 1;
		gbc_dayTextField.gridy = 4;
		reservePanel.add(dayTextField, gbc_dayTextField);
		dayTextField.setColumns(10);

		// flight label
		JLabel lblFlight = new JLabel("Flight:");
		GridBagConstraints gbc_lblFlight = new GridBagConstraints();
		gbc_lblFlight.anchor = GridBagConstraints.EAST;
		gbc_lblFlight.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlight.gridx = 0;
		gbc_lblFlight.gridy = 2;
		reservePanel.add(lblFlight, gbc_lblFlight);

		// flight text field
		flightTextField = new JTextField();
		flightTextField.setEditable(false);
		GridBagConstraints gbc_flightTextField = new GridBagConstraints();
		gbc_flightTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_flightTextField.gridx = 1;
		gbc_flightTextField.gridy = 2;
		reservePanel.add(flightTextField, gbc_flightTextField);
		flightTextField.setColumns(10);

		// airline label
		JLabel lblAirline = new JLabel("Airline:");
		GridBagConstraints gbc_lblAirline = new GridBagConstraints();
		gbc_lblAirline.anchor = GridBagConstraints.EAST;
		gbc_lblAirline.insets = new Insets(0, 0, 5, 5);
		gbc_lblAirline.gridx = 0;
		gbc_lblAirline.gridy = 3;
		reservePanel.add(lblAirline, gbc_lblAirline);

		// day label
		JLabel lblDay = new JLabel("Day:");
		GridBagConstraints gbc_lblDay = new GridBagConstraints();
		gbc_lblDay.anchor = GridBagConstraints.EAST;
		gbc_lblDay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay.gridx = 0;
		gbc_lblDay.gridy = 4;
		reservePanel.add(lblDay, gbc_lblDay);

		// time label
		JLabel lblTime = new JLabel("Time:");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.EAST;
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 5;
		reservePanel.add(lblTime, gbc_lblTime);

		// time text field
		timeTextField = new JTextField();
		timeTextField.setEditable(false);
		GridBagConstraints gbc_timeTextField = new GridBagConstraints();
		gbc_timeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeTextField.gridx = 1;
		gbc_timeTextField.gridy = 5;
		reservePanel.add(timeTextField, gbc_timeTextField);
		timeTextField.setColumns(10);

		// cost label
		JLabel lblCost = new JLabel("Cost:");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.EAST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 6;
		reservePanel.add(lblCost, gbc_lblCost);

		// cost text field
		costTextField = new JTextField();
		costTextField.setEditable(false);
		GridBagConstraints gbc_costTextField = new GridBagConstraints();
		gbc_costTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_costTextField.gridx = 1;
		gbc_costTextField.gridy = 6;
		reservePanel.add(costTextField, gbc_costTextField);
		costTextField.setColumns(10);

		// name label
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 7;
		reservePanel.add(lblName, gbc_lblName);

		// name text field
		nameTextField = new JTextField();
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameTextField.gridx = 1;
		gbc_nameTextField.gridy = 7;
		reservePanel.add(nameTextField, gbc_nameTextField);
		nameTextField.setColumns(10);

		// citizenship label
		JLabel lblCitizenship = new JLabel("Citizenship:");
		GridBagConstraints gbc_lblCitizenship = new GridBagConstraints();
		gbc_lblCitizenship.anchor = GridBagConstraints.EAST;
		gbc_lblCitizenship.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitizenship.gridx = 0;
		gbc_lblCitizenship.gridy = 8;
		reservePanel.add(lblCitizenship, gbc_lblCitizenship);

		// citizenship text field
		citzTextField = new JTextField();
		GridBagConstraints gbc_citzTextField = new GridBagConstraints();
		gbc_citzTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_citzTextField.gridx = 1;
		gbc_citzTextField.gridy = 8;
		reservePanel.add(citzTextField, gbc_citzTextField);
		citzTextField.setColumns(10);

		// reserve button
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ButtionListener());
		GridBagConstraints gbc_btnReserve = new GridBagConstraints();
		gbc_btnReserve.gridwidth = 2;
		gbc_btnReserve.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReserve.insets = new Insets(10, 0, 0, 5);
		gbc_btnReserve.gridx = 0;
		gbc_btnReserve.gridy = 9;
		reservePanel.add(btnReserve, gbc_btnReserve);

		// Find Flights
		JPanel finderPanel = new JPanel();
		panel.add(finderPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_finderPanel = new GridBagLayout();
		gbl_finderPanel.columnWidths = new int[] { 10, 0, 0, 0, 0 };
		gbl_finderPanel.rowHeights = new int[] { 13, 0, 0, 0, 0, 5 };
		gbl_finderPanel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_finderPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		finderPanel.setLayout(gbl_finderPanel);

		// flight finder label
		JLabel finderTitle = new JLabel("Flight Finder");
		finderTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_finderTitle = new GridBagConstraints();
		gbc_finderTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_finderTitle.insets = new Insets(19, 0, 5, 5);
		gbc_finderTitle.gridx = 2;
		gbc_finderTitle.gridy = 0;
		finderPanel.add(finderTitle, gbc_finderTitle);

		// from label
		JLabel lblFrom = new JLabel("From");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.anchor = GridBagConstraints.WEST;
		gbc_lblFrom.gridx = 0;
		gbc_lblFrom.gridy = 1;
		finderPanel.add(lblFrom, gbc_lblFrom);

		// from combo box
		fromComboBox = new JComboBox(manager.getAirports().toArray());
		GridBagConstraints gbc_fromComboBox = new GridBagConstraints();
		gbc_fromComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_fromComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_fromComboBox.gridwidth = 3;
		gbc_fromComboBox.gridx = 1;
		gbc_fromComboBox.gridy = 1;
		finderPanel.add(fromComboBox, gbc_fromComboBox);

		// to label
		JLabel lblTo = new JLabel("To:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.anchor = GridBagConstraints.WEST;
		gbc_lblTo.gridx = 0;
		gbc_lblTo.gridy = 2;
		finderPanel.add(lblTo, gbc_lblTo);

		// to combo box
		toComboBox = new JComboBox(manager.getAirports().toArray());
		;
		GridBagConstraints gbc_toComboBox = new GridBagConstraints();
		gbc_toComboBox.gridwidth = 3;
		gbc_toComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_toComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_toComboBox.gridx = 1;
		gbc_toComboBox.gridy = 2;
		finderPanel.add(toComboBox, gbc_toComboBox);

		// day label
		JLabel lblDay_1 = new JLabel("Day:");
		GridBagConstraints gbc_lblDay_1 = new GridBagConstraints();
		gbc_lblDay_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay_1.anchor = GridBagConstraints.WEST;
		gbc_lblDay_1.gridx = 0;
		gbc_lblDay_1.gridy = 3;
		finderPanel.add(lblDay_1, gbc_lblDay_1);

		// add days to day combobox
		dayComboBox = new JComboBox();
		dayComboBox.addItem(manager.ANY);
		dayComboBox.addItem(manager.MONDAY);
		dayComboBox.addItem(manager.TUESDAY);
		dayComboBox.addItem(manager.WEDNESDAY);
		dayComboBox.addItem(manager.THURSDAY);
		dayComboBox.addItem(manager.FRIDAY);
		dayComboBox.addItem(manager.SATURDAY);
		dayComboBox.addItem(manager.SUNDAY);
		GridBagConstraints gbc_dayComboBox = new GridBagConstraints();
		gbc_dayComboBox.gridwidth = 3;
		gbc_dayComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_dayComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayComboBox.gridx = 1;
		gbc_dayComboBox.gridy = 3;
		finderPanel.add(dayComboBox, gbc_dayComboBox);

		// find flights button
		JButton btnFindFlights = new JButton("Find Flights");
		btnFindFlights.addActionListener(new ButtionListener());
		GridBagConstraints gbc_btnFindFlights = new GridBagConstraints();
		gbc_btnFindFlights.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFindFlights.gridwidth = 4;
		gbc_btnFindFlights.gridx = 0;
		gbc_btnFindFlights.gridy = 4;
		finderPanel.add(btnFindFlights, gbc_btnFindFlights);

		return panel;
	}

	private class MyListSelectionListener implements ListSelectionListener {
		/**
		 * Called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (flightsList.getSelectedIndex() != -1) {
				Flights flight = flightsList.getSelectedValue();
				String cost = "$" + flight.getCostPerSeat();
				costTextField.setText(cost);
				timeTextField.setText(flight.getTime());
				flightTextField.setText(flight.getCode());
				airlineTextField.setText(flight.getAirline());
				dayTextField.setText(flight.getWeekday());
			}
		}

	}

	private class ButtionListener implements ActionListener {
		/**
		 * Called when the find flights button is clicked or the reserve button is
		 * clicked.
		 * 
		 * Find Flights - collects the user input from the combo boxes and searches the
		 * flights arraylist to see if there are any matching flights and displays it on
		 * the GUI
		 * 
		 * Reserve - after the user selects a flight, the user may enter in their Name
		 * and Citizenship and click 'Reserve' to reserve a seat on that flight.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();

			if (actionCommand.equals("Find Flights")) {
				flightsList.clearSelection();
				String from, to, day;
				flightsModel.clear();
				costTextField.setText("");
				timeTextField.setText("");
				flightTextField.setText("");
				airlineTextField.setText("");
				dayTextField.setText("");

				from = (String) fromComboBox.getSelectedItem();
				to = (String) toComboBox.getSelectedItem();
				day = (String) dayComboBox.getSelectedItem();
				for (Flights i : manager.findFlights(from, to, day)) {
					flightsModel.addElement(i);
				}
			} else if (actionCommand.equals("Reserve")) {
				try {

					Reservation rev = manager.makeReservation(flightsList.getSelectedValue(), nameTextField.getText(),
							citzTextField.getText());
					manager.getReservations().add(rev);
					JOptionPane.showMessageDialog(null, "Reservation Created. Your code is " + rev.getCode());

				} catch (NullFlightException e1) {
					JOptionPane.showMessageDialog(null, "Empty Reservation.");
				} catch (NoMoreSeatsException e1) {
					JOptionPane.showMessageDialog(null,
							"There are currently no more seats available. Please pick a different flight.");
				} catch (InvalidNameException e1) {
					JOptionPane.showMessageDialog(null, "Name is Empty or Null.");
				} catch (InvalidCitizenshipException e1) {
					JOptionPane.showMessageDialog(null, "Citizenship is Empty or Null.");
				}
			}
		}
	}
}