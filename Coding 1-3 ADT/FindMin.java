public class FindMin<E> {
    private Compare<E> test;
	private int number;
	private E minimum;

    public FindMin(Compare<E> comp) {
        test = comp;
        minimum =null;
    }
    public void reset() {
        number = 0;
        minimum = null;
        test = null;
    }
    public void add(E e) {
    	if(minimum == null) {
    		minimum = e;
    		number = 1;
    	}else if (test.smaller(e, minimum)) {
    		minimum = e;
    		number = 1;
    	}else if(test.equal(e, minimum)) {
    		number++;
    		minimum = e;
    	}

    }
    public E getMinimum() {
        return minimum;
    }
    public int getMinimumCount() {
        return number;

    }
}