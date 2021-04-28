import java.util.ArrayList;
import java.util.List;

class GreedyEgypt {
	
    public static List<Fraction> getEgyptFrac(Fraction fraction) {
        // Return an array of fractions that represent the Egyptian Fractions
		ArrayList<Fraction> egyptrac = new ArrayList<Fraction>(); 
    	if((fraction.denominator ==0) || (fraction.numerator ==0)) { 
    		
    		return egyptrac;
    	
    	}
    	if(fraction.numerator ==1) {
    		
    		egyptrac.add(fraction);
    		return egyptrac;
    		
    	}
    	if(fraction.numerator > fraction.denominator) {
        	
    		egyptrac.add(new Fraction(fraction.numerator/ fraction.denominator, 1));
        	
    	}
    	if (fraction.numerator % fraction.denominator ==0) {
    		
    		egyptrac.add(fraction);
    		return egyptrac;	
    	
    	}	
        	Fraction first = new Fraction (1, (fraction.denominator / fraction.numerator) + 1);
        	egyptrac.add(first);
        	int numerator = (fraction.numerator * first.denominator) - (fraction.denominator);
        	int denominator = first.denominator * fraction.denominator;
        	if((numerator!=0) && (numerator !=1) && (denominator% numerator ==0)){
        		denominator = denominator /numerator;
        		numerator =1;
        	}	
        	Fraction reminder = new Fraction(numerator,denominator ) ;
        	ArrayList<Fraction> sub = (ArrayList<Fraction>)  getEgyptFrac(reminder);
        	for(Fraction i : sub) {
        		egyptrac.add(i);
        	}
    	return egyptrac;
    	                                                                        
    	
    }


}