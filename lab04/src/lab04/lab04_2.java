package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab04_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Greeting Program Pattaraporn Kanpee 68160162 n89");
        frame.setSize(550, 120);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 25));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter Name:");
        JTextField textField = new JTextField(12);
        JButton sendButton = new JButton("Send");
        JLabel resultLabel = new JLabel("");

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText().trim();
                resultLabel.setText("Hello " + name);
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(sendButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
