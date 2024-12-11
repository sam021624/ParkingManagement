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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import main.Main;
import main.MainPanel;
import main.Methods;

public class CourtParkingLayout extends JPanel {
	private Map<String, Object[]> occupyButtons = new HashMap<>();

	Main frame;
	MainPanel mainPanel = new MainPanel(frame);
	
	Methods methods = new Methods();
	private JLabel[] motorLabels = new JLabel[89];
	private boolean status;

	ImageIcon motorcycleIcon = new ImageIcon((getClass().getResource("/motorcycle.png")));
	ImageIcon motorIcon = new ImageIcon((getClass().getResource("/motorIcon.png")));
	ImageIcon layoutIcon = new ImageIcon(getClass().getResource("/layout.png"));
	ImageIcon backIcon = new ImageIcon((getClass().getResource("/back.png")));
	ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));

	JButton buttons[];

	@SuppressWarnings("unused")
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
		btnBack.setBounds(10, 300, 78, 23);
		add(btnBack);
		btnBack.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.mainPanel);
		});

		JButton btnNext = new JButton("next", nextIcon);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		btnNext.setFocusable(false);
		btnNext.setBounds(898, 300, 78, 23);
		btnNext.setHorizontalTextPosition(SwingConstants.LEFT);
		add(btnNext);
		btnNext.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.gateParkingLayout);
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
		motorLabels[20] = createMotorpLabels(689, 33);
		motorLabels[21] = createMotorpLabels(721, 33);
		motorLabels[22] = createMotorpLabels(753, 33);
		motorLabels[23] = createMotorpLabels(785, 33);
		motorLabels[24] = createMotorpLabels(782, 177);
		motorLabels[25] = createMotorpLabels(750, 177);
		motorLabels[26] = createMotorpLabels(719, 177);
		motorLabels[27] = createMotorpLabels(687, 177);
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
		motorLabels[58] = createMotorpLabels(827, 488);
		motorLabels[59] = createMotorpLabels(859, 488);
		motorLabels[60] = createMotorpLabels(889, 488);
		motorLabels[61] = createMotorpLabels(920, 488);
		motorLabels[62] = createMotorpLabels(920, 370);
		motorLabels[63] = createMotorpLabels(889, 370);
		motorLabels[64] = createMotorpLabels(859, 370);
		motorLabels[65] = createMotorpLabels(827, 370);
		motorLabels[66] = createMotorpLabels(920, 214);
		motorLabels[67] = createMotorpLabels(889, 214);
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
		motorLabels[80] = createMotorpLabels(333, 31);
		motorLabels[81] = createMotorpLabels(300, 31);
		motorLabels[82] = createMotorpLabels(266, 31);
		motorLabels[83] = createMotorpLabels(232, 358);
		motorLabels[84] = createMotorpLabels(73, 72);
		motorLabels[85] = createMotorpLabels(37, 72);
		motorLabels[86] = createMotorpLabels(106, 401);
		motorLabels[87] = createMotorpLabels(70, 401);
		motorLabels[88] = createMotorpLabels(34, 401);

		JButton btn01 = new JButton();
		parkingValidation(btn01, 467, 206, 40, 21, 0, "01");

		JButton btn02 = new JButton();
		parkingValidation(btn02, 467, 177, 40, 21, 1, "02");

		JButton btn03 = new JButton();
		parkingValidation(btn03, 467, 147, 40, 21, 2, "03");

		JButton btn04 = new JButton();
		parkingValidation(btn04, 467, 118, 40, 21, 3, "04");

		JButton btn05 = new JButton();
		parkingValidation(btn05, 467, 89, 40, 21, 4, "05");

		JButton btn06 = new JButton();
		parkingValidation(btn06, 467, 60, 40, 21, 5, "06");

		JButton btn07 = new JButton();
		parkingValidation(btn07, 556, 206, 40, 21, 6, "07");
		
		JButton btn08 = new JButton();
		parkingValidation(btn08, 556, 176, 40, 21, 7, "08");

		JButton btn09 = new JButton();
		parkingValidation(btn09, 556, 147, 40, 21, 8, "09");

		JButton btn10 = new JButton();
		parkingValidation(btn10, 556, 118, 40, 21, 9, "10");

		JButton btn11 = new JButton();
		parkingValidation(btn11, 556, 89, 40, 21, 10, "11");

		JButton btn12 = new JButton();
		parkingValidation(btn12, 556, 60, 40, 21, 11, "12");

		JButton btn13 = new JButton();
		parkingValidation(btn13, 556, 31, 40, 21, 12, "13");

		JButton btn14 = new JButton();
		parkingValidation(btn14, 602, 206, 40, 21, 13, "14");

		JButton btn15 = new JButton();
		parkingValidation(btn15, 602, 176, 40, 21, 14, "15");

		JButton btn16 = new JButton();
		parkingValidation(btn16, 602, 147, 40, 21, 15, "16");

		JButton btn17 = new JButton();
		parkingValidation(btn17, 602, 118, 40, 21, 16, "17");

		JButton btn18 = new JButton();
		parkingValidation(btn18, 602, 89, 40, 21, 17, "18");

		JButton btn19 = new JButton();
		parkingValidation(btn19, 602, 60, 40, 21, 18, "19");

		JButton btn20 = new JButton();
		parkingValidation(btn20, 602, 31, 40, 21, 19, "20");

		JButton btn21 = new JButton();
		parkingValidation(btn21, 689, 33, 22, 38, 20, "21");

		JButton btn22 = new JButton();
		parkingValidation(btn22, 721, 33, 22, 38, 21, "22");

		JButton btn23 = new JButton();
		parkingValidation(btn23, 753, 33, 22, 38, 22, "23");

		JButton btn24 = new JButton();
		parkingValidation(btn24, 785, 33, 22, 38, 23, "24");

		JButton btn25 = new JButton();
		parkingValidation(btn25, 782, 177, 22, 38, 24, "25");

		JButton btn26 = new JButton();
		parkingValidation(btn26, 750, 177, 22, 38, 25, "26");

		JButton btn27 = new JButton();
		parkingValidation(btn27, 719, 177, 22, 38, 26, "27");

		JButton btn28 = new JButton();
		parkingValidation(btn28, 687, 177, 22, 38, 27, "28");

		JButton btn29 = new JButton();
		parkingValidation(btn29, 453, 505, 40, 21, 28, "29");

		JButton btn30 = new JButton();
		parkingValidation(btn30, 453, 476, 40, 21, 29, "30");

		JButton btn31 = new JButton();
		parkingValidation(btn31, 453, 447, 40, 21, 30, "31");

		JButton btn32 = new JButton();
		parkingValidation(btn32, 453, 416, 40, 21, 31, "32");

		JButton btn33 = new JButton();
		parkingValidation(btn33, 453, 387, 40, 21, 32, "33");

		JButton btn34 = new JButton();
		parkingValidation(btn34, 453, 358, 40, 21, 33, "34");

		JButton btn35 = new JButton();
		parkingValidation(btn35, 548, 505, 40, 21, 34, "35");

		JButton btn36 = new JButton();
		parkingValidation(btn36, 548, 476, 40, 21, 35, "36");

		JButton btn37 = new JButton();
		parkingValidation(btn37, 548, 447, 40, 21, 36, "37");

		JButton btn38 = new JButton();
		parkingValidation(btn38, 548, 418, 40, 21, 37, "38");

		JButton btn39 = new JButton();
		parkingValidation(btn39, 548, 387, 40, 21, 38, "39");

		JButton btn40 = new JButton();
		parkingValidation(btn40, 548, 358, 40, 21, 39, "40");

		JButton btn41 = new JButton();
		parkingValidation(btn41, 595, 505, 40, 21, 40, "41");

		JButton btn42 = new JButton();
		parkingValidation(btn42, 595, 476, 40, 21, 41, "42");

		JButton btn43 = new JButton();
		parkingValidation(btn43, 595, 447, 40, 21, 42, "43");

		JButton btn44 = new JButton();
		parkingValidation(btn44, 595, 418, 40, 21, 43, "44");

		JButton btn45 = new JButton();
		parkingValidation(btn45, 595, 387, 40, 21, 44, "45");

		JButton btn46 = new JButton();
		parkingValidation(btn46, 595, 358, 40, 21, 45, "46");

		JButton btn47 = new JButton();
		parkingValidation(btn47, 697, 358, 40, 21, 46, "47");

		JButton btn48 = new JButton();
		parkingValidation(btn48, 697, 387, 40, 21, 47, "48");

		JButton btn49 = new JButton();
		parkingValidation(btn49, 697, 418, 40, 21, 48, "49");

		JButton btn50 = new JButton();
		parkingValidation(btn50, 697, 447, 40, 21, 49, "50");

		JButton btn51 = new JButton();
		parkingValidation(btn51, 697, 476, 40, 21, 50, "51");

		JButton btn52 = new JButton();
		parkingValidation(btn52, 697, 505, 40, 21, 51, "52");

		JButton btn53 = new JButton();
		parkingValidation(btn53, 744, 505, 40, 21, 52, "53");

		JButton btn54 = new JButton();
		parkingValidation(btn54, 744, 476, 40, 21, 53, "54");

		JButton btn55 = new JButton();
		parkingValidation(btn55, 744, 447, 40, 21, 54, "55");

		JButton btn56 = new JButton();
		parkingValidation(btn56, 744, 418, 40, 21, 55, "56");

		JButton btn57 = new JButton();
		parkingValidation(btn57, 744, 387, 40, 21, 56, "57");

		JButton btn58 = new JButton();
		parkingValidation(btn58, 744, 358, 40, 21, 57, "58");

		JButton btn59 = new JButton();
		parkingValidation(btn59, 827, 488, 22, 38, 58, "59");

		JButton btn60 = new JButton();
		parkingValidation(btn60, 859, 488, 22, 38, 59, "60");

		JButton btn61 = new JButton();
		parkingValidation(btn61, 889, 488, 22, 38, 60, "61");

		JButton btn62 = new JButton();
		parkingValidation(btn62, 920, 488, 22, 38, 61, "62");

		JButton btn63 = new JButton();
		parkingValidation(btn63, 920, 370, 22, 38, 62, "63");

		JButton btn64 = new JButton();
		parkingValidation(btn64, 889, 370, 22, 38, 63, "64");

		JButton btn65 = new JButton();
		parkingValidation(btn65, 859, 370, 22, 38, 64, "65");

		JButton btn66 = new JButton();
		parkingValidation(btn66, 827, 370, 22, 38, 65, "66");

		JButton btn67 = new JButton();
		parkingValidation(btn67, 920, 214, 22, 38, 66, "67");

		JButton btn68 = new JButton();
		parkingValidation(btn68, 889, 214, 22, 38, 67, "68");

		JButton btn69 = new JButton();
		parkingValidation(btn69, 403, 505, 40, 21, 68, "69");

		JButton btn70 = new JButton();
		parkingValidation(btn70, 403, 476, 40, 21, 69, "70");
		
		// Call parkingValidation for each button
		JButton btn71 = new JButton();
		parkingValidation(btn71, 403, 447, 40, 21, 70, "71");

		JButton btn72 = new JButton();
		parkingValidation(btn72, 403, 416, 40, 21, 71, "72");

		JButton btn73 = new JButton();
		parkingValidation(btn73, 403, 387, 40, 21, 72, "73");

		JButton btn74 = new JButton();
		parkingValidation(btn74, 403, 358, 40, 21, 73, "74");

		JButton btn75 = new JButton();
		parkingValidation(btn75, 318, 505, 40, 21, 74, "75");

		JButton btn76 = new JButton();
		parkingValidation(btn76, 318, 476, 40, 21, 75, "76");

		JButton btn77 = new JButton();
		parkingValidation(btn77, 318, 447, 40, 21, 76, "77");

		JButton btn78 = new JButton();
		parkingValidation(btn78, 318, 416, 40, 21, 77, "78");

		JButton btn79 = new JButton();
		parkingValidation(btn79, 318, 387, 40, 21, 78, "79");

		JButton btn80 = new JButton();
		parkingValidation(btn80, 318, 358, 40, 21, 79, "80");

		JButton btn81 = new JButton();
		parkingValidation(btn81, 333, 31, 22, 64, 80, "81");

		JButton btn82 = new JButton();
		parkingValidation(btn82, 300, 31, 22, 64, 81, "82");

		JButton btn83 = new JButton();
		parkingValidation(btn83, 266, 31, 22, 64, 82, "83");

		JButton btn84 = new JButton();
		parkingValidation(btn84, 232, 358, 22, 69, 83, "84");

		JButton btn85 = new JButton();
		parkingValidation(btn85, 73, 72, 22, 96, 84, "85");

		JButton btn86 = new JButton();
		parkingValidation(btn86, 37, 72, 22, 96, 85, "86");

		JButton btn87 = new JButton();
		parkingValidation(btn87, 106, 401, 22, 96, 86, "87");

		JButton btn88 = new JButton();
		parkingValidation(btn88, 70, 401, 22, 96, 87, "88");

		JButton btn89 = new JButton();
		parkingValidation(btn89, 34, 401, 22, 96, 88, "89");

		JLabel lblLayout = new JLabel(scaledIcon);
		lblLayout.setBounds(0, 0, 986, 563);
		add(lblLayout);

		occupyButtons.put("01", new Object[] { btn01, motorLabels[0] });
		occupyButtons.put("02", new Object[] { btn02, motorLabels[1] });
		occupyButtons.put("03", new Object[] { btn03, motorLabels[2] });
		occupyButtons.put("04", new Object[] { btn04, motorLabels[3] });
		occupyButtons.put("05", new Object[] { btn05, motorLabels[4] });
		occupyButtons.put("06", new Object[] { btn06, motorLabels[5] });
		occupyButtons.put("07", new Object[] { btn07, motorLabels[6] });
		occupyButtons.put("08", new Object[] { btn08, motorLabels[7] });
		occupyButtons.put("09", new Object[] { btn09, motorLabels[8] });
		occupyButtons.put("10", new Object[] { btn10, motorLabels[9] });
		occupyButtons.put("11", new Object[] { btn11, motorLabels[10] });
		occupyButtons.put("12", new Object[] { btn12, motorLabels[11] });
		occupyButtons.put("13", new Object[] { btn13, motorLabels[12] });
		occupyButtons.put("14", new Object[] { btn14, motorLabels[13] });
		occupyButtons.put("15", new Object[] { btn15, motorLabels[14] });
		occupyButtons.put("16", new Object[] { btn16, motorLabels[15] });
		occupyButtons.put("17", new Object[] { btn17, motorLabels[16] });
		occupyButtons.put("18", new Object[] { btn18, motorLabels[17] });
		occupyButtons.put("19", new Object[] { btn19, motorLabels[18] });
		occupyButtons.put("20", new Object[] { btn20, motorLabels[19] });
		occupyButtons.put("21", new Object[] { btn21, motorLabels[20] });
		occupyButtons.put("22", new Object[] { btn22, motorLabels[21] });
		occupyButtons.put("23", new Object[] { btn23, motorLabels[22] });
		occupyButtons.put("24", new Object[] { btn24, motorLabels[23] });
		occupyButtons.put("25", new Object[] { btn25, motorLabels[24] });
		occupyButtons.put("26", new Object[] { btn26, motorLabels[25] });
		occupyButtons.put("27", new Object[] { btn27, motorLabels[26] });
		occupyButtons.put("28", new Object[] { btn28, motorLabels[27] });
		occupyButtons.put("29", new Object[] { btn29, motorLabels[28] });
		occupyButtons.put("30", new Object[] { btn30, motorLabels[29] });
		occupyButtons.put("31", new Object[] { btn31, motorLabels[30] });
		occupyButtons.put("32", new Object[] { btn32, motorLabels[31] });
		occupyButtons.put("33", new Object[] { btn33, motorLabels[32] });
		occupyButtons.put("34", new Object[] { btn34, motorLabels[33] });
		occupyButtons.put("35", new Object[] { btn35, motorLabels[34] });
		occupyButtons.put("36", new Object[] { btn36, motorLabels[35] });
		occupyButtons.put("37", new Object[] { btn37, motorLabels[36] });
		occupyButtons.put("38", new Object[] { btn38, motorLabels[37] });
		occupyButtons.put("39", new Object[] { btn39, motorLabels[38] });
		occupyButtons.put("40", new Object[] { btn40, motorLabels[39] });
		occupyButtons.put("41", new Object[] { btn41, motorLabels[40] });
		occupyButtons.put("42", new Object[] { btn42, motorLabels[41] });
		occupyButtons.put("43", new Object[] { btn43, motorLabels[42] });
		occupyButtons.put("44", new Object[] { btn44, motorLabels[43] });
		occupyButtons.put("45", new Object[] { btn45, motorLabels[44] });
		occupyButtons.put("46", new Object[] { btn46, motorLabels[45] });
		occupyButtons.put("47", new Object[] { btn47, motorLabels[46] });
		occupyButtons.put("48", new Object[] { btn48, motorLabels[47] });
		occupyButtons.put("49", new Object[] { btn49, motorLabels[48] });
		occupyButtons.put("50", new Object[] { btn50, motorLabels[49] });
		occupyButtons.put("51", new Object[] { btn51, motorLabels[50] });
		occupyButtons.put("52", new Object[] { btn52, motorLabels[51] });
		occupyButtons.put("53", new Object[] { btn53, motorLabels[52] });
		occupyButtons.put("54", new Object[] { btn54, motorLabels[53] });
		occupyButtons.put("55", new Object[] { btn55, motorLabels[54] });
		occupyButtons.put("56", new Object[] { btn56, motorLabels[55] });
		occupyButtons.put("57", new Object[] { btn57, motorLabels[56] });
		occupyButtons.put("58", new Object[] { btn58, motorLabels[57] });
		occupyButtons.put("59", new Object[] { btn59, motorLabels[58] });
		occupyButtons.put("60", new Object[] { btn60, motorLabels[59] });
		occupyButtons.put("61", new Object[] { btn61, motorLabels[60] });
		occupyButtons.put("62", new Object[] { btn62, motorLabels[61] });
		occupyButtons.put("63", new Object[] { btn63, motorLabels[62] });
		occupyButtons.put("64", new Object[] { btn64, motorLabels[63] });
		occupyButtons.put("65", new Object[] { btn65, motorLabels[64] });
		occupyButtons.put("66", new Object[] { btn66, motorLabels[65] });
		occupyButtons.put("67", new Object[] { btn67, motorLabels[66] });
		occupyButtons.put("68", new Object[] { btn68, motorLabels[67] });
		occupyButtons.put("69", new Object[] { btn69, motorLabels[68] });
		occupyButtons.put("70", new Object[] { btn70, motorLabels[69] });
		occupyButtons.put("71", new Object[] { btn71, motorLabels[70] });
		occupyButtons.put("72", new Object[] { btn72, motorLabels[71] });
		occupyButtons.put("73", new Object[] { btn73, motorLabels[72] });
		occupyButtons.put("74", new Object[] { btn74, motorLabels[73] });
		occupyButtons.put("75", new Object[] { btn75, motorLabels[74] });
		occupyButtons.put("76", new Object[] { btn76, motorLabels[75] });
		occupyButtons.put("77", new Object[] { btn77, motorLabels[76] });
		occupyButtons.put("78", new Object[] { btn78, motorLabels[77] });
		occupyButtons.put("79", new Object[] { btn79, motorLabels[78] });
		occupyButtons.put("80", new Object[] { btn80, motorLabels[79] });
		occupyButtons.put("81", new Object[] { btn81, motorLabels[80] });
		occupyButtons.put("82", new Object[] { btn82, motorLabels[81] });
		occupyButtons.put("83", new Object[] { btn83, motorLabels[82] });
		occupyButtons.put("84", new Object[] { btn84, motorLabels[83] });
		occupyButtons.put("85", new Object[] { btn85, motorLabels[84] });
		occupyButtons.put("86", new Object[] { btn86, motorLabels[85] });
		occupyButtons.put("87", new Object[] { btn87, motorLabels[86] });
		occupyButtons.put("88", new Object[] { btn88, motorLabels[87] });
		occupyButtons.put("89", new Object[] { btn89, motorLabels[88] });

		buttons = new JButton[] {btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10, btn11, btn12,
								btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27,
								btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42,
								btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57,
								btn58, btn59, btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69, btn70, btn71, btn72,
								btn73, btn74, btn75, btn76, btn77, btn78, btn79, btn80, btn81, btn82, btn83, btn84, btn85, btn86, btn87,
								btn88, btn89};
		enableButtons(buttons);
	}

	private void parkingValidation(JButton button, int x, int y, int width, int height, int labelIndex, String slot) {
	    button.setFocusable(false);
	    button.setBounds(x, y, width, height);
	    add(button);
	    button.addActionListener(e -> {
	        int choice = JOptionPane.showConfirmDialog(
	            null,
	            "Are you sure you want to park in slot " + slot + "?",
	            "Notice!",
	            JOptionPane.YES_NO_OPTION
	        );
	        if (choice == JOptionPane.YES_OPTION) {
	            button.setVisible(false);
	            motorLabels[labelIndex].setVisible(true);
	            parkSuccess(slot);
	        }
	    });
	}

	private JLabel createMotorLabels(int x, int y) { // horizontal motor icon
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

	private JLabel createMotorpLabels(int x, int y) {
		Image originalImage = motorIcon.getImage();
		int originalWidth = originalImage.getWidth(null);
		int originalHeight = originalImage.getHeight(null);

		double widthRatio = 20.9 / originalWidth;
		double heightRatio = 36.9 / originalHeight;

		double scaleFactor = Math.min(widthRatio, heightRatio);

		int newWidth = (int) (originalWidth * scaleFactor);
		int newHeight = (int) (originalHeight * scaleFactor);

		Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel label = new JLabel();
		label.setIcon(scaledIcon);

		int xOffset = (22 - newWidth) / 2; 
		int yOffset = (38 - newHeight) / 2; 
		label.setBounds(x + xOffset, y + yOffset, newWidth, newHeight);

		label.setVisible(false);

		add(label);

		return label;
	}
	
	private void enableButtons(JButton[] button) {
		for (JButton btn : button) {
			btn.setEnabled(status); 
		}

	}

	public void buttonState(boolean status) {
		this.status = status;
		enableButtons(buttons);
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
		this.status = false;
		enableButtons(buttons);
		frame.buttonState(status);
		JOptionPane.showMessageDialog(null, "Successfully Parked!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
		methods.switchPanel(frame, this, frame.mainPanel);
		frame.setOccupiedStatus(occupied);
	}

}
