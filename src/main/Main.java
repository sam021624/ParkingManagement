package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import helpPanel.HelpPanel;
import history.History;
import parkingpanel.CourtParkingLayout;
import parkingpanel.GateParkingLayout;

public class Main extends JFrame {
	
	ImageIcon stiIcon = new ImageIcon(getClass().getResource("/stiIcon.png"));
	
	public MainPanel mainPanel = new MainPanel(this);
	public HelpPanel helpPanel = new HelpPanel(this);
	public History historyPanel = new History(this);
	public GateParkingLayout gateParkingLayout = new GateParkingLayout(this);
	public CourtParkingLayout courtParkingLayout = new CourtParkingLayout(this);
	
	public Main() {
		getContentPane().add(mainPanel);

		this.setTitle("Parking Management System");
		this.setIconImage(stiIcon.getImage());
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				int response = JOptionPane.showConfirmDialog(
					Main.this, 
					"Are you sure you want to exit?", 
					"Confirm Exit", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE
				);
				if (response == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
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
	
	public void addtotalCars() {
		mainPanel.addtotalCars();
	}

	public void minustotalCars() {
		mainPanel.minustotalCars();
	}
	
	public void buttonState(boolean status) {
		courtParkingLayout.buttonState(status);
		gateParkingLayout.buttonState(status);
	}
	
	public void releaseCarCourt(String slotID) {
		courtParkingLayout.releaseCar(slotID);
	}
	
	public void releaseCarGate(String slotID) {
		gateParkingLayout.releaseCarGate(slotID);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}