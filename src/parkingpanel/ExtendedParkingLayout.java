package parkingpanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import main.Methods;

public class ExtendedParkingLayout extends JPanel{
	Methods methods = new Methods();
	
	ImageIcon layoutIcon = new ImageIcon(getClass().getResource("/layout1.png"));
	ImageIcon backIcon = new ImageIcon((getClass().getResource("/back.png")));

	public ExtendedParkingLayout(Main frame) {
		this.setBounds(0, 0, 986, 563);
		setLayout(null);

		Image originalImage = layoutIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(966, 541, Image.SCALE_SMOOTH); 
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JButton btnBack = new JButton(backIcon);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(10, 323, 35, 23);
		add(btnBack);
		btnBack.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.courtParkingLayout);
		});
		
		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 0, 986, 563);
		add(lblNewLabel);
	}
}
