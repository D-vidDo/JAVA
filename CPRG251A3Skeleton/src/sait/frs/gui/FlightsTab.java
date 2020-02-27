package sait.frs.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import sait.frs.manager.Manager;
import sait.frs.problemdomain.Flight;

/**
 * Holds the components for the flights tab.
 * 
 */
public class FlightsTab extends TabBase 
{
	/**
	 * Instance of travel manager.
	 */
	private Manager manager;
	
	
	/**
	 * List of flights.
	 */
	private JList<Flight> flightsList;
	
	private DefaultListModel<Flight> flightsModel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	/**
	 * Creates the components for flights tab.
	 */
	public FlightsTab(Manager manager) 
	{
		this.manager = manager;
		panel.setLayout(new BorderLayout());
	
		
		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = createCenterPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Creates the north panel.
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() 
	{
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Flights", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title);
		
		return panel;
	}
	
	/**
	 * Creates the center panel.
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() 
	{
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
		
		JPanel reservePanel = new JPanel();
		panel.add(reservePanel, BorderLayout.EAST);
		GridBagLayout gbl_reservePanel = new GridBagLayout();
		gbl_reservePanel.columnWidths = new int[] {37, 2};
		gbl_reservePanel.rowHeights = new int[]{13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_reservePanel.columnWeights = new double[]{1.0, 1.0};
		gbl_reservePanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		reservePanel.setLayout(gbl_reservePanel);
		
		JLabel reserveTitle = new JLabel("Reserve");
		GridBagConstraints gbc_reserveTitle = new GridBagConstraints();
		gbc_reserveTitle.gridwidth = 2;
		gbc_reserveTitle.insets = new Insets(0, 0, 5, 0);
		gbc_reserveTitle.anchor = GridBagConstraints.NORTH;
		gbc_reserveTitle.gridx = 0;
		gbc_reserveTitle.gridy = 0;
		reservePanel.add(reserveTitle, gbc_reserveTitle);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 3;
		reservePanel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 4;
		reservePanel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblFlight = new JLabel("Flight:");
		GridBagConstraints gbc_lblFlight = new GridBagConstraints();
		gbc_lblFlight.anchor = GridBagConstraints.EAST;
		gbc_lblFlight.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlight.gridx = 0;
		gbc_lblFlight.gridy = 2;
		reservePanel.add(lblFlight, gbc_lblFlight);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 2;
		reservePanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAirline = new JLabel("Airline:");
		GridBagConstraints gbc_lblAirline = new GridBagConstraints();
		gbc_lblAirline.anchor = GridBagConstraints.EAST;
		gbc_lblAirline.insets = new Insets(0, 0, 5, 5);
		gbc_lblAirline.gridx = 0;
		gbc_lblAirline.gridy = 3;
		reservePanel.add(lblAirline, gbc_lblAirline);
		
		JLabel lblDay = new JLabel("Day:");
		GridBagConstraints gbc_lblDay = new GridBagConstraints();
		gbc_lblDay.anchor = GridBagConstraints.EAST;
		gbc_lblDay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay.gridx = 0;
		gbc_lblDay.gridy = 4;
		reservePanel.add(lblDay, gbc_lblDay);
		
		JLabel lblTime = new JLabel("Time:");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.EAST;
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 5;
		reservePanel.add(lblTime, gbc_lblTime);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		reservePanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCost = new JLabel("Cost:");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.EAST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 6;
		reservePanel.add(lblCost, gbc_lblCost);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		reservePanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 7;
		reservePanel.add(lblName, gbc_lblName);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 7;
		reservePanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCitizenship = new JLabel("Citizenship:");
		GridBagConstraints gbc_lblCitizenship = new GridBagConstraints();
		gbc_lblCitizenship.anchor = GridBagConstraints.EAST;
		gbc_lblCitizenship.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitizenship.gridx = 0;
		gbc_lblCitizenship.gridy = 8;
		reservePanel.add(lblCitizenship, gbc_lblCitizenship);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 8;
		reservePanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnReserve = new JButton("Reserve");
		GridBagConstraints gbc_btnReserve = new GridBagConstraints();
		gbc_btnReserve.gridwidth = 2;
		gbc_btnReserve.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReserve.insets = new Insets(10, 0, 0, 5);
		gbc_btnReserve.gridx = 0;
		gbc_btnReserve.gridy = 9;
		reservePanel.add(btnReserve, gbc_btnReserve);
		
		JPanel finderPanel = new JPanel();
		panel.add(finderPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_finderPanel = new GridBagLayout();
		gbl_finderPanel.columnWidths = new int[] {10, 0, 0, 0, 0};
		gbl_finderPanel.rowHeights = new int[] {13, 0, 0, 0, 0, 5};
		gbl_finderPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_finderPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		finderPanel.setLayout(gbl_finderPanel);
		
		JLabel finderTitle = new JLabel("Flight Finder");
		finderTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_finderTitle = new GridBagConstraints();
		gbc_finderTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_finderTitle.insets = new Insets(19, 0, 5, 5);
		gbc_finderTitle.gridx = 2;
		gbc_finderTitle.gridy = 0;
		finderPanel.add(finderTitle, gbc_finderTitle);
		
		JLabel lblFrom = new JLabel("From");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.anchor = GridBagConstraints.WEST;
		gbc_lblFrom.gridx = 0;
		gbc_lblFrom.gridy = 1;
		finderPanel.add(lblFrom, gbc_lblFrom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.add(comboBox, "HELLO");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		finderPanel.add(comboBox, gbc_comboBox);
		
		
		JLabel lblTo = new JLabel("To:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.anchor = GridBagConstraints.WEST;
		gbc_lblTo.gridx = 0;
		gbc_lblTo.gridy = 2;
		finderPanel.add(lblTo, gbc_lblTo);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 2;
		finderPanel.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblDay_1 = new JLabel("Day:");
		GridBagConstraints gbc_lblDay_1 = new GridBagConstraints();
		gbc_lblDay_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay_1.anchor = GridBagConstraints.WEST;
		gbc_lblDay_1.gridx = 0;
		gbc_lblDay_1.gridy = 3;
		finderPanel.add(lblDay_1, gbc_lblDay_1);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 3;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 3;
		finderPanel.add(comboBox_2, gbc_comboBox_2);
		
		JButton btnFindFlights = new JButton("Find Flights");
		GridBagConstraints gbc_btnFindFlights = new GridBagConstraints();
		gbc_btnFindFlights.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFindFlights.gridwidth = 4;
		gbc_btnFindFlights.gridx = 0;
		gbc_btnFindFlights.gridy = 4;
		finderPanel.add(btnFindFlights, gbc_btnFindFlights);
		
		return panel;
	}
	
	private class MyListSelectionListener implements ListSelectionListener 
	{
		/**
		 * Called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
		}
		
	}
}