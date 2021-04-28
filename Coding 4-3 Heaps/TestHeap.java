import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestHeap {

	@Test
	public void testInsertInOrder() 
	{
		System.out.println("\n\nInsert In Order");
		Heap heap = new Heap(10);
		for(int i = 0; i < 10; i++)
		{
			try {
				heap.insert(i);
			} catch (Exception e) {}
			
			System.out.println(Arrays.toString(heap.getHeap()));
			int exp = i;
			int act = heap.findMax();
			assertEquals(exp, act);
		}
	}
	
	@Test
	public void testInsertOutOfOrder() 
	{
		System.out.println("\n\nInsert Out Of Order");
		Heap heap = new Heap(10);
		int[] in = {1,3,5,7,9,2,4,6,8,0};
		for(int i = 0; i < 10; i++)
		{
			try {
				heap.insert(in[i]);
			} catch (Exception e) {}
			
			System.out.println(Arrays.toString(heap.getHeap()));
			int exp = 0;
			if(i < 5)
				exp = in[i];
			else
				exp = 9;
			int act = heap.findMax();
			assertEquals(exp, act);
		}
	}
		
	@Test
	public void testRemoveFromTop() 
	{
		System.out.println("\n\nRemove From Top");
		Heap heap = new Heap(10);
		for(int i = 0; i < 10; i++)
		{
			try {
				heap.insert(i);
			} catch (Exception e) {}
		}
		int exp[] = {8,7,6,5,4,3,2,1,0};
		for(int i = 0; i < exp.length; i++)
		{
			try {
				heap.delete(0);
			} catch (Exception e) {}
			
			System.out.println(Arrays.toString(heap.getHeap()));
			int act = heap.findMax();
			assertEquals(exp[i], act);
		}
	}
	
	@Test
	public void testRemoveFromBottom() 
	{
		System.out.println("\n\nRemove From Bottom");
		Heap heap = new Heap(10);
		for(int i = 0; i < 10; i++)
		{
			try {
				heap.insert(i);
			} catch (Exception e) {}
		}
		int exp[] = {9,8,7,6,5,4,3,2,1,0};
		for(int i = 0; i < exp.length-1; i++)
		{
			System.out.println(Arrays.toString(heap.getHeap()));
			try {
				heap.delete(10-i);
			} catch (Exception e) {}
			
			System.out.println(Arrays.toString(heap.getHeap()));
			int act = heap.findMax();
			assertEquals(9, act);
		}
	}
	
	@Test
	public void testRemoveFromMiddle() 
	{
		System.out.println("\n\nRemove From Middle");
		Heap heap = new Heap(10);
		for(int i = 0; i < 10; i++)
		{
			try {
				heap.insert(i);
			} catch (Exception e) {}
		}
		
		int exp = 9;
		int act;
		try { heap.delete(5); } catch (Exception e) {}
		act = heap.findMax();
		System.out.println(Arrays.toString(heap.getHeap()));
		assertEquals(exp, act);
		try { heap.delete(5); } catch (Exception e) {}
		act = heap.findMax();
		System.out.println(Arrays.toString(heap.getHeap()));
		assertEquals(exp, act);
		try { heap.delete(5); } catch (Exception e) {}
		act = heap.findMax();
		System.out.println(Arrays.toString(heap.getHeap()));
		assertEquals(exp, act);
		try { heap.delete(5); } catch (Exception e) {}
		act = heap.findMax();
		System.out.println(Arrays.toString(heap.getHeap()));
		assertEquals(exp, act);
	}
}