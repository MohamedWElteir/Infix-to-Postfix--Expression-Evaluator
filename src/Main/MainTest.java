package Main;

import java.util.Stack;

public class MainTest {
    public static void main(String[] args) {
        String prefixExpression = "+ 11 * 15 + 20 4";
       // double result = MainTest.evaluate(prefixExpression);
      //  System.out.println(result);

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
