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
    	frame.setMinimumSize(new Dimension(250, 50));
    	
    	JMenuBar topBar = new JMenuBar();
    	JMenu menu = new JMenu("Menu");
// Buttons for Top Bar 	
    	JMenuItem btn = new JMenuItem("Date and Time");
    	JMenuItem btn2 = new JMenuItem("Save Timestamp");
    	JMenuItem btn3 = new JMenuItem("Background Color");
    	JMenuItem btn4 = new JMenuItem("Exit");
// Add buttons to top bar with separator for spacing    	
    	menu.add(btn);
    	menu.addSeparator();
    	menu.add(btn2);
    	menu.addSeparator();
    	menu.add(btn3);
    	menu.addSeparator();
    	menu.add(btn4);
    	
    	topBar.add(menu);
    	frame.setJMenuBar(topBar);
// Panel to show top bar menu    	
    	JPanel panel = new JPanel(new BorderLayout(5, 5));
    	panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
// Label and text box to hold date and time. 	
    	JLabel dateLabel = new JLabel("Current Date and Time: ");   	
    	JTextField dateField = new JTextField();
    	dateField.setEditable(false);
// Panel to hold date and time items    	
    	JPanel dateDisplay = new JPanel(new BorderLayout(5, 5));
    	dateDisplay.setVisible(false);
    	dateDisplay.add(dateLabel, BorderLayout.WEST);
    	dateDisplay.add(dateField, BorderLayout.CENTER);  	
    	panel.add(dateDisplay, BorderLayout.SOUTH);
    	
    	frame.add(panel);
    	
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
// Format date and time     	
    	DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
// Generate current time upon button click   	
    	btn.addActionListener(e -> {
    		LocalDateTime currentTime = LocalDateTime.now();
    		String dateTime = currentTime.format(dateFormat);
// Display timestamp when button is clicked   		
    		dateField.setText(dateTime);
    		dateDisplay.setVisible(true);
    		frame.pack();
    		frame.setLocationRelativeTo(null);
    	});
// Write text field to text file and show path in console    	
    	btn2.addActionListener(e -> {
    		try (FileWriter writer = new FileWriter("log.txt")) {
    			writer.write(dateField.getText());
    			System.out.println("Saving to: " + new java.io.File("log.txt").getAbsolutePath());
    			JOptionPane.showMessageDialog(frame, "Saved to log.txt");
    		} catch (IOException ex) {
    			JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
    		}
    	});
// Change background of frame to green color when pressed    	
    	btn3.addActionListener(e -> {
    		Color greenBack = greenRandom();
    		panel.setBackground(greenBack);
// Display green hex code   		
    		btn3.setText("Color: " + String.format("#%02X%02X%02X", greenBack.getRed(), greenBack.getGreen(), greenBack.getBlue()));
    	});	
// Exit Java program   	
    	btn4.addActionListener(e -> System.exit(0));
    }
// Generate random green color    
    	private static Color greenRandom() {
    		int red = (int)(Math.random() * 100);
    		int green = 150 + (int)(Math.random() * 106);
    		int blue = (int)(Math.random() * 100);
// Return color hex values to be displayed in button    		
    		return new Color(red, green, blue);
    	}
}
