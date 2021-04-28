import static org.junit.Assert.*;

import org.junit.Test;

public class TestMergeSort {

	@Test
	public void testSort() 
	{
		MergeSort sort = new MergeSort();
		int[] in = {9,0,8,1,7,2,6,3,5,4};
		int[] exp = {0,1,2,3,4,5,6,7,8,9};
		int[] act = new int[10];
		
		act = sort.sort(in);
		
		for(int i = 0; i < act.length; i++)
		{
			assertEquals(exp[i], act[i]);
		}
	}
	
	@Test
	public void testSameSort() 
	{
		MergeSort sort = new MergeSort();
		int[] in = {1,2,3,4,5,5,4,3,2,1};
		int[] exp = {1,1,2,2,3,3,4,4,5,5};
		int[] act = new int[10];
		
		act = sort.sort(in);
		
		for(int i = 0; i < act.length; i++)
		{
			assertEquals(exp[i], act[i]);
		}
	}
	
	@Test
	public void testEmptyArray() 
	{
		MergeSort sort = new MergeSort();
		int[] in = {};
		int[] exp = {};
		int[] act = new int[10];
		
		act = sort.sort(in);
		
		for(int i = 0; i < act.length; i++)
		{
			assertEquals(exp[i], act[i]);
		}
	}
}