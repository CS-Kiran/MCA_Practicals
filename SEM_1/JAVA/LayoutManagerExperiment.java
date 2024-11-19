package shubham;

import javax.swing.*;
import java.awt.*;

public class LayoutManagerExperiment {

    public static void main(String[] args) {
        // Create a JFrame to hold the buttons
        JFrame frame = new JFrame("Layout Manager Experiment");

        // Set the overall layout for the JFrame
        frame.setLayout(new BorderLayout());  // Using BorderLayout for the frame

        // Panel for BorderLayout (North, South, East, West, Center)
        JPanel borderLayoutPanel = new JPanel();
        borderLayoutPanel.setLayout(new BorderLayout());
        
        // Create buttons with different labels
        JButton button1 = new JButton("North");
        JButton button2 = new JButton("South");
        JButton button3 = new JButton("East");
        JButton button4 = new JButton("West");
        JButton button5 = new JButton("Center");
        
        // Adding buttons to the BorderLayout
        borderLayoutPanel.add(button1, BorderLayout.NORTH);
        borderLayoutPanel.add(button2, BorderLayout.SOUTH);
        borderLayoutPanel.add(button3, BorderLayout.EAST);
        borderLayoutPanel.add(button4, BorderLayout.WEST);
        borderLayoutPanel.add(button5, BorderLayout.CENTER);

        // Panel for FlowLayout
        JPanel flowLayoutPanel = new JPanel();
        flowLayoutPanel.setLayout(new FlowLayout());  // Using FlowLayout
        
        // Create buttons for FlowLayout
        JButton flowButton1 = new JButton("Flow 1");
        JButton flowButton2 = new JButton("Flow 2");
        JButton flowButton3 = new JButton("Flow 3");
        
        // Add buttons to the FlowLayout panel
        flowLayoutPanel.add(flowButton1);
        flowLayoutPanel.add(flowButton2);
        flowLayoutPanel.add(flowButton3);

        // Panel for GridLayout
        JPanel gridLayoutPanel = new JPanel();
        gridLayoutPanel.setLayout(new GridLayout(2, 2));  // 2 rows, 2 columns
        
        // Create buttons for GridLayout
        JButton gridButton1 = new JButton("Grid 1");
        JButton gridButton2 = new JButton("Grid 2");
        JButton gridButton3 = new JButton("Grid 3");
        JButton gridButton4 = new JButton("Grid 4");
        
        // Add buttons to the GridLayout panel
        gridLayoutPanel.add(gridButton1);
        gridLayoutPanel.add(gridButton2);
        gridLayoutPanel.add(gridButton3);
        gridLayoutPanel.add(gridButton4);

        // Panel for BoxLayout
        JPanel boxLayoutPanel = new JPanel();
        boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));  // Vertical BoxLayout
        
        // Create buttons for BoxLayout
        JButton boxButton1 = new JButton("Box 1");
        JButton boxButton2 = new JButton("Box 2");
        JButton boxButton3 = new JButton("Box 3");
        
        // Add buttons to the BoxLayout panel
        boxLayoutPanel.add(boxButton1);
        boxLayoutPanel.add(boxButton2);
        boxLayoutPanel.add(boxButton3);

        // Add all the panels to the main frame
        frame.add(borderLayoutPanel, BorderLayout.NORTH);
        frame.add(flowLayoutPanel, BorderLayout.CENTER);
        frame.add(gridLayoutPanel, BorderLayout.SOUTH);
        frame.add(boxLayoutPanel, BorderLayout.EAST);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
