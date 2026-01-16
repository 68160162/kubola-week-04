package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class lab04_6 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Easy Math Quiz");
        frame.setSize(450, 150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random random = new Random();

        int num1 = random.nextInt(20) + 1;
        int num2 = random.nextInt(20) + 1;

        String[] operators = {"+", "-", "*"};
        String operator = operators[random.nextInt(3)];

        int correctAnswer;
        if (operator.equals("+")) {
            correctAnswer = num1 + num2;
        } else if (operator.equals("-")) {
            correctAnswer = num1 - num2;
        } else {
            correctAnswer = num1 * num2;
        }

        JLabel questionLabel = new JLabel(num1 + " " + operator + " " + num2 + " = ");
        JTextField answerField = new JTextField(5);
        JButton checkButton = new JButton("Check");
        JLabel resultLabel = new JLabel("");

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int userAnswer = Integer.parseInt(answerField.getText());

                    if (userAnswer == correctAnswer) {
                        resultLabel.setText("Correct ✓");
                        resultLabel.setForeground(Color.GREEN);
                    } else {
                        resultLabel.setText("Wrong ✗");
                        resultLabel.setForeground(Color.RED);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a number");
                }
            }
        });

        frame.add(questionLabel);
        frame.add(answerField);
        frame.add(checkButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}

