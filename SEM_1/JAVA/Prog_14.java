package Java_Prog;

import javax.swing.*;
import java.awt.event.*;


@SuppressWarnings("serial")
class AlarmEvent extends java.util.EventObject {
    public AlarmEvent(Object source) {
        super(source);
    }
}


interface AlarmListener {
    void alarmTriggered(AlarmEvent event);
}


class AlarmHandler implements AlarmListener {
    @Override
    public void alarmTriggered(AlarmEvent event) {
        JOptionPane.showMessageDialog(null, "Alarm Triggered! Event received.");
    }
}


@SuppressWarnings("serial")
public class Prog_14 extends JFrame {
    private JButton triggerButton;
    private AlarmListener alarmListener;

    public Prog_14() {
        
        setTitle("Alarm System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        alarmListener = new AlarmHandler();

        
        triggerButton = new JButton("Trigger Alarm");
        triggerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                AlarmEvent event = new AlarmEvent(this);
                alarmListener.alarmTriggered(event);
            }
        });

               add(triggerButton);

        
        setLayout(new java.awt.FlowLayout());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prog_14().setVisible(true);
            }
        });
    }
}
