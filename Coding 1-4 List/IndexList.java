public interface IndexList<E> {

    public void insert(int index,E e);
    public void remove(int index);
    public E get(int index);
    public int getSize();
}
