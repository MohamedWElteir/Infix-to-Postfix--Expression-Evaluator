package Stack;

public interface Stack {
    boolean push(Object data);
    Object pop();
    Object peek();
    boolean containes(Object target);
   void display();
   int size();
   boolean isFull();
   boolean isEmpty();

}
