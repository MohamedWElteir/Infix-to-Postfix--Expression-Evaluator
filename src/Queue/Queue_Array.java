package Queue;

public class Queue_Array implements Queue{
    private final Object[] arr;
    private int front;
    private int rear;
    private final int size;

    public Queue_Array(int size) {
        this.size = size;
        arr = new Object[ this.size];
        front = rear = -1;
    }
        @Override
    public void enqueue(Object data) {
        if (isFull()) {
        } else if (isEmpty()) {
            front = rear = 0;
            arr[front] = data;
        } else {
            arr[++rear % size] = data;
        }
        }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return -0;
        }

        Object v = arr[front];
        if (front == rear) {

            rear = front = -1;
        } else {
            front++;
            front %= size;
        }
        return v;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    @Override
    public boolean isEmpty() {
        return front==-1;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            return;
        }
        Object x = dequeue();
        System.out.println(x);
        display();
    }
}
