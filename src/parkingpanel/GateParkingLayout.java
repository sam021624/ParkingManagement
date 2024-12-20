package parkingpanel;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Main;
import main.MainPanel;
import main.Methods;

public class GateParkingLayout extends JPanel {
    ImageIcon car = new ImageIcon((getClass().getResource("/carvertical.png")));
    ImageIcon backIcon = new ImageIcon((getClass().getResource("/back.png")));
    ImageIcon nextIcon = new ImageIcon((getClass().getResource("/next.png")));
    ImageIcon homeIcon = new ImageIcon((getClass().getResource("/home.png")));

    Main frame;
    MainPanel mainPanel = new MainPanel(frame);
    Methods methods = new Methods();

    private Map<String, Object[]> occupyButtons = new HashMap<>();
    private JLabel[] carLabels = new JLabel[8];
    private boolean status;
    private JButton[] buttons;

    public GateParkingLayout(Main frame) {
        this.frame = frame;

        this.setBounds(0, 0, 986, 563);
        setLayout(null);

        carLabels[0] = createCarLabels("Occupy", 30, 35);
        carLabels[1] = createCarLabels("Occupy", 147, 35);
        carLabels[2] = createCarLabels("Occupy", 264, 35);
        carLabels[3] = createCarLabels("Occupy", 381, 35);
        carLabels[4] = createCarLabels("Occupy", 498, 35);
        carLabels[5] = createCarLabels("Occupy", 615, 35);
        carLabels[6] = createCarLabels("Occupy", 732, 35);
        carLabels[7] = createCarLabels("Occupy", 849, 35);

        JLabel lblTitle = new JLabel("Gate Parking");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 60));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(10, 306, 966, 246);
        add(lblTitle);

        JButton btnBack = new JButton(backIcon);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnBack.setText("back");
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusable(false);
        btnBack.setBounds(10, 300, 78, 23);
        add(btnBack);
        btnBack.addActionListener(e -> {
            mainPanel.resetFields();
            methods.switchPanel(frame, this, frame.courtParkingLayout);
        });
        
        JLabel lblHome = new JLabel(homeIcon);
        lblHome.setBounds(330, 460, 333, 92);
        add(lblHome);
        lblHome.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		methods.switchPanel(frame, frame.gateParkingLayout, frame.mainPanel);
        	}
        });
        
        // BUTTON OCCUPY
        JButton btn90 = createOccupyButton("Occupy", 30, 114);
        parkingValidation(btn90, 0, "90");

        JButton btn91 = createOccupyButton("Occupy", 147, 114);
        parkingValidation(btn91, 1, "91");

        JButton btn92 = createOccupyButton("Occupy", 264, 114);
        parkingValidation(btn92, 2, "92");

        JButton btn93 = createOccupyButton("Occupy", 381, 114);
        parkingValidation(btn93, 3, "93");
        
        JButton btn94 = createOccupyButton("Occupy", 498, 114);
        parkingValidation(btn94, 4, "94");
        
        JButton btn95 = createOccupyButton("Occupy", 615, 114);
        parkingValidation(btn95, 5, "95");        

        JButton btn96 = createOccupyButton("Occupy", 732, 114);
        parkingValidation(btn96, 6, "96");

        JButton btn97 = createOccupyButton("Occupy", 849, 114);
        parkingValidation(btn97, 7, "97");

        occupyButtons.put("90", new Object[]{btn90, carLabels[0]});
        occupyButtons.put("91", new Object[]{btn91, carLabels[1]});
        occupyButtons.put("92", new Object[]{btn92, carLabels[2]});
        occupyButtons.put("93", new Object[]{btn93, carLabels[3]});
        occupyButtons.put("94", new Object[]{btn94, carLabels[4]});
        occupyButtons.put("95", new Object[]{btn95, carLabels[5]});
        occupyButtons.put("96", new Object[]{btn96, carLabels[6]});
        occupyButtons.put("97", new Object[]{btn97, carLabels[7]});

        buttons = new JButton[] {btn90,btn91,btn92,btn93,btn94,btn95,btn96,btn97};
        enableButtons(buttons);
        createLabels();
    }
    
    private void parkingValidation(JButton button, int labelIndex, String slot) {
	    button.addActionListener(e -> {
	        int choice = JOptionPane.showConfirmDialog(
	            null,
	            "Are you sure you want to park in slot " + slot + "?",
	            "Notice!",
	            JOptionPane.YES_NO_OPTION
	        );
	        if (choice == JOptionPane.YES_OPTION) {
	            button.setVisible(false);
	            carLabels[labelIndex].setVisible(true);
	            parkSuccess(slot);
	        }
	    });
    }

    private void createLabels() {
        int lineSpacing = 117;
        for (int i = 0; i < 8; i++) {
            int labelNumber = 90 + i;

            JLabel label = new JLabel(String.format("%02d", labelNumber));
            int xPos = 70 + i * lineSpacing;
            label.setBounds(xPos - 10, 215, 46, 14);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(label);
        }
    }

    private JLabel createCarLabels(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setIcon(car);
        label.setBounds(x, y, 107, 169);
        label.setVisible(false); 
        add(label);

        return label;
    }

    private JButton createOccupyButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 107, 30);
        button.setFocusable(false);
        add(button);

        return button;
    }

    public void releaseCarGate(String slotID) {
        if (occupyButtons.containsKey(slotID)) {
            Object[] components = occupyButtons.get(slotID);
            JButton button = (JButton) components[0];
            JLabel label = (JLabel) components[1];

            JOptionPane.showMessageDialog(null, "Slot " + slotID + " is now released!", "Notice!",
                    JOptionPane.INFORMATION_MESSAGE);

            button.setVisible(true);
            label.setVisible(false);
        }
    }
    
	private void enableButtons(JButton[] button) {
		for (JButton btn : button) {
			btn.setEnabled(status); 
		}

	}

	public void buttonState(boolean status) {
		this.status = status;
		enableButtons(buttons);
	}

    private void parkSuccess(String occupied) {
    	this.status = false;
    	enableButtons(buttons);
    	frame.buttonState(status);
        JOptionPane.showMessageDialog(null, "Successfully Parked!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
        methods.switchPanel(frame, this, frame.mainPanel);
        frame.setOccupiedStatus(occupied);
    }

	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(25, 30, 960, 30);

        int line = 9;
        int lineSpacing = 117;

        for (int i = 0; i < line; i++) {
            int xPos = 25 + i * lineSpacing;
            g2d.drawLine(xPos, 30, xPos, 200);
        }
    }
}
