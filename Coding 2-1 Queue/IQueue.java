public interface IQueue<E> {

    public E dequeue();

    public void enqueue(E item);

    public E peek();

    public int size();

    public boolean isEmpty();

    public boolean isFull();
}