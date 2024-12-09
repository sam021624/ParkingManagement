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
	private Map<String, JButton> occupyButtons = new HashMap<>();

	Main frame;
	
	Methods methods = new Methods();
	private JLabel[] carLabels = new JLabel[8];

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
		
		JLabel lbl01 = new JLabel(motorcycleIcon);
		lbl01.setBounds(467, 206, 40, 21);
		lbl01.setVisible(false);
		add(lbl01);
		
		JButton btn01 = new JButton();				
		btn01.setFocusable(false);
		btn01.setBounds(467, 206, 40, 21);
		add(btn01);
		btn01.addActionListener(e -> {
			btn01.setVisible(false);
			lbl01.setVisible(true);
			parkSuccess("01");
		});
		
		JButton btn02 = new JButton();				
		btn02.setFocusable(false);
		btn02.setBounds(467, 177, 40, 21);
		add(btn02);
		btn02.addActionListener(e -> {
			btn02.setVisible(false);
			parkSuccess("02");
		});
		
		JButton btn03 = new JButton();			
		btn03.setFocusable(false);
		btn03.setBounds(467, 147, 40, 21);
		add(btn03);
		btn03.addActionListener(e -> {
			btn03.setVisible(false);
			parkSuccess("03");
		});
		
		JButton btn04 = new JButton();
		btn04.setFocusable(false);
		btn04.setBounds(467, 118, 40, 21);
		add(btn04);
		
		JButton btn05 = new JButton();
		btn05.setFocusable(false);
		btn05.setBounds(467, 89, 40, 21);
		add(btn05);
		
		JButton btn06 = new JButton();
		btn06.setFocusable(false);
		btn06.setBounds(467, 60, 40, 21);
		add(btn06);
		
		JButton btn07 = new JButton();
		btn07.setFocusable(false);
		btn07.setBounds(556, 206, 40, 21);
		add(btn07);
		
		JButton btn08 = new JButton();
		btn08.setFocusable(false);
		btn08.setBounds(556, 176, 40, 21);
		add(btn08);
		btn08.addActionListener(e -> {
			btn08.setVisible(false);
			parkSuccess("08");
		});
		
		JButton btn09 = new JButton();
		btn09.setFocusable(false);
		btn09.setBounds(556, 147, 40, 21);
		add(btn09);
		btn09.addActionListener(e -> {
			btn09.setVisible(false);
			parkSuccess("09");
		});
		
		JButton btn10 = new JButton();
		btn10.setFocusable(false);
		btn10.setBounds(556, 118, 40, 21);
		add(btn10);
		
		JButton btn11 = new JButton();
		btn11.setFocusable(false);
		btn11.setBounds(556, 89, 40, 21);
		add(btn11);
		
		JButton btn12 = new JButton();
		btn12.setFocusable(false);
		btn12.setBounds(556, 60, 40, 21);
		add(btn12);
		
		JButton btn13 = new JButton();
		btn13.setFocusable(false);
		btn13.setBounds(556, 31, 40, 21);
		add(btn13);
		
		JButton btn14 = new JButton();
		btn14.setFocusable(false);
		btn14.setBounds(602, 206, 40, 21);
		add(btn14);
		
		JButton btn15 = new JButton();
		btn15.setFocusable(false);
		btn15.setBounds(602, 176, 40, 21);
		add(btn15);
		
		JButton btn16 = new JButton();
		btn16.setFocusable(false);
		btn16.setBounds(602, 147, 40, 21);
		add(btn16);
		
		JButton btn17 = new JButton();
		btn17.setFocusable(false);
		btn17.setBounds(602, 118, 40, 21);
		add(btn17);
		
		JButton btn18 = new JButton();
		btn18.setFocusable(false);
		btn18.setBounds(602, 89, 40, 21);
		add(btn18);
		
		JButton btn19 = new JButton();
		btn19.setFocusable(false);
		btn19.setBounds(602, 60, 40, 21);
		add(btn19);
		
		JButton btn20 = new JButton();
		btn20.setFocusable(false);
		btn20.setBounds(602, 31, 40, 21);
		add(btn20);
		
		JButton btn21 = new JButton("");
		btn21.setBounds(689, 33, 22, 38);
		add(btn21);
		
		JButton btn22 = new JButton("");
		btn22.setBounds(721, 33, 22, 38);
		add(btn22);
		
		JButton btn23 = new JButton("");
		btn23.setBounds(753, 33, 22, 38);
		add(btn23);
		
		JButton btn24 = new JButton("");
		btn24.setBounds(785, 33, 22, 38);
		add(btn24);
		
		JButton btn25 = new JButton("");
		btn25.setBounds(782, 177, 22, 38);
		add(btn25);
		
		JButton btn26 = new JButton("");
		btn26.setBounds(750, 177, 22, 38);
		add(btn26);
		
		JButton btn27 = new JButton("");
		btn27.setBounds(719, 177, 22, 38);
		add(btn27);
		btn27.addActionListener(e -> {
			btn27.setVisible(false);
			parkSuccess("27");
		});
		
		JButton btn28 = new JButton("");
		btn28.setBounds(687, 177, 22, 38);
		add(btn28);
		btn28.addActionListener(e -> {
			btn28.setVisible(false);
			parkSuccess("28");
		});
		
		JButton btn29 = new JButton();
		btn29.setFocusable(false);
		btn29.setBounds(453, 505, 40, 21);
		add(btn29);
		btn29.addActionListener(e -> {
			btn29.setVisible(false);
			parkSuccess("29");
		});
		
		JButton btn30 = new JButton();
		btn30.setFocusable(false);
		btn30.setBounds(453, 476, 40, 21);
		add(btn30);
		
		JButton btn31 = new JButton();
		btn31.setFocusable(false);
		btn31.setBounds(453, 447, 40, 21);
		add(btn31);
		
		JButton btn32 = new JButton();
		btn32.setFocusable(false);
		btn32.setBounds(453, 416, 40, 21);
		add(btn32);
		
		JButton btn33 = new JButton();
		btn33.setFocusable(false);
		btn33.setBounds(453, 387, 40, 21);
		add(btn33);
		
		JButton btn34 = new JButton();
		btn34.setFocusable(false);
		btn34.setBounds(453, 358, 40, 21);
		add(btn34);
		
		JButton btn35 = new JButton();
		btn35.setFocusable(false);
		btn35.setBounds(548, 505, 40, 21);
		add(btn35);
		
		JButton btn36 = new JButton();
		btn36.setFocusable(false);
		btn36.setBounds(548, 476, 40, 21);
		add(btn36);
		
		JButton btn37 = new JButton();
		btn37.setFocusable(false);
		btn37.setBounds(548, 447, 40, 21);
		add(btn37);
		
		JButton btn38 = new JButton();
		btn38.setFocusable(false);
		btn38.setBounds(548, 418, 40, 21);
		add(btn38);
		
		JButton btn39 = new JButton();
		btn39.setFocusable(false);
		btn39.setBounds(548, 387, 40, 21);
		add(btn39);
		
		JButton btn40 = new JButton();
		btn40.setFocusable(false);
		btn40.setBounds(548, 358, 40, 21);
		add(btn40);
		
		JButton btn41 = new JButton();
		btn41.setFocusable(false);
		btn41.setBounds(595, 505, 40, 21);
		add(btn41);
		
		JButton btn42 = new JButton();
		btn42.setFocusable(false);
		btn42.setBounds(595, 476, 40, 21);
		add(btn42);
		
		JButton btn43 = new JButton();
		btn43.setFocusable(false);
		btn43.setBounds(595, 447, 40, 21);
		add(btn43);
		
		JButton btn44 = new JButton();
		btn44.setFocusable(false);
		btn44.setBounds(595, 418, 40, 21);
		add(btn44);
		
		JButton btn45 = new JButton();
		btn45.setFocusable(false);
		btn45.setBounds(595, 387, 40, 21);
		add(btn45);
		
		JButton btn46 = new JButton();
		btn46.setFocusable(false);
		btn46.setBounds(595, 358, 40, 21);
		add(btn46);
		
		JButton btn47 = new JButton();
		btn47.setFocusable(false);
		btn47.setBounds(697, 358, 40, 21);
		add(btn47);
		
		JButton btn48 = new JButton();
		btn48.setFocusable(false);
		btn48.setBounds(697, 387, 40, 21);
		add(btn48);
		
		JButton btn49 = new JButton();
		btn49.setFocusable(false);
		btn49.setBounds(697, 418, 40, 21);
		add(btn49);
		
		JButton btn50 = new JButton();
		btn50.setFocusable(false);
		btn50.setBounds(697, 447, 40, 21);
		add(btn50);
		
		JButton btn51 = new JButton();
		btn51.setFocusable(false);
		btn51.setBounds(697, 476, 40, 21);
		add(btn51);
		
		JButton btn52 = new JButton();
		btn52.setFocusable(false);
		btn52.setBounds(697, 505, 40, 21);
		add(btn52);
		
		JButton btn53 = new JButton();
		btn53.setFocusable(false);
		btn53.setBounds(744, 505, 40, 21);
		add(btn53);
		
		JButton btn54 = new JButton();
		btn54.setFocusable(false);
		btn54.setBounds(744, 476, 40, 21);
		add(btn54);
		
		JButton btn55 = new JButton();
		btn55.setFocusable(false);
		btn55.setBounds(744, 447, 40, 21);
		add(btn55);
		
		JButton btn56 = new JButton();
		btn56.setFocusable(false);
		btn56.setBounds(744, 418, 40, 21);
		add(btn56);
		
		JButton btn57 = new JButton();
		btn57.setFocusable(false);
		btn57.setBounds(744, 387, 40, 21);
		add(btn57);
		
		JButton btn58 = new JButton();
		btn58.setFocusable(false);
		btn58.setBounds(744, 358, 40, 21);
		add(btn58);
		
		JButton btn59 = new JButton("");
		btn59.setBounds(827, 488, 22, 38);
		add(btn59);
		
		JButton btn60 = new JButton("");
		btn60.setBounds(859, 488, 22, 38);
		add(btn60);
		
		JButton btn61 = new JButton("");
		btn61.setBounds(889, 488, 22, 38);
		add(btn61);
		
		JButton btn62 = new JButton("");
		btn62.setBounds(920, 488, 22, 38);
		add(btn62);
		
		JButton btn63 = new JButton("");
		btn63.setBounds(920, 370, 22, 38);
		add(btn63);
		
		JButton btn64 = new JButton("");
		btn64.setBounds(889, 370, 22, 38);
		add(btn64);
		
		JButton btn65 = new JButton("");
		btn65.setBounds(859, 370, 22, 38);
		add(btn65);
		
		JButton btn66 = new JButton("");
		btn66.setBounds(827, 370, 22, 38);
		add(btn66);
		
		JButton btn67 = new JButton("");
		btn67.setBounds(920, 214, 22, 38);
		add(btn67);
		
		
		JButton btn68 = new JButton("");
		btn68.setBounds(889, 214, 22, 38);
		add(btn68);
		
		JButton btn69 = new JButton();
		btn69.setFocusable(false);
		btn69.setBounds(403, 505, 40, 21);
		add(btn69);
		
		JButton btn70 = new JButton();
		btn70.setFocusable(false);
		btn70.setBounds(403, 476, 40, 21);
		add(btn70);
		
		JButton btn71 = new JButton();
		btn71.setFocusable(false);
		btn71.setBounds(403, 447, 40, 21);
		add(btn71);
		
		JButton btn72 = new JButton();
		btn72.setFocusable(false);
		btn72.setBounds(403, 416, 40, 21);
		add(btn72);
		
		JButton btn73 = new JButton();
		btn73.setFocusable(false);
		btn73.setBounds(403, 387, 40, 21);
		add(btn73);
		
		JButton btn74 = new JButton();
		btn74.setFocusable(false);
		btn74.setBounds(403, 358, 40, 21);
		add(btn74);
		
		JButton btn75 = new JButton();
		btn75.setFocusable(false);
		btn75.setBounds(318, 505, 40, 21);
		add(btn75);
		
		JButton btn76 = new JButton();
		btn76.setFocusable(false);
		btn76.setBounds(318, 476, 40, 21);
		add(btn76);
		
		JButton btn77 = new JButton();
		btn77.setFocusable(false);
		btn77.setBounds(318, 447, 40, 21);
		add(btn77);
		
		JButton btn78 = new JButton();
		btn78.setFocusable(false);
		btn78.setBounds(318, 416, 40, 21);
		add(btn78);
		
		JButton btn79 = new JButton();
		btn79.setFocusable(false);
		btn79.setBounds(318, 387, 40, 21);
		add(btn79);
		
		JButton btn80 = new JButton();
		btn80.setFocusable(false);
		btn80.setBounds(318, 358, 40, 21);
		add(btn80);
		
		JButton btn81 = new JButton("");
		btn81.setBounds(333, 31, 22, 64);
		add(btn81);
		
		JButton btn82 = new JButton("");
		btn82.setBounds(300, 31, 22, 64);
		add(btn82);
		
		JButton btn83 = new JButton("");
		btn83.setBounds(266, 31, 22, 64);
		add(btn83);

		JButton btn84 = new JButton("");
		btn84.setBounds(232, 358, 22, 69);
		add(btn84);
		
		JButton btn85 = new JButton("");
		btn85.setBounds(73, 72, 22, 96);
		add(btn85);
		
		JButton btn86 = new JButton("");
		btn86.setBounds(37, 72, 22, 96);
		add(btn86);
		
		JButton btn87 = new JButton("");
		btn87.setBounds(106, 401, 22, 96);
		add(btn87);
		
		JButton btn88 = new JButton("");
		btn88.setBounds(70, 401, 22, 96);
		add(btn88);
		
		JButton btn89 = new JButton("");
		btn89.setBounds(34, 401, 22, 96);
		add(btn89);

		JLabel lblLayout = new JLabel(scaledIcon);
		lblLayout.setBounds(0, 0, 986, 563);
		add(lblLayout);
		
	}
	
	private void addParkingAction(JButton button, String slotID) {
	    button.addActionListener(e -> {
	        button.setVisible(false);
	        parkSuccess(slotID);
	        
	        occupyButtons.put(slotID, button);
	    });
	}
	
	private JLabel createCarLabels(int x, int y) {
		JLabel label = new JLabel("🏍");
		label.setBounds(x, y, 40, 21);
		label.setVisible(false);
		add(label);

		return label;
	}
	
	public void releaseCar(String slotID) {
	    // Check if the slot ID exists in the HashMap
	    if (occupyButtons.containsKey(slotID)) {
	        // Access the button using the slot ID
	        JButton button = occupyButtons.get(slotID);
	        
	        // Show a message dialog indicating the car has been released
	        JOptionPane.showMessageDialog(null, "Slot " + slotID + " is now released!", "Notice!",
	                JOptionPane.INFORMATION_MESSAGE);
	        
	        // Make the button visible again
	        button.setVisible(true);
	    }
	}

	private void parkSuccess(String occupied) {
		JOptionPane.showMessageDialog(null, "Successfully Parked!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
		methods.switchPanel(frame, this, frame.mainPanel);
		frame.setOccupiedStatus(occupied);
	}
}
