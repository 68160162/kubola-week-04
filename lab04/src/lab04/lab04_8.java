package lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab04_8 extends JFrame {
    private JTextField txtWeight, txtHeight;
    private JLabel lblResult, lblCategory;

    public lab04_8() {
        setTitle("BMI Calculator - Pattaraporn Kanpee 68160162 n89");
        setSize(350, 250);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Weight (kg):"));
        txtWeight = new JTextField();
        add(txtWeight);

        add(new JLabel("Height (cm):"));
        txtHeight = new JTextField();
        add(txtHeight);

        JButton btn = new JButton("Calculate BMI");
        add(btn);
        add(new JLabel(""));

        lblResult = new JLabel("Your BMI:");
        lblCategory = new JLabel("Status:");
        add(lblResult);
        add(lblCategory);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(txtWeight.getText());
                    double height = Double.parseDouble(txtHeight.getText()) / 100;
                    double bmi = weight / (height * height);

                    lblResult.setText("Your BMI: " + String.format("%.2f", bmi));

                    if (bmi < 18.5)
                        lblCategory.setText("Underweight");
                    else if (bmi < 25)
                        lblCategory.setText("Normal Weight");
                    else if (bmi < 30)
                        lblCategory.setText("Overweight");
                    else
                        lblCategory.setText("Obese");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new lab04_8();
    }
}
