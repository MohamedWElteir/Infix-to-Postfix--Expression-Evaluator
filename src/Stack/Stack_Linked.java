package Stack;


import java.util.Objects;
import java.util.StringJoiner;




public class Stack_Linked implements Stack{

    private Node Top = null;
   private int counter = 0;

    private class Node {

        private final Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
            counter++;
        }
    }
    @Override
    public boolean isEmpty() {
        return Top == null;
    }

    @Override
    public boolean push(Object data) {
        Node n = new Node(data);
        if (isEmpty()) {
            Top = n;
        }
        n.next = Top;
        Top = n;
        return true;
    }


    public Object pop() {
        if (!isEmpty()) {
            Object res = Top.data;
            Top = Top.next;
            counter--;
            return res;
        } else {
            return -1;
        }
    }
    @Override
    public Object peek() {
        if (!isEmpty()) {
            Object result = pop();
            push(result);
            return result;
        } else {
            return -1;
        }
    }

    @Override
    public boolean containes(Object target) {
        boolean flag = false;
        if (isEmpty()) {
            return false;
        }

        while (!isEmpty()) {
            Object value = pop();
            if (Objects.equals(value, target)) {
                flag = true;
                break;
            }
        }

        return flag;
    }


    public static boolean AreReversed(Stack_Linked s1, Stack_Linked s2) { //needs double-checking!

        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        Stack_Linked temp = new Stack_Linked();
        while (!s1.isEmpty()) {
            temp.push(s1.pop());
        }

        while (!s2.isEmpty() && s2.pop() == temp.pop()) {
        }
        return s2.isEmpty();
    }

    public void display() {
        Node current = Top;
        System.out.print("Stack: ");
        while (counter > 0) {
            System.out.print(current.data + " ");
            current = current.next;
            counter--;
        }
        System.out.println();

    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    public Stack_Linked Reverse() {
        Stack_Linked temp = new Stack_Linked();

        while (!isEmpty()) {
            Object data = pop();
            temp.push(data);
        }

        return temp;
    }

//------------------------------------------------------------------------------------------------------------------------//
    public static String infixToPostfix(String expression) {
        StringJoiner postfixString = new StringJoiner(" ");
        java.util.Stack<Character> operatorStack = new java.util.Stack<>();
        StringBuilder operandBuilder = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                // If the token is a digit, append it to the operand builder string
                operandBuilder.append(c);
            } else {
                if (operandBuilder.length() > 0) {

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
                        }
                        if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                            operatorStack.pop();
                        }
                    }
                    default -> {
                        // Works in case of operators
                        while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
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
      public static int getPrecedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    public static Double evaluate(String expression) {

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
                    case "/" -> {
                        if (x == 0) { // In case of division by zero
                            System.out.println("Cannot divide by zero");
                            return (double) -1;
                        }
                        operandStack.push(y / x);
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                }
            }
        }
        return operandStack.pop();
    }

}
