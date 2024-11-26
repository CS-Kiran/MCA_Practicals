package Java_Prog;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;

public class Prog_13 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Event Handling");

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button 1 clicked!");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button 2 clicked!");
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(button1);
        frame.add(button2);

        frame.setSize(300, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
