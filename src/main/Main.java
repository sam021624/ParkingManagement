package main;

import javax.swing.JFrame;

import helpPanel.HelpPanel;
import history.History;
import parkingpanel.CourtParkingLayout;
import parkingpanel.GateParkingLayout;

public class Main extends JFrame {

	public MainPanel mainPanel = new MainPanel(this);
	public HelpPanel helpPanel = new HelpPanel(this);
	public History historyPanel = new History(this);
	public GateParkingLayout gateParkingLayout = new GateParkingLayout(this);
	public CourtParkingLayout courtParkingLayout1 = new CourtParkingLayout(this);

	public Main() {
		getContentPane().add(mainPanel);

		//this is a comment, should be viewed in my computer
		
		//this should also be seen in laptop
		
		this.setTitle("Parking Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void updateInfo(String category, String studentName, String plateNumber) {
		mainPanel.updateFields(category, studentName, plateNumber);
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