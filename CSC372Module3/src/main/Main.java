package main;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.*;

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
    	dateDisplay.add(dateLabel, BorderLayout.WEST);
    	dateDisplay.add(dateField, BorderLayout.CENTER);
    	
    	dateDisplay.setVisible(true);
    	
    	panel.add(dateDisplay, BorderLayout.SOUTH);
    	
    	frame.add(panel);
    	frame.setVisible(true);
    	
    	LocalDateTime currentTime = LocalDateTime.now();
    	
    	DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    	String dateTime = currentTime.format(dateFormat);
    	
    	System.out.println("Current date is: " + dateTime);
    	
    	
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Layout Manager Example");
//            JPanel panel = new JPanel(new FlowLayout());
//
//            panel.add(new JButton("Button 1"));
//            panel.add(new JButton("Button 2"));
//            panel.add(new JButton("Button 3"));
//
//            frame.add(panel);
//            frame.setSize(300, 100);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//        });
    }
}
