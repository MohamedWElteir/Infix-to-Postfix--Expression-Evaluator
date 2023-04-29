package Operations;


public class Evaluate {
    public static String evaluate(String expression) {

        // Converting the expression from infix to postfix, so it is easier to work with
        String postfix = InfixToPostfix.infixToPostfix(expression);

        Stack.Stack_Linked operandStack = new Stack.Stack_Linked();

        for (String token : postfix.split(" ")) { // The spacing for distinguishing between a single vs multi-digit operands
            if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Double.parseDouble(token));
            }
            else if (operandStack.isEmpty()|| operandStack.size() == 1) { // In case of an unbalanced expression
                System.err.println("Invalid expression");
                return "Invalid expression";

            }
            else {
                double x = (double) operandStack.pop();
                double y = (double) operandStack.pop();
                // if a token is only a negative sign, then it is a unary operator,
                // and we only pop one operand
                if (token.equals("-") && x == 0) {
                    operandStack.push(-y);
                }

                /* Switch case for the operators */
                switch (token) {
                    case "+" -> operandStack.push(y + x);
                    case "-" -> operandStack.push(y - x);
                    case "*" -> operandStack.push(y * x);
                    case "%" -> operandStack.push(y % x);
                    case "^" -> operandStack.push(Math.pow(y, x)); // Using the Math.pow() method
                    case "/" -> {
                        if (x == 0) { // In case of division by zero
                            System.out.println("Cannot divide by zero");
                            return "Cannot divide by zero";
                        }
                        operandStack.push(y / x);
                    }
                    default -> {
                        return "Unbalanced expression";
                    }
                }
            }
        }
        return String.valueOf(operandStack.pop());
    }

}
