package wk3_TreeTraversal;

import java.util.ArrayList;
import wk3_binTree.BinaryTree;
import wk3_binTree.BinaryTreeNode;


public class LinearFamilyTree 
{
	ArrayList<BinaryTreeNode<String>> visitedList;
	
    public LinearFamilyTree () 
    {
    	visitedList = new ArrayList<BinaryTreeNode<String>>();
    }

    public String linearize(BinaryTree<String> tree) 
    {
        String s = print(tree.getRoot());
        return s.stripLeading();
    }
    
    private String print(BinaryTreeNode<String> n) 
    {
    	visitedList.clear();
    	StringBuilder string = new StringBuilder();
    	visitedList.add(n);
    	if((visited(n.getLeftChild()) == true) && (visited(n.getRightChild()) == true))
    		return string.toString();
    	else
    	{
	    	string.append(" ( ");
    		string.append(n.getElement());
	    	if(n.hasLeftChild() && (!visited(n.getLeftChild())) )
	    		string.append(print(n.getLeftChild()));
	    	if(n.hasRightChild() && (!visited(n.getRightChild())) )
	    		string.append(print(n.getRightChild()));
	    	string.append(" )");
	    	return string.toString();
    	}
    }
    
    private boolean visited(BinaryTreeNode<String> n)
    {
    	boolean v = false;
    	for(int i = 0; i < visitedList.size(); i++)
    	{
    		if(n == visitedList.get(i))
    			v = true;
    	}
    	return v;
    }
} 