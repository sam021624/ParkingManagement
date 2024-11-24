package login;

import java.awt.Color;
import java.awt.Font;
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

public class Login extends JFrame {
	public LoadingAnimation animation = new LoadingAnimation(this);
	
	Methods methods = new Methods();
	
	ImageIcon eyeIcon = new ImageIcon(getClass().getResource("/eye.png"));
	ImageIcon eyehideIcon = new ImageIcon(getClass().getResource("/eyehide.png"));
	
	JPanel panel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	
	JCheckBox eyeLabel = new JCheckBox(eyehideIcon);

	Login() {
		panel.setBounds(0, 0, 984, 561);
		panel.setLayout(null);
		panel.setBackground(Color.yellow);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Cambria Math", Font.BOLD, 30),
				SystemColor.textHighlight));
		panel_1.setBounds(281, 150, 475, 302);
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
		loginButton.setBounds(98, 220, 299, 40);
		panel_1.add(loginButton);
		loginButton.addActionListener(e -> {
			if(!getUsername().isEmpty() || !getPassword().isEmpty()){
				
			}
		});
		
		eyeLabel.setBounds(407, 174, 29, 35);
		panel_1.add(eyeLabel);
		eyeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(eyeLabel.isSelected()) showPassword(); else hidePassword();
			}
		});
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
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
				methods.switchPanel(this, panel, animation);
				animation.fillBar();
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
		new Login();
	}
}