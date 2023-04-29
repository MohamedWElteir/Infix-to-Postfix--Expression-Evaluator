package Main;

import java.util.Stack;
import java.util.StringJoiner;

public class MainTest {
    public static void main(String[] args) {
       Test test = new Test();
        System.out.println(test.evaluate("-5+5"));


    }

//    public static double evaluate(String expression) {
//        // Convert the prefix expression to postfix expression
//        String postfixExpression = convertToPostfix(expression);
//        // Evaluate the postfix expression using the standard algorithm
//        return MainTest.evaluate(postfixExpression);
//    }

    public static String convertToPostfix(String expression) {
        // Split the prefix expression into tokens
        String[] tokens = expression.split(" ");
        // Create a stack to store operators
        Stack<String> stack = new Stack<String>();
        // Create a string to store the postfix expression
        StringBuilder postfixExpression = new StringBuilder();
        // Iterate through the tokens in reverse order
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperator(token)) {
                // If the token is an operator, push it onto the stack
                stack.push(token);
            } else {
                // If the token is a number, append it to the postfix expression
                postfixExpression.append(token).append(" ");
                // Pop operators from the stack and append them to the postfix expression
                // until a lower-precedence operator or an opening parenthesis is encountered
                while (!stack.empty() && isHigherPrecedence(stack.peek(), token)) {
                    postfixExpression.append(stack.pop()).append(" ");
                }
            }
        }
        // Pop any remaining operators from the stack and append them to the postfix expression
        while (!stack.empty()) {
            postfixExpression.append(stack.pop()).append(" ");
        }
        // Reverse the postfix expression to get the correct order
        return postfixExpression.reverse().toString().trim();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%") || token.equals("^");
    }

    private static boolean isHigherPrecedence(String operator1, String operator2) {
        // Check if operator1 has higher precedence than operator2
        if (operator1.equals("^")) {
            return true;
        } else if (operator1.equals("*") || operator1.equals("/") || operator1.equals("%")) {
            return !operator2.equals("^");
        } else if (operator1.equals("+") || operator1.equals("-")) {
            return !operator2.equals("^") && !operator2.equals("*") && !operator2.equals("/") && !operator2.equals("%");
        }
        return false;
    }
}
class Test{
    public  String infixToPostfix(String expression) {
        StringJoiner postfixString = new StringJoiner(" ");
        java.util.Stack<Character> operatorStack = new java.util.Stack<>();
        StringBuilder operandBuilder = new StringBuilder();

        for (char c : expression.toCharArray()) {
            System.out.println("current token: " + c);
            if (Character.isDigit(c)) {
                // If the token is a digit, append it to the operand builder string
                operandBuilder.append(c);
                System.out.println("Is digit: " + Character.isDigit(c));
            } else {
                if (operandBuilder.length() > 0) {
                    System.out.println("Operand builder: " + operandBuilder.toString());
                    // This handles multi-digit numbers
                    // It adds all the digits from the  operand builder to the postfix string
                    postfixString.add(operandBuilder.toString());

                    // Reset the operand builder so it re-append new operands
                    operandBuilder.setLength(0);
                }
                switch (c) {
                    case '(' -> operatorStack.push(c);
                    case ')' -> {
                        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                            postfixString.add(String.valueOf(operatorStack.pop()));
                            System.out.println("current postfiẋ: " + postfixString.toString());

                        }
                        if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                            operatorStack.pop();
                        }
                    }
                    default -> {
                        // Works in case of operators
                        while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                            postfixString.add(String.valueOf(operatorStack.pop()));
                            System.out.println("current postfiẋ: " + postfixString.toString());

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
            System.out.println("current postfiẋ: " + postfixString.toString());
        }
        // For the operators
        while (!operatorStack.isEmpty()) {
            postfixString.add(String.valueOf(operatorStack.pop()));
            System.out.println("current postfiẋ: " + postfixString.toString());
        }

        return postfixString.toString();


    }
    // Comparing the precedence of the operators
    public static int getPrecedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }

    public  String evaluate(String expression) {

        // Converting the expression from infix to postfix, so it is easier to work with
        String postfix = infixToPostfix(expression);

        java.util.Stack<Double> operandStack = new java.util.Stack<>();

        for (String token : postfix.split(" ")) { // The spacing for distinguishing between a single vs multi-digit operands
            if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Double.parseDouble(token));
            } else {
                double x = operandStack.pop();
                double y = operandStack.pop();
                switch (token) {
                    case "+" -> operandStack.push(y + x);
                    case "-" -> operandStack.push(y - x);
                    case "*" -> operandStack.push(y * x);
                    case "^" -> operandStack.push(Math.pow(y, x)); // "y to the power of x
                    case "/" -> {
                        if (x == 0) { // In case of division by zero
                            System.out.println("Cannot divide by zero");

                            return "Cannot divide by zero";
                        }
                        operandStack.push(y / x);
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                }
            }
        }
        return String.valueOf(operandStack.pop());
    }
}
