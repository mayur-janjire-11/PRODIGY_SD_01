import javax.swing.*;
import java.awt.event.*;

public class TemperatureConverterGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel tempLabel = new JLabel("Enter Temperature:");
        tempLabel.setBounds(20, 20, 150, 25);
        frame.add(tempLabel);

        JTextField tempField = new JTextField();
        tempField.setBounds(180, 20, 120, 25);
        frame.add(tempField);

        JLabel unitLabel = new JLabel("Select Unit:");
        unitLabel.setBounds(20, 60, 150, 25);
        frame.add(unitLabel);

        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> unitBox = new JComboBox<>(units);
        unitBox.setBounds(180, 60, 120, 25);
        frame.add(unitBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(110, 100, 100, 30);
        frame.add(convertButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20, 150, 280, 80);
        resultArea.setEditable(false);
        frame.add(resultArea);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double temp = Double.parseDouble(tempField.getText());
                    String unit = (String) unitBox.getSelectedItem();
                    double c, f, k;

                    if (unit.equals("Celsius")) {
                        c = temp;
                        f = (c * 9 / 5) + 32;
                        k = c + 273.15;
                    } else if (unit.equals("Fahrenheit")) {
                        f = temp;
                        c = (f - 32) * 5 / 9;
                        k = c + 273.15;
                    } else {
                        k = temp;
                        c = k - 273.15;
                        f = (c * 9 / 5) + 32;
                    }

                    resultArea.setText(
                            "Celsius: " + String.format("%.2f", c) + " °C\n" +
                            "Fahrenheit: " + String.format("%.2f", f) + " °F\n" +
                            "Kelvin: " + String.format("%.2f", k) + " K"
                    );

                } catch (Exception ex) {
                    resultArea.setText("Please enter a valid number.");
                }
            }
        });

        frame.setVisible(true);
    }
}
