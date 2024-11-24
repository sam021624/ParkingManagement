package history;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import main.Main;
import main.Methods;
import javax.swing.JLabel;
import java.awt.Font;

public class History extends JPanel {
    private JTable table;
    private DefaultTableModel targetModel;

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
        
        String[] columnNames = {"License Plate", "Occupied", "Time Parked", "Time Released"};
        targetModel = new DefaultTableModel(null, columnNames);
        table = new JTable(targetModel);
        
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setCellRenderer(centerRenderer);
		}
        
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("PARKING HISTORY");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(10, 11, 277, 73);
        add(lblNewLabel);
        

    }
    
    public void updateTableData(DefaultTableModel sourceModel) {
    	targetModel.setRowCount(0);
    	for (int row = 0; row < sourceModel.getRowCount(); row++) {
    		Object[] rowData = new Object[sourceModel.getColumnCount()];
    		for (int col = 0; col < sourceModel.getColumnCount(); col++) {
    			rowData[col] = sourceModel.getValueAt(row, col);
    		}
    		targetModel.addRow(rowData);
    	}
    }

}
