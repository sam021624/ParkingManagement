package parkingpanel;

import java.awt.Font;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Main;
import main.Methods;

public class CourtParkingLayout extends JPanel {
	private Map<String, Object[]> occupyButtons = new HashMap<>();

	Main frame;
	
	Methods methods = new Methods();
	private JLabel[] motorLabels = new JLabel[89];

	ImageIcon motorcycleIcon = new ImageIcon((getClass().getResource("/motorcycle.png")));
	ImageIcon layoutIcon = new ImageIcon(getClass().getResource("/layout.png"));
	ImageIcon backIcon = new ImageIcon((getClass().getResource("/back.png")));
	ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));

	public CourtParkingLayout(Main frame) {
		this.frame = frame;
		this.setBounds(0, 0, 986, 563);
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
		
		motorLabels[0] = createMotorLabels(467, 206);
		motorLabels[1] = createMotorLabels(467, 177);
		motorLabels[2] = createMotorLabels(467, 147);
		motorLabels[3] = createMotorLabels(467, 118);
		motorLabels[4] = createMotorLabels(467, 89);
		motorLabels[5] = createMotorLabels(467, 60);
		motorLabels[6] = createMotorLabels(556, 206);
		motorLabels[7] = createMotorLabels(556, 176);
		motorLabels[8] = createMotorLabels(556, 147);
		motorLabels[9] = createMotorLabels(556, 118);
		motorLabels[10] = createMotorLabels(556, 89);
		motorLabels[11] = createMotorLabels(556, 60);
		motorLabels[12] = createMotorLabels(556, 31);
		motorLabels[13] = createMotorLabels(602, 206);
		motorLabels[14] = createMotorLabels(602, 176);
		motorLabels[15] = createMotorLabels(602, 147);
		motorLabels[16] = createMotorLabels(602, 118);
		motorLabels[17] = createMotorLabels(602, 89);
		motorLabels[18] = createMotorLabels(602, 60);
		motorLabels[19] = createMotorLabels(602, 31);
		motorLabels[20] = createMotorLabels(689, 33);
		motorLabels[21] = createMotorLabels(721, 33);
		motorLabels[22] = createMotorLabels(753, 33);
		motorLabels[23] = createMotorLabels(785, 33);
		motorLabels[24] = createMotorLabels(782, 177);
		motorLabels[25] = createMotorLabels(750, 177);
		motorLabels[26] = createMotorLabels(719, 177);
		motorLabels[27] = createMotorLabels(687, 177);
		motorLabels[28] = createMotorLabels(453, 505);
		motorLabels[29] = createMotorLabels(453, 476);
		motorLabels[30] = createMotorLabels(453, 447);
		motorLabels[31] = createMotorLabels(453, 416);
		motorLabels[32] = createMotorLabels(453, 387);
		motorLabels[33] = createMotorLabels(453, 358);
		motorLabels[34] = createMotorLabels(548, 505);
		motorLabels[35] = createMotorLabels(548, 476);
		motorLabels[36] = createMotorLabels(548, 447);
		motorLabels[37] = createMotorLabels(548, 418);
		motorLabels[38] = createMotorLabels(548, 387);
		motorLabels[39] = createMotorLabels(548, 358);
		motorLabels[40] = createMotorLabels(595, 505);
		motorLabels[41] = createMotorLabels(595, 476);
		motorLabels[42] = createMotorLabels(595, 447);
		motorLabels[43] = createMotorLabels(595, 418);
		motorLabels[44] = createMotorLabels(595, 387);
		motorLabels[45] = createMotorLabels(595, 358);
		motorLabels[46] = createMotorLabels(697, 358);
		motorLabels[47] = createMotorLabels(697, 387);
		motorLabels[48] = createMotorLabels(697, 418);
		motorLabels[49] = createMotorLabels(697, 447);
		motorLabels[50] = createMotorLabels(697, 476);
		motorLabels[51] = createMotorLabels(697, 505);
		motorLabels[52] = createMotorLabels(744, 505);
		motorLabels[53] = createMotorLabels(744, 476);
		motorLabels[54] = createMotorLabels(744, 447);
		motorLabels[55] = createMotorLabels(744, 418);
		motorLabels[56] = createMotorLabels(744, 387);
		motorLabels[57] = createMotorLabels(744, 358);
		motorLabels[58] = createMotorLabels(827, 488);
		motorLabels[59] = createMotorLabels(859, 488);
		motorLabels[60] = createMotorLabels(889, 488);
		motorLabels[61] = createMotorLabels(920, 488);
		motorLabels[62] = createMotorLabels(920, 370);
		motorLabels[63] = createMotorLabels(889, 370);
		motorLabels[64] = createMotorLabels(859, 370);
		motorLabels[65] = createMotorLabels(827, 370);
		motorLabels[66] = createMotorLabels(920, 214);
		motorLabels[67] = createMotorLabels(889, 214);
		motorLabels[68] = createMotorLabels(403, 505);
		motorLabels[69] = createMotorLabels(403, 476);
		motorLabels[70] = createMotorLabels(403, 447);
		motorLabels[71] = createMotorLabels(403, 416);
		motorLabels[72] = createMotorLabels(403, 387);
		motorLabels[73] = createMotorLabels(403, 358);
		motorLabels[74] = createMotorLabels(318, 505);
		motorLabels[75] = createMotorLabels(318, 476);
		motorLabels[76] = createMotorLabels(318, 447);
		motorLabels[77] = createMotorLabels(318, 416);
		motorLabels[78] = createMotorLabels(318, 387);
		motorLabels[79] = createMotorLabels(318, 358);
		motorLabels[80] = createMotorLabels(333, 31);
		motorLabels[81] = createMotorLabels(300, 31);
		motorLabels[82] = createMotorLabels(266, 31);
		motorLabels[83] = createMotorLabels(232, 358);
		motorLabels[84] = createMotorLabels(73, 72);
		motorLabels[85] = createMotorLabels(37, 72);
		motorLabels[86] = createMotorLabels(106, 401);
		motorLabels[87] = createMotorLabels(70, 401);
		motorLabels[88] = createMotorLabels(34, 401);

		JButton btn01 = new JButton();				
		btn01.setFocusable(false);
		btn01.setBounds(467, 206, 40, 21);
		add(btn01);
		btn01.addActionListener(e -> {
			btn01.setVisible(false);
			motorLabels[0].setVisible(true);
			parkSuccess("01");
		});
		
		JButton btn02 = new JButton();				
		btn02.setFocusable(false);
		btn02.setBounds(467, 177, 40, 21);
		add(btn02);
		btn02.addActionListener(e -> {
			btn02.setVisible(false);
			motorLabels[1].setVisible(true);
			parkSuccess("02");
		});
		
		JButton btn03 = new JButton();			
		btn03.setFocusable(false);
		btn03.setBounds(467, 147, 40, 21);
		add(btn03);
		btn03.addActionListener(e -> {
			btn03.setVisible(false);
			motorLabels[2].setVisible(true);
			parkSuccess("03");
		});
		
		JButton btn04 = new JButton();
		btn04.setFocusable(false);
		btn04.setBounds(467, 118, 40, 21);
		add(btn04);
		btn04.addActionListener(e -> {
			btn04.setVisible(false);
			motorLabels[3].setVisible(true);
			parkSuccess("04");
		});
		
		JButton btn05 = new JButton();
		btn05.setFocusable(false);
		btn05.setBounds(467, 89, 40, 21);
		add(btn05);
		btn05.addActionListener(e -> {
			btn05.setVisible(false);
			motorLabels[4].setVisible(true);
			parkSuccess("05");
		});
		
		JButton btn06 = new JButton();
		btn06.setFocusable(false);
		btn06.setBounds(467, 60, 40, 21);
		add(btn06);
		btn06.addActionListener(e -> {
			btn06.setVisible(false);
			motorLabels[5].setVisible(true);
			parkSuccess("06");
		});
		
		JButton btn07 = new JButton();
		btn07.setFocusable(false);
		btn07.setBounds(556, 206, 40, 21);
		add(btn07);
		btn07.addActionListener(e -> {
			btn07.setVisible(false);
			motorLabels[6].setVisible(true);
			parkSuccess("07");
		});
		
		JButton btn08 = new JButton();
		btn08.setFocusable(false);
		btn08.setBounds(556, 176, 40, 21);
		add(btn08);
		btn08.addActionListener(e -> {
			btn08.setVisible(false);
			motorLabels[7].setVisible(true);
			parkSuccess("08");
		});
		
		JButton btn09 = new JButton();
		btn09.setFocusable(false);
		btn09.setBounds(556, 147, 40, 21);
		add(btn09);
		btn09.addActionListener(e -> {
			btn09.setVisible(false);
			motorLabels[8].setVisible(true);
			parkSuccess("09");
		});
		
		JButton btn10 = new JButton();
		btn10.setFocusable(false);
		btn10.setBounds(556, 118, 40, 21);
		add(btn10);
		btn10.addActionListener(e -> {
			btn10.setVisible(false);
			motorLabels[9].setVisible(true);
			parkSuccess("10");
		});
		
		JButton btn11 = new JButton();
		btn11.setFocusable(false);
		btn11.setBounds(556, 89, 40, 21);
		add(btn11);
		btn11.addActionListener(e -> {
		    btn11.setVisible(false);
		    motorLabels[10].setVisible(true);
		    parkSuccess("11");
		});

		JButton btn12 = new JButton();
		btn12.setFocusable(false);
		btn12.setBounds(556, 60, 40, 21);
		add(btn12);
		btn12.addActionListener(e -> {
		    btn12.setVisible(false);
		    motorLabels[11].setVisible(true);
		    parkSuccess("12");
		});

		JButton btn13 = new JButton();
		btn13.setFocusable(false);
		btn13.setBounds(556, 31, 40, 21);
		add(btn13);
		btn13.addActionListener(e -> {
		    btn13.setVisible(false);
		    motorLabels[12].setVisible(true);
		    parkSuccess("13");
		});

		JButton btn14 = new JButton();
		btn14.setFocusable(false);
		btn14.setBounds(602, 206, 40, 21);
		add(btn14);
		btn14.addActionListener(e -> {
		    btn14.setVisible(false);
		    motorLabels[13].setVisible(true);
		    parkSuccess("14");
		});

		JButton btn15 = new JButton();
		btn15.setFocusable(false);
		btn15.setBounds(602, 176, 40, 21);
		add(btn15);
		btn15.addActionListener(e -> {
		    btn15.setVisible(false);
		    motorLabels[14].setVisible(true);
		    parkSuccess("15");
		});

		JButton btn16 = new JButton();
		btn16.setFocusable(false);
		btn16.setBounds(602, 147, 40, 21);
		add(btn16);
		btn16.addActionListener(e -> {
		    btn16.setVisible(false);
		    motorLabels[15].setVisible(true);
		    parkSuccess("16");
		});

		JButton btn17 = new JButton();
		btn17.setFocusable(false);
		btn17.setBounds(602, 118, 40, 21);
		add(btn17);
		btn17.addActionListener(e -> {
		    btn17.setVisible(false);
		    motorLabels[16].setVisible(true);
		    parkSuccess("17");
		});

		JButton btn18 = new JButton();
		btn18.setFocusable(false);
		btn18.setBounds(602, 89, 40, 21);
		add(btn18);
		btn18.addActionListener(e -> {
		    btn18.setVisible(false);
		    motorLabels[17].setVisible(true);
		    parkSuccess("18");
		});

		JButton btn19 = new JButton();
		btn19.setFocusable(false);
		btn19.setBounds(602, 60, 40, 21);
		add(btn19);
		btn19.addActionListener(e -> {
		    btn19.setVisible(false);
		    motorLabels[18].setVisible(true);
		    parkSuccess("19");
		});

		JButton btn20 = new JButton();
		btn20.setFocusable(false);
		btn20.setBounds(602, 31, 40, 21);
		add(btn20);
		btn20.addActionListener(e -> {
		    btn20.setVisible(false);
		    motorLabels[19].setVisible(true);
		    parkSuccess("20");
		});
		
		JButton btn21 = new JButton();
		btn21.setBounds(689, 33, 22, 38);
		add(btn21);
		motorLabels[20].setBounds(689, 33, 60, 20); // Position label next to button
		add(motorLabels[20]);
		btn21.addActionListener(e -> {
		    btn21.setVisible(false);
		    motorLabels[20].setVisible(true);
		    parkSuccess("21");
		});

		JButton btn22 = new JButton();
		btn22.setBounds(721, 33, 22, 38);
		add(btn22);
		motorLabels[21].setBounds(721, 33, 60, 20);
		add(motorLabels[21]);
		btn22.addActionListener(e -> {
		    btn22.setVisible(false);
		    motorLabels[21].setVisible(true);
		    parkSuccess("22");
		});

		JButton btn23 = new JButton();
		btn23.setBounds(753, 33, 22, 38);
		add(btn23);
		motorLabels[22].setBounds(753, 33, 60, 20);
		add(motorLabels[22]);
		btn23.addActionListener(e -> {
		    btn23.setVisible(false);
		    motorLabels[22].setVisible(true);
		    parkSuccess("23");
		});

		JButton btn24 = new JButton();
		btn24.setBounds(785, 33, 22, 38);
		add(btn24);
		motorLabels[23].setBounds(785, 33, 60, 20);
		add(motorLabels[23]);
		btn24.addActionListener(e -> {
		    btn24.setVisible(false);
		    motorLabels[23].setVisible(true);
		    parkSuccess("24");
		});

		JButton btn25 = new JButton();
		btn25.setBounds(782, 177, 22, 38);
		add(btn25);
		motorLabels[24].setBounds(782, 177, 60, 20);
		add(motorLabels[24]);
		btn25.addActionListener(e -> {
		    btn25.setVisible(false);
		    motorLabels[24].setVisible(true);
		    parkSuccess("25");
		});

		JButton btn26 = new JButton();
		btn26.setBounds(750, 177, 22, 38);
		add(btn26);
		motorLabels[25].setBounds(750, 177, 60, 20);
		add(motorLabels[25]);
		btn26.addActionListener(e -> {
		    btn26.setVisible(false);
		    motorLabels[25].setVisible(true);
		    parkSuccess("26");
		});

		JButton btn27 = new JButton();
		btn27.setBounds(719, 177, 22, 38);
		add(btn27);
		motorLabels[26].setBounds(719, 177, 60, 20);
		add(motorLabels[26]);
		btn27.addActionListener(e -> {
		    btn27.setVisible(false);
		    motorLabels[26].setVisible(true);
		    parkSuccess("27");
		});

		JButton btn28 = new JButton();
		btn28.setBounds(687, 177, 22, 38);
		add(btn28);
		motorLabels[27].setBounds(687, 177, 60, 20);
		add(motorLabels[27]);
		btn28.addActionListener(e -> {
		    btn28.setVisible(false);
		    motorLabels[27].setVisible(true);
		    parkSuccess("28");
		});

		JButton btn29 = new JButton();
		btn29.setFocusable(false);
		btn29.setBounds(453, 505, 40, 21);
		add(btn29);
		motorLabels[28].setBounds(453, 505, 60, 20);
		add(motorLabels[28]);
		btn29.addActionListener(e -> {
		    btn29.setVisible(false);
		    motorLabels[28].setVisible(true);
		    parkSuccess("29");
		});

		JButton btn30 = new JButton();
		btn30.setFocusable(false);
		btn30.setBounds(453, 476, 40, 21);
		add(btn30);
		motorLabels[29].setBounds(453, 476, 60, 20);
		add(motorLabels[29]);
		btn30.addActionListener(e -> {
		    btn30.setVisible(false);
		    motorLabels[29].setVisible(true);
		    parkSuccess("30");
		});

		JButton btn31 = new JButton();
		btn31.setFocusable(false);
		btn31.setBounds(453, 447, 40, 21);
		add(btn31);
		motorLabels[30].setBounds(453, 447, 60, 20);
		add(motorLabels[30]);
		btn31.addActionListener(e -> {
		    btn31.setVisible(false);
		    motorLabels[30].setVisible(true);
		    parkSuccess("31");
		});

		JButton btn32 = new JButton();
		btn32.setFocusable(false);
		btn32.setBounds(453, 416, 40, 21);
		add(btn32);
		motorLabels[31].setBounds(453, 416, 60, 20);
		add(motorLabels[31]);
		btn32.addActionListener(e -> {
		    btn32.setVisible(false);
		    motorLabels[31].setVisible(true);
		    parkSuccess("32");
		});

		JButton btn33 = new JButton();
		btn33.setFocusable(false);
		btn33.setBounds(453, 387, 40, 21);
		add(btn33);
		motorLabels[32].setBounds(453, 387, 60, 20);
		add(motorLabels[32]);
		btn33.addActionListener(e -> {
		    btn33.setVisible(false);
		    motorLabels[32].setVisible(true);
		    parkSuccess("33");
		});

		JButton btn34 = new JButton();
		btn34.setFocusable(false);
		btn34.setBounds(453, 358, 40, 21);
		add(btn34);
		motorLabels[33].setBounds(453, 358, 60, 20);
		add(motorLabels[33]);
		btn34.addActionListener(e -> {
		    btn34.setVisible(false);
		    motorLabels[33].setVisible(true);
		    parkSuccess("34");
		});

		JButton btn35 = new JButton();
		btn35.setFocusable(false);
		btn35.setBounds(548, 505, 40, 21);
		add(btn35);
		motorLabels[34].setBounds(548, 505, 60, 20);
		add(motorLabels[34]);
		btn35.addActionListener(e -> {
		    btn35.setVisible(false);
		    motorLabels[34].setVisible(true);
		    parkSuccess("35");
		});

		JButton btn36 = new JButton();
		btn36.setFocusable(false);
		btn36.setBounds(548, 476, 40, 21);
		add(btn36);
		motorLabels[35].setBounds(548, 476, 60, 20);
		add(motorLabels[35]);
		btn36.addActionListener(e -> {
		    btn36.setVisible(false);
		    motorLabels[35].setVisible(true);
		    parkSuccess("36");
		});

		JButton btn37 = new JButton();
		btn37.setFocusable(false);
		btn37.setBounds(548, 447, 40, 21);
		add(btn37);
		motorLabels[36].setBounds(548, 447, 60, 20);
		add(motorLabels[36]);
		btn37.addActionListener(e -> {
		    btn37.setVisible(false);
		    motorLabels[36].setVisible(true);
		    parkSuccess("37");
		});

		JButton btn38 = new JButton();
		btn38.setFocusable(false);
		btn38.setBounds(548, 418, 40, 21);
		add(btn38);
		motorLabels[37].setBounds(548, 418, 60, 20);
		add(motorLabels[37]);
		btn38.addActionListener(e -> {
		    btn38.setVisible(false);
		    motorLabels[37].setVisible(true);
		    parkSuccess("38");
		});

		JButton btn39 = new JButton();
		btn39.setFocusable(false);
		btn39.setBounds(548, 387, 40, 21);
		add(btn39);
		motorLabels[38].setBounds(548, 387, 60, 20);
		add(motorLabels[38]);
		btn39.addActionListener(e -> {
		    btn39.setVisible(false);
		    motorLabels[38].setVisible(true);
		    parkSuccess("39");
		});

		JButton btn40 = new JButton();
		btn40.setFocusable(false);
		btn40.setBounds(548, 358, 40, 21);
		add(btn40);
		motorLabels[39].setBounds(548, 358, 60, 20);
		add(motorLabels[39]);
		btn40.addActionListener(e -> {
		    btn40.setVisible(false);
		    motorLabels[39].setVisible(true);
		    parkSuccess("40");
		});

		JButton btn41 = new JButton();
		btn41.setFocusable(false);
		btn41.setBounds(595, 505, 40, 21);
		add(btn41);
		motorLabels[40].setBounds(595, 505, 60, 20);
		add(motorLabels[40]);
		btn41.addActionListener(e -> {
		    btn41.setVisible(false);
		    motorLabels[40].setVisible(true);
		    parkSuccess("41");
		});

		JButton btn42 = new JButton();
		btn42.setFocusable(false);
		btn42.setBounds(595, 476, 40, 21);
		add(btn42);
		motorLabels[41].setBounds(595, 476, 60, 20);
		add(motorLabels[41]);
		btn42.addActionListener(e -> {
		    btn42.setVisible(false);
		    motorLabels[41].setVisible(true);
		    parkSuccess("42");
		});

		JButton btn43 = new JButton();
		btn43.setFocusable(false);
		btn43.setBounds(595, 447, 40, 21);
		add(btn43);
		motorLabels[42].setBounds(595, 447, 60, 20);
		add(motorLabels[42]);
		btn43.addActionListener(e -> {
		    btn43.setVisible(false);
		    motorLabels[42].setVisible(true);
		    parkSuccess("43");
		});

		JButton btn44 = new JButton();
		btn44.setFocusable(false);
		btn44.setBounds(595, 418, 40, 21);
		add(btn44);
		motorLabels[43].setBounds(595, 418, 60, 20);
		add(motorLabels[43]);
		btn44.addActionListener(e -> {
		    btn44.setVisible(false);
		    motorLabels[43].setVisible(true);
		    parkSuccess("44");
		});

		JButton btn45 = new JButton();
		btn45.setFocusable(false);
		btn45.setBounds(595, 387, 40, 21);
		add(btn45);
		motorLabels[44].setBounds(595, 387, 60, 20);
		add(motorLabels[44]);
		btn45.addActionListener(e -> {
		    btn45.setVisible(false);
		    motorLabels[44].setVisible(true);
		    parkSuccess("45");
		});

		JButton btn46 = new JButton();
		btn46.setFocusable(false);
		btn46.setBounds(595, 358, 40, 21);
		add(btn46);
		motorLabels[45].setBounds(595, 358, 60, 20);
		add(motorLabels[45]);
		btn46.addActionListener(e -> {
		    btn46.setVisible(false);
		    motorLabels[45].setVisible(true);
		    parkSuccess("46");
		});

		JButton btn47 = new JButton();
		btn47.setFocusable(false);
		btn47.setBounds(697, 358, 40, 21);
		add(btn47);
		motorLabels[46].setBounds(697, 358, 60, 20);
		add(motorLabels[46]);
		btn47.addActionListener(e -> {
		    btn47.setVisible(false);
		    motorLabels[46].setVisible(true);
		    parkSuccess("47");
		});

		JButton btn48 = new JButton();
		btn48.setFocusable(false);
		btn48.setBounds(697, 387, 40, 21);
		add(btn48);
		motorLabels[47].setBounds(697, 387, 60, 20);
		add(motorLabels[47]);
		btn48.addActionListener(e -> {
		    btn48.setVisible(false);
		    motorLabels[47].setVisible(true);
		    parkSuccess("48");
		});

		JButton btn49 = new JButton();
		btn49.setFocusable(false);
		btn49.setBounds(697, 418, 40, 21);
		add(btn49);
		motorLabels[48].setBounds(697, 418, 60, 20);
		add(motorLabels[48]);
		btn49.addActionListener(e -> {
		    btn49.setVisible(false);
		    motorLabels[48].setVisible(true);
		    parkSuccess("49");
		});

		JButton btn50 = new JButton();
		btn50.setFocusable(false);
		btn50.setBounds(697, 447, 40, 21);
		add(btn50);
		motorLabels[49].setBounds(697, 447, 60, 20);
		add(motorLabels[49]);
		btn50.addActionListener(e -> {
		    btn50.setVisible(false);
		    motorLabels[49].setVisible(true);
		    parkSuccess("50");
		});

		JButton btn51 = new JButton();
		btn51.setFocusable(false);
		btn51.setBounds(697, 476, 40, 21);
		add(btn51);
		motorLabels[50].setBounds(697, 476, 60, 20);
		add(motorLabels[50]);
		btn51.addActionListener(e -> {
		    btn51.setVisible(false);
		    motorLabels[50].setVisible(true);
		    parkSuccess("51");
		});
		
		JButton btn52 = new JButton();
		btn52.setFocusable(false);
		btn52.setBounds(697, 505, 40, 21);
		add(btn52);
		motorLabels[51].setBounds(697, 505, 60, 20);
		add(motorLabels[51]);
		btn52.addActionListener(e -> {
		    btn52.setVisible(false);
		    motorLabels[51].setVisible(true);
		    parkSuccess("52");
		});

		JButton btn53 = new JButton();
		btn53.setFocusable(false);
		btn53.setBounds(744, 505, 40, 21);
		add(btn53);
		motorLabels[52].setBounds(744, 505, 60, 20);
		add(motorLabels[52]);
		btn53.addActionListener(e -> {
		    btn53.setVisible(false);
		    motorLabels[52].setVisible(true);
		    parkSuccess("53");
		});

		JButton btn54 = new JButton();
		btn54.setFocusable(false);
		btn54.setBounds(744, 476, 40, 21);
		add(btn54);
		motorLabels[53].setBounds(744, 476, 60, 20);
		add(motorLabels[53]);
		btn54.addActionListener(e -> {
		    btn54.setVisible(false);
		    motorLabels[53].setVisible(true);
		    parkSuccess("54");
		});

		JButton btn55 = new JButton();
		btn55.setFocusable(false);
		btn55.setBounds(744, 447, 40, 21);
		add(btn55);
		motorLabels[54].setBounds(744, 447, 60, 20);
		add(motorLabels[54]);
		btn55.addActionListener(e -> {
		    btn55.setVisible(false);
		    motorLabels[54].setVisible(true);
		    parkSuccess("55");
		});

		JButton btn56 = new JButton();
		btn56.setFocusable(false);
		btn56.setBounds(744, 418, 40, 21);
		add(btn56);
		motorLabels[55].setBounds(744, 418, 60, 20);
		add(motorLabels[55]);
		btn56.addActionListener(e -> {
		    btn56.setVisible(false);
		    motorLabels[55].setVisible(true);
		    parkSuccess("56");
		});

		JButton btn57 = new JButton();
		btn57.setFocusable(false);
		btn57.setBounds(744, 387, 40, 21);
		add(btn57);
		motorLabels[56].setBounds(744, 387, 60, 20);
		add(motorLabels[56]);
		btn57.addActionListener(e -> {
		    btn57.setVisible(false);
		    motorLabels[56].setVisible(true);
		    parkSuccess("57");
		});

		JButton btn58 = new JButton();
		btn58.setFocusable(false);
		btn58.setBounds(744, 358, 40, 21);
		add(btn58);
		motorLabels[57].setBounds(744, 358, 60, 20);
		add(motorLabels[57]);
		btn58.addActionListener(e -> {
		    btn58.setVisible(false);
		    motorLabels[57].setVisible(true);
		    parkSuccess("58");
		});

		JButton btn59 = new JButton();
		btn59.setBounds(827, 488, 22, 38);
		add(btn59);
		motorLabels[58].setBounds(827, 488, 60, 20);
		add(motorLabels[58]);
		btn59.addActionListener(e -> {
		    btn59.setVisible(false);
		    motorLabels[58].setVisible(true);
		    parkSuccess("59");
		});

		JButton btn60 = new JButton();
		btn60.setBounds(859, 488, 22, 38);
		add(btn60);
		motorLabels[59].setBounds(859, 488, 60, 20);
		add(motorLabels[59]);
		btn60.addActionListener(e -> {
		    btn60.setVisible(false);
		    motorLabels[59].setVisible(true);
		    parkSuccess("60");
		});

		JButton btn61 = new JButton();
		btn61.setBounds(889, 488, 22, 38);
		add(btn61);
		motorLabels[60].setBounds(889, 488, 60, 20);
		add(motorLabels[60]);
		btn61.addActionListener(e -> {
		    btn61.setVisible(false);
		    motorLabels[60].setVisible(true);
		    parkSuccess("61");
		});

		JButton btn62 = new JButton();
		btn62.setBounds(920, 488, 22, 38);
		add(btn62);
		motorLabels[61].setBounds(920, 488, 60, 20);
		add(motorLabels[61]);
		btn62.addActionListener(e -> {
		    btn62.setVisible(false);
		    motorLabels[61].setVisible(true);
		    parkSuccess("62");
		});

		JButton btn63 = new JButton();
		btn63.setBounds(920, 370, 22, 38);
		add(btn63);
		motorLabels[62].setBounds(920, 370, 60, 20);
		add(motorLabels[62]);
		btn63.addActionListener(e -> {
		    btn63.setVisible(false);
		    motorLabels[62].setVisible(true);
		    parkSuccess("63");
		});

		JButton btn64 = new JButton();
		btn64.setBounds(889, 370, 22, 38);
		add(btn64);
		motorLabels[63].setBounds(889, 370, 60, 20);
		add(motorLabels[63]);
		btn64.addActionListener(e -> {
		    btn64.setVisible(false);
		    motorLabels[63].setVisible(true);
		    parkSuccess("64");
		});

		JButton btn65 = new JButton();
		btn65.setBounds(859, 370, 22, 38);
		add(btn65);
		motorLabels[64].setBounds(859, 370, 60, 20);
		add(motorLabels[64]);
		btn65.addActionListener(e -> {
		    btn65.setVisible(false);
		    motorLabels[64].setVisible(true);
		    parkSuccess("65");
		});

		JButton btn66 = new JButton();
		btn66.setBounds(827, 370, 22, 38);
		add(btn66);
		motorLabels[65].setBounds(827, 370, 60, 20);
		add(motorLabels[65]);
		btn66.addActionListener(e -> {
		    btn66.setVisible(false);
		    motorLabels[65].setVisible(true);
		    parkSuccess("66");
		});

		JButton btn67 = new JButton();
		btn67.setBounds(920, 214, 22, 38);
		add(btn67);
		motorLabels[66].setBounds(920, 214, 60, 20);
		add(motorLabels[66]);
		btn67.addActionListener(e -> {
		    btn67.setVisible(false);
		    motorLabels[66].setVisible(true);
		    parkSuccess("67");
		});

		JButton btn68 = new JButton();
		btn68.setBounds(889, 214, 22, 38);
		add(btn68);
		motorLabels[67].setBounds(889, 214, 60, 20);
		add(motorLabels[67]);
		btn68.addActionListener(e -> {
		    btn68.setVisible(false);
		    motorLabels[67].setVisible(true);
		    parkSuccess("68");
		});

		JButton btn69 = new JButton();
		btn69.setFocusable(false);
		btn69.setBounds(403, 505, 40, 21);
		add(btn69);
		motorLabels[68].setBounds(403, 505, 60, 20);
		add(motorLabels[68]);
		btn69.addActionListener(e -> {
		    btn69.setVisible(false);
		    motorLabels[68].setVisible(true);
		    parkSuccess("69");
		});

		JButton btn70 = new JButton();
		btn70.setFocusable(false);
		btn70.setBounds(403, 476, 40, 21);
		add(btn70);
		motorLabels[69].setBounds(403, 476, 60, 20);
		add(motorLabels[69]);
		btn70.addActionListener(e -> {
		    btn70.setVisible(false);
		    motorLabels[69].setVisible(true);
		    parkSuccess("70");
		});
		
		JButton btn71 = new JButton();
		btn71.setFocusable(false);
		btn71.setBounds(403, 447, 40, 21);
		add(btn71);
		motorLabels[70].setBounds(403, 447, 60, 20);
		add(motorLabels[70]);
		btn71.addActionListener(e -> {
		    btn71.setVisible(false);
		    motorLabels[70].setVisible(true);
		    parkSuccess("71");
		});

		JButton btn72 = new JButton();
		btn72.setFocusable(false);
		btn72.setBounds(403, 416, 40, 21);
		add(btn72);
		motorLabels[71].setBounds(403, 416, 60, 20);
		add(motorLabels[71]);
		btn72.addActionListener(e -> {
		    btn72.setVisible(false);
		    motorLabels[71].setVisible(true);
		    parkSuccess("72");
		});

		JButton btn73 = new JButton();
		btn73.setFocusable(false);
		btn73.setBounds(403, 387, 40, 21);
		add(btn73);
		motorLabels[72].setBounds(403, 387, 60, 20);
		add(motorLabels[72]);
		btn73.addActionListener(e -> {
		    btn73.setVisible(false);
		    motorLabels[72].setVisible(true);
		    parkSuccess("73");
		});

		JButton btn74 = new JButton();
		btn74.setFocusable(false);
		btn74.setBounds(403, 358, 40, 21);
		add(btn74);
		motorLabels[73].setBounds(403, 358, 60, 20);
		add(motorLabels[73]);
		btn74.addActionListener(e -> {
		    btn74.setVisible(false);
		    motorLabels[73].setVisible(true);
		    parkSuccess("74");
		});

		JButton btn75 = new JButton();
		btn75.setFocusable(false);
		btn75.setBounds(318, 505, 40, 21);
		add(btn75);
		motorLabels[74].setBounds(318, 505, 60, 20);
		add(motorLabels[74]);
		btn75.addActionListener(e -> {
		    btn75.setVisible(false);
		    motorLabels[74].setVisible(true);
		    parkSuccess("75");
		});

		JButton btn76 = new JButton();
		btn76.setFocusable(false);
		btn76.setBounds(318, 476, 40, 21);
		add(btn76);
		motorLabels[75].setBounds(318, 476, 60, 20);
		add(motorLabels[75]);
		btn76.addActionListener(e -> {
		    btn76.setVisible(false);
		    motorLabels[75].setVisible(true);
		    parkSuccess("76");
		});

		JButton btn77 = new JButton();
		btn77.setFocusable(false);
		btn77.setBounds(318, 447, 40, 21);
		add(btn77);
		motorLabels[76].setBounds(318, 447, 60, 20);
		add(motorLabels[76]);
		btn77.addActionListener(e -> {
		    btn77.setVisible(false);
		    motorLabels[76].setVisible(true);
		    parkSuccess("77");
		});

		JButton btn78 = new JButton();
		btn78.setFocusable(false);
		btn78.setBounds(318, 416, 40, 21);
		add(btn78);
		motorLabels[77].setBounds(318, 416, 60, 20);
		add(motorLabels[77]);
		btn78.addActionListener(e -> {
		    btn78.setVisible(false);
		    motorLabels[77].setVisible(true);
		    parkSuccess("78");
		});

		JButton btn79 = new JButton();
		btn79.setFocusable(false);
		btn79.setBounds(318, 387, 40, 21);
		add(btn79);
		motorLabels[78].setBounds(318, 387, 60, 20);
		add(motorLabels[78]);
		btn79.addActionListener(e -> {
		    btn79.setVisible(false);
		    motorLabels[78].setVisible(true);
		    parkSuccess("79");
		});

		JButton btn80 = new JButton();
		btn80.setFocusable(false);
		btn80.setBounds(318, 358, 40, 21);
		add(btn80);
		motorLabels[79].setBounds(318, 358, 60, 20);
		add(motorLabels[79]);
		btn80.addActionListener(e -> {
		    btn80.setVisible(false);
		    motorLabels[79].setVisible(true);
		    parkSuccess("80");
		});

		JButton btn81 = new JButton();
		btn81.setBounds(333, 31, 22, 64);
		add(btn81);
		motorLabels[80].setBounds(333, 31, 60, 20);
		add(motorLabels[80]);
		btn81.addActionListener(e -> {
		    btn81.setVisible(false);
		    motorLabels[80].setVisible(true);
		    parkSuccess("81");
		});

		JButton btn82 = new JButton();
		btn82.setBounds(300, 31, 22, 64);
		add(btn82);
		motorLabels[81].setBounds(300, 31, 60, 20);
		add(motorLabels[81]);
		btn82.addActionListener(e -> {
		    btn82.setVisible(false);
		    motorLabels[81].setVisible(true);
		    parkSuccess("82");
		});

		JButton btn83 = new JButton();
		btn83.setBounds(266, 31, 22, 64);
		add(btn83);
		motorLabels[82].setBounds(266, 31, 60, 20);
		add(motorLabels[82]);
		btn83.addActionListener(e -> {
		    btn83.setVisible(false);
		    motorLabels[82].setVisible(true);
		    parkSuccess("83");
		});

		JButton btn84 = new JButton();
		btn84.setBounds(232, 358, 22, 69);
		add(btn84);
		motorLabels[83].setBounds(232, 358, 60, 20);
		add(motorLabels[83]);
		btn84.addActionListener(e -> {
		    btn84.setVisible(false);
		    motorLabels[83].setVisible(true);
		    parkSuccess("84");
		});

		JButton btn85 = new JButton();
		btn85.setBounds(73, 72, 22, 96);
		add(btn85);
		motorLabels[84].setBounds(73, 72, 60, 20);
		add(motorLabels[84]);
		btn85.addActionListener(e -> {
		    btn85.setVisible(false);
		    motorLabels[84].setVisible(true);
		    parkSuccess("85");
		});

		JButton btn86 = new JButton();
		btn86.setBounds(37, 72, 22, 96);
		add(btn86);
		motorLabels[85].setBounds(37, 72, 60, 20);
		add(motorLabels[85]);
		btn86.addActionListener(e -> {
		    btn86.setVisible(false);
		    motorLabels[85].setVisible(true);
		    parkSuccess("86");
		});

		JButton btn87 = new JButton();
		btn87.setBounds(106, 401, 22, 96);
		add(btn87);
		motorLabels[86].setBounds(106, 401, 60, 20);
		add(motorLabels[86]);
		btn87.addActionListener(e -> {
		    btn87.setVisible(false);
		    motorLabels[86].setVisible(true);
		    parkSuccess("87");
		});

		JButton btn88 = new JButton();
		btn88.setBounds(70, 401, 22, 96);
		add(btn88);
		motorLabels[87].setBounds(70, 401, 60, 20);
		add(motorLabels[87]);
		btn88.addActionListener(e -> {
		    btn88.setVisible(false);
		    motorLabels[87].setVisible(true);
		    parkSuccess("88");
		});

		JButton btn89 = new JButton();
		btn89.setBounds(34, 401, 22, 96);
		add(btn89);
		motorLabels[88].setBounds(34, 401, 60, 20);
		add(motorLabels[88]);
		btn89.addActionListener(e -> {
		    btn89.setVisible(false);
		    motorLabels[88].setVisible(true);
		    parkSuccess("89");
		});


		JLabel lblLayout = new JLabel(scaledIcon);
		lblLayout.setBounds(0, 0, 986, 563);
		add(lblLayout);
		
		occupyButtons.put("01", new Object[] {btn01, motorLabels[0]});
		occupyButtons.put("02", new Object[] {btn02, motorLabels[1]});
		occupyButtons.put("03", new Object[] {btn03, motorLabels[2]});
		occupyButtons.put("04", new Object[] {btn04, motorLabels[3]}); 
		occupyButtons.put("05", new Object[] {btn05, motorLabels[4]}); 
		occupyButtons.put("06", new Object[] {btn06, motorLabels[5]});
		occupyButtons.put("07", new Object[] {btn07, motorLabels[6]});
		occupyButtons.put("08", new Object[] {btn08, motorLabels[7]});
		occupyButtons.put("09", new Object[] {btn09, motorLabels[8]});
		occupyButtons.put("10", new Object[] {btn10, motorLabels[9]});
		occupyButtons.put("11", new Object[] {btn11, motorLabels[10]});
		occupyButtons.put("12", new Object[] {btn12, motorLabels[11]});
		occupyButtons.put("13", new Object[] {btn13, motorLabels[12]});
		occupyButtons.put("14", new Object[] {btn14, motorLabels[13]});
		occupyButtons.put("15", new Object[] {btn15, motorLabels[14]});
		occupyButtons.put("16", new Object[] {btn16, motorLabels[15]});
		occupyButtons.put("17", new Object[] {btn17, motorLabels[16]});
		occupyButtons.put("18", new Object[] {btn18, motorLabels[17]});
		occupyButtons.put("19", new Object[] {btn19, motorLabels[18]});
		occupyButtons.put("20", new Object[] {btn20, motorLabels[19]});
		occupyButtons.put("21", new Object[] {btn21, motorLabels[20]});
		occupyButtons.put("22", new Object[] {btn22, motorLabels[21]});
		occupyButtons.put("23", new Object[] {btn23, motorLabels[22]});
		occupyButtons.put("24", new Object[] {btn24, motorLabels[23]});
		occupyButtons.put("25", new Object[] {btn25, motorLabels[24]});
		occupyButtons.put("26", new Object[] {btn26, motorLabels[25]});
		occupyButtons.put("27", new Object[] {btn27, motorLabels[26]});
		occupyButtons.put("28", new Object[] {btn28, motorLabels[27]});
		occupyButtons.put("29", new Object[] {btn29, motorLabels[28]});
		occupyButtons.put("30", new Object[] {btn30, motorLabels[29]});
		occupyButtons.put("31", new Object[] {btn31, motorLabels[30]});
		occupyButtons.put("32", new Object[] {btn32, motorLabels[31]});
		occupyButtons.put("33", new Object[] {btn33, motorLabels[32]});
		occupyButtons.put("34", new Object[] {btn34, motorLabels[33]});
		occupyButtons.put("35", new Object[] {btn35, motorLabels[34]});
		occupyButtons.put("36", new Object[] {btn36, motorLabels[35]});
		occupyButtons.put("37", new Object[] {btn37, motorLabels[36]});
		occupyButtons.put("38", new Object[] {btn38, motorLabels[37]});
		occupyButtons.put("39", new Object[] {btn39, motorLabels[38]});
		occupyButtons.put("40", new Object[] {btn40, motorLabels[39]});
		occupyButtons.put("41", new Object[] {btn41, motorLabels[40]});
		occupyButtons.put("42", new Object[] {btn42, motorLabels[41]});
		occupyButtons.put("43", new Object[] {btn43, motorLabels[42]});
		occupyButtons.put("44", new Object[] {btn44, motorLabels[43]});
		occupyButtons.put("45", new Object[] {btn45, motorLabels[44]});
		occupyButtons.put("46", new Object[] {btn46, motorLabels[45]});
		occupyButtons.put("47", new Object[] {btn47, motorLabels[46]});
		occupyButtons.put("48", new Object[] {btn48, motorLabels[47]});
		occupyButtons.put("49", new Object[] {btn49, motorLabels[48]});
		occupyButtons.put("50", new Object[] {btn50, motorLabels[49]});
		occupyButtons.put("51", new Object[] {btn51, motorLabels[50]});
		occupyButtons.put("52", new Object[] {btn52, motorLabels[51]});
		occupyButtons.put("53", new Object[] {btn53, motorLabels[52]});
		occupyButtons.put("54", new Object[] {btn54, motorLabels[53]});
		occupyButtons.put("55", new Object[] {btn55, motorLabels[54]});
		occupyButtons.put("56", new Object[] {btn56, motorLabels[55]});
		occupyButtons.put("57", new Object[] {btn57, motorLabels[56]});
		occupyButtons.put("58", new Object[] {btn58, motorLabels[57]});
		occupyButtons.put("59", new Object[] {btn59, motorLabels[58]});
		occupyButtons.put("60", new Object[] {btn60, motorLabels[59]});
		occupyButtons.put("61", new Object[] {btn61, motorLabels[60]});
		occupyButtons.put("62", new Object[] {btn62, motorLabels[61]});
		occupyButtons.put("63", new Object[] {btn63, motorLabels[62]});
		occupyButtons.put("64", new Object[] {btn64, motorLabels[63]});
		occupyButtons.put("65", new Object[] {btn65, motorLabels[64]});
		occupyButtons.put("66", new Object[] {btn66, motorLabels[65]});
		occupyButtons.put("67", new Object[] {btn67, motorLabels[66]});
		occupyButtons.put("68", new Object[] {btn68, motorLabels[67]});
		occupyButtons.put("69", new Object[] {btn69, motorLabels[68]});
		occupyButtons.put("70", new Object[] {btn70, motorLabels[69]});
		occupyButtons.put("71", new Object[] {btn71, motorLabels[70]});
		occupyButtons.put("72", new Object[] {btn72, motorLabels[71]});
		occupyButtons.put("73", new Object[] {btn73, motorLabels[72]});
		occupyButtons.put("74", new Object[] {btn74, motorLabels[73]});
		occupyButtons.put("75", new Object[] {btn75, motorLabels[74]});
		occupyButtons.put("76", new Object[] {btn76, motorLabels[75]});
		occupyButtons.put("77", new Object[] {btn77, motorLabels[76]});
		occupyButtons.put("78", new Object[] {btn78, motorLabels[77]});
		occupyButtons.put("79", new Object[] {btn79, motorLabels[78]});
		occupyButtons.put("80", new Object[] {btn80, motorLabels[79]});
		occupyButtons.put("81", new Object[] {btn81, motorLabels[80]});
		occupyButtons.put("82", new Object[] {btn82, motorLabels[81]});
		occupyButtons.put("83", new Object[] {btn83, motorLabels[82]});
		occupyButtons.put("84", new Object[] {btn84, motorLabels[83]});
		occupyButtons.put("85", new Object[] {btn85, motorLabels[84]});
		occupyButtons.put("86", new Object[] {btn86, motorLabels[85]});
		occupyButtons.put("87", new Object[] {btn87, motorLabels[86]});
		occupyButtons.put("88", new Object[] {btn88, motorLabels[87]});
		occupyButtons.put("89", new Object[] {btn88, motorLabels[88]});
	}
	
	private JLabel createMotorLabels(int x, int y) {
	    Image originalImage = motorcycleIcon.getImage();
	    Image scaledImage = originalImage.getScaledInstance(40, 21, Image.SCALE_SMOOTH); 
	    ImageIcon scaledIcon = new ImageIcon(scaledImage); 

	    JLabel label = new JLabel();
	    label.setIcon(scaledIcon);
	    label.setBounds(x, y, 40, 21);
	    label.setVisible(false);
	    add(label);

	    return label;
	}
	
	public void releaseCar(String slotID) {
	    if (occupyButtons.containsKey(slotID)) {
	    	Object[] components = occupyButtons.get(slotID);
            JButton button = (JButton) components[0];
            JLabel label = (JLabel) components[1];
	        
	        JOptionPane.showMessageDialog(null, "Slot " + slotID + " is now released!", "Notice!",
	                JOptionPane.INFORMATION_MESSAGE);
	        
	        button.setVisible(true);
	        label.setVisible(false);
	    }
	}

	private void parkSuccess(String occupied) {
		JOptionPane.showMessageDialog(null, "Successfully Parked!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
		methods.switchPanel(frame, this, frame.mainPanel);
		frame.setOccupiedStatus(occupied);
	}
}
