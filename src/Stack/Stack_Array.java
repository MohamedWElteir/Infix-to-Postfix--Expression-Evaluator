package Stack;

public class Stack_Array implements Stack {
    private final Object[] arr;
    private int top;
    private final int size;

    public Stack_Array(int size) {
        this.size = size;
        arr = new Object[size];
        top = -1;

    }

    @Override
    public boolean push(Object data) {
        if (isFull()) {
            return false;
        } else {
            arr[++top] = data;
        }
        return true;
    }

    @Override
    public Object pop() {
        if (!isEmpty()) {
            return arr[top--];

        } else {
            System.out.println("Stack is Empty, can't pop");

            return -1;
        }
    }
    @Override
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty, can't peek");
            return -1;

        } else {
            return arr[top];
        }
    }

        @Override
        public boolean containes (Object target){
            boolean flag = false;
            if (isEmpty()) {
                return false;
            }

            while (!isEmpty()) {
                Object value = pop();
                if (value == target) {
                    flag = true;
                    break;
                }
            }

            return flag;
        }

        @Override
        public void display () {
            Stack_Array temp = new Stack_Array(size);
            while (!isEmpty()) {
                Object x = pop();
                System.out.println(x);
                temp.push(x);
            }
            while (!temp.isEmpty()) {
                push(temp.pop());

            }

        }

        @Override
        public int size () {
            return size;
        }

        @Override
        public boolean isFull () {
            return top==size-1;
        }

        @Override
        public boolean isEmpty () {
            return top == -1;
        }


    public void printInReverseOrder() {
        if(!isEmpty()){
            Object temp = pop();
            printInReverseOrder();
            System.out.println(temp+" ");
            push(temp);
        }else
            System.out.println("Stack is Empty");

    }





    public boolean areReversed(Stack_Array s1, Stack_Array s2) {
        if(s1.isEmpty() || s2.isEmpty())
            return false;
        if(s1.size!=s2.size)
            return false;
        Stack_Array temp = new Stack_Array(s1.size);
        while(!s1.isEmpty()){
            temp.push(s1.pop());
        }

        while(!s2.isEmpty()&& s2.pop()==temp.pop()){
        }
        return s2.isEmpty();
    }






}




