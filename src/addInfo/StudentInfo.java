package addInfo;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import main.Methods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class StudentInfo extends JFrame{
	Methods methods = new Methods();
	
	private JTextField idTextField;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JTextField platenumberTextField;
	
	StudentInfo(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(56,170,149));
		panel.setBounds(0, 0, 686, 561);
		getContentPane().add(panel);
		
		JLabel lblStudentNumber = new JLabel("Student Number");
		lblStudentNumber.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		lblStudentNumber.setForeground(new Color(255, 255, 255));
		lblStudentNumber.setBounds(198, 45, 467, 51);
		panel.add(lblStudentNumber);
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idTextField.setBounds(198, 95, 325, 43);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		lblFirstName.setBounds(198, 149, 467, 51);
		panel.add(lblFirstName);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(198, 200, 325, 43);
		panel.add(firstnameTextField);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		lblLastName.setBounds(198, 254, 467, 51);
		panel.add(lblLastName);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(198, 304, 325, 43);
		panel.add(lastnameTextField);
		
		JLabel lblPlateNumber = new JLabel("Plate Number");
		lblPlateNumber.setForeground(Color.WHITE);
		lblPlateNumber.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		lblPlateNumber.setBounds(198, 358, 467, 51);
		panel.add(lblPlateNumber);
		
		platenumberTextField = new JTextField();
		platenumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		platenumberTextField.setColumns(10);
		platenumberTextField.setBounds(198, 410, 325, 43);
		panel.add(platenumberTextField);
		
		JButton btnSubmit = new JButton("Submit!");
		btnSubmit.setBounds(198, 469, 123, 51);
		panel.add(btnSubmit);
		btnSubmit.addActionListener(e -> {
			if(idTextField.getText().isEmpty() || firstnameTextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fill in the Blanks");
			} else if (lastnameTextField.getText().isEmpty() || platenumberTextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fill in the Blanks");
			} else {
				methods.registerInfo(getStudentID(), getStudentFirstName(), getStudentLastName(), getPlateNumber());
				clearAll();
			}
			
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(400, 469, 123, 51);
		panel.add(btnBack);
		
		this.setTitle("Registration");
		this.setSize(701,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public int getStudentID() {
		return Integer.parseInt(idTextField.getText());
	}
	public String getStudentFirstName() {
		return firstnameTextField.getText();
	}
	public String getStudentLastName() {
		return lastnameTextField.getText();
	}
	public String getPlateNumber() {
		return platenumberTextField.getText();
	}
	public void isEmpty() {
		//to do
	}
	public void clearAll() {
		idTextField.setText(null);
		firstnameTextField.setText(null);
		lastnameTextField.setText(null);
		platenumberTextField.setText(null);
	}

	public static void main(String[] args) {
		new StudentInfo();
	}
}
