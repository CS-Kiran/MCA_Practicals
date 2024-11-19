package shubham;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;

public class ButtonEventHandling {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Button Event Handling");

        // Create two buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        // Add ActionListener for Button 1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message when Button 1 is clicked
                JOptionPane.showMessageDialog(frame, "Button 1 clicked!");
            }
        });

        // Add ActionListener for Button 2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message when Button 2 is clicked
                JOptionPane.showMessageDialog(frame, "Button 2 clicked!");
            }
        });

        // Set the layout of the frame (using FlowLayout for simplicity)
        frame.setLayout(new FlowLayout());

        // Add buttons to the frame
        frame.add(button1);
        frame.add(button2);

        // Set the frame properties
        frame.setSize(300, 150); // Set the size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit when closed
        frame.setVisible(true); // Make the frame visible
    }
}
