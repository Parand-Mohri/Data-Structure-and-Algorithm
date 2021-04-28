import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;

public class TestBreadthFirstSearch 
{

	@Test
	public void testIntegers() 
	{
		
		
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();
		G.addVertex(1);
		G.addVertex(2);
		G.addVertex(3);
		G.addVertex(4);
		G.addVertex(5);
		G.addVertex(6);
		G.addVertex(7);
		G.addVertex(8);
		G.addVertex(9);
		
		G.addEdge(1, 2);
		G.addEdge(2, 5);
		G.addEdge(2, 6);
		G.addEdge(2, 7);
		G.addEdge(1, 3);
		G.addEdge(1, 4);
		G.addEdge(4, 8);
		G.addEdge(5, 9);
		
		Integer[] exp = {1,4,3,2,8,7,6,5,9};
		Search<Integer> search = new Search<Integer>();
		LinkedList<Integer> act = (LinkedList<Integer>) search.BFS(G, 1);
		System.out.println("\nTest Ints from 1");
		for(int i = 0; i < act.size(); i++)
		{
			assertEquals(exp[i], act.get(i));
			System.out.println(i);
		}
		
		//Integer[] exp2 = {8,4,1,2,3,5,6,7};
		//System.out.println("\nTest Ints from 8");
		//act = (LinkedList<Integer>) search.BFS(G, 8);
		//for(int i = 0; i < act.size(); i++)
		//{
		//	assertEquals(act.get(i), exp2[i]);
		//	System.out.println(act.get(i));
		//}
		//
		//Integer[] exp3 = {2,1,5,6,7,3,4,8};
		//System.out.println("\nTest Ints from 2");
		//act = (LinkedList<Integer>) search.BFS(G, 2);
		//for(int i = 0; i < act.size(); i++)
		//{
		//	assertEquals(act.get(i), exp3[i]);
		//	System.out.println(act.get(i));
		//}
		//
		//Integer[] exp4 = {4,1,8,2,3,5,6,7};
		//System.out.println("\nTest Ints from 4");
		//act = (LinkedList<Integer>) search.BFS(G, 4);
		//for(int i = 0; i < act.size(); i++)
		//{
		//	assertEquals(act.get(i), exp4[i]);
		//	System.out.println(act.get(i));
		//}
		//
		//Integer[] exp5 = {6,2,1,5,7,3,4,8};
		//System.out.println("\nTest Ints from 6");
		//act = (LinkedList<Integer>) search.BFS(G, 6);
		//for(int i = 0; i < act.size(); i++)
		//{
		//	assertEquals(act.get(i), exp5[i]);
		//	System.out.println(act.get(i));
		//}
	}
	
	@Test
	public void testChars() 
	{
		char[] exp = {'x','w','z','y','a'};
		
		GraphAdjacencyList<Character> G = new GraphAdjacencyList<Character>();
		G.addVertex('x');
		G.addVertex('w');
		G.addVertex('y');
		G.addVertex('z');
		G.addVertex('a');
		
		G.addEdge('x', 'w');
		G.addEdge('w', 'y');
		G.addEdge('w', 'z');
		G.addEdge('z', 'a');

		
		Search<Character> search = new Search<Character>();
		LinkedList<Character> act = (LinkedList<Character>) search.BFS(G, 'x');
		System.out.println("\nTest Chars");
		for(int i = 0; i < act.size(); i++)
		{
			assertEquals(act.get(i).charValue(), exp[i]);
			System.out.println(act.get(i).charValue());
		}
	}
	
	@Test
	public void testCycle() 
	{
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();
		G.addVertex(1);
		G.addVertex(2);
		G.addVertex(3);
		G.addVertex(4);
		
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		G.addEdge(3, 4);
		G.addEdge(4, 1);
		
		Search<Integer> search = new Search<Integer>();
		LinkedList<Integer> l = (LinkedList<Integer>) search.BFS(G, 1);
		System.out.println("\nTest Cycle");
		for(Integer i: l)
		{
			System.out.println(i);
		}
	}

}
