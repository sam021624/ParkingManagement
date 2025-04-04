package main;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Methods {
	private String username = "root";
	private String password = "root";

	public void switchPanel(JFrame frame, JPanel removePanel, JPanel addPanel) {
		frame.remove(removePanel);
		frame.add(addPanel);
		frame.revalidate();
		frame.repaint();
	}

	public void registerInfo(String ID, String category, String studentName, String studentLastName, String plateNumber) {
		String url = "jdbc:mysql://localhost:3306/parkingmanagementdatabase";

		// STUDENT ID, FIRST NAME, LAST NAME, PLATE NUMBER
		String sql = "INSERT INTO studentInfo(student_id, category, first_name, last_name, plate_number) VALUES(?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ID);
			pst.setString(2, category);
			pst.setString(3, studentName);
			pst.setString(4, studentLastName);
			pst.setString(5, plateNumber);

			int affectedRows = pst.executeUpdate();

			if (affectedRows > 0)
				JOptionPane.showMessageDialog(null, "Added Successfully!");
			else
				JOptionPane.showMessageDialog(null, "Try again", "Notice", JOptionPane.ERROR_MESSAGE);

		} catch (SQLException e) {
			if (e.getSQLState().equals("23000") || e.getErrorCode() == 1602) {
				JOptionPane.showMessageDialog(null, "Duplicate Entry", "Notice!", JOptionPane.ERROR_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getInfoDatabase(String student_id, Main main) {
		String url = "jdbc:mysql://localhost:3306/parkingmanagementdatabase";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pst = con.prepareStatement("SELECT * FROM studentInfo WHERE student_id = ?");
			pst.setString(1, student_id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String category = rs.getString(2);
				String firstName = rs.getString(3);
				String lastName = rs.getString(4);
				String plateNumber = rs.getString(5);

				String fullName = firstName + " " + lastName;

				main.updateInfo(category, fullName, plateNumber);

			} else {
				JOptionPane.showMessageDialog(null, "ID not Found!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			rs.close();
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
