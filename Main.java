import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Ami's Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 20));

        JTextField firstNumberField = new JTextField();
        JTextField secondNumberField = new JTextField();
        JComboBox <String> operationsBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result: ");

        panel.add(new JLabel("First Number:"));
        panel.add(firstNumberField);
        panel.add(new JLabel("Second Number:"));
        panel.add(secondNumberField);
        panel.add(new JLabel("Operation:"));
        panel.add(operationsBox);
        panel.add(calculateButton);
        panel.add(resultLabel);

        frame.add(panel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float firstNumber = Float.parseFloat(firstNumberField.getText());
                    float secondNumber = Float.parseFloat(secondNumberField.getText());
                    String operation = (String) operationsBox.getSelectedItem();

                    float result = 0;
                    boolean validOperation = true;

                    switch (operation) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            if (secondNumber != 0) {
                                result = firstNumber / secondNumber;
                            } else {
                                resultLabel.setText("Error: Division by 0 is not allowed!");
                                validOperation = false;
                            }
                            break;
                        default:
                            resultLabel.setText("Error: Invalid operation.");
                            validOperation = false;
                    }

                    if (validOperation) {
                        resultLabel.setText("Result: " + result);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Invalid input.");
                }
            }
        });

        frame.setVisible(true);

    }
}