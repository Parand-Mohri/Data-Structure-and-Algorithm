public class HashEntry<E> {

    private int key;
    private E value;
    private HashEntry next;

    HashEntry(int key, E value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getKey() {
        return key;
    }
    public E getValue() {
    	return value;
    }
    public void setValue(E value) {
    	this.value = value;
    }

//    public E[] getValues() {
//    	E[] chain;
//    	if(next ==null) {
//    		chain =(E[]) new Object[1];
//    		chain[0] = value;
//    	}else {
//    		E[] subchain = next.getValues();
//    		chain = (E[]) new Object[subchain.length + 1];
//    		chain[0] = value;
//    		System.arraycopy(subchain, 0, chain, 1, subchain.length);
//    	}
//    	
//         return chain;
//    }
    public void setNext(HashEntry<E> x) {
//    	if(next == null) {
    		next = x;
//    	}else {
//    		next.setNext(x);
//    	}
//    	
    }
    public HashEntry getNext(){
    	return next;
    }


}