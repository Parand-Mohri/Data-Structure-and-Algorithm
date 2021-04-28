

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GraphTest {
	// This test doesn't have an assert, merely checking for null pointers and resizing
	@Test
	public void testAddVertex() 
	{
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();
		for(int i = 0; i < 1000; i++)
		{
			G.addVertex(i);
			//System.out.println("Vertex Added: " + i);
		}
	}
	
	// This test doesn't have an assert, merely checking for null pointers and resizing
	@Test
	public void testRemoveVertex() 
	{
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();
		for(int i = 0; i < 1000; i++)
		{
			G.addVertex(i);
		}
		for(int i = 0; i < 1000; i++)
		{
			G.removeVertex(i);
			//System.out.println("Vertex Removed: " + i);
		}
	}

	@Test
	public void testAddEdges() 
	{
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();
		for(int i = 0; i < 1000; i++)
		{
			G.addVertex(i);
		}
		for(int i = 0; i < 1000; i+=2)
		{
			G.addEdge(i, i+1);
			//System.out.println("Edge Added: " + i + " - " + (i+1));
			
		}
	}
	
	@Test
	public void testRemoveEdges() 
	{
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();
		for(int i = 0; i < 1000; i++)
		{
			G.addVertex(i);
		}
		for(int i = 0; i < 1000; i+=2)
		{
			G.addEdge(i, i+1);
		}
		for(int i = 0; i < 1000; i+=2)
		{
			G.removeEdge(i, i+1);
			//System.out.println("Edge Removed: " + i + " - " + (i+1));
		}
	}
	
	@Test
	public void testAdjacent() 
	{
		// Arrange
		int n = 6;
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();

		boolean[][] exp = new boolean[n][n];
		for(int i = 0; i < exp.length; i++)
		{
			for(int j = 0; j < exp[i].length; j++)
			{
				exp[i][j] = false;
			}
		}
		exp[2][1] = true;
		exp[1][2] = true;
		exp[3][1] = true;
		exp[1][3] = true;
		exp[4][1] = true;
		exp[1][4] = true;
		exp[5][1] = true;
		exp[1][5] = true;
		
		for(int i = 0; i < exp.length; i++)
		{
			System.out.println(Arrays.toString(exp[i]));
		}
		
		
		// Act
		G.addVertex(1);
		G.addVertex(2);
		G.addVertex(3);
		G.addVertex(4);
		G.addVertex(5);
			
		G.addEdge(2, 1);
		G.addEdge(1, 2);
		G.addEdge(3, 1);
		G.addEdge(1, 3);
		G.addEdge(4, 1);
		G.addEdge(1, 4);
		G.addEdge(5, 1);
		G.addEdge(1, 5);

		
		// Assert
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				boolean act = G.adjacent(i, j);
				assertEquals(exp[i][j], act);
			}
		}
	}
	
	@Test
	public void testNeighbours() 
	{
		GraphAdjacencyList<Integer> G = new GraphAdjacencyList<Integer>();
		int n = 10;
		for(int i = 0; i < n; i++)
		{
			G.addVertex(i);
		}
		for(int i = 0; i < n; i+=2)
		{
			G.addEdge(0, i);
		}
		
		G.neighbors(7);
	}
}