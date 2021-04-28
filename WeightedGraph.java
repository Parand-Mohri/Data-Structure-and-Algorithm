import java.util.ArrayList;
import java.util.Stack;

public class WeightedGraph 
{
    private int[][] matrix; 			
	private boolean[] visited; 		
	private ArrayList<Edges> E;	
	
public WeightedGraph(int size) 
    {
    	E = new ArrayList<Edges>();
		matrix = new int[size][size];
		visited = new boolean[size];
    	for(int i = 0; i < matrix.length; i++)
    	{
    		visited[i] = false;	
    		for(int j = 0; j < matrix[i].length; j++)
    		{
    			matrix[i][j] = -1;
    		}
    	}
    }
public WeightedGraph minimumSpanningTree() 
{					
		visited[0] = true;
		int[][] minimum = new int[matrix.length][matrix.length];
    	for(int i = 0; i < minimum.length; i++)
    	{
    		for(int j = 0; j < minimum[i].length; j++)
    		{
    			minimum[i][j] = -1;
    		}
    	}
		Edges edge = getNextEdge();
		while(edge != null)									
		{
			visited[edge.u] = true;
			visited[edge.v] = true;
			minimum[edge.u][edge.v] = edge.w;
			minimum[edge.v][edge.u] = edge.w;
			edge = getNextEdge();
		}
		matrix = minimum;
		return this;
	}
	public Edges getNextEdge()
	{
		Edges smallest = null;
		for(Edges e: E)
		{
			if(!visited[e.u] || !visited[e.v])
			{
				if(smallest == null)
					smallest = e;
				else if(e.w < smallest.w)
					smallest = e;
			}
		}
		return smallest;
	}
    public int degree(int n) 
    {
    	int degree = 0;
    	for(int i = 0; i < matrix[n].length; i++)
    	{
    		if(matrix[n][i] > 0)
    			degree++;
    	}
    	return degree;
    }
    public int edgeCount() 
    {
    	return E.size();
    }
    public int adjacent(int m, int n) 
    {
    	if(m == n)
    		return 0;
    	return matrix[m][n];
    }
    public void insert(int m, int n, int w) 
    {
    	if(m >= matrix.length || n >= matrix.length || m == n || m < 0 || n < 0) 
    		throw new RuntimeException("Error");
    	if(w == 0)
    	{
    		matrix[m][n] = -1;
    		matrix[n][m] = -1;
    	}
    	else
    	{
    		matrix[m][n] = w;
    		matrix[n][m] = w;
    		E.add(new Edges(m,n,w));
    	}
    }
    public String getName() 
    {
        return "YO";
    }
}

class Edges
{
	public int u;
	public int v;
	public int w;
	
	public Edges(int u, int v, int w)
	{
		this.u = u;
		this.v = v;
		this.w = w;
	}
}