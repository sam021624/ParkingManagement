package history;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.Main;
import main.Methods;

public class History extends JPanel {
	private JTable table;
	private DefaultTableModel targetModel;

	ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));
	Methods methods = new Methods();

	public History(Main frame) {
		this.setBackground(Color.yellow);
		this.setBounds(0, 0, 986, 563);
		setLayout(null);

		JButton btnBack = new JButton("back", nextIcon);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBack.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(898, 323, 78, 23);
		add(btnBack);
		btnBack.addActionListener(e -> {
			methods.switchPanel(frame, this, frame.mainPanel);
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 966, 457);
		add(scrollPane);

		String[] columnNames = {"Student ID", "License Plate", "Occupied", "Time Parked", "Time Released", "Date"};
		targetModel = new DefaultTableModel(null, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false; // editable to false
			}
		};
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

	public void updateTableData(Object[] rowData) {
		DefaultTableModel targetModel = (DefaultTableModel) table.getModel();

		targetModel.addRow(rowData);

		int newRow = targetModel.getRowCount() - 1;

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM-dd-yyyy");

		table.setValueAt(dateFormat.format(currentDate), newRow, 5);
	}

	public void export() {
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save as PDF");
			int userSelection = fileChooser.showSaveDialog(null);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				String filePath = fileToSave.getAbsolutePath();

				if (!filePath.endsWith(".pdf")) {
					filePath += ".pdf";
				}

				PdfWriter writer = new PdfWriter(filePath);
				PdfDocument pdfDoc = new PdfDocument(writer);
				Document document = new Document(pdfDoc);

				Table pdfTable = new Table(targetModel.getColumnCount());

				for (int col = 0; col < targetModel.getColumnCount(); col++) {
					String columnName = targetModel.getColumnName(col);
					pdfTable.addHeaderCell(new Cell().add(new Paragraph(columnName)));
				}

				for (int row = 0; row < targetModel.getRowCount(); row++) {
					for (int col = 0; col < targetModel.getColumnCount(); col++) {
						Object value = targetModel.getValueAt(row, col);
						pdfTable.addCell(new Cell().add(new Paragraph(value != null ? value.toString() : "N/A")));
					}
				}

				document.add(pdfTable);
				document.close();

				JOptionPane.showMessageDialog(null, "Data exported to PDF successfully!", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error exporting data: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
