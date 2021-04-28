import java.util.ArrayList;
/* - What is the complexity of inserting elements in your hashmap? O(1)
- How improve the efficiency? make a hash function that make less collision can make the program more and more efficient. 
*/

public class HashMap<E> {
    class HashEntry<E> {
        int key;
        E value;
        HashEntry next;

        public HashEntry(int key, E value) {
            this.key = key;
            this.value = value;
        }
    }

    private final static int TABLE_SIZE = 128;
    ArrayList<HashEntry<E>> table;

    public HashMap() {
        table = new ArrayList<>();
        for (int i = 0; i < TABLE_SIZE; i++)
            table.add(null);
    }

    public E get(int key) {
        int hash = (key % TABLE_SIZE);
        HashEntry<E> front = table.get(hash);
        while (front != null) {
            if (front.key == key) {
                return front.value;
            }
            front = front.next;
        }
        return null;
    }

    public void put(int key, E value) {
        int hash = (key % TABLE_SIZE);
        HashEntry<E> front = table.get(hash);
        while (front != null) {
            if (front.key == key) {
                front.value = value;
                return;
            }
            front = front.next;
        }
        front = table.get(hash);
        HashEntry<E> New = new HashEntry(key, value);
        New.next = front;
        table.set(hash, New);

    }
}