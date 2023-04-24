package Queue;

public class Queue_Linked implements Queue {
    private Node front = null, rear = null;

    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            next = null;
        }
    }

    @Override
    public void enqueue(Object data) {
        Node n = new Node(data);
        if (front == null) {
            front = n;
        } else {
            rear.next = n;
        }
        rear = n;
    }

    @Override
    public Object dequeue() {
        Node n = front;
        if (!isEmpty()) {

            front = front.next;
            if (front == null) {
                rear = null;
            }
        } else {
            return -1;
        }
        return n.data;
    }


    @Override
    public boolean isFull() {
        return false;
    }


    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void display() {
        Queue_Linked temp = new Queue_Linked();
        Object x;
        while (!isEmpty()) {
            x = dequeue();
            System.out.println(x);
            temp.enqueue(x);
        }
    }
    public int getSize() {
        int counter = 0;
        Node p = front;
        while (p != null) {
            counter++;
            p = p.next;
        }

        System.out.println("Size = " + counter);
        return counter;
    }
    public void reverseQueue(){
        if (isEmpty()) {
            return;
        }
        Object element = dequeue();
        reverseQueue();
        enqueue(element);

    }

}
