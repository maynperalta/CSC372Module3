package main;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
    	JFrame frame = new JFrame("User Interface");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(425, 150);
    	
    	JToolBar topBar = new JToolBar();
    	
    	JButton btn = new JButton("Date and Time");
    	JButton btn2 = new JButton("Save Timestamp");
    	JButton btn3 = new JButton("Background Color");
    	JButton btn4 = new JButton("Exit");
    	
    	
    	topBar.add(btn);
    	topBar.addSeparator();
    	topBar.add(btn2);
    	topBar.addSeparator();
    	topBar.add(btn3);
    	topBar.addSeparator();
    	topBar.add(btn4);
    	
    	JPanel panel = new JPanel(new BorderLayout(5, 5));
    	panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	panel.add(topBar, BorderLayout.NORTH);
    	
    	JLabel dateLabel = new JLabel("Current Date and Time: ");
    	
    	JTextField dateField = new JTextField();
    	dateField.setEditable(false);
    	
    	JPanel dateDisplay = new JPanel(new BorderLayout(5, 5));
    	dateDisplay.setVisible(false);
    	dateDisplay.add(dateLabel, BorderLayout.WEST);
    	dateDisplay.add(dateField, BorderLayout.CENTER);
    	
    	dateDisplay.setVisible(true);
    	
    	panel.add(dateDisplay, BorderLayout.SOUTH);
    	
    	frame.add(panel);
    	frame.setVisible(true);
    	
    	DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    	
    	btn.addActionListener(e -> {
    		LocalDateTime currentTime = LocalDateTime.now();
    		String dateTime = currentTime.format(dateFormat);
    		
    		dateField.setText(dateTime);
    		dateDisplay.setVisible(true);
    		frame.revalidate();
    		frame.repaint();
    	});
    	
    	btn2.addActionListener(e -> {
    		try (FileWriter writer = new FileWriter("log.txt")) {
    			writer.write(dateField.getText());
    			System.out.println("Saving to: " + new java.io.File("log.txt").getAbsolutePath());
    			JOptionPane.showMessageDialog(frame, "Saved to log.txt");
    		} catch (IOException ex) {
    			JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
    		}
    	});
    	
    	btn3.addActionListener(e -> {
    		Color greenBack = greenRandom();
    		panel.setBackground(greenBack);
    		
    		btn3.setText("Color: " + String.format("#%02X%02X%02X", greenBack.getRed(), greenBack.getGreen(), greenBack.getBlue()));
    	});
    	
    	
    	
    	
    }
    	private static Color greenRandom() {
    		int red = (int)(Math.random() * 100);
    		int green = 150 + (int)(Math.random() * 106);
    		int blue = (int)(Math.random() * 100);
    		
    		return new Color(red, green, blue);
    	}
}
