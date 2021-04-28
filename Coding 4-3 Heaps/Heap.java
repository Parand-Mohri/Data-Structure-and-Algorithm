import java.util.*;

class Heap {
    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    public Heap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return (i - 1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    public void insert(int x) throws Exception {
        if (isFull())
            throw new Exception("Heap is full");
        heap[heapSize++] = x;
        upHeap(heapSize - 1);
    }

    public int delete(int x) throws Exception {
        if (isEmpty())
            throw new Exception("Heap is empty");
        int key = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        downHeap(x);
        return key;
    }

    // maintain heap property during insertion
    private void upHeap(int i) {
        // TODO Implement this method
    	while(heap[i] > heap[parent(i)] && i != 0){
        		int temp = heap[i];
        		heap[i] = heap[parent(i)];
        		heap[parent(i)] = temp;
        		i = parent(i);
    	}
    }

    // maintain heap property during deletion
    private void downHeap(int i) {
        // TODO Implement this method
    	while(kthChild(i,2)<heapSize && heap[i] < heap[maxChild(i)] ) {
    		int temp = heap[i];
    		int max = maxChild(i);
    		heap[i] = heap[max];
    		heap[max] = temp;
    		i = max;
    		
    	}
    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void printHeap() {
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    // return max from the heap
    public int findMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

    public int[] getHeap() {
        // This method is used for autotesting
        return heap;
    }
}