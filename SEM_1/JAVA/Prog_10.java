package Java_Prog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prog_10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Program 10");

        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter text below");
        frame.add(label);

        JTextField textField = new JTextField(20);
        frame.add(textField);

        JButton button = new JButton("Click!!");
        frame.add(button);
        
        JLabel label2 = new JLabel();
        frame.add(label2);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                label2.setText(inputText);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}