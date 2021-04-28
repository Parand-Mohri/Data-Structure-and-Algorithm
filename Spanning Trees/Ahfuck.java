import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Ahfuck 
{
    public int v;				// The maximum number of vertices
    public int edges;				// The number of edges
    public Vertex[] graph;
    public boolean[] inMST;
    public PriorityQueue<Edge> Q;
    public int totalWeight = 0;
	    
	// Initialise an empty graph with a maximum of size vertices
    public Ahfuck(int size) 
    {
    	v = size;
    	edges = 0;
    	inMST = new boolean[v];
     	graph = new Vertex[v];
    	for(int i = 0; i < graph.length; i++)
    	{
    		graph[i] = new Vertex();
    		inMST[i] = false;
    	} 
    	
    }
    
    // Return the minimum spanning tree of this WeightedGraph in the form of a new WeightedGraph
    public Ahfuck minimumSpanningTree() 
    {
    	Ahfuck MST = new Ahfuck(v);
    	Q = new PriorityQueue<Edge>(new EdgeComparer());
    	Q.addAll(graph[0].E);				// Add all the neighbours of 0 to the queue
    	graph[0].E.clear();
    	inMST[0] = true;					// Add vertex 0 to the MST
    	Edge e; 
    	while(!Q.isEmpty())
    	{
    		e = Q.poll();
    		if(inMST[e.u] && !inMST[e.v])
    		{
    			inMST[e.v] = true;
    			Q.addAll(graph[e.v].E);
    			//graph[e.v].E.clear();
    			MST.insert(e.u, e.v, e.weight);
    		}
    		else if(!inMST[e.u] && inMST[e.v])
    		{
    			inMST[e.u] = true;
    			Q.addAll(graph[e.u].E);
    			//graph[e.u].E.clear();
    			MST.insert(e.v, e.u, e.weight);
    		}
    	}
    	return MST;
    }
    
    // Returns the total number of edges in the graph
    public int edgeCount() 
    {
    	return edges;
    }
    
    // Returns the degree of vertex with id/index n
    public int degree(int n) 
    { 
    	return graph[n].degree;
    }

    /* Returns the weight of the edge connecting vertices m and n. 
     * If the vertices are equal, return 0. 
     * If the vertices are not adjacent, return -1
     */
	 public int adjacent(int m, int n)
	 { 
		 if(m == n)
			 return 0;
		 else
			 return graph[m].adjacent(n);
	 }

    /* If the weight w is 0, remove any edge between m and n (if any). 
    * Otherwise, add an edge between vertices m and n with weight w. 
    * If an edge already exists, replace the weight of the edge with the new weight. 
    * If the vertices do not exist or are equal, throw an exception.
    */
    public void insert(int m, int n, int w)
    {
    	if((m > v) || (n > v))
    		return;
    	if(w == 0)
    	{
    		graph[m].removeEdge(n);
    		graph[m].removeEdge(n);
    		edges--;
    	}
    	else if(graph[m].adjacent(n) > 0)
    	{
    		graph[m].updateEdge(n, w);
    		graph[n].updateEdge(m, w);
    	}
    	else
    	{
    		graph[m].addEdge(m,n,w);		// Add a half edge to the linked graph
	    	graph[n].addEdge(n,m,w);		// Add a half edge in the opposite direction
	    	edges++;
    	}
    }
    
    public void printTotalWeight()
    {
    	int weight = 0;
    	for(int i = 0; i < graph.length; i++)
    	{
    		for(Edge e: graph[i].E)
    		{
    			if(e.weight != -1)
    				weight = weight + e.weight;
    		}
    	}
    	System.out.println("Heaps Total Weight: " + weight);
    }

    // Returns name
    public String getName() 
    {
        return "ליון";
    }
}

class Vertex
{
	public LinkedList<Edge> E;
	public int degree;
	
	public Vertex()
	{
		degree = 0;
		E = new LinkedList<Edge>();
	}
		
	public void addEdge(int u, int v, int weight)
	{
		E.add(new Edge(u, v, weight));
		degree++;
	}
	
	public void updateEdge(int vertex, int weight)
	{
		for(Edge e: E)
		{
			if(e.v == vertex)
			{
				e.weight = weight;
				return;
			}
		}
	}
	
		
	public void removeEdge(int vertex)
	{
		for(Edge e: E)
		{
			if(e.v == vertex)
			{
				E.remove(e);
				degree--;
				return;
			}
		}
	}
		
	public int adjacent(int v)
	{
		for(Edge e: E)
		{
			if(e.v == v)
			{
				return e.weight;
			}
		}
		return -1;
	}
}

class Edge
{
	public int weight;
	public int u;
	public int v;
	
	public Edge(int u, int v, int weight)
	{
		this.weight = weight;
		this.u = u;
		this.v = v;
	}
}

class EdgeComparer implements Comparator<Edge>
{
	@Override
	public int compare(Edge a, Edge b) 
	{
		return a.weight - b.weight;
	}
}