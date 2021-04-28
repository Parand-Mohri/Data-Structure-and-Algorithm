public class LinearFamilyTree {
    public String linearize(BinaryTree<String> tree) {
        
    	String an = print(tree.getRoot());
    	an = an.substring(1);
    	return an;
    	
    }

    private String print(BinaryTreeNode<String> n) {
    	String yo ="";
        yo +=" ( ";
        yo+=n.getElement();
       
        
        if (!n.hasLeftChild() && !n.hasRightChild()) {
            yo+= " )";
        } else {
            if (n.hasLeftChild()) {
                yo+=print(n.getLeftChild());
            }
            if (n.hasRightChild()) {
                yo+=print(n.getRightChild());
            }
            yo+=" )";
        }
        
        return yo ;
    }

}