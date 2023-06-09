package Main;

import Operations.Evaluate;
import Operations.InfixToPostfix;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serial;

import static Operations.Evaluate.infixOrPostfix;


public class Main extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    public Main() {

        JRadioButton infixToPostfixButton = new JRadioButton("Infix to Postfix");
        JRadioButton postfixEvalButton = new JRadioButton("Expression Evaluation");

        // Create a text field for user input
        JTextField inputField = new JTextField(25);


        // Create labels
        JLabel outputLabel = new JLabel("Enter an expression and select an operation");
        JLabel Note = new JLabel("Separate the operands and operators with spaces only in postfix");
        Note.setForeground(Color.BLUE);

        // Create a button to perform the operation
        JButton performButton = new JButton("Perform");
        performButton.addActionListener((ActionEvent e) -> {

        // Get the input from the text field
        String input = inputField.getText();

        // Perform the selected operation
         outputLabel.setForeground(Color.BLACK);

                if (infixToPostfixButton.isSelected()) { // Infix to Postfix
                    outputLabel.setText("Output: " + InfixToPostfix.infixToPostfix(input));

                } else if (postfixEvalButton.isSelected()) { // Expression Evaluation
                    outputLabel.setText("Output: " + Evaluate.evaluate(input));
                    Note.setText(infixOrPostfix(input));

                } else { // No operation selected
                    outputLabel.setForeground(Color.RED);
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
        panel.add(Note);

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
