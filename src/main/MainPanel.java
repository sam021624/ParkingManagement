package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
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

		JPopupMenu suggestionsMenu = new JPopupMenu();

		IDtextField = new JTextField();
		IDtextField.setText("");
		IDtextField.setColumns(10);
		IDtextField.setBounds(155, 55, 159, 29);
		pnlParking.add(IDtextField);
		IDtextField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				fetchSuggestions();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				fetchSuggestions();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				fetchSuggestions();
			}

			private void fetchSuggestions() {
				String input = IDtextField.getText().trim();
				if (input.isEmpty()) {
					suggestionsMenu.setVisible(false);
					return;
				}
				List<String> suggestions = getSuggestionsFromDatabase(input);

				suggestionsMenu.removeAll();
				for (String suggestion : suggestions) {
					JMenuItem item = new JMenuItem(suggestion);
					item.addActionListener(event -> {
						IDtextField.setText(suggestion);
						suggestionsMenu.setVisible(false);
					});
					suggestionsMenu.add(item);
				}

				suggestionsMenu.show(IDtextField, 0, IDtextField.getHeight());
				IDtextField.requestFocusInWindow();
			}
		});

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
		btnMap.setBounds(38, 124, 103, 35);
		pnlOperation.add(btnMap);
		btnMap.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.gateParkingLayout);
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
		btnRelease.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				// Confirm action
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to perform this action?",
						"Confirmation", JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String slotID = table.getValueAt(selectedRow, 1).toString();

					model.setValueAt(getCurrentTime(), selectedRow, 3);

					if (isRowFilled(selectedRow)) {
						sendData(table, selectedRow);

						release(slotID);

						model.removeRow(selectedRow);
					} else {
						JOptionPane.showMessageDialog(null, "Please ensure all fields in the selected row are filled.");
					}
				}
			}
		});

		JButton btnPark = new JButton("🚗 Park");
		btnPark.setFocusable(false);
		btnPark.setBounds(38, 35, 103, 35);
		pnlOperation.add(btnPark);
		btnPark.addActionListener(e -> {
			if (!getName().isEmpty() && getCategory() && !getPlateNumber().isEmpty()) {
				String license = getPlateNumber();

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

	private static List<String> getSuggestionsFromDatabase(String input) {
		List<String> suggestions = new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/studentdatabase";
		String user = "root";
		String password = "root";

		String query = "SELECT student_id FROM studentInfo WHERE student_id LIKE ? LIMIT 10";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, input + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				suggestions.add(resultSet.getString("student_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return suggestions;
	}

}