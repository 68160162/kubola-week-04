package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class lab04_5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Easy Math Quiz Pattaraporn Kanpee 68160162 n89");
        frame.setSize(450, 150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random random = new Random();
        int num1 = random.nextInt(20);
        int num2 = random.nextInt(20);

        JLabel label = new JLabel(num1 + " + " + num2 + " = ");
        JTextField answerField = new JTextField(5);
        JButton checkButton = new JButton("Check");
        JLabel resultLabel = new JLabel("");

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int answer = Integer.parseInt(answerField.getText());
                    if (answer == num1 + num2) {
                        resultLabel.setText("Correct ✓");
                        resultLabel.setForeground(Color.GREEN);
                    } else {
                        resultLabel.setText("Wrong ✗");
                        resultLabel.setForeground(Color.RED);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter a number");
                }
            }
        });

        frame.add(label);
        frame.add(answerField);
        frame.add(checkButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
