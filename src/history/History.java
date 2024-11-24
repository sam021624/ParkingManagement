package history;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Main;
import main.Methods;
import javax.swing.JLabel;
import java.awt.Font;

public class History extends JPanel {
    private JTable table;

	ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));
	
	Methods methods = new Methods();
    
    public History(Main frame) {
        this.setBackground(Color.yellow);
        this.setBounds(0, 0, 986, 563);
        setLayout(null);
        
		JButton btnNext = new JButton(nextIcon);
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		btnNext.setFocusable(false);
		btnNext.setBounds(941, 323, 35, 23);
		add(btnNext);
		btnNext.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.mainPanel);
		});
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 95, 966, 457);
        add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "License Plate", "Occupied", "Time Parked", "Time Released" }
        ));
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("PARKING HISTORY");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(10, 11, 277, 73);
        add(lblNewLabel);
        

    }

    // Utility method to check if a specific row is fully filled
    public static boolean isRowFilled(JTable table, int rowIndex) {
        int columnCount = table.getColumnCount();
        for (int col = 0; col < columnCount; col++) {
            Object cellValue = table.getValueAt(rowIndex, col);
            if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                return false; 
            }
        }
        return true;
    }

    // Utility method to check if all rows in the table are fully filled
    public static boolean areAllRowsFilled(JTable table) {
        int rowCount = table.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            if (!isRowFilled(table, row)) {
                return false;
            }
        }
        return true;
    }

    // Utility method to transfer data from one table to another
    public void transferTableData(JTable sourceTable) {
        DefaultTableModel sourceModel = (DefaultTableModel) sourceTable.getModel();
        DefaultTableModel targetModel = (DefaultTableModel) table.getModel();
        
        // Clear target table before transferring data
        targetModel.setRowCount(0);

        int rowCount = sourceModel.getRowCount();
        int columnCount = sourceModel.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            Object[] rowData = new Object[columnCount];
            for (int col = 0; col < columnCount; col++) {
                rowData[col] = sourceModel.getValueAt(row, col);
            }
            targetModel.addRow(rowData);
        }
    }

    // Optional: method to directly access the History table from other classes
    public JTable getTable() {
        return table;
    }

    // Example method to check and transfer data
    public void checkAndTransferData(JTable sourceTable) {
        if (areAllRowsFilled(sourceTable)) {
            transferTableData(sourceTable);
            System.out.println("Data transferred to History table.");
        } else {
            System.out.println("Not all rows are filled in the source table.");
        }
    }
}
