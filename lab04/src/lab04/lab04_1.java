package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab04_1 {

    public static void main(String[] args) {
        JFrame f = new JFrame("Hello Program Pattaraporn Kanpee 68160162 n89");
        f.setSize(400, 300);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter name:");
        JTextField nameBox = new JTextField(10);
        JButton btn = new JButton("Send");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameBox.getText();
                JOptionPane.showMessageDialog(null, "Hello " + name);
            }
        });

        f.add(label);
        f.add(nameBox);
        f.add(btn);

        f.setVisible(true);
    }
}
