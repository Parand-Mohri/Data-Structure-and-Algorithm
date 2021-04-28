import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ListTest 
{
	
	@Test
	public void testInsertSequential() 
	{
		// Arrange
		ArrayBasedIndexList<Integer> L = new ArrayBasedIndexList<Integer>();	
		int[] exp = new int[50];
		for(int i = 0; i < 50; i++)
		{
			exp[i] = i;
		}
		
		// Act
		for(int i = 0; i < 50; i++)
		{
			L.insert(i, i);
		}
		
		// Assess
		for(int i = 0; i < 50; i++)
		{
			int act = L.get(i);
			assertEquals(act,exp[i]);
		}
	}
	
	@Test
	public void testInsertInterval() 
	{
		// Arrange
		ArrayBasedIndexList<Integer> L = new ArrayBasedIndexList<Integer>();	
		int[] exp = new int[50];
		for(int i = 0; i < 50; i=+10)
		{
			exp[i] = 100;
		}
		
		// Act
		for(int i = 0; i < 50; i++)
		{
			L.insert(i, 0);
		}
		L.insert(0, 100);
		L.insert(9, 100);
		L.insert(19, 100);
		L.insert(29, 100);
		L.insert(39, 100);
		L.insert(49, 100);
		
		// Assess
		for(int i = 0; i < 50; i++)
		{
			int act = L.get(i);
			assertEquals(act,exp[i]);
		}
	}
	
	
	@Test
	public void testRemove() 
	{
		// Arrange
		ArrayBasedIndexList<Integer> L = new ArrayBasedIndexList<Integer>();	
		int[] exp = new int[50];
		for(int i = 0; i < 50; i=+2)
		{
			exp[i] = i;
		}
		
		// Act
		for(int i = 0; i < 100; i++)
		{
			L.insert(i, 100);
		}
    
		for(int i = 100; i >= 0; i--)
		{
			if(L.get(i) % 2 == 0)
				L.remove(i);
		}
		
		// Assess
		for(int i = 0; i < 50; i++)
		{
			int act = L.get(i);
			assertEquals(act,exp[i]);
		}
	}
}