package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import addInfo.StudentInfo;

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
		if (comboBoxCategory.getSelectedIndex() == 2) {
			IDtextField.setEditable(false);
			IDtextField.setFocusable(false);
		} else
			IDtextField.setEditable(true);

		JLabel registerLabel = new JLabel("-> ID not found? Click here");
		registerLabel.setBounds(165, 83, 149, 14);
		pnlParking.add(registerLabel);
		registerLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		registerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		registerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new StudentInfo();
			}

			public void mouseEntered(MouseEvent e) {
				registerLabel.setForeground(Color.blue);
			}

			public void mouseExited(MouseEvent e) {
				registerLabel.setForeground(Color.black);
			}
		});

		JPanel pnlCars = new JPanel();
		TitledBorder border2 = new TitledBorder(null, "Parked Car's", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Cambria Math", Font.BOLD, 20), SystemColor.textHighlight);
		pnlCars.setBorder(border2);
		pnlCars.setBounds(572, 231, 404, 322);
		add(pnlCars);
		pnlCars.setLayout(null);

		String[] columnTitle = { "Student ID ", "License Plate", "Occupied", "Time Parked", "Time Released" };
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

		TableColumn hiddenColumn = table.getColumnModel().getColumn(0); // to hide my first row
		table.getColumnModel().removeColumn(hiddenColumn);

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
		btnMap.setBounds(38, 124, 103, 35);
		pnlOperation.add(btnMap);
		btnMap.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.courtParkingLayout);
		});

		JButton btnHistory = new JButton("📜 History");
		btnHistory.setFocusable(false);
		btnHistory.setBounds(38, 170, 103, 35);
		pnlOperation.add(btnHistory);
		btnHistory.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.historyPanel);
		});

		JButton btnRelease = new JButton("❌ Release");
		btnRelease.setFocusable(false);
		btnRelease.setBounds(38, 81, 103, 35);
		pnlOperation.add(btnRelease);
		btnRelease.addActionListener(e -> handleRelease());

		JButton btnPark = new JButton("🚗 Park");
		btnPark.setFocusable(false);
		btnPark.setBounds(38, 35, 103, 35);
		pnlOperation.add(btnPark);
		btnPark.addActionListener(e -> {
			if (!getName().isEmpty() && getCategory() && !getPlateNumber().isEmpty()) {
				String studentID = getStudentID();
				String license = getPlateNumber();

				tableModel.addRow(new Object[] { studentID, license, null, getCurrentTime(), null });

				methods.switchPanel(frame, this, frame.courtParkingLayout);
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

		JButton btnHelp = new JButton(helpIcon);
		btnHelp.setBorderPainted(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setFocusable(false);
		btnHelp.setBounds(937, 190, 39, 30);
		add(btnHelp);
		btnHelp.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.helpPanel);
		});

		JButton btnExport = new JButton("💾 Export");
		btnExport.setBounds(38, 30, 103, 35);
		pnlExport.add(btnExport);
		btnExport.addActionListener(e -> {
			main.export();
		});

		timer.start();
	}

	private void handleRelease() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to perform this action?",
					"Confirmation", JOptionPane.YES_NO_OPTION);

			if (choice == JOptionPane.YES_OPTION) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String slotID = table.getValueAt(selectedRow, 1).toString();

				model.setValueAt(getCurrentTime(), selectedRow, 4);
				
				if (isRowFilled(selectedRow)) {
					sendData(table, selectedRow);

					release(slotID);
				} else {
					JOptionPane.showMessageDialog(null, "Please ensure all fields in the selected row are filled.");
				}
			}
		}
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
			model.setValueAt(occupied, lastRow, 2);
		}
	}

	public void release(String slotID) {
		int slotNumber = Integer.parseInt(slotID);
		
		if(slotNumber >= 90 && slotNumber <= 97)
			main.releaseCarGate(slotID);
		else if (slotNumber >= 1 && slotNumber <= 89)
			main.releaseCarCourt(slotID);
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

	private boolean isRowFilled(int row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int columnCount = table.getColumnCount();

		for (int column = 0; column < columnCount; column++) {
			Object cellValue = model.getValueAt(row, column);
			if (cellValue == null || cellValue.toString().trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private void sendData(JTable table, int row) {
		DefaultTableModel sourceModel = (DefaultTableModel) table.getModel();

		Object[] rowData = new Object[sourceModel.getColumnCount()];
		for (int col = 0; col < sourceModel.getColumnCount(); col++) {
			rowData[col] = sourceModel.getValueAt(row, col);
		}

		main.updateTableData(rowData);
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}

}