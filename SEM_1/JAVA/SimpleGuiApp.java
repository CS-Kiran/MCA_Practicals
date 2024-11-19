package shubham;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGuiApp {
    public static void main(String[] args) {
        // Creating the main frame
        JFrame frame = new JFrame("Simple GUI Application");

        // Setting the layout of the frame (using FlowLayout here for simplicity)
        frame.setLayout(new FlowLayout());

        // Creating a JLabel to display instructions
        JLabel label = new JLabel("Enter text below and click the button:");
        frame.add(label);

        // Creating a JTextField for user input
        JTextField textField = new JTextField(20); // 20 columns wide
        frame.add(textField);

        // Creating a JButton to trigger the action
        JButton button = new JButton("Display Text");
        frame.add(button);

        // ActionListener to update the label when button is clicked
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text field
                String inputText = textField.getText();

                // Update the label with the text from the text field
                label.setText("You entered: " + inputText);
            }
        });

        // Setting the default close operation to exit when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the size of the frame
        frame.setSize(300, 150);

        // Making the frame visible
        frame.setVisible(true);
    }
}
