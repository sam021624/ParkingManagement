package parkingpanel;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Main;
import main.MainPanel;
import main.Methods;

public class GateParkingLayout extends JPanel {
	ImageIcon car = new ImageIcon((getClass().getResource("/carvertical.png")));
	ImageIcon backIcon = new ImageIcon((getClass().getResource("/back.png")));
	ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));

	Main frame;
	MainPanel mainPanel = new MainPanel(frame);
	Methods methods = new Methods();

	private JLabel[] carLabels = new JLabel[8];
	private JButton[] occupyButtons;
	private JButton[] releaseButtons = new JButton[8];
	
	public GateParkingLayout(Main frame, JButton[] occupyButton) {
		this.frame = frame;
		this.occupyButtons = occupyButton;
		
		this.setBounds(0, 0, 986, 563);
		setLayout(null);

		carLabels[0] = createCarLabels("Occupy", 30, 35);
		carLabels[1] = createCarLabels("Occupy", 147, 35);
		carLabels[2] = createCarLabels("Occupy", 264, 35);
		carLabels[3] = createCarLabels("Occupy", 381, 35);
		carLabels[4] = createCarLabels("Occupy", 498, 35);
		carLabels[5] = createCarLabels("Occupy", 615, 35);
		carLabels[6] = createCarLabels("Occupy", 732, 35);
		carLabels[7] = createCarLabels("Occupy", 849, 35);

		JLabel lblNewLabel = new JLabel("Gate Parking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 306, 966, 246);
		add(lblNewLabel);

		JButton btnBack = new JButton(backIcon);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBack.setText("back");
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(10, 323, 78, 23);
		add(btnBack);
		btnBack.addActionListener(e -> {
			mainPanel.resetFields();
			methods.switchPanel(frame, this, frame.mainPanel);
		});

		JButton btnNext = new JButton("next", nextIcon);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		btnNext.setFocusable(false);
		btnNext.setBounds(898, 323, 78, 23);
		btnNext.setHorizontalTextPosition(SwingConstants.LEFT);
		add(btnNext);
		btnNext.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.courtParkingLayout);
		});

		// BUTTON RELEASE
		releaseButtons[0] = createReleaseButton("Release", 30, 253);
		releaseButtons[0].addActionListener(e -> {
			occupyButtons[0].setVisible(true); 
			JOptionPane.showMessageDialog(null, "Slot " + 01 + " is now released!", "Notice!",
					JOptionPane.INFORMATION_MESSAGE);

		});

		releaseButtons[1] = createReleaseButton("Release", 147, 253);
		releaseButtons[2] = createReleaseButton("Release", 264, 253);
		releaseButtons[3] = createReleaseButton("Release", 381, 253);
		releaseButtons[4] = createReleaseButton("Release", 498, 253);
		releaseButtons[5] = createReleaseButton("Release", 615, 253);
		releaseButtons[6] = createReleaseButton("Release", 732, 253);
		releaseButtons[7] = createReleaseButton("Release", 849, 253);

		// BUTTON OCCUPY
		occupyButtons[0] = createOccupyButton("Occupy", 30, 114);
		occupyButtons[0].addActionListener(e -> {
			occupyButtons[0].setVisible(false);
			releaseButtons[0].setVisible(true);
			carLabels[0].setVisible(true);
			parkSuccess("01");
			revalidate();
			repaint();
		});

		occupyButtons[1] = createOccupyButton("Occupy", 147, 114);
		occupyButtons[1].addActionListener(e -> {
			occupyButtons[1].setVisible(false);
			releaseButtons[1].setVisible(true);
			carLabels[1].setVisible(true);
			parkSuccess("02");
		});

		occupyButtons[2] = createOccupyButton("Occupy", 264, 114);
		occupyButtons[2].addActionListener(e -> {
			occupyButtons[2].setVisible(false);
			releaseButtons[2].setVisible(true);
			carLabels[2].setVisible(true);
			parkSuccess("03");
		});

		occupyButtons[3] = createOccupyButton("Occupy", 381, 114);
		occupyButtons[3].addActionListener(e -> {
			occupyButtons[3].setVisible(false);
			releaseButtons[3].setVisible(true);
			carLabels[3].setVisible(true);
			parkSuccess("04");
		});

		occupyButtons[4] = createOccupyButton("Occupy", 498, 114);
		occupyButtons[4].addActionListener(e -> {
			occupyButtons[4].setVisible(false);
			releaseButtons[4].setVisible(true);
			carLabels[4].setVisible(true);
			parkSuccess("05");
		});

		occupyButtons[5] = createOccupyButton("Occupy", 615, 114);
		occupyButtons[5].addActionListener(e -> {
			occupyButtons[5].setVisible(false);
			releaseButtons[5].setVisible(true);
			carLabels[5].setVisible(true);
			parkSuccess("06");
		});

		occupyButtons[6] = createOccupyButton("Occupy", 732, 114);
		occupyButtons[6].addActionListener(e -> {
			occupyButtons[6].setVisible(false);
			releaseButtons[6].setVisible(true);
			carLabels[6].setVisible(true);
			parkSuccess("07");
		});

		occupyButtons[7] = createOccupyButton("Occupy", 849, 114);
		occupyButtons[7].addActionListener(e -> {
			occupyButtons[7].setVisible(false);
			releaseButtons[7].setVisible(true);
			carLabels[7].setVisible(true);
			parkSuccess("08");
		});

		createLabels();

	}

	private void createLabels() {
		int lineSpacing = 117;
		for (int i = 1; i <= 8; i++) {
			JLabel label = new JLabel(String.format("%02d", i));
			int xPos = 70 + (i - 1) * lineSpacing;
			label.setBounds(xPos - 10, 215, 46, 14);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			add(label);
		}
	}

	private JLabel createCarLabels(String text, int x, int y) {
		JLabel label = new JLabel(text);
		label.setIcon(car);
		label.setBounds(x, y, 107, 169);
		label.setVisible(false);
		add(label);

		return label;
	}

	private JButton createReleaseButton(String text, int x, int y) {
		JButton button = new JButton(text);
		button.setBounds(x, y, 107, 30);
		button.setFocusable(false);
		button.setVisible(false);
		add(button);

		return button;
	}

	private JButton createOccupyButton(String text, int x, int y) {
		JButton button = new JButton(text);
		button.setBounds(x, y, 107, 30);
		button.setFocusable(false);
		add(button);

		return button;
	}

	public void releaseCar(String slotID) {
		int slotNumber = Integer.parseInt(slotID) - 1; // Convert slotId to index (e.g., "01" -> 0)
		if (slotNumber >= 0 && slotNumber < releaseButtons.length) {
			releaseButtons[slotNumber].setVisible(false);

			JOptionPane.showMessageDialog(null, "Slot " + slotID + " is now released!", "Notice!",
					JOptionPane.INFORMATION_MESSAGE);

			carLabels[slotNumber].setVisible(false);
			occupyButtons[slotNumber].setVisible(true);
		}
	}

	private void parkSuccess(String occupied) {
		JOptionPane.showMessageDialog(null, "Successfully Parked!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
		methods.switchPanel(frame, this, frame.mainPanel);
		frame.setOccupiedStatus(occupied);
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(25, 30, 960, 30);

		int line = 9;
		int lineSpacing = 117;

		for (int i = 0; i < line; i++) {
			int xPos = 25 + i * lineSpacing;
			g2d.drawLine(xPos, 30, xPos, 200);
		}
	}
}
