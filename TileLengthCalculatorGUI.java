import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TileLengthCalculatorGUI {

    private static final double INCHES_PER_TILE = 9.842;
    private static final int INCHES_IN_FOOT = 12;

    public static void main(String[] args) {
        // Set up the main frame
        JFrame frame = new JFrame("Tile Length Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); // Center the window

        // Create components
        JLabel promptLabel = new JLabel("Enter number of tiles:");
        JTextField tileInput = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Feet and inches will appear here");

        // Layout panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(promptLabel);
        panel.add(tileInput);
        panel.add(calculateButton);
        panel.add(resultLabel);

        // Action listener for the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tileCount = Integer.parseInt(tileInput.getText());
                    if (tileCount < 0) {
                        resultLabel.setText("Please enter a positive number.");
                        return;
                    }

                    double totalInches = tileCount * INCHES_PER_TILE;
                    int feet = (int) (totalInches / INCHES_IN_FOOT);
                    double remainingInches = totalInches % INCHES_IN_FOOT;

                    resultLabel.setText(String.format("Total: %d feet and %.3f inches", feet, remainingInches));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}