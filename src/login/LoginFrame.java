package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginFrame extends JFrame{

	ImageIcon adminIcon = new ImageIcon(getClass().getResource("/admin.png"));
	ImageIcon guardIcon = new ImageIcon(getClass().getResource("/guard.png"));
	
	LoginFrame() {		
        ImageIcon icon = new ImageIcon(getClass().getResource("/admin.png")); // Load image
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Resize
        icon = new ImageIcon(scaledImage);
		
        ImageIcon iconGuard = new ImageIcon(getClass().getResource("/guard.png")); // Load image
        Image imageGuard = iconGuard.getImage();
        Image scaledImageGuard = imageGuard.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Resize
        iconGuard = new ImageIcon(scaledImageGuard);

		
		JLabel lblNewLabel_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(75, 394, 391, 72);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("GUARD LOGIN");
		lblNewLabel_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_2_1.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(546, 394, 391, 72);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblAdmin = new JLabel("ADMIN LOGIN");
		lblAdmin.setForeground(SystemColor.textHighlight);
		lblAdmin.setFont(new Font("Consolas", Font.BOLD, 30));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(67, 280, 350, 72);
		getContentPane().add(lblAdmin);
		
		JLabel lblGuard = new JLabel("GUARD LOGIN");
		lblGuard.setForeground(SystemColor.textHighlight);
		lblGuard.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuard.setFont(new Font("Consolas", Font.BOLD, 30));
		lblGuard.setBounds(460, 280, 350, 72);
		getContentPane().add(lblGuard);
		
        
		JLabel lblAdminIcon = new JLabel(icon);
		lblAdminIcon.setBounds(43, 10, 423, 279);
		getContentPane().add(lblAdminIcon);
		lblAdminIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
				lblAdmin.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent e) {
				lblAdmin.setForeground(SystemColor.textHighlight);
			}
		});
		
		JLabel lblGuardIcon = new JLabel(iconGuard);
		lblGuardIcon.setBounds(427, 10, 423, 279);
		getContentPane().add(lblGuardIcon);
		lblGuardIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
				lblGuard.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent e) {
				lblGuard.setForeground(SystemColor.textHighlight);
			}
		});
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(874, 399);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.yellow);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
}
