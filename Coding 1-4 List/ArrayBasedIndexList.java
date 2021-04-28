import java.util.Arrays;

public class ArrayBasedIndexList<E> implements IndexList<E> {

    private E[] list;
    private int n ;
    private int capacity;

    public ArrayBasedIndexList(){
        int capacity = 100;
        int n = -1;
        list = (E[]) new Object[capacity];
    }

    @Override
    public void insert(int index, E e) {
        if (index > capacity) {
            capacity = list.length + index;
            list = Arrays.copyOf(list, capacity);
            list[index] = e;
            n++;
        } else if(index  <= n) {
            list = Arrays.copyOf(list, list.length+1);
            capacity++;
            for (int i =n ; i>=index; i--){
                list[i+1] = list[i];
            }
            list[index] = e;
            n++;
        }else{
            list[index] = e;
            n++;
        }

    }

    @Override
    public void remove(int index) {
        // if (index == n) {
        //     list[index] = null;
        //     n--;
        // } else {
        //     list[index] = null;
        //     for (int i = index; i < n; i++) {
        //         list[i] = list[i + 1];
        //         n--;
        //     }
        // }
        if(index<n){
            list[index] = null;
            for (int i = index; i < n; i++) {
                list[i] = list[i + 1];   
            }
            n--;
        }else{
            list[index] = null;
            
        }


    }

    @Override
    public E get(int index) {
        return list[index];
    }

    @Override
    public int getSize() {
        return n+1;
    }

}
