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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class StudentInfo extends JFrame {
	Methods methods = new Methods();

	private JTextField idTextField;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JTextField platenumberTextField;
	private JComboBox<String> comboBoxCategory = new JComboBox<>();

	public StudentInfo() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		panel.setBounds(10, 93, 459, 307);
		getContentPane().add(panel);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblFirstName.setBounds(22, 27, 202, 30);
		panel.add(lblFirstName);

		firstnameTextField = new JTextField();
		firstnameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(22, 58, 202, 30);
		panel.add(firstnameTextField);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblLastName.setBounds(244, 27, 196, 30);
		panel.add(lblLastName);

		lastnameTextField = new JTextField();
		lastnameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(244, 59, 196, 30);
		panel.add(lastnameTextField);

		JLabel lblStudentNumber = new JLabel("Student Number");
		lblStudentNumber.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblStudentNumber.setBounds(22, 99, 202, 30);
		panel.add(lblStudentNumber);

		idTextField = new JTextField();
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idTextField.setBounds(22, 129, 202, 30);
		panel.add(idTextField);
		idTextField.setColumns(10);

		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		categoryLabel.setBounds(244, 100, 196, 30);
		panel.add(categoryLabel);

		comboBoxCategory.setBounds(244, 130, 196, 30);
		panel.add(comboBoxCategory);
		comboBoxCategory.addItem("Student");
		comboBoxCategory.addItem("Teacher");

		JLabel lblPlateNumber = new JLabel("Plate Number");
		lblPlateNumber.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblPlateNumber.setBounds(22, 170, 196, 30);
		panel.add(lblPlateNumber);

		platenumberTextField = new JTextField();
		platenumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		platenumberTextField.setColumns(10);
		platenumberTextField.setBounds(22, 200, 202, 30);
		panel.add(platenumberTextField);

		JButton btnSubmit = new JButton("Submit!");
		btnSubmit.setBounds(22, 246, 418, 35);
		panel.add(btnSubmit);

		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 473, 71);
		getContentPane().add(lblNewLabel);
		btnSubmit.addActionListener(e -> {
			if (areFieldsEmpty()) {
				JOptionPane.showMessageDialog(null, "Fill in the Blanks");
			} else if (idTextField.getText().length() > 11) {
					JOptionPane.showMessageDialog(null, "Student number only contains 11 numbers.", "Notice!", JOptionPane.ERROR_MESSAGE);
			} else if (!idTextField.getText().matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "Student ID should contain numbers only", "Notice!",
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				methods.registerInfo(getStudentID(), getCategory(), getStudentFirstName(), getStudentLastName(), getPlateNumber());
				clearAll();
			}
		});

		this.setTitle("Registration");
		this.setSize(495, 450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public int getStudentID() {
		return Integer.parseInt(idTextField.getText());
	}

	public String getCategory() {
		return (String) comboBoxCategory.getSelectedItem();
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

	public boolean areFieldsEmpty() {
		return idTextField.getText() == null && firstnameTextField.getText() == null
				&& lastnameTextField.getText() == null && comboBoxCategory.getSelectedIndex() == -1
				&& platenumberTextField.getText() == null;
	}

	public void clearAll() {
		idTextField.setText(null);
		firstnameTextField.setText(null);
		lastnameTextField.setText(null);
		comboBoxCategory.setSelectedIndex(0);
		platenumberTextField.setText(null);
	}

	public static void main(String[] args) {
		new StudentInfo();
	}
}
