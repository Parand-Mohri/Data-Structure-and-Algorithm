// Class for queue
public class QueueTarditional<E> implements IQueue<E> {
    private E arr[]; // array to store queue elements
    private int front; // front points to front element in the queue
    private int rear; // rear points to last element in the queue
    private int capacity; // maximum capacity of the queue
    private int count; // current size of the queue

    // Constructor to initialize queue
    public QueueTarditional(int size) {
        arr = (E[]) (new Object[size]);
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue empty exception");

        E element = arr[front];
        front = (front + 1) % capacity;
        count--;
        return element;
    }

    public void enqueue(E item) {
        if (isFull())
            throw new RuntimeException("Queue is full exception");

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public E peek() {
        if (isEmpty())
            throw new RuntimeException("Queue empty exception");

        return arr[front];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == capacity);
    }
}
