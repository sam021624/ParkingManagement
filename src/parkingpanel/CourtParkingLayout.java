package parkingpanel;

import main.Main;
import main.Methods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourtParkingLayout extends JPanel {
	private JButton[] occupyButtons;

	Main frame;
	
	Methods methods = new Methods();

	ImageIcon layoutIcon = new ImageIcon(getClass().getResource("/layout.png"));
	ImageIcon backIcon = new ImageIcon((getClass().getResource("/back.png")));
	ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));

	public CourtParkingLayout(Main frame, JButton[] occupyButtons) {
		this.frame = frame;
		this.setBounds(0, 0, 986, 563);
		this.occupyButtons = occupyButtons;
		setLayout(null);

		Image originalImage = layoutIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(966, 541, Image.SCALE_SMOOTH); 
		ImageIcon scaledIcon = new ImageIcon(scaledImage); 

		JButton btnBack = new JButton(backIcon);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBack.setText("back");
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(10, 323, 78, 23);
		add(btnBack);
		btnBack.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.gateParkingLayout);
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
			methods.switchPanel(frame, this, frame.extendedParkingLayout);
		});
		
//		occupyButtons[9] = new JButton("New button");
//		occupyButtons[9].setBounds(464, 208, 40, 21);
//		add(occupyButtons[9]);
//		occupyButtons[9].addActionListener(e -> {
//			parkSuccess("15");
//		});
		
		JButton button1 = new JButton();
		button1.setFocusable(false);
		button1.setBounds(464, 208, 40, 21);
		add(button1);
		button1.addActionListener(e -> {
			button1.setVisible(false);
		});
		
		JButton button1_1 = new JButton();
		button1_1.setFocusable(false);
		button1_1.setBounds(464, 179, 40, 21);
		add(button1_1);
		
		JButton button1_1_1 = new JButton();
		button1_1_1.setFocusable(false);
		button1_1_1.setBounds(464, 120, 40, 21);
		add(button1_1_1);
		
		JButton button1_2 = new JButton();
		button1_2.setFocusable(false);
		button1_2.setBounds(464, 149, 40, 21);
		add(button1_2);
		
		JButton button1_1_2 = new JButton();
		button1_1_2.setFocusable(false);
		button1_1_2.setBounds(464, 91, 40, 21);
		add(button1_1_2);
		
		JButton button1_3 = new JButton();
		button1_3.setFocusable(false);
		button1_3.setBounds(464, 120, 40, 21);
		add(button1_3);
		
		JButton button1_1_3 = new JButton();
		button1_1_3.setFocusable(false);
		button1_1_3.setBounds(553, 208, 40, 21);
		add(button1_1_3);
		
		JButton button1_1_1_1 = new JButton();
		button1_1_1_1.setFocusable(false);
		button1_1_1_1.setBounds(553, 149, 40, 21);
		add(button1_1_1_1);
		
		JButton button1_2_1 = new JButton();
		button1_2_1.setFocusable(false);
		button1_2_1.setBounds(553, 178, 40, 21);
		add(button1_2_1);
		
		JButton button1_1_2_1 = new JButton();
		button1_1_2_1.setFocusable(false);
		button1_1_2_1.setBounds(553, 120, 40, 21);
		add(button1_1_2_1);
		
		JButton button1_3_1 = new JButton();
		button1_3_1.setFocusable(false);
		button1_3_1.setBounds(553, 149, 40, 21);
		add(button1_3_1);
		
		JButton button1_1_4 = new JButton();
		button1_1_4.setFocusable(false);
		button1_1_4.setBounds(603, 208, 40, 21);
		add(button1_1_4);
		
		JButton button1_1_1_2 = new JButton();
		button1_1_1_2.setFocusable(false);
		button1_1_1_2.setBounds(603, 149, 40, 21);
		add(button1_1_1_2);
		
		JButton button1_2_2 = new JButton();
		button1_2_2.setFocusable(false);
		button1_2_2.setBounds(603, 178, 40, 21);
		add(button1_2_2);
		
		JButton button1_1_2_2 = new JButton();
		button1_1_2_2.setFocusable(false);
		button1_1_2_2.setBounds(603, 120, 40, 21);
		add(button1_1_2_2);
		
		JButton button1_3_2 = new JButton();
		button1_3_2.setFocusable(false);
		button1_3_2.setBounds(603, 149, 40, 21);
		add(button1_3_2);
		
		JButton button1_2_2_1 = new JButton();
		button1_2_2_1.setFocusable(false);
		button1_2_2_1.setBounds(603, 91, 40, 21);
		add(button1_2_2_1);
		
		JButton button1_1_2_2_1 = new JButton();
		button1_1_2_2_1.setFocusable(false);
		button1_1_2_2_1.setBounds(603, 33, 40, 21);
		add(button1_1_2_2_1);
		
		JButton button1_3_2_1 = new JButton();
		button1_3_2_1.setFocusable(false);
		button1_3_2_1.setBounds(603, 62, 40, 21);
		add(button1_3_2_1);
		
		JButton button1_2_2_2 = new JButton();
		button1_2_2_2.setFocusable(false);
		button1_2_2_2.setBounds(553, 91, 40, 21);
		add(button1_2_2_2);
		
		JButton button1_1_2_2_2 = new JButton();
		button1_1_2_2_2.setFocusable(false);
		button1_1_2_2_2.setBounds(553, 33, 40, 21);
		add(button1_1_2_2_2);
		
		JButton button1_3_2_2 = new JButton();
		button1_3_2_2.setFocusable(false);
		button1_3_2_2.setBounds(553, 62, 40, 21);
		add(button1_3_2_2);
		
		JButton button1_2_2_1_1 = new JButton();
		button1_2_2_1_1.setFocusable(false);
		button1_2_2_1_1.setBounds(450, 507, 40, 21);
		add(button1_2_2_1_1);
		
		JButton button1_1_2_2_1_1 = new JButton();
		button1_1_2_2_1_1.setFocusable(false);
		button1_1_2_2_1_1.setBounds(450, 449, 40, 21);
		add(button1_1_2_2_1_1);
		
		JButton button1_3_2_1_1 = new JButton();
		button1_3_2_1_1.setFocusable(false);
		button1_3_2_1_1.setBounds(450, 478, 40, 21);
		add(button1_3_2_1_1);
		
		JButton button1_2_2_2_1 = new JButton();
		button1_2_2_2_1.setFocusable(false);
		button1_2_2_2_1.setBounds(400, 507, 40, 21);
		add(button1_2_2_2_1);
		
		JButton button1_1_2_2_2_1 = new JButton();
		button1_1_2_2_2_1.setFocusable(false);
		button1_1_2_2_2_1.setBounds(400, 449, 40, 21);
		add(button1_1_2_2_2_1);
		
		JButton button1_3_2_2_1 = new JButton();
		button1_3_2_2_1.setFocusable(false);
		button1_3_2_2_1.setBounds(400, 478, 40, 21);
		add(button1_3_2_2_1);
		
		JButton button1_2_2_1_2 = new JButton();
		button1_2_2_1_2.setFocusable(false);
		button1_2_2_1_2.setBounds(450, 418, 40, 21);
		add(button1_2_2_1_2);
		
		JButton button1_1_2_2_1_2 = new JButton();
		button1_1_2_2_1_2.setFocusable(false);
		button1_1_2_2_1_2.setBounds(450, 360, 40, 21);
		add(button1_1_2_2_1_2);
		
		JButton button1_3_2_1_2 = new JButton();
		button1_3_2_1_2.setFocusable(false);
		button1_3_2_1_2.setBounds(450, 389, 40, 21);
		add(button1_3_2_1_2);
		
		JButton button1_2_2_2_2 = new JButton();
		button1_2_2_2_2.setFocusable(false);
		button1_2_2_2_2.setBounds(400, 418, 40, 21);
		add(button1_2_2_2_2);
		
		JButton button1_1_2_2_2_2 = new JButton();
		button1_1_2_2_2_2.setFocusable(false);
		button1_1_2_2_2_2.setBounds(400, 360, 40, 21);
		add(button1_1_2_2_2_2);
		
		JButton button1_3_2_2_2 = new JButton();
		button1_3_2_2_2.setFocusable(false);
		button1_3_2_2_2.setBounds(400, 389, 40, 21);
		add(button1_3_2_2_2);
		
		JButton button1_1_3_1 = new JButton();
		button1_1_3_1.setFocusable(false);
		button1_1_3_1.setBounds(547, 507, 40, 21);
		add(button1_1_3_1);
		
		JButton button1_1_3_1_1 = new JButton();
		button1_1_3_1_1.setFocusable(false);
		button1_1_3_1_1.setBounds(547, 478, 40, 21);
		add(button1_1_3_1_1);
		
		JButton button1_1_3_1_2 = new JButton();
		button1_1_3_1_2.setFocusable(false);
		button1_1_3_1_2.setBounds(547, 449, 40, 21);
		add(button1_1_3_1_2);
		
		JButton button1_1_3_1_1_1 = new JButton();
		button1_1_3_1_1_1.setFocusable(false);
		button1_1_3_1_1_1.setBounds(547, 420, 40, 21);
		add(button1_1_3_1_1_1);
		
		JButton button1_1_3_1_3 = new JButton();
		button1_1_3_1_3.setFocusable(false);
		button1_1_3_1_3.setBounds(547, 389, 40, 21);
		add(button1_1_3_1_3);
		
		JButton button1_1_3_1_1_2 = new JButton();
		button1_1_3_1_1_2.setFocusable(false);
		button1_1_3_1_1_2.setBounds(547, 360, 40, 21);
		add(button1_1_3_1_1_2);
		
		JButton button1_1_3_1_4 = new JButton();
		button1_1_3_1_4.setFocusable(false);
		button1_1_3_1_4.setBounds(594, 507, 40, 21);
		add(button1_1_3_1_4);
		
		JButton button1_1_3_1_1_3 = new JButton();
		button1_1_3_1_1_3.setFocusable(false);
		button1_1_3_1_1_3.setBounds(594, 478, 40, 21);
		add(button1_1_3_1_1_3);
		
		JButton button1_1_3_1_2_1 = new JButton();
		button1_1_3_1_2_1.setFocusable(false);
		button1_1_3_1_2_1.setBounds(594, 449, 40, 21);
		add(button1_1_3_1_2_1);
		
		JButton button1_1_3_1_1_1_1 = new JButton();
		button1_1_3_1_1_1_1.setFocusable(false);
		button1_1_3_1_1_1_1.setBounds(594, 420, 40, 21);
		add(button1_1_3_1_1_1_1);
		
		JButton button1_1_3_1_3_1 = new JButton();
		button1_1_3_1_3_1.setFocusable(false);
		button1_1_3_1_3_1.setBounds(594, 389, 40, 21);
		add(button1_1_3_1_3_1);
		
		JButton button1_1_3_1_1_2_1 = new JButton();
		button1_1_3_1_1_2_1.setFocusable(false);
		button1_1_3_1_1_2_1.setBounds(594, 360, 40, 21);
		add(button1_1_3_1_1_2_1);
		
		JButton button1_1_3_1_5 = new JButton();
		button1_1_3_1_5.setFocusable(false);
		button1_1_3_1_5.setBounds(696, 507, 40, 21);
		add(button1_1_3_1_5);
		
		JButton button1_1_3_1_1_4 = new JButton();
		button1_1_3_1_1_4.setFocusable(false);
		button1_1_3_1_1_4.setBounds(696, 478, 40, 21);
		add(button1_1_3_1_1_4);
		
		JButton button1_1_3_1_2_2 = new JButton();
		button1_1_3_1_2_2.setFocusable(false);
		button1_1_3_1_2_2.setBounds(696, 449, 40, 21);
		add(button1_1_3_1_2_2);
		
		JButton button1_1_3_1_1_1_2 = new JButton();
		button1_1_3_1_1_1_2.setFocusable(false);
		button1_1_3_1_1_1_2.setBounds(696, 420, 40, 21);
		add(button1_1_3_1_1_1_2);
		
		JButton button1_1_3_1_3_2 = new JButton();
		button1_1_3_1_3_2.setFocusable(false);
		button1_1_3_1_3_2.setBounds(696, 389, 40, 21);
		add(button1_1_3_1_3_2);
		
		JButton button1_1_3_1_1_2_2 = new JButton();
		button1_1_3_1_1_2_2.setFocusable(false);
		button1_1_3_1_1_2_2.setBounds(696, 360, 40, 21);
		add(button1_1_3_1_1_2_2);
		
		JButton button1_1_3_1_4_1 = new JButton();
		button1_1_3_1_4_1.setFocusable(false);
		button1_1_3_1_4_1.setBounds(742, 507, 40, 21);
		add(button1_1_3_1_4_1);
		
		JButton button1_1_3_1_1_3_1 = new JButton();
		button1_1_3_1_1_3_1.setFocusable(false);
		button1_1_3_1_1_3_1.setBounds(742, 478, 40, 21);
		add(button1_1_3_1_1_3_1);
		
		JButton button1_1_3_1_2_1_1 = new JButton();
		button1_1_3_1_2_1_1.setFocusable(false);
		button1_1_3_1_2_1_1.setBounds(742, 449, 40, 21);
		add(button1_1_3_1_2_1_1);
		
		JButton button1_1_3_1_1_1_1_1 = new JButton();
		button1_1_3_1_1_1_1_1.setFocusable(false);
		button1_1_3_1_1_1_1_1.setBounds(742, 420, 40, 21);
		add(button1_1_3_1_1_1_1_1);
		
		JButton button1_1_3_1_3_1_1 = new JButton();
		button1_1_3_1_3_1_1.setFocusable(false);
		button1_1_3_1_3_1_1.setBounds(742, 389, 40, 21);
		add(button1_1_3_1_3_1_1);
		
		JButton button1_1_3_1_1_2_1_1 = new JButton();
		button1_1_3_1_1_2_1_1.setFocusable(false);
		button1_1_3_1_1_2_1_1.setBounds(743, 360, 40, 21);
		add(button1_1_3_1_1_2_1_1);
		
		JButton button1_1_2_2_2_2_1 = new JButton();
		button1_1_2_2_2_2_1.setFocusable(false);
		button1_1_2_2_2_2_1.setBounds(315, 360, 40, 21);
		add(button1_1_2_2_2_2_1);
		
		JButton button1_3_2_2_2_1 = new JButton();
		button1_3_2_2_2_1.setFocusable(false);
		button1_3_2_2_2_1.setBounds(315, 389, 40, 21);
		add(button1_3_2_2_2_1);
		
		JButton button1_2_2_2_2_1 = new JButton();
		button1_2_2_2_2_1.setFocusable(false);
		button1_2_2_2_2_1.setBounds(315, 418, 40, 21);
		add(button1_2_2_2_2_1);
		
		JButton button1_1_2_2_2_1_1 = new JButton();
		button1_1_2_2_2_1_1.setFocusable(false);
		button1_1_2_2_2_1_1.setBounds(315, 449, 40, 21);
		add(button1_1_2_2_2_1_1);
		
		JButton button1_3_2_2_1_1 = new JButton();
		button1_3_2_2_1_1.setFocusable(false);
		button1_3_2_2_1_1.setBounds(315, 478, 40, 21);
		add(button1_3_2_2_1_1);
		
		JButton button1_2_2_2_1_1 = new JButton();
		button1_2_2_2_1_1.setFocusable(false);
		button1_2_2_2_1_1.setBounds(315, 507, 40, 21);
		add(button1_2_2_2_1_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(688, 33, 22, 38);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(720, 33, 22, 38);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(752, 33, 22, 38);
		add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setBounds(784, 33, 22, 38);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setBounds(686, 179, 22, 38);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.setBounds(718, 179, 22, 38);
		add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("");
		btnNewButton_2_1_1_1.setBounds(781, 179, 22, 38);
		add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_2 = new JButton("");
		btnNewButton_2_1_1_2.setBounds(749, 179, 22, 38);
		add(btnNewButton_2_1_1_2);
		
		JButton btnNewButton_2_1_2 = new JButton("");
		btnNewButton_2_1_2.setBounds(826, 372, 22, 38);
		add(btnNewButton_2_1_2);
		
		JButton btnNewButton_2_1_3 = new JButton("");
		btnNewButton_2_1_3.setBounds(858, 372, 22, 38);
		add(btnNewButton_2_1_3);
		
		JButton btnNewButton_2_1_4 = new JButton("");
		btnNewButton_2_1_4.setBounds(890, 372, 22, 38);
		add(btnNewButton_2_1_4);
		
		JButton btnNewButton_2_1_5 = new JButton("");
		btnNewButton_2_1_5.setBounds(920, 372, 22, 38);
		add(btnNewButton_2_1_5);
		
		JButton btnNewButton_2_1_2_1 = new JButton("");
		btnNewButton_2_1_2_1.setBounds(826, 490, 22, 38);
		add(btnNewButton_2_1_2_1);
		
		JButton btnNewButton_2_1_3_1 = new JButton("");
		btnNewButton_2_1_3_1.setBounds(858, 490, 22, 38);
		add(btnNewButton_2_1_3_1);
		
		JButton btnNewButton_2_1_4_1 = new JButton("");
		btnNewButton_2_1_4_1.setBounds(890, 490, 22, 38);
		add(btnNewButton_2_1_4_1);
		
		JButton btnNewButton_2_1_5_1 = new JButton("");
		btnNewButton_2_1_5_1.setBounds(920, 490, 22, 38);
		add(btnNewButton_2_1_5_1);
		
		JButton btnNewButton_2_1_4_2 = new JButton("");
		btnNewButton_2_1_4_2.setBounds(890, 214, 22, 38);
		add(btnNewButton_2_1_4_2);
		
		JButton btnNewButton_2_1_5_2 = new JButton("");
		btnNewButton_2_1_5_2.setBounds(920, 214, 22, 38);
		add(btnNewButton_2_1_5_2);
		
		JButton btnNewButton_2_1_3_1_1 = new JButton("");
		btnNewButton_2_1_3_1_1.setBounds(263, 33, 22, 64);
		add(btnNewButton_2_1_3_1_1);
		
		JButton btnNewButton_2_1_4_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1.setBounds(297, 33, 22, 64);
		add(btnNewButton_2_1_4_1_1);
		
		JButton btnNewButton_2_1_5_1_1 = new JButton("");
		btnNewButton_2_1_5_1_1.setBounds(330, 33, 22, 64);
		add(btnNewButton_2_1_5_1_1);
		
		JButton btnNewButton_2_1_3_1_1_1 = new JButton("");
		btnNewButton_2_1_3_1_1_1.setBounds(31, 403, 22, 96);
		add(btnNewButton_2_1_3_1_1_1);
		
		JButton btnNewButton_2_1_4_1_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1_1.setBounds(67, 403, 22, 96);
		add(btnNewButton_2_1_4_1_1_1);
		
		JButton btnNewButton_2_1_5_1_1_1 = new JButton("");
		btnNewButton_2_1_5_1_1_1.setBounds(102, 403, 22, 96);
		add(btnNewButton_2_1_5_1_1_1);
		
		JButton btnNewButton_2_1_4_1_1_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1_1_1.setBounds(69, 74, 22, 96);
		add(btnNewButton_2_1_4_1_1_1_1);
		
		JButton btnNewButton_2_1_3_1_1_1_1 = new JButton("");
		btnNewButton_2_1_3_1_1_1_1.setBounds(33, 74, 22, 96);
		add(btnNewButton_2_1_3_1_1_1_1);
		
		JButton btnNewButton_2_1_4_1_1_1_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1_1_1_1.setBounds(229, 360, 22, 69);
		add(btnNewButton_2_1_4_1_1_1_1_1);
		
		JButton button1_1_2_3 = new JButton();
		button1_1_2_3.setFocusable(false);
		button1_1_2_3.setBounds(464, 62, 40, 21);
		add(button1_1_2_3);
		
		JLabel lblLayout = new JLabel(scaledIcon);
		lblLayout.setBounds(0, 0, 986, 563);
		add(lblLayout);
	}
	
	private void parkSuccess(String occupied) {
		JOptionPane.showMessageDialog(null, "Successfully Parked!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
		methods.switchPanel(frame, this, frame.mainPanel);
		frame.setOccupiedStatus(occupied);
	}
}
