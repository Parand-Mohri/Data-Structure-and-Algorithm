import java.util.*;

public class StringSearch{ 
    public static int[] patternMatch(String t, String p) {
        // Return an array of indices representing the first indices of the matched
        // pattern in the String

        // You choose which algorithm you'd prefer to implement here (don't use brute-force)

        // If the pattern does not exist in the string, return an empty array
    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	boolean x = false;
    	int lastST = p.length()-1;
    	Object[][] list = new Object[p.length()][2];
    	for(int i = 0; i < p.length(); i++) {
    		list[i][0] = p.charAt(i);
//    		list[i][1] = i;
    		list[i][1] = (p.length()-1) - i;
    	}
    	while(!x) {
    		String subt ="";
    		for(int i = lastST - (p.length() -1); i <=lastST; i++) {
    			 subt +=t.charAt(i);
    			 
    		}
    		if(ifthesame(p,subt)) {   			
    			int y = lastST - (p.length()-1);
    			solution.add(y);
    			lastST += p.length();
    		}else {
    			if((wherethereis(list,t.charAt(lastST)) != -1)) {
    				lastST += wherethereis(list,t.charAt(lastST));
    			}else {
    				lastST += p.length();
    			}
    		}
    		if(lastST+1 > t.length() ) {
    			x = true;
    		}

    	}
    	
    	int[] array = new int[solution.size()];
    	for(int i =0; i< solution.size(); i++) {
    		array[i] = solution.get(i);
    	}
        return  array;
    }
    
    public static int wherethereis(Object[][] list, char x) {
    	for(int i = list.length-2; i >-1; i-- ) {
    		if(x == (char) list[i][0]) {
    			return (int) list[i][1];
    		}
    	}
    	return -1;
    }
    public static boolean ifthesame(String p, String t) {
    	for(int i =p.length()-1; i >-1; i-- ) {
			if(t.charAt(i) != p.charAt(i)) {
				return false;
			}
			
		}
    	return true;

    	
    }
}
