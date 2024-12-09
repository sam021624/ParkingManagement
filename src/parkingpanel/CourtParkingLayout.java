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
	private JLabel[] carLabels = new JLabel[8];

	ImageIcon car = new ImageIcon((getClass().getResource("/carvertical.png")));
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
		
		occupyButtons[0] = new JButton();				//01
		occupyButtons[0].setFocusable(false);
		occupyButtons[0].setBounds(467, 206, 40, 21);
		add(occupyButtons[0]);
		occupyButtons[0].addActionListener(e -> {
			occupyButtons[0].setVisible(false);
			parkSuccess("01");
		});
		
		carLabels[0] = createCarLabels(467, 208);
		
		occupyButtons[1] = new JButton();				//02
		occupyButtons[1].setFocusable(false);
		occupyButtons[1].setBounds(467, 177, 40, 21);
		add(occupyButtons[1]);
		occupyButtons[1].addActionListener(e -> {
			occupyButtons[1].setVisible(false);
			parkSuccess("02");
		});
		
		occupyButtons[2] = new JButton();			//03
		occupyButtons[2].setFocusable(false);
		occupyButtons[2].setBounds(467, 147, 40, 21);
		add(occupyButtons[2]);
		occupyButtons[2].addActionListener(e -> {
			occupyButtons[2].setVisible(false);
			parkSuccess("03");
		});
		
		JButton button1_1_2_3 = new JButton();
		button1_1_2_3.setFocusable(false);
		button1_1_2_3.setBounds(467, 60, 40, 21);
		add(button1_1_2_3);
		
		JButton button1_1_1 = new JButton();
		button1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button1_1_1.setFocusable(false);
		button1_1_1.setBounds(467, 118, 40, 21);
		add(button1_1_1);
		
		JButton button1_1_2 = new JButton();
		button1_1_2.setFocusable(false);
		button1_1_2.setBounds(467, 89, 40, 21);
		add(button1_1_2);
		
		JButton button1_3 = new JButton();
		button1_3.setFocusable(false);
		button1_3.setBounds(467, 118, 40, 21);
		add(button1_3);
		
		JButton button1_1_3 = new JButton();
		button1_1_3.setFocusable(false);
		button1_1_3.setBounds(556, 206, 40, 21);
		add(button1_1_3);
		
		JButton button1_1_1_1 = new JButton();
		button1_1_1_1.setFocusable(false);
		button1_1_1_1.setBounds(556, 147, 40, 21);
		add(button1_1_1_1);
		
		JButton button1_2_1 = new JButton();
		button1_2_1.setFocusable(false);
		button1_2_1.setBounds(556, 176, 40, 21);
		add(button1_2_1);
		
		JButton button1_1_2_1 = new JButton();
		button1_1_2_1.setFocusable(false);
		button1_1_2_1.setBounds(556, 118, 40, 21);
		add(button1_1_2_1);
		
		JButton button1_3_1 = new JButton();
		button1_3_1.setFocusable(false);
		button1_3_1.setBounds(556, 147, 40, 21);
		add(button1_3_1);
		
		JButton button1_1_4 = new JButton();
		button1_1_4.setFocusable(false);
		button1_1_4.setBounds(602, 206, 40, 21);
		add(button1_1_4);
		
		JButton button1_2_2 = new JButton();
		button1_2_2.setFocusable(false);
		button1_2_2.setBounds(602, 176, 40, 21);
		add(button1_2_2);
		
		JButton button1_1_2_2 = new JButton();
		button1_1_2_2.setFocusable(false);
		button1_1_2_2.setBounds(602, 118, 40, 21);
		add(button1_1_2_2);
		
		JButton button1_3_2 = new JButton();
		button1_3_2.setFocusable(false);
		button1_3_2.setBounds(602, 147, 40, 21);
		add(button1_3_2);
		
		JButton button1_2_2_1 = new JButton();
		button1_2_2_1.setFocusable(false);
		button1_2_2_1.setBounds(602, 89, 40, 21);
		add(button1_2_2_1);
		
		JButton button1_1_2_2_1 = new JButton();
		button1_1_2_2_1.setFocusable(false);
		button1_1_2_2_1.setBounds(602, 31, 40, 21);
		add(button1_1_2_2_1);
		
		JButton button1_3_2_1 = new JButton();
		button1_3_2_1.setFocusable(false);
		button1_3_2_1.setBounds(602, 60, 40, 21);
		add(button1_3_2_1);
		
		JButton button1_2_2_2 = new JButton();
		button1_2_2_2.setFocusable(false);
		button1_2_2_2.setBounds(556, 89, 40, 21);
		add(button1_2_2_2);
		
		JButton button1_1_2_2_2 = new JButton();
		button1_1_2_2_2.setFocusable(false);
		button1_1_2_2_2.setBounds(556, 31, 40, 21);
		add(button1_1_2_2_2);
		
		JButton button1_3_2_2 = new JButton();
		button1_3_2_2.setFocusable(false);
		button1_3_2_2.setBounds(556, 60, 40, 21);
		add(button1_3_2_2);
		
		JButton button1_2_2_1_1 = new JButton();
		button1_2_2_1_1.setFocusable(false);
		button1_2_2_1_1.setBounds(453, 505, 40, 21);
		add(button1_2_2_1_1);
		
		JButton button1_1_2_2_1_1 = new JButton();
		button1_1_2_2_1_1.setFocusable(false);
		button1_1_2_2_1_1.setBounds(453, 447, 40, 21);
		add(button1_1_2_2_1_1);
		
		JButton button1_3_2_1_1 = new JButton();
		button1_3_2_1_1.setFocusable(false);
		button1_3_2_1_1.setBounds(453, 476, 40, 21);
		add(button1_3_2_1_1);
		
		JButton button1_2_2_2_1 = new JButton();
		button1_2_2_2_1.setFocusable(false);
		button1_2_2_2_1.setBounds(403, 505, 40, 21);
		add(button1_2_2_2_1);
		
		JButton button1_1_2_2_2_1 = new JButton();
		button1_1_2_2_2_1.setFocusable(false);
		button1_1_2_2_2_1.setBounds(403, 447, 40, 21);
		add(button1_1_2_2_2_1);
		
		JButton button1_3_2_2_1 = new JButton();
		button1_3_2_2_1.setFocusable(false);
		button1_3_2_2_1.setBounds(403, 476, 40, 21);
		add(button1_3_2_2_1);
		
		JButton button1_2_2_1_2 = new JButton();
		button1_2_2_1_2.setFocusable(false);
		button1_2_2_1_2.setBounds(453, 416, 40, 21);
		add(button1_2_2_1_2);
		
		JButton button1_1_2_2_1_2 = new JButton();
		button1_1_2_2_1_2.setFocusable(false);
		button1_1_2_2_1_2.setBounds(453, 358, 40, 21);
		add(button1_1_2_2_1_2);
		
		JButton button1_3_2_1_2 = new JButton();
		button1_3_2_1_2.setFocusable(false);
		button1_3_2_1_2.setBounds(453, 387, 40, 21);
		add(button1_3_2_1_2);
		
		JButton button1_2_2_2_2 = new JButton();
		button1_2_2_2_2.setFocusable(false);
		button1_2_2_2_2.setBounds(403, 416, 40, 21);
		add(button1_2_2_2_2);
		
		JButton button1_1_2_2_2_2 = new JButton();
		button1_1_2_2_2_2.setFocusable(false);
		button1_1_2_2_2_2.setBounds(403, 358, 40, 21);
		add(button1_1_2_2_2_2);
		
		JButton button1_3_2_2_2 = new JButton();
		button1_3_2_2_2.setFocusable(false);
		button1_3_2_2_2.setBounds(403, 387, 40, 21);
		add(button1_3_2_2_2);
		
		JButton button1_1_3_1 = new JButton();
		button1_1_3_1.setFocusable(false);
		button1_1_3_1.setBounds(548, 505, 40, 21);
		add(button1_1_3_1);
		
		JButton button1_1_3_1_1 = new JButton();
		button1_1_3_1_1.setFocusable(false);
		button1_1_3_1_1.setBounds(548, 476, 40, 21);
		add(button1_1_3_1_1);
		
		JButton button1_1_3_1_2 = new JButton();
		button1_1_3_1_2.setFocusable(false);
		button1_1_3_1_2.setBounds(548, 447, 40, 21);
		add(button1_1_3_1_2);
		
		JButton button1_1_3_1_1_1 = new JButton();
		button1_1_3_1_1_1.setFocusable(false);
		button1_1_3_1_1_1.setBounds(548, 418, 40, 21);
		add(button1_1_3_1_1_1);
		
		JButton button1_1_3_1_3 = new JButton();
		button1_1_3_1_3.setFocusable(false);
		button1_1_3_1_3.setBounds(548, 387, 40, 21);
		add(button1_1_3_1_3);
		
		JButton button1_1_3_1_1_2 = new JButton();
		button1_1_3_1_1_2.setFocusable(false);
		button1_1_3_1_1_2.setBounds(548, 358, 40, 21);
		add(button1_1_3_1_1_2);
		
		JButton button1_1_3_1_4 = new JButton();
		button1_1_3_1_4.setFocusable(false);
		button1_1_3_1_4.setBounds(595, 505, 40, 21);
		add(button1_1_3_1_4);
		
		JButton button1_1_3_1_1_3 = new JButton();
		button1_1_3_1_1_3.setFocusable(false);
		button1_1_3_1_1_3.setBounds(595, 476, 40, 21);
		add(button1_1_3_1_1_3);
		
		JButton button1_1_3_1_2_1 = new JButton();
		button1_1_3_1_2_1.setFocusable(false);
		button1_1_3_1_2_1.setBounds(595, 447, 40, 21);
		add(button1_1_3_1_2_1);
		
		JButton button1_1_3_1_1_1_1 = new JButton();
		button1_1_3_1_1_1_1.setFocusable(false);
		button1_1_3_1_1_1_1.setBounds(595, 418, 40, 21);
		add(button1_1_3_1_1_1_1);
		
		JButton button1_1_3_1_3_1 = new JButton();
		button1_1_3_1_3_1.setFocusable(false);
		button1_1_3_1_3_1.setBounds(595, 387, 40, 21);
		add(button1_1_3_1_3_1);
		
		JButton button1_1_3_1_1_2_1 = new JButton();
		button1_1_3_1_1_2_1.setFocusable(false);
		button1_1_3_1_1_2_1.setBounds(595, 358, 40, 21);
		add(button1_1_3_1_1_2_1);
		
		JButton button1_1_3_1_5 = new JButton();
		button1_1_3_1_5.setFocusable(false);
		button1_1_3_1_5.setBounds(697, 505, 40, 21);
		add(button1_1_3_1_5);
		
		JButton button1_1_3_1_1_4 = new JButton();
		button1_1_3_1_1_4.setFocusable(false);
		button1_1_3_1_1_4.setBounds(697, 476, 40, 21);
		add(button1_1_3_1_1_4);
		
		JButton button1_1_3_1_2_2 = new JButton();
		button1_1_3_1_2_2.setFocusable(false);
		button1_1_3_1_2_2.setBounds(697, 447, 40, 21);
		add(button1_1_3_1_2_2);
		
		JButton button1_1_3_1_1_1_2 = new JButton();
		button1_1_3_1_1_1_2.setFocusable(false);
		button1_1_3_1_1_1_2.setBounds(697, 418, 40, 21);
		add(button1_1_3_1_1_1_2);
		
		JButton button1_1_3_1_3_2 = new JButton();
		button1_1_3_1_3_2.setFocusable(false);
		button1_1_3_1_3_2.setBounds(697, 387, 40, 21);
		add(button1_1_3_1_3_2);
		
		JButton button1_1_3_1_1_2_2 = new JButton();
		button1_1_3_1_1_2_2.setFocusable(false);
		button1_1_3_1_1_2_2.setBounds(697, 358, 40, 21);
		add(button1_1_3_1_1_2_2);
		
		JButton button1_1_3_1_4_1 = new JButton();
		button1_1_3_1_4_1.setFocusable(false);
		button1_1_3_1_4_1.setBounds(744, 505, 40, 21);
		add(button1_1_3_1_4_1);
		
		JButton button1_1_3_1_1_3_1 = new JButton();
		button1_1_3_1_1_3_1.setFocusable(false);
		button1_1_3_1_1_3_1.setBounds(744, 476, 40, 21);
		add(button1_1_3_1_1_3_1);
		
		JButton button1_1_3_1_2_1_1 = new JButton();
		button1_1_3_1_2_1_1.setFocusable(false);
		button1_1_3_1_2_1_1.setBounds(744, 447, 40, 21);
		add(button1_1_3_1_2_1_1);
		
		JButton button1_1_3_1_1_1_1_1 = new JButton();
		button1_1_3_1_1_1_1_1.setFocusable(false);
		button1_1_3_1_1_1_1_1.setBounds(744, 418, 40, 21);
		add(button1_1_3_1_1_1_1_1);
		
		JButton button1_1_3_1_3_1_1 = new JButton();
		button1_1_3_1_3_1_1.setFocusable(false);
		button1_1_3_1_3_1_1.setBounds(744, 387, 40, 21);
		add(button1_1_3_1_3_1_1);
		
		JButton button1_1_3_1_1_2_1_1 = new JButton();
		button1_1_3_1_1_2_1_1.setFocusable(false);
		button1_1_3_1_1_2_1_1.setBounds(744, 358, 40, 21);
		add(button1_1_3_1_1_2_1_1);
		
		JButton button1_1_2_2_2_2_1 = new JButton();
		button1_1_2_2_2_2_1.setFocusable(false);
		button1_1_2_2_2_2_1.setBounds(318, 358, 40, 21);
		add(button1_1_2_2_2_2_1);
		
		JButton button1_3_2_2_2_1 = new JButton();
		button1_3_2_2_2_1.setFocusable(false);
		button1_3_2_2_2_1.setBounds(318, 387, 40, 21);
		add(button1_3_2_2_2_1);
		
		JButton button1_2_2_2_2_1 = new JButton();
		button1_2_2_2_2_1.setFocusable(false);
		button1_2_2_2_2_1.setBounds(318, 416, 40, 21);
		add(button1_2_2_2_2_1);
		
		JButton button1_1_2_2_2_1_1 = new JButton();
		button1_1_2_2_2_1_1.setFocusable(false);
		button1_1_2_2_2_1_1.setBounds(318, 447, 40, 21);
		add(button1_1_2_2_2_1_1);
		
		JButton button1_3_2_2_1_1 = new JButton();
		button1_3_2_2_1_1.setFocusable(false);
		button1_3_2_2_1_1.setBounds(318, 476, 40, 21);
		add(button1_3_2_2_1_1);
		
		JButton button1_2_2_2_1_1 = new JButton();
		button1_2_2_2_1_1.setFocusable(false);
		button1_2_2_2_1_1.setBounds(318, 505, 40, 21);
		add(button1_2_2_2_1_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(689, 33, 22, 38);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(721, 33, 22, 38);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(753, 33, 22, 38);
		add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setBounds(785, 33, 22, 38);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setBounds(687, 177, 22, 38);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.setBounds(719, 177, 22, 38);
		add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("");
		btnNewButton_2_1_1_1.setBounds(782, 177, 22, 38);
		add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_2 = new JButton("");
		btnNewButton_2_1_1_2.setBounds(750, 177, 22, 38);
		add(btnNewButton_2_1_1_2);
		
		JButton btnNewButton_2_1_2 = new JButton("");
		btnNewButton_2_1_2.setBounds(827, 370, 22, 38);
		add(btnNewButton_2_1_2);
		
		JButton btnNewButton_2_1_3 = new JButton("");
		btnNewButton_2_1_3.setBounds(859, 370, 22, 38);
		add(btnNewButton_2_1_3);
		
		JButton btnNewButton_2_1_4 = new JButton("");
		btnNewButton_2_1_4.setBounds(889, 370, 22, 38);
		add(btnNewButton_2_1_4);
		
		JButton btnNewButton_2_1_5 = new JButton("");
		btnNewButton_2_1_5.setBounds(920, 370, 22, 38);
		add(btnNewButton_2_1_5);
		
		JButton btnNewButton_2_1_2_1 = new JButton("");
		btnNewButton_2_1_2_1.setBounds(827, 488, 22, 38);
		add(btnNewButton_2_1_2_1);
		
		JButton btnNewButton_2_1_3_1 = new JButton("");
		btnNewButton_2_1_3_1.setBounds(859, 488, 22, 38);
		add(btnNewButton_2_1_3_1);
		
		JButton btnNewButton_2_1_4_1 = new JButton("");
		btnNewButton_2_1_4_1.setBounds(889, 488, 22, 38);
		add(btnNewButton_2_1_4_1);
		
		JButton btnNewButton_2_1_5_1 = new JButton("");
		btnNewButton_2_1_5_1.setBounds(920, 488, 22, 38);
		add(btnNewButton_2_1_5_1);
		
		JButton btnNewButton_2_1_4_2 = new JButton("");
		btnNewButton_2_1_4_2.setBounds(889, 214, 22, 38);
		add(btnNewButton_2_1_4_2);
		
		JButton btnNewButton_2_1_5_2 = new JButton("");
		btnNewButton_2_1_5_2.setBounds(920, 214, 22, 38);
		add(btnNewButton_2_1_5_2);
		
		JButton btnNewButton_2_1_3_1_1 = new JButton("");
		btnNewButton_2_1_3_1_1.setBounds(266, 31, 22, 64);
		add(btnNewButton_2_1_3_1_1);
		
		JButton btnNewButton_2_1_4_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1.setBounds(300, 31, 22, 64);
		add(btnNewButton_2_1_4_1_1);
		
		JButton btnNewButton_2_1_5_1_1 = new JButton("");
		btnNewButton_2_1_5_1_1.setBounds(333, 31, 22, 64);
		add(btnNewButton_2_1_5_1_1);
		
		JButton btnNewButton_2_1_3_1_1_1 = new JButton("");
		btnNewButton_2_1_3_1_1_1.setBounds(34, 401, 22, 96);
		add(btnNewButton_2_1_3_1_1_1);
		
		JButton btnNewButton_2_1_4_1_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1_1.setBounds(70, 401, 22, 96);
		add(btnNewButton_2_1_4_1_1_1);
		
		JButton btnNewButton_2_1_5_1_1_1 = new JButton("");
		btnNewButton_2_1_5_1_1_1.setBounds(106, 401, 22, 96);
		add(btnNewButton_2_1_5_1_1_1);
		
		JButton btnNewButton_2_1_4_1_1_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1_1_1.setBounds(73, 72, 22, 96);
		add(btnNewButton_2_1_4_1_1_1_1);
		
		JButton btnNewButton_2_1_3_1_1_1_1 = new JButton("");
		btnNewButton_2_1_3_1_1_1_1.setBounds(37, 72, 22, 96);
		add(btnNewButton_2_1_3_1_1_1_1);
		
		JButton btnNewButton_2_1_4_1_1_1_1_1 = new JButton("");
		btnNewButton_2_1_4_1_1_1_1_1.setBounds(232, 358, 22, 69);
		add(btnNewButton_2_1_4_1_1_1_1_1);
		
		JLabel lblLayout = new JLabel(scaledIcon);
		lblLayout.setBounds(0, 0, 986, 563);
		add(lblLayout);
	}
	
	private JLabel createCarLabels(int x, int y) {
		JLabel label = new JLabel("🏍");
		label.setBounds(x, y, 40, 21);
		label.setVisible(false);
		add(label);

		return label;
	}
	
	public void releaseCar(String slotID) {
		int slotNumber = Integer.parseInt(slotID) - 1; // Convert slotId to index (e.g., "01" -> 0)
		if (slotNumber >= 0) {
			JOptionPane.showMessageDialog(null, "Slot " + slotID + " is now released!", "Notice!",
					JOptionPane.INFORMATION_MESSAGE);

			occupyButtons[slotNumber].setVisible(true);
		}
	}
	
	private void parkSuccess(String occupied) {
		JOptionPane.showMessageDialog(null, "Successfully Parked!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
		methods.switchPanel(frame, this, frame.mainPanel);
		frame.setOccupiedStatus(occupied);
	}
}
