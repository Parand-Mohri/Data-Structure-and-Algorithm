import java.util.Arrays;

public class ArrayBasedIndexList1<E> implements IndexList<E> {
    private E[] list;
    private int n;

    public ArrayBasedIndexList1() {

    }
    public void insert(int index,E e) {
        if(index>n){
            list[index-1] = e;
        }
        else {
            for (int i = n; i >= index; i--  ){
                list[i] = list[i+1];
            }
            list[index-1] =e;
        }
    }
    public void remove(int index) {
        if(index-1 == n){
            list[index-1] = null;

        }
        else{
            list[index-1] = null;
            for(int i = index-1; i<n; i++ ){
                list[i] = list[i-1];
            }
        }
    }
    public E get(int index) {
        return list[index-1];

    }
    public int getSize() {
        return n;
    }

}
