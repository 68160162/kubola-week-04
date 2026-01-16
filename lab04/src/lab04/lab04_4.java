package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab04_4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grade Calculator Pattaraporn Kanpee 68160162 n89");
        frame.setSize(500, 150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField midText = new JTextField(5);
        JTextField finalText = new JTextField(5);
        JTextField hwText = new JTextField(5);

        JButton gradeButton = new JButton("Grade");
        JLabel resultLabel = new JLabel(" ");

        gradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double mid = Double.parseDouble(midText.getText());
                    double fin = Double.parseDouble(finalText.getText());
                    double hw = Double.parseDouble(hwText.getText());

                    double total = mid + fin + hw;
                    String grade;

                    if (total >= 80) grade = "A";
                    else if (total >= 70) grade = "B";
                    else if (total >= 60) grade = "C";
                    else if (total >= 50) grade = "D";
                    else grade = "F";

                    resultLabel.setText(grade);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter numbers only");
                }
            }
        });

        frame.add(new JLabel("Mid:"));
        frame.add(midText);
        frame.add(new JLabel("Final:"));
        frame.add(finalText);
        frame.add(new JLabel("HW:"));
        frame.add(hwText);
        frame.add(gradeButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
