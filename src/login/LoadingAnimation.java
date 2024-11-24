package login;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import main.Main;

public class LoadingAnimation extends JPanel {
	Login frame;

	ImageIcon carIcon = new ImageIcon((getClass().getResource("/carstart.png")));

	JProgressBar progressBar = new JProgressBar(0, 100);

	public LoadingAnimation(Login frame) {
		this.frame = frame;
		
		this.setBounds(0, 0, 986, 563);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Parking Management System", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Consolas", Font.BOLD, 25), null));
		panel.setBounds(10, 11, 966, 541);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(carIcon);
		lblNewLabel.setBounds(10, 49, 946, 343);
		panel.add(lblNewLabel);

		progressBar.setValue(0);
		progressBar.setBounds(193, 403, 620, 38);
		progressBar.setStringPainted(true);
		panel.add(progressBar);

		JLabel lblNewLabel_1 = new JLabel("Loading Module");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(193, 454, 620, 14);
		panel.add(lblNewLabel_1);

	}

	public void fillBar() {
		int delay = 15; 
		Timer timer = new Timer(delay, e -> {
			int value = progressBar.getValue();
			if (value < 100) {
				progressBar.setValue(value + 1);
			} else {
				((Timer) e.getSource()).stop();
				frame.dispose();
				new Main();
			}
		});
		timer.start();

	}
}
