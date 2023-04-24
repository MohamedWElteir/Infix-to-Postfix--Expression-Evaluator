package Queue;

public interface Queue {
    void enqueue(Object data);
    Object dequeue();
    boolean isFull();
    boolean isEmpty();
    void display();

}
