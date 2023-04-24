package Main;

import Stack.Stack_Linked;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serial;


public class Main extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    public Main() {

        JRadioButton infixToPostfixButton = new JRadioButton("Infix to Postfix");
        JRadioButton postfixEvalButton = new JRadioButton("Expression Evaluation");

        // Create a text field for user input
        JTextField inputField = new JTextField(25);

        // Create a label to display the output
        JLabel outputLabel = new JLabel();

        // Create a button to perform the operation
        JButton performButton = new JButton("Perform");
        performButton.addActionListener((ActionEvent e) -> {
            String input = inputField.getText();

            if (infixToPostfixButton.isSelected()) {
                String output = Stack_Linked.infixToPostfix(input);
                outputLabel.setText("Output: " + output);
            } else if (postfixEvalButton.isSelected()) {
                double output = Stack_Linked.evaluate(input);
                outputLabel.setText("Output: " + output);
            } else {
                outputLabel.setText("No operation selected");
            }

        });

        // Building the scene
        JPanel panel = new JPanel();
        panel.add(new JLabel("Operation: "));
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(infixToPostfixButton);
        buttonGroup1.add(postfixEvalButton);
        panel.add(infixToPostfixButton);
        panel.add(postfixEvalButton);
        panel.add(inputField);
        panel.add(performButton);
        panel.add(outputLabel);

        // Set the window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Infix to Postfix / Expression Evaluation");
        setPreferredSize(new Dimension(390, 150));
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Main();

    }

}
