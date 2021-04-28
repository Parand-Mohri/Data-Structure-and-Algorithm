import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class TestEgyFrac 
{
	@Test
	public void test() 
	{
		GreedyEgypt sphinx = new GreedyEgypt();
		Fraction fraction = new Fraction(20,53);
		ArrayList<Fraction> eFraction = (ArrayList<Fraction>) sphinx.getEgyptFrac(fraction);
		for(Fraction f: eFraction)
		{
			System.out.println(f.toString());
		}
	}
	
	@Test
	public void testMinus()
	{
		GreedyEgypt s = new GreedyEgypt();
		Fraction half = new Fraction(1,2);
		Fraction quarter = new Fraction(1,4);
		Fraction eighth = new Fraction(1,8);
		Fraction threeQuarter = new Fraction(3,4);
		Fraction threeEighths = new Fraction(3,8);
		Fraction fiveEighths = new Fraction(5,8);
		
//		Fraction result = s.minus(half, quarter);
//		assertEquals(1, result.numerator);
//		assertEquals(4, result.denominator);
////		
//		result = s.minus(half, eighth);
//		assertEquals(3, result.numerator);
//		assertEquals(8, result.denominator);
//		
//		result = s.minus(half, half);
//		assertEquals(0, result.numerator);
//		
//		result = s.minus(quarter, quarter);
//		assertEquals(0, result.numerator);
//		
//		result = s.minus(threeEighths, quarter);
//		assertEquals(1, result.numerator);
//		assertEquals(8, result.denominator);
//		
//		result = s.minus(fiveEighths, eighth);
//		assertEquals(1, result.numerator);
//		assertEquals(2, result.denominator);
	}
}