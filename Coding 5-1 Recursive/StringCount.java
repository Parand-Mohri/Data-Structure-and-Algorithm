public class StringCount {
    public StringCount() {

    }

    public int count( String s,char c, int i) {
    	if(i>0) {
    		s = s.substring(i);
    	}
    	if(s.length()-1 ==0) {
    		if(s.charAt(0) == c) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}else {
    		String first = s.substring(0, (s.length())/2);
    		String second = s.substring((s.length())/2,s.length());
    		int accurence = count(first,c,0) + count(second,c,0) ;
    		return accurence;
    	}
    }
}
