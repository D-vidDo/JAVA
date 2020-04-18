package sait.frs.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sait.frs.exception.InvalidCitizenshipException;
import sait.frs.exception.InvalidNameException;
import sait.frs.exception.NoMoreSeatsException;
import sait.frs.exception.NullFlightException;
import sait.frs.manager.Manager;
import sait.frs.problemdomain.Flights;
import sait.frs.problemdomain.Reservation;

/**
 * Holds the components for the reservations tab.
 * 
 * @author David Do
 * @author Chris Manuel-Smith
 * @version 03/06/2020
 */
public class ReservationsTab extends TabBase {
	/**
	 * Instance of travel manager.
	 */
	private Manager manager;

	// private JTextField global variables
	private JTextField flightTextField;
	private JTextField airlineTextField;
	private JTextField codeTextField;
	private JTextField costTextField;
	private JTextField nameTextField;
	private JTextField citzTextField;
	private JTextField codeField;
	private JTextField airlineField;
	private JTextField nameField;
	private JComboBox statusComboBox;

	private JList<Reservation> reserveList;
	private DefaultListModel<Reservation> reserveModel;

	/**
	 * Creates the components for reservations tab.
	 */
	public ReservationsTab(Manager manager) {
		this.manager = manager;
		panel.setLayout(new BorderLayout());

		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);
	}

	/**
	 * Creates the north panel.
	 * 
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));

		reserveModel = new DefaultListModel<>();
		panel.setLayout(new BorderLayout(0, 0));
		reserveList = new JList<>(reserveModel);

		// User can only select one item at a time.
		reserveList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.reserveList);

		reserveList.addListSelectionListener(new MyListSelectionListener());

		panel.add(scrollPane, BorderLayout.CENTER);

		JLabel title = new JLabel("Reservations", SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.TOP);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title, BorderLayout.NORTH);

		// Reserver panel
		JPanel reservePanel = new JPanel();
		panel.add(reservePanel, BorderLayout.EAST);
		GridBagLayout gbl_reservePanel = new GridBagLayout();
		gbl_reservePanel.columnWidths = new int[] { 37, 2, 0 };
		gbl_reservePanel.rowHeights = new int[] { 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_reservePanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_reservePanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		reservePanel.setLayout(gbl_reservePanel);

		// reserve label
		JLabel reserveTitle_1 = new JLabel("Reserve");
		GridBagConstraints gbc_reserveTitle_1 = new GridBagConstraints();
		gbc_reserveTitle_1.anchor = GridBagConstraints.NORTH;
		gbc_reserveTitle_1.gridwidth = 2;
		gbc_reserveTitle_1.insets = new Insets(0, 0, 5, 0);
		gbc_reserveTitle_1.gridx = 0;
		gbc_reserveTitle_1.gridy = 0;
		reservePanel.add(reserveTitle_1, gbc_reserveTitle_1);

		// code label
		JLabel lblCode = new JLabel("Code:");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 2;
		reservePanel.add(lblCode, gbc_lblCode);

		// code text field
		codeTextField = new JTextField();
		codeTextField.setEditable(false);
		codeTextField.setColumns(10);
		GridBagConstraints gbc_codeTextField = new GridBagConstraints();
		gbc_codeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_codeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_codeTextField.gridx = 1;
		gbc_codeTextField.gridy = 2;
		reservePanel.add(codeTextField, gbc_codeTextField);

		// flight label
		JLabel lblFlight = new JLabel("Flight:");
		GridBagConstraints gbc_lblFlight = new GridBagConstraints();
		gbc_lblFlight.anchor = GridBagConstraints.EAST;
		gbc_lblFlight.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlight.gridx = 0;
		gbc_lblFlight.gridy = 3;
		reservePanel.add(lblFlight, gbc_lblFlight);

		// flights text field
		flightTextField = new JTextField();
		flightTextField.setEditable(false);
		flightTextField.setColumns(10);
		GridBagConstraints gbc_flightTextField = new GridBagConstraints();
		gbc_flightTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_flightTextField.insets = new Insets(0, 0, 5, 0);
		gbc_flightTextField.gridx = 1;
		gbc_flightTextField.gridy = 3;
		reservePanel.add(flightTextField, gbc_flightTextField);

		// airline label
		JLabel lblAirline = new JLabel("Airline:");
		GridBagConstraints gbc_lblAirline = new GridBagConstraints();
		gbc_lblAirline.anchor = GridBagConstraints.EAST;
		gbc_lblAirline.insets = new Insets(0, 0, 5, 5);
		gbc_lblAirline.gridx = 0;
		gbc_lblAirline.gridy = 4;
		reservePanel.add(lblAirline, gbc_lblAirline);

		// airline text field
		airlineTextField = new JTextField();
		airlineTextField.setEditable(false);
		airlineTextField.setColumns(10);
		GridBagConstraints gbc_airlineTextField = new GridBagConstraints();
		gbc_airlineTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_airlineTextField.insets = new Insets(0, 0, 5, 0);
		gbc_airlineTextField.gridx = 1;
		gbc_airlineTextField.gridy = 4;
		reservePanel.add(airlineTextField, gbc_airlineTextField);

		// cost label
		JLabel lblCost = new JLabel("Cost:");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.EAST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 5;
		reservePanel.add(lblCost, gbc_lblCost);

		// cost text field
		costTextField = new JTextField();
		costTextField.setEditable(false);
		costTextField.setColumns(10);
		GridBagConstraints gbc_costTextField = new GridBagConstraints();
		gbc_costTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_costTextField.insets = new Insets(0, 0, 5, 0);
		gbc_costTextField.gridx = 1;
		gbc_costTextField.gridy = 5;
		reservePanel.add(costTextField, gbc_costTextField);

		// name label
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 6;
		reservePanel.add(lblName, gbc_lblName);

		// name text field
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.gridx = 1;
		gbc_nameTextField.gridy = 6;
		reservePanel.add(nameTextField, gbc_nameTextField);

		// citizenship label
		JLabel lblCitizenship = new JLabel("Citizenship:");
		GridBagConstraints gbc_lblCitizenship = new GridBagConstraints();
		gbc_lblCitizenship.anchor = GridBagConstraints.EAST;
		gbc_lblCitizenship.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitizenship.gridx = 0;
		gbc_lblCitizenship.gridy = 7;
		reservePanel.add(lblCitizenship, gbc_lblCitizenship);

		// citizenship text field
		citzTextField = new JTextField();
		citzTextField.setColumns(10);
		GridBagConstraints gbc_citzTextField = new GridBagConstraints();
		gbc_citzTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_citzTextField.insets = new Insets(0, 0, 5, 0);
		gbc_citzTextField.gridx = 1;
		gbc_citzTextField.gridy = 7;
		reservePanel.add(citzTextField, gbc_citzTextField);

		// status label
		JLabel lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 8;
		reservePanel.add(lblStatus, gbc_lblStatus);

		// status combo box
		statusComboBox = new JComboBox();
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] { "Inactive", "Active" }));
		statusComboBox.setSelectedIndex(1);
		GridBagConstraints gbc_statusComboBox = new GridBagConstraints();
		gbc_statusComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_statusComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_statusComboBox.gridx = 1;
		gbc_statusComboBox.gridy = 8;
		reservePanel.add(statusComboBox, gbc_statusComboBox);

		// update button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ButtionListener());
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(10, 0, 0, 0);
		gbc_btnUpdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdate.gridwidth = 2;
		gbc_btnUpdate.gridx = 0;
		gbc_btnUpdate.gridy = 9;
		reservePanel.add(btnUpdate, gbc_btnUpdate);

		JPanel finderPanel = new JPanel();
		panel.add(finderPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_finderPanel = new GridBagLayout();
		gbl_finderPanel.columnWidths = new int[] { 10, 0, 0, 0, 0 };
		gbl_finderPanel.rowHeights = new int[] { 13, 0, 0, 0, 0, 0 };
		gbl_finderPanel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_finderPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		finderPanel.setLayout(gbl_finderPanel);

		// Reservation Finder Pannel
		JLabel finderTitle = new JLabel("Flight Finder");
		finderTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_finderTitle = new GridBagConstraints();
		gbc_finderTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_finderTitle.insets = new Insets(19, 0, 5, 5);
		gbc_finderTitle.gridx = 2;
		gbc_finderTitle.gridy = 0;
		finderPanel.add(finderTitle, gbc_finderTitle);

		JLabel lblFrom = new JLabel("Code:");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.anchor = GridBagConstraints.EAST;
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.gridx = 0;
		gbc_lblFrom.gridy = 1;
		finderPanel.add(lblFrom, gbc_lblFrom);

		codeField = new JTextField();
		GridBagConstraints gbc_codeField = new GridBagConstraints();
		gbc_codeField.gridwidth = 3;
		gbc_codeField.insets = new Insets(0, 0, 5, 0);
		gbc_codeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_codeField.gridx = 1;
		gbc_codeField.gridy = 1;
		finderPanel.add(codeField, gbc_codeField);
		codeField.setColumns(10);

		JLabel lblTo = new JLabel("Airline:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 0;
		gbc_lblTo.gridy = 2;
		finderPanel.add(lblTo, gbc_lblTo);

		airlineField = new JTextField();
		airlineField.setColumns(10);
		GridBagConstraints gbc_airlineField = new GridBagConstraints();
		gbc_airlineField.gridwidth = 3;
		gbc_airlineField.insets = new Insets(0, 0, 5, 0);
		gbc_airlineField.fill = GridBagConstraints.HORIZONTAL;
		gbc_airlineField.gridx = 1;
		gbc_airlineField.gridy = 2;
		finderPanel.add(airlineField, gbc_airlineField);

		JLabel lblDay_1 = new JLabel("Name:");
		GridBagConstraints gbc_lblDay_1 = new GridBagConstraints();
		gbc_lblDay_1.anchor = GridBagConstraints.EAST;
		gbc_lblDay_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay_1.gridx = 0;
		gbc_lblDay_1.gridy = 3;
		finderPanel.add(lblDay_1, gbc_lblDay_1);

		nameField = new JTextField();
		nameField.setColumns(10);
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.gridwidth = 3;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 3;
		finderPanel.add(nameField, gbc_nameField);

		JButton btnFindReservations = new JButton("Find Reservations");
		GridBagConstraints gbc_btnFindReservations = new GridBagConstraints();
		btnFindReservations.addActionListener(new ButtionListener());
		gbc_btnFindReservations.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFindReservations.gridwidth = 4;
		gbc_btnFindReservations.gridx = 0;
		gbc_btnFindReservations.gridy = 4;
		finderPanel.add(btnFindReservations, gbc_btnFindReservations);

		return panel;
	}

	private class MyListSelectionListener implements ListSelectionListener {
		/**
		 * Called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (reserveList.getSelectedIndex() != -1) {
				Reservation flight = reserveList.getSelectedValue();
				String cost = "$" + flight.getFlight().getCostPerSeat();
				flightTextField.setText(flight.getFlight().getCode());
				airlineTextField.setText(flight.getFlight().getAirline());
				codeTextField.setText(flight.getCode());
				costTextField.setText(cost);
				nameTextField.setText(flight.getName());
				citzTextField.setText(flight.getCitizenship());
				if (flight.isActive())
					statusComboBox.setSelectedIndex(1);
				else
					statusComboBox.setSelectedIndex(0);

			}
		}

	}

	private class ButtionListener implements ActionListener {
		/**
		 * method called when Find Reservations button is pressed or Update button is
		 * pressed Find Reservations - with user input, locate any reservations that
		 * match Update - update the current reservation with updated information
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();

			if (actionCommand.equals("Find Reservations")) {
				reserveList.clearSelection();
				reserveModel.clear();

				flightTextField.setText("");
				airlineTextField.setText("");
				codeTextField.setText("");
				costTextField.setText("");
				nameTextField.setText("");
				citzTextField.setText("");
				statusComboBox.setSelectedIndex(1);

				for (Reservation i : manager.findReservations(codeField.getText(), airlineField.getText(),
						nameField.getText())) {
					reserveModel.addElement(i);
				}

			} else if (actionCommand.equals("Update")) {
				Reservation rev = reserveList.getSelectedValue();
				String name = nameTextField.getText();
				String cit = citzTextField.getText();
				int status = statusComboBox.getSelectedIndex();
				boolean stat = false;
				if (status == 1)
					stat = true;
				try {
					rev.setName(name);
				} catch (InvalidNameException e1) {
					JOptionPane.showMessageDialog(null, "Name is Empty or Null.");
					try {
						rev.setCitizenship(cit);
					} catch (InvalidCitizenshipException e11) {
						JOptionPane.showMessageDialog(null, "Citizenship is Empty or Null.");
					}
					rev.setActive(stat);
					manager.persist();
				}
			}
		}
	}
}
