import java.util.Arrays;

class MergeSort {

    public static int[] merge(int[] left, int[] right) {
        // Initial indexes of first and second subarrays
        int[] arr = new int[left.length + right.length];
        int theleft =0;
    	int theright = 0;
    	int real =0;
        while (theleft!= left.length-1 && theright != right.length-1) {	
        	if(left[theleft] < right[theright]) {
    			arr[real++] = left[theleft++];
    		}else {
    			arr[real++] = right[theright++];
    		}
        	
        }
                
        
        	
        // TODO Complete the method
        return arr;
    }

    public static int[] sort(int arr[]) {
        // Find the middle point
        if (arr.length > 1) {
            int m = arr.length / 2;
            int[] l1 = Arrays.copyOfRange(arr, 0, m);
            int[] l2 = Arrays.copyOfRange(arr, m, arr.length);

            l1 = sort(l1);
            l2 = sort(l2);
            
            return merge(l1, l2);
        } else {
            return arr;
        }
    }
}
