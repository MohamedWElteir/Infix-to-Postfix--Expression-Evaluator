package Operations;


import Stack.Stack_Array;

import java.util.StringJoiner;

import static Operations.Evaluate.endsWithOperator;


public class InfixToPostfix {

    public static String infixToPostfix(String expression) {

        if (endsWithOperator(expression))
            return "Expression is already in postfix form";

        // if infix has spaces, we remove them
        expression = expression.replaceAll("\\s+", "");
        System.out.println("expression: " + expression);

        StringJoiner postfixString = new StringJoiner(" ");
        Stack.Stack_Array operatorStack = new Stack_Array(50);
        StringBuilder operandBuilder = new StringBuilder();


        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)|| c=='.') {
                // If the token is a digit, append it to the operand builder string
                operandBuilder.append(c);
             }
            else { // If the token is not a digit
                if (operandBuilder.length() > 0) { // This handles multi-digit numbers
                    // Add all the digits from the  operand builder to the postfix string
                    postfixString.add(operandBuilder.toString());
                    // Reset the operand builder so it re-append new operands
                    operandBuilder.setLength(0);
                }
                switch (c) { // Switch case for the operators
                    case '(' -> operatorStack.push(c);
                    case ')' -> {
                        while (!operatorStack.isEmpty() && !operatorStack.peek().equals('(')) {
                            postfixString.add(String.valueOf(operatorStack.pop()));
                        }
                        if (!operatorStack.isEmpty() && operatorStack.peek().equals('(')) {
                            operatorStack.pop();
                        }
                    }
                    default -> {
                        // Works in case of operators
                        while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence((Character) operatorStack.peek())) {
                            postfixString.add(String.valueOf(operatorStack.pop()));
                        }
                        operatorStack.push(c);

                    }
                }
            }
        }
        // In the end, we construct the postfix string
        // For the operands
        if (operandBuilder.length() > 0) {
            postfixString.add(operandBuilder.toString());
        }
        // For the operators
        while (!operatorStack.isEmpty()) {
            postfixString.add(String.valueOf(operatorStack.pop()));
        }

        return postfixString.toString();


    }
    // Comparing the precedence of the operators
    private static int getPrecedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            case '%' -> 4;
            default -> 0;
        };
    }

}
