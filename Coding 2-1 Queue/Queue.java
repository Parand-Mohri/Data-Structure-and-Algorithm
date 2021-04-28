public class Queue<E> implements IQueue<E> {
    private Stack<E> stack1;
    private Stack<E> stack2;
    private int capacity; // maximum capacity of the queue
    private int count; // current size of the queue

    public Queue(int size) {
        stack1 = new Stack<E>(size);
        stack2 = new Stack<E>(size);
        capacity = size;
        count = 0;

    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue empty exception");

        count--;
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        
    }

    @Override
    public void enqueue(E item) {
        if (isFull())
            throw new RuntimeException("Queue is full exception");

            stack1.push(item);
        // if (!stack2.isEmpty()) {
        //     for (int i = 0; i < stack2.size(); i++) {
        //         stack1.push(stack2.pop());
        //     }
        //     stack1.push(item);
        // } else {
        //     stack1.push(item);
        // }
        count++;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new RuntimeException("Queue empty exception");

        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            for (int i = 0; i < stack1.size(); i++) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (count == capacity) {
            return true;
        } else {
            return false;
        }
    }

}