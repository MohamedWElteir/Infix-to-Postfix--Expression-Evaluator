package Stack;


import java.util.Objects;

//

public class Stack_Linked implements Stack{

    private Node top = null;
   private int counter = 0;

    private class Node {

        private final Object data;
        private Node next;

        public Node(Object  data) {
            this.data = data;
            next = null;
            counter++;
        }
    }
    @Override
    public boolean isEmpty() {
        return top == null;
    }


    

    @Override
    public boolean push(Object data) {
        Node n = new Node(data);
        if (isEmpty()) {
            top = n;
        }
        n.next = top;
        top = n;
        return true;
    }


    public Object pop() {
        if (!isEmpty()) {
            Object res = top.data;
            top = top.next;
            counter--;
            return res;
        } else {
            return "Stack is Empty, can't pop";
        }
    }
    @Override
    public Object peek() {
        if (!isEmpty()) {
            Object result =  pop();
            push(result);
            return result;
        } else {
            return "Stack is Empty, can't peek";
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

        while (!s2.isEmpty() && Objects.equals(s2.pop(), temp.pop())) {
        }
        return s2.isEmpty();
    }

    public void display() {
        Node current = top;
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


}
