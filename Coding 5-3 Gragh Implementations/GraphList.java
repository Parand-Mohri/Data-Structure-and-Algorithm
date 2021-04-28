import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphList<T> implements Graph<T>{
//	LinkedList<T>[] list;
	ArrayList<LinkedList<T>> list;
	public GraphList(){
		list = new ArrayList<LinkedList<T>>(); 
	}

	@Override
	public boolean adjacent(T x, T y) {
		if (list.get(findIndex(x)).contains(y)) {	
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List neighbors(T x) {
		int index = -1;
		for(int i = 0; i< list.size();i++) {
			if(list.get(i).getFirst() == x){
				index = i;
			}
		}
		if(index != -1)
			return list.get(index);
		else
			return null;
	}

	@Override
	public void addVertex(T x) {
		LinkedList<T> p = new LinkedList<T>();
		p.add(x);
		list.add(p);
	}

	@Override
	public void removeVertex(T x) {
		for(int p =0; p <list.size(); p++) {
			if(list.get(p).getFirst() == x) {
				list.remove(p);
			}
		}
		
		for(int i = 0; i< list.size();i++) {	
			for(int j =0; j<list.get(i).size(); j++) {
				if(list.get(i).get(j)==x) {
					list.get(i).remove(j);
				}
			}
			
		}
		
	}

	@Override
	public void addEdge(T x, T y) {
		for(int i = 0; i< list.size();i++) {
			if(list.get(i).get(0) == x){
				list.get(i).add(y);
			}
			if(list.get(i).get(0)==y) {
				list.get(i).add(x);
			}
		}
		
		
	}

	@Override
	public void removeEdge(T x, T y) {
		for(int i = 0; i< list.size();i++) {
			if(list.get(i).getFirst() == x){
				list.get(i).remove(y);
			}
			if(list.get(i).getFirst() ==y) {
				list.get(i).remove(x);
			}
		}
	}
	public int findIndex(T x) {
		for(int i =0; i< list.size(); i++) {
			if(list.get(i).getFirst() == x) {
				return i;
			}
		}
		return -1;
	}

}

class Vertex{
	
	
}
