import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GraphAdjacencyList<T> implements Graph<T>{
	
	

	 LinkedList<Connected<T>> myList = new  LinkedList<>();
	
	@Override
	public boolean adjacent(T x, T y) {
		for(Connected<T> i :myList) {
			if(i.element.equals(x)) {
				for(T p : i.edges ) {
					if(p.equals(y)) {
						return true;
					}
				}
			}
			if(i.element.equals(y)) {
				for(T p : i.edges ) {
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
		for(Connected<T> i : myList) {
			if(i.element.equals(x)) {
				return i.edges;
			}
		}
		return null;
		

	}

	@Override
	public void addVertex(T x) {
		myList.add(new Connected<T>(x));
		
	}

	@Override
	public void removeVertex(T x) {
		ArrayList<T> n;
		for(Connected<T> i : myList) {
			if(i.element == x) {
				n = i.edges;
				while(n.size() != 0) {
					T vertex = n.get(0);
					removeEdge(vertex , x);
				}
				myList.remove(i);
				break;
				
			}	
		}
		
		
	}

	@Override
	public void addEdge(T x, T y) {
		for(Connected<T> i : myList) {
			if(i.element.equals(x)) {
				i.edges.add(y);
			}
			if(i.element.equals(y)) {
				i.edges.add(x);
			}
		}
		
	}

	@Override
	public void removeEdge(T x, T y) {
		for(Connected<T> i : myList) {
			if(i.element.equals(x)) {
				i.edges.remove(y);
			}
			if(i.element.equals(y)) {
				i.edges.remove(x);
			}
		}
	}
}

class Connected<T> {
    T element;
    ArrayList<T> edges;
    public Connected(T x) {
         element = x;
         edges = new ArrayList<T>();
    }

}
