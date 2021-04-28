import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestStringCount {

	@Test
	public void testExample() 
	{
		StringCount count = new StringCount();
		String string = "abcdee";
		char e = 'e';
		
		int exp = 2;
		int act = count.count(string, e, 0);
		
		assertEquals(exp, act);
	}
	
	
	@Test
	public void testIndexLeading() 
	{
		StringCount count = new StringCount();
		String string = "eaaaaaaaaaee";
		char e = 'e';
		
		int exp = 2;
		int act = count.count(string, e, 1);
		
		assertEquals(exp, act);
	}
	
	@Test
	public void testSingleChar() 
	{
		StringCount count = new StringCount();
		String string = "e";
		char e = 'e';
		
		int exp = 1;
		int act = count.count(string, e, 0);
		
		assertEquals(exp, act);
	}
	
	@Test
	public void testNoneFound() 
	{
		StringCount count = new StringCount();
		String string = "aaaaaaaaaaaaa";
		char e = 'e';
		
		int exp = 0;
		int act = count.count(string, e, 0);
		
		assertEquals(exp, act);
	}
}