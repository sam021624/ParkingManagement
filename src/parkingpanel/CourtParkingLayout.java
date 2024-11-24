package parkingpanel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.Main;
import main.Methods;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.*;
import java.awt.*;

public class CourtParkingLayout extends JPanel {
	Methods methods = new Methods();

	ImageIcon layoutIcon = new ImageIcon(getClass().getResource("/layout.png"));
	ImageIcon backIcon = new ImageIcon((getClass().getResource("/back.png")));
	ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));

	public CourtParkingLayout(Main frame) {
		this.setBounds(0, 0, 986, 563);
		setLayout(null);

		// Scale the image to fit the label
		Image originalImage = layoutIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(966, 541, Image.SCALE_SMOOTH); // Resize to the JLabel size
		ImageIcon scaledIcon = new ImageIcon(scaledImage); // Create new ImageIcon with the scaled image

		JButton btnBack = new JButton(backIcon);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(10, 323, 35, 23);
		add(btnBack);
		btnBack.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.gateParkingLayout);
		});
		
		// Create the JLabel with the scaled image
		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 0, 986, 563);
		add(lblNewLabel);
	}
}
