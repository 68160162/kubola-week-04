package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class lab04_7 {
    private static int score = 0;
    private static int questionCount = 0;
    private static int num1, num2, correctAnswer;
    private static final int MAX_QUESTIONS = 10;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Math Quiz Challenge (10 Questions) - Pattaraporn Kanpee 68160162 n89");
        frame.setSize(500, 200);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel qLabel = new JLabel();
        JTextField answerField = new JTextField(5);
        JButton submitButton = new JButton("Submit");
        JLabel scoreLabel = new JLabel("Score: 0");

        Random rand = new Random();

        Runnable generateQuestion = () -> {
            num1 = rand.nextInt(12) + 1;
            num2 = rand.nextInt(12) + 1;
            correctAnswer = num1 * num2;
            qLabel.setText("Question " + (questionCount + 1) + "/" + MAX_QUESTIONS +
                    " : " + num1 + " * " + num2 + " = ");
            answerField.setText("");
        };

        generateQuestion.run();

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int userAnswer = Integer.parseInt(answerField.getText());
                    if (userAnswer == correctAnswer) score++;
                    questionCount++;
                    scoreLabel.setText("Score: " + score);

                    if (questionCount == MAX_QUESTIONS) {
                        JOptionPane.showMessageDialog(frame,
                                "Quiz Finished!\nYour Total Score: " + score + " / " + MAX_QUESTIONS);
                        submitButton.setEnabled(false);
                    } else {
                        generateQuestion.run();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a number");
                }
            }
        });

        frame.add(qLabel);
        frame.add(answerField);
        frame.add(submitButton);
        frame.add(scoreLabel);

        frame.setVisible(true);
    }
}
