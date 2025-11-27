package main;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.*;

public class Main {
    public static void main(String[] args) {
    	JFrame frame = new JFrame("User Interface");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(350, 125);
    	
    	JToolBar topBar = new JToolBar();
    	
    	JButton btn = new JButton("Date and Time");
    	JButton btn2 = new JButton("Save Note");
    	JButton btn3 = new JButton("Background Color");
    	JButton btn4 = new JButton("Exit");
    	
    	
    	topBar.add(btn);
    	topBar.add(btn2);
    	topBar.add(btn3);
    	topBar.add(btn4);
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(new BorderLayout(5, 5));
    	panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	panel.add(topBar, BorderLayout.NORTH);
    	
    	TextField dateField = new TextField();
    	
    	panel.add(dateField, BorderLayout.SOUTH);
    	
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
