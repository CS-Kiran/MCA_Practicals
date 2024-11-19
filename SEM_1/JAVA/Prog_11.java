package Java_Prog;

import javax.swing.*;
import java.awt.*;

public class Prog_11 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Program 11");

        frame.setLayout(new BorderLayout());

        
        JPanel borderLayoutPanel = new JPanel();
        borderLayoutPanel.setLayout(new BorderLayout());
        
        JLabel label1 = new JLabel("Border Layout");
        
        JButton button2 = new JButton("Button 1");
        JButton button3 = new JButton("Button 2");
        JButton button4 = new JButton("Button 3");
        JButton button5 = new JButton("Button 4");
        
        borderLayoutPanel.add(label1, BorderLayout.NORTH);
        borderLayoutPanel.add(button2, BorderLayout.SOUTH);
        borderLayoutPanel.add(button3, BorderLayout.EAST);
        borderLayoutPanel.add(button4, BorderLayout.WEST);
        borderLayoutPanel.add(button5, BorderLayout.CENTER);

        
        JPanel flowLayoutPanel = new JPanel();
        flowLayoutPanel.setLayout(new FlowLayout()); 
        
        JLabel label2 = new JLabel("Flow Layout");
        JButton flowButton1 = new JButton("Flow 1");
        JButton flowButton2 = new JButton("Flow 2");
        JButton flowButton3 = new JButton("Flow 3");
        
        flowLayoutPanel.add(label2);
        flowLayoutPanel.add(flowButton1);
        flowLayoutPanel.add(flowButton2);
        flowLayoutPanel.add(flowButton3);

        JPanel gridLayoutPanel = new JPanel();
        gridLayoutPanel.setLayout(new GridLayout(2, 2)); 
        
        JLabel label3 = new JLabel("Grid Layout");
        JButton gridButton1 = new JButton("Grid 1");
        JButton gridButton2 = new JButton("Grid 2");
        JButton gridButton3 = new JButton("Grid 3");
        
        gridLayoutPanel.add(label3);
        gridLayoutPanel.add(gridButton1);
        gridLayoutPanel.add(gridButton2);
        gridLayoutPanel.add(gridButton3);

        JPanel boxLayoutPanel = new JPanel();
        boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));
        
        JLabel label4 = new JLabel("Box Layout");
        JButton boxButton1 = new JButton("Box 1");
        JButton boxButton2 = new JButton("Box 2");
        JButton boxButton3 = new JButton("Box 3");
        
        boxLayoutPanel.add(label4);
        boxLayoutPanel.add(boxButton1);
        boxLayoutPanel.add(boxButton2);
        boxLayoutPanel.add(boxButton3);

        frame.add(borderLayoutPanel, BorderLayout.NORTH);
        frame.add(flowLayoutPanel, BorderLayout.CENTER);
        frame.add(gridLayoutPanel, BorderLayout.SOUTH);
        frame.add(boxLayoutPanel, BorderLayout.EAST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}