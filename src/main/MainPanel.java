package main;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {
	Main main;
	Methods methods = new Methods();
	
	ImageIcon stiIcon = new ImageIcon((getClass().getResource("/stiLogo.png")));
	ImageIcon searchIcon = new ImageIcon((getClass().getResource("/search.png")));
	ImageIcon helpIcon = new ImageIcon((getClass().getResource("/help.png")));
	
	private JTable table;
	private JTextField nameTextField;
	private JTextField plateTextField;
	private JTextField IDtextField;

	JComboBox<String> comboBoxDate = new JComboBox<>();
	JComboBox<String> comboBoxCategory = new JComboBox<String>();

	Date currentDate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM-dd-yyyy");

	public MainPanel(Main frame) {
		this.main = frame;
		
		this.setBackground(Color.yellow);
		this.setBounds(0, 0, 986, 563);
		setLayout(null);

		JLabel lblCurrentTime = new JLabel();
		lblCurrentTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentTime.setBounds(853, 10, 105, 30);
		add(lblCurrentTime);

		Timer timer = new Timer(1000, e -> lblCurrentTime.setText(getCurrentTime()));

		JLabel lblCurrentDate = new JLabel(dateFormat.format(currentDate));
		lblCurrentDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentDate.setBounds(839, 46, 119, 30);
		add(lblCurrentDate);

		JPanel pnlParking = new JPanel();
		pnlParking.setBounds(10, 231, 371, 322);
		pnlParking.setLayout(null);
		pnlParking.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Parking",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Cambria Math", Font.BOLD, 20),
				SystemColor.textHighlight));
		add(pnlParking);

		JLabel lblPlateNum = new JLabel("Plate Number:");
		lblPlateNum.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblPlateNum.setBounds(10, 243, 135, 37);
		pnlParking.add(lblPlateNum);

		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblFullName.setBounds(10, 147, 135, 37);
		pnlParking.add(lblFullName);

		JLabel lblDateParked = new JLabel("Parking Date:");
		lblDateParked.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblDateParked.setBounds(10, 195, 135, 37);
		pnlParking.add(lblDateParked);

		nameTextField = new JTextField();
		nameTextField.setBounds(155, 151, 159, 29);
		pnlParking.add(nameTextField);
		nameTextField.setColumns(10);

		plateTextField = new JTextField();
		plateTextField.setColumns(10);
		plateTextField.setBounds(155, 247, 159, 29);
		pnlParking.add(plateTextField);

		comboBoxDate.setBounds(155, 199, 159, 29);
		pnlParking.add(comboBoxDate);
		comboBoxDate.addItem(dateFormat.format(currentDate));

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblID.setBounds(10, 51, 135, 37);
		pnlParking.add(lblID);

		IDtextField = new JTextField();
		IDtextField.setText("");
		IDtextField.setColumns(10);
		IDtextField.setBounds(155, 55, 159, 29);
		pnlParking.add(IDtextField);

		JButton btnSearch = new JButton(searchIcon);
		btnSearch.setBounds(320, 51, 41, 37);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setFocusPainted(false);
		pnlParking.add(btnSearch);
		btnSearch.addActionListener(e -> {
			methods.getInfoDatabase(getStudentID(), frame);
		});

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblCategory.setBounds(10, 99, 135, 37);
		pnlParking.add(lblCategory);

		comboBoxCategory.setBounds(155, 103, 159, 29);
		comboBoxCategory.addItem("Student");
		comboBoxCategory.addItem("Teacher");
		comboBoxCategory.addItem("Visitor");
		comboBoxCategory.setSelectedIndex(-1);
		pnlParking.add(comboBoxCategory);
		if(comboBoxCategory.getSelectedIndex() == 2) {
			IDtextField.setEditable(false);
			IDtextField.setFocusable(false);
		} else 
			IDtextField.setEditable(true);

		JPanel pnlCars = new JPanel();
		TitledBorder border2 = new TitledBorder(null, "Parked Car's", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Cambria Math", Font.BOLD, 20), SystemColor.textHighlight);
		pnlCars.setBorder(border2);
		pnlCars.setBounds(572, 231, 404, 322);
		add(pnlCars);
		pnlCars.setLayout(null);

		String[] columnTitle = { "License Plate", "Occupied", "Time Parked", "Time Released" };
		Object[][] data = {};

		DefaultTableModel tableModel = new DefaultTableModel(data, columnTitle) {
			public boolean isCellEditable(int row, int column) {
				return false; // editable to false
			}
		};
		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setCellRenderer(centerRenderer);
        }

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 24, 384, 287);
		pnlCars.add(scrollPane);

		JPanel pnlOperation = new JPanel();
		TitledBorder border3 = new TitledBorder(null, "Operations", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Cambria Math", Font.BOLD, 20), SystemColor.textHighlight);
		pnlOperation.setBorder(border3);
		pnlOperation.setBounds(391, 231, 171, 228);
		add(pnlOperation);
		pnlOperation.setLayout(null);

		JButton btnMap = new JButton("🌐 Map");
		btnMap.setFocusable(false);
		btnMap.setBounds(40, 124, 95, 35);
		pnlOperation.add(btnMap);
		btnMap.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.gateParkingLayout);
		});

		JButton btnHistory = new JButton("📜 History");
		btnHistory.setFocusable(false);
		btnHistory.setBounds(40, 170, 95, 35);
		pnlOperation.add(btnHistory);
		btnHistory.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.historyPanel);
		});

		JButton btnRelease = new JButton("❌ Release");
		btnRelease.setFocusable(false);
		btnRelease.setBounds(40, 81, 95, 35);
		pnlOperation.add(btnRelease);
		btnRelease.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to perform this action?",
														   "Confirmation", JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setValueAt(getCurrentTime(), selectedRow, 3);
					
					Object value = table.getValueAt(selectedRow, 1);
					
					String slotID = value.toString();
					
					release(slotID);
				}

			}
		});

		JButton btnPark = new JButton("🚗 Park");
		btnPark.setFocusable(false);
		btnPark.setBounds(40, 35, 95, 35);
		pnlOperation.add(btnPark);
		btnPark.addActionListener(e -> {
		    if (!getName().isEmpty() && getCategory() && !getPlateNumber().isEmpty()) {
		        String license = getPlateNumber();
		        int newRow = tableModel.getRowCount(); 
		        
		        tableModel.addRow(new Object[] { license, null, getCurrentTime(), null });
		        
		        methods.switchPanel(frame, this, frame.gateParkingLayout);
		        resetFields();
		        this.revalidate();
		        this.repaint();
		    } else {
		        JOptionPane.showMessageDialog(null, "Try again");
		    }
		});


		JLabel lblLogo = new JLabel(stiIcon);
		lblLogo.setBounds(10, 10, 317, 202);
		add(lblLogo);

		JPanel pnlExport = new JPanel();
		pnlExport.setBorder(new TitledBorder(null, "Export", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Cambria Math", Font.BOLD, 20), SystemColor.textHighlight));
		pnlExport.setBounds(391, 470, 171, 83);
		add(pnlExport);
		pnlExport.setLayout(null);
		
		JButton btnExport = new JButton("💾 Export");
		btnExport.setBounds(40, 30, 95, 35);
		pnlExport.add(btnExport);
		
		JButton btnHelp = new JButton(helpIcon);
		btnHelp.setBorderPainted(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setFocusable(false);
		btnHelp.setBounds(937, 190, 39, 30);
		add(btnHelp);
		btnHelp.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.helpPanel);
		});

		timer.start();
	}

	private String getStudentID() {
		return IDtextField.getText();
	}

	public void resetFields() {
		IDtextField.setText("");
		nameTextField.setText("");
		plateTextField.setText("");
		comboBoxCategory.setSelectedIndex(-1);
	}

	public void updateFields(String category, String fullName, String plateNumber) {
		nameTextField.setText(fullName);
		comboBoxCategory.setSelectedIndex(category.equals("Student") ? 0 : 1);
		plateTextField.setText(plateNumber);
	}
	
	public void occupied(String occupied) {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    int lastRow = model.getRowCount() - 1;
	    if (lastRow >= 0) {
	        model.setValueAt(occupied, lastRow, 1);
	    }
	}
	
	public void release(String slotID) {
		main.releaseCar(slotID);
	}

	public String getName() {
		return nameTextField.getText();
	}

	public boolean getCategory() {
		if (comboBoxCategory.getSelectedIndex() == 0 || comboBoxCategory.getSelectedIndex() == 1)
			return true;
		else
			return false;
	}

	public String getPlateNumber() {
		return plateTextField.getText();
	}

	public String getCurrentTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
		String time = currentTime.format(timeFormat);
		return time;
	}
}