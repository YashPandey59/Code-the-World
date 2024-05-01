import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {

    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private JPanel panel;

    private double num1, num2, result;
    private char operator;

    public CalculatorApp() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 20, 340, 40);
        frame.add(textField);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        functionButtons = new JButton[6];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqButton;
        functionButtons[5] = clrButton;

        for (int i = 0; i < 6; i++) {
            functionButtons[i].addActionListener(new MyActionListener());
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            functionButtons[i].setBackground(Color.GRAY);
            functionButtons[i].setFocusPainted(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(new MyActionListener());
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].setFocusPainted(false);
        }

        clrButton.setFont(new Font("Arial", Font.BOLD, 18));
        clrButton.setBackground(Color.RED);
        clrButton.setFocusPainted(false);

        panel = new JPanel();
        panel.setBounds(30, 80, 340, 280);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textField.setText(textField.getText() + i);
                }
            }
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if (e.getSource() == eqButton) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textField.setText("Error");
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
            }
            if (e.getSource() == clrButton) {
                textField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
