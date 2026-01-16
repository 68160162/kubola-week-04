package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab04_3 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Hello Program Pattaraporn Kanpee 68160162 n89");
        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.PINK);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.WHITE);

        JLabel label1 = new JLabel("Enter name:");
        JTextField nameBox = new JTextField(10);
        JButton btn = new JButton("Send");
        JLabel label2 = new JLabel("");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label2.setText("Hello " + nameBox.getText());
            }
        });

        p1.add(label1);
        p1.add(nameBox);
        p1.add(btn);
        p2.add(label2);

        f.add(p1, BorderLayout.CENTER);
        f.add(p2, BorderLayout.SOUTH);

        f.setVisible(true);
    }
}
