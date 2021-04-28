

import java.util.Stack;


public class Leo {

    BinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    public Leo() 
    {
    	
    }

    public void insert(Integer e) 
    {
    	if(!tree.hasRoot())
    		tree.addRoot(e);
    	else 
    	{
    		BinaryTreeNode<Integer> closest = search(tree.getRoot(), e);
    		if(closest.getElement() == e)
    			return;
    		else if(e < closest.getElement())
    			closest.addLeftChild(e);
    		else if(e > closest.getElement())
    			closest.addRightChild(e);
    	}
    		
    }
    
    // This is stupid, inefficient and slow and I know it.
    // Want to know why I made the abomination of code? It's because rather than being able to simply change
    // two pointers to delete a node with addLeftChild(BinaryTreeNode<E>), I can only edit elements as 
    // you've only included a setLeftChild(E element) in the interface.  So thanks for making this unreasonably hard.
    public boolean delete(Integer e) 
    {
    	boolean deleted = false;
    	if(!tree.hasRoot())
    		return false;
    	stackUp(tree.getRoot());
    	tree = new LinkedBinaryTree<Integer>();
    	while(!stack.isEmpty())
    	{
    		int next = stack.pop();
    		if(next == e)
    			deleted = true;
    		else
    			insert(next);
    	}
    	return deleted;
    }
    
    private void stackUp(BinaryTreeNode<Integer> n)
    {
    	stack.add(n.getElement());
    	if(n.hasLeftChild())
    		stackUp(n.getLeftChild());
    	if(n.hasRightChild())
    		stackUp(n.getRightChild());
    	n.delete();
    }

    public boolean find(Integer e) 
    {
    	if(tree.getRoot() == null)
    		return false;
    	if(search(tree.getRoot(), e).getElement().equals(e))
    		return true;
    	else
    		return false;
    }
    
    private BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> n, Integer e)
    {
    	int currentValue = -1;
    	if(!(n.getElement() == null))
    			currentValue = n.getElement();
    	
    	// If the target value is found
    	if(e == currentValue)
    		return n;
    	
    	// If the node n is not a terminus && target is smaller than current
    	if((n.hasLeftChild()) && (e < currentValue))
    	{
    		//Search the nodes smaller than current value
    		if(!(n.getLeftChild().equals(null)))
    			n = search(n.getLeftChild(),e);
    	}
    	// If the node n is not a terminus && target is larger than current
    	if((n.hasRightChild()) && (e > currentValue))
    	{
    		//Search the nodes larger than current value
    		if(!(n.getRightChild().equals(null)))
    			n = search(n.getRightChild(),e);
    	}
    	// Return the now closest node to the target
    	return n;
    }	
}
