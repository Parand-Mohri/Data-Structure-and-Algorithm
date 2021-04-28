import static org.junit.Assert.*;

import org.junit.Test;


public class TestBinarySearchTree {

	@Test
	public void testInsert() 
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(60);
		tree.insert(30);
		tree.insert(90);
		tree.insert(15);
		tree.insert(45);
		tree.insert(105);	
	}
   
	@Test
	public void testInsertZero() 
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(0);
		tree.insert(-1);
		tree.insert(1);
		tree.insert(-2);
		tree.insert(+2);
		tree.insert(-3);	
	}
		
	@Test
	public void testFind() 
	{
		// Arrange
		BinarySearchTree tree = new BinarySearchTree();
		boolean[] exp = new boolean[100];
		for(int i = 0; i < 100; i++)
		{
			if(i % 2 == 0)
			{
				exp[i] = true;
				tree.insert(i);
			}
			else
				exp[i] = false;
		}

		// Act
		boolean act[] = new boolean[100];
		for(int i = 0; i < 100; i++)
		{
			act[i] = tree.find(i);
		}
		
		// Assert
		for(int i = 0; i < 100; i++)
		{
			assertEquals(act[i], exp[i]);
		}
	}

	@Test
	public void testNotFound() 
	{
		BinarySearchTree tree = new BinarySearchTree();
		for(int i = 0; i < 100; i++)
		{
			// Test without number added
			boolean act = tree.find(i*100);
			assertEquals(false, act);
			
			// Add number
			tree.insert(i*100);
			
			// Test with number added
			act = tree.find(i*100);
			assertEquals(true, act);
		}
	}
	
	@Test
	public void testDeleteFromBottom() 
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(60);
		tree.insert(30);
		tree.insert(90);
		tree.insert(15);
		tree.insert(45);
		tree.insert(105);
		boolean found = tree.find(105);
		assertEquals(true, found);
		boolean deleted = tree.delete(105);
		assertEquals(true, deleted);
		found = tree.find(105);
		assertEquals(false, found);
	}

	@Test
	public void testDeleteFromMiddle() 
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(60);
		tree.insert(30);
		tree.insert(90);
		tree.insert(15);
		tree.insert(45);
		tree.insert(105);
		// Test finding 90 and 150 before deletion
		boolean found = tree.find(90);
		assertEquals(true, found);
		boolean found105 = tree.find(105);
		assertEquals(true, found105);
		// Delete 90
		boolean deleted = tree.delete(90);
		assertEquals(true, deleted);
		// Test finding 90 and 150 after deletion
		found = tree.find(90);
		assertEquals(false, found);
		found105 = tree.find(105);
		assertEquals(true, found105);
	}

	@Test
	public void testDeleteFromTop() 
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(60);
		tree.insert(30);
		tree.insert(90);
		tree.insert(15);
		tree.insert(45);
		tree.insert(105);
		// Test finding 60 and 150 before deletion
		boolean found60 = tree.find(60);
		assertEquals(true, found60);
		boolean found105 = tree.find(105);
		assertEquals(true, found105);
		// Delete 60
		boolean deleted = tree.delete(60);
		assertEquals(true, deleted);
		// Test finding 60 and 150 after deletion
		found60 = tree.find(60);
		assertEquals(false, found60);
		found105 = tree.find(105);
		assertEquals(true, found105);
	}

}