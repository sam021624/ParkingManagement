package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import main.Methods;

public class AdminLogin extends JFrame {
	
	Methods methods = new Methods();
	
	ImageIcon eyeIcon = new ImageIcon(getClass().getResource("/eye.png"));
	ImageIcon eyehideIcon = new ImageIcon(getClass().getResource("/eyehide.png"));
	ImageIcon adminIcon = new ImageIcon(getClass().getResource("/admin.png"));
	
	JPanel panel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	
	JCheckBox eyeLabel = new JCheckBox(eyehideIcon);

	AdminLogin() {
		panel.setBounds(0, 0, 860, 362);
		panel.setLayout(null);
		panel.setBackground(Color.yellow);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Cambria Math", Font.BOLD, 30),
				SystemColor.textHighlight));
		panel_1.setBounds(357, 44, 475, 302);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameLabel.setBounds(98, 42, 100, 35);
		panel_1.add(usernameLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(98, 82, 299, 35);
		panel_1.add(textField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(98, 128, 100, 35);
		panel_1.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(98, 174, 299, 35);
		panel_1.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		loginButton.setFocusable(false);
		loginButton.setBounds(98, 220, 116, 40);
		panel_1.add(loginButton);
		loginButton.addActionListener(e -> {
			if(!getUsername().isEmpty() || !getPassword().isEmpty()){
				
			}
		});
		
		eyeLabel.setBounds(407, 174, 29, 35);
		panel_1.add(eyeLabel);
		
        ImageIcon icon = new ImageIcon(getClass().getResource("/admin.png")); // Load image
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // Resize
        icon = new ImageIcon(scaledImage);
		
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(32, 10, 315, 336);
		panel.add(lblNewLabel);
		eyeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(eyeLabel.isSelected()) showPassword(); else hidePassword();
			}
		});
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(874, 399);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	private void loginValidation() {
		String url = "jdbc:mysql://localhost:3306/parkinglogin";
		String username = "root";
		String password = "Sam71604";
		
		String user = getUsername();
		String pass = getPassword();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement("SELECT * FROM logindatabase WHERE username = ? AND password = ?");
			pst.setString(1, user);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Login Success!");
				
			}
				
			else
				JOptionPane.showMessageDialog(null, "Try Again!", "Error", JOptionPane.ERROR_MESSAGE);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getUsername() {
		return textField.getText();
	}

	private String getPassword() {
		return passwordField.getText();
	}
	
	private void showPassword() {
		eyeLabel.setIcon(eyeIcon);
		passwordField.setEchoChar((char)0);
	}
	
	private void hidePassword() {
		eyeLabel.setIcon(eyehideIcon);
		passwordField.setEchoChar('•');
	}
	
	private void clearTextField() {
		
	}

	public static void main(String[] args) {
		new AdminLogin();
	}
}