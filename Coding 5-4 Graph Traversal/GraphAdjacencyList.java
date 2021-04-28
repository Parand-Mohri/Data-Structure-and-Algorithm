import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GraphAdjacencyList<T> implements Graph<T>{
	
	

	 ArrayList<Node<T>> list = new ArrayList<>();
	
	@Override
	public boolean adjacent(T x, T y) {
		for(Node<T> i :list) {
			if(i.value == x) {
				for(T p : i.connected ) {
					if(p.equals(y)) {
						return true;
					}
				}
			}
			if(i.value == y) {
				for(T p : i.connected ) {
					if(p.equals(x)) {
						return true;
					}
				}
				
			}
		}
		return false;
	}

	@Override
	public List<T> neighbors(T x) {
		for(Node<T> i : list) {
			if(i.value == x) {
				return i.connected;
			}
		}
		return null;
		

	}

	@Override
	public void addVertex(T x) {
		list.add(new Node<T>(x));
		
	}

	@Override
	public void removeVertex(T x) {
		LinkedList<T> neghbors;
		for(Node<T> i : list) {
			if(i.value == x) {
				neghbors = i.connected;
				while(!neghbors.isEmpty()) {
					T vertex = neghbors.get(0);
					removeEdge(vertex , x);
				}
				list.remove(i);
				break;
				
			}	
		}
		
		
	}

	@Override
	public void addEdge(T x, T y) {
		for(Node<T> i : list) {
			if(i.value == x) {
				i.connected.add(y);
			}
			if(i.value == y) {
				i.connected.add(x);
			}
		}
		
	}

	@Override
	public void removeEdge(T x, T y) {
		for(Node<T> i : list) {
			if(i.value == x) {
				i.connected.remove(y);
			}
			if(i.value == y) {
				i.connected.remove(x);
			}
		}
	}
}

class Node<T> {
    T value;
    LinkedList<T> connected;
    public Node(T value) {
        this.value = value;
        connected = new LinkedList<T>();
    }

}
