package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import helpPanel.HelpPanel;
import history.History;
import parkingpanel.CourtParkingLayout;
import parkingpanel.ExtendedParkingLayout;
import parkingpanel.GateParkingLayout;

public class Main extends JFrame {

	ImageIcon stiIcon = new ImageIcon(getClass().getResource("/stiIcon.png"));
	
	public MainPanel mainPanel = new MainPanel(this);
	public HelpPanel helpPanel = new HelpPanel(this);
	public History historyPanel = new History(this);
	public GateParkingLayout gateParkingLayout = new GateParkingLayout(this);
	public CourtParkingLayout courtParkingLayout = new CourtParkingLayout(this);
	public ExtendedParkingLayout extendedParkingLayout = new ExtendedParkingLayout(this);

	public Main() {
		getContentPane().add(mainPanel);

		this.setTitle("Parking Management System");
		this.setIconImage(stiIcon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void export() {
		historyPanel.export();
	}

	public void updateInfo(String category, String studentName, String plateNumber) {
		mainPanel.updateFields(category, studentName, plateNumber);
	}

	public void updateTableData(Object[] rowData) {
		historyPanel.updateTableData(rowData);
	}

	public void setOccupiedStatus(String occupied) {
		mainPanel.occupied(occupied);
	}

	public void releaseCar(String slotID) {
		gateParkingLayout.releaseCar(slotID);
	}

	public static void main(String[] args) {
		new Main();
	}
}