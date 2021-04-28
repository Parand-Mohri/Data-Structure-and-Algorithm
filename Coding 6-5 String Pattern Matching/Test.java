import java.util.*;

public class StringSearch{ 
    public static int[] patternMatch(String text, String pattern) {
        // Return an array of indices representing the first indices of the matched
        // pattern in the String

        // You choose which algorithm you'd prefer to implement here (don't use brute-force)

        // If the pattern does not exist in the string, return an empty array
    	ArrayList<Integer> s = new ArrayList<Integer>();
    	boolean check = false;
    	int pointer = pattern.length()-1;
    	final int patternL = pattern.length()-1;
    	while(!check) {
    		String subT ="";
    		subT = text.substring((pointer - patternL), pointer);
    		subT+= text.charAt(pointer);

    		if(check(pattern,subT)) {   			
    			s.add(pointer - patternL);
    			pointer += pattern.length();
    		}else {
    			if((find(pattern,text.charAt(pointer)) == -1)) {
    				pointer += pattern.length();
    			}else {
    				pointer += find(pattern,text.charAt(pointer));
    			}
    		}
    		if(pointer > text.length()-1 ) {
    			check = true;
    		}

    	}
    	
    	int[] array = new int[s.size()];
    	for(int i =0; i< s.size(); i++) {
    		array[i] = s.get(i);
    	}
        return array;
    }
    
    public static int find(String y, char x) {
    	for(int i = y.length()-2; i >-1; i-- ) {
    		if(x == y.charAt(i)) {
    			return y.length() - i;
    		}
    	}
    	return -1;
    }
    public static boolean check(String p, String t) {
    	for(int i =p.length()-1; i >-1; i-- ) {
			if(t.charAt(i) != p.charAt(i)) {
				return false;
			}
			
		}
    	return true;

    	
    }
}
