import java.util.*;

public class Search<E> {
	LinkedList<E> visited = new LinkedList<E>();
	LinkedList<E> Queue  = new LinkedList<E>(); 
 	E node = null;
	public void Search(Graph<E> g, E startnode) {
		
		Queue.add(startnode);
    	while(!Queue.isEmpty()) {
    		node = Queue.get(0);
    		Queue.remove(0);
    		visited.add(node);
    		LinkedList<E> neighbors =(LinkedList<E>) g.neighbors(node);
        	for(E i: neighbors) {
        			if(!Visited(i)) {
        				Queue.add(i);
        			}
        		}		
        	}
        }
    public List<E> BFS(Graph<E> g, E startnode) {
    	Search(g, startnode) ;
    	return visited;
    }
    public boolean Visited(E e) {
    	for(E i: visited) {
    		if(i == e) {
    			return true;
    		}
    		
    	}
    	return false;
    }
}
