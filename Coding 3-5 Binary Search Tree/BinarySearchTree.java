import java.util.Stack;
public class BinarySearchTree {

    BinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
    Stack<Integer> fuck = new Stack<Integer>();

    public BinarySearchTree() {
    }

    public void insert(Integer e) {
        if (!tree.hasRoot()) {
            tree.addRoot(e);
        } else {
            BinaryTreeNode<Integer> closest = findclosest(tree.getRoot(),e);
            if(closest.getElement() == e) {
            	return;
            }
            else {
            	if(closest.getElement() < e){
            
                closest.addRightChild(e);
            	}else{
                closest.addLeftChild(e);
            }
           }
        }

    }

    private BinaryTreeNode<Integer> findclosest(BinaryTreeNode<Integer> node, Integer e){
        BinaryTreeNode<Integer> x = new LinkedBinaryTreeNode<Integer>(null,null);
        if(node.getElement() == e){
            x=node;
        }
        if(node.getElement() < e ){
            if(!node.hasRightChild()){
                x = node;
            }else {
                x = findclosest(node.getRightChild(), e);
            }       
        }
        if(node.getElement() > e ){
            if(!node.hasLeftChild()){
                x = node;
            }else {
               x =  findclosest(node.getLeftChild(), e);
                
            }       
        }
        return x;
    }

    public boolean delete(Integer e) {
    	
    	BinaryTreeNode<Integer> doomed = findclosest(tree.getRoot(), e);
    	if (!tree.hasRoot()) {
            return false;
        }
        
    	else if(doomed.getElement() != e){
            return false;
        }
        else if( (!doomed.hasLeftChild()) && (!doomed.hasRightChild()))
        {
            doomed.delete();
//        	doomed = null;
            return true;
        }
        else if((doomed.hasLeftChild()) && (!doomed.hasRightChild()))
        {
        	
        	doomed.setElement(doomed.getLeftChild().getElement());
            doomed.getLeftChild().setElement(null);
            doomed.getLeftChild().delete();
//            doomed.getLeftChild().setElement(null);
            fuckyou(tree.getRoot());
        	tree = new LinkedBinaryTree<Integer>();
        	while(!fuck.isEmpty())
        	{
        		int next = fuck.pop();
        		
        	}
            
            return true;
        }
        else if((doomed.hasRightChild()) && (!doomed.hasLeftChild()))
        {       
        	
        	doomed.setElement(doomed.getRightChild().getElement());
            doomed.getRightChild().setElement(null);
            doomed.getRightChild().delete();
//            doomed.getRightChild().delete();
            fuckyou(tree.getRoot());
        	tree = new LinkedBinaryTree<Integer>();
        	while(!fuck.isEmpty())
        	{
        		int next = fuck.pop();
        		insert(next);
        	}
            return true;
        }
        else if((doomed.hasLeftChild()) && (doomed.hasRightChild()))
        {
        	
        	BinaryTreeNode<Integer>  n = doomed.getRightChild();
            n = goLeft(n);
            doomed = n;
//            n.delete();
            n = null;
            fuckyou(tree.getRoot());
        	tree = new LinkedBinaryTree<Integer>();
        	while(!fuck.isEmpty())
        	{
        		int next = fuck.pop();
        		insert(next);
        	}
            return true;
        }else{
            return false;
        }
    	

    }

    private BinaryTreeNode<Integer> goLeft(BinaryTreeNode<Integer> n)
    {
        while(n.hasLeftChild())
        {
            n = n.getLeftChild();
        }
        return n;
    }

    public boolean find(Integer e) {
        if (!tree.hasRoot()) {
            return false;
        }else{
            BinaryTreeNode<Integer> closest = findclosest(tree.getRoot(),e);
            if(closest.getElement() == e){
                return true;
            }else{
                return false;
            }

        }
        
    }
    private void fuckyou(BinaryTreeNode<Integer> n)
    {
    	fuck.add(n.getElement());
    	if(n.hasLeftChild())
    		fuckyou(n.getLeftChild());
    	if(n.hasRightChild())
    		fuckyou(n.getRightChild());
    }

}