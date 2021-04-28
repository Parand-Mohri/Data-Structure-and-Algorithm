// WARN You may study this code, but you cannot change it.
public class Stack<E> {
    private E[] arr;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public Stack(int size) {
        arr = (E[]) (new Object[size]);
        capacity = size;
        top = -1;
    }

    public void push(E x) {
        if (isFull())
            throw new RuntimeException("Stack is full");

        arr[++top] = x;
    }

    public E pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");

        return arr[top--];
    }

    public E peek() {
        if (!isEmpty())
            return arr[top];

        return null;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}