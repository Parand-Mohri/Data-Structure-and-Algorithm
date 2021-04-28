public class LinearFamilyTree {
    private String yo ;
    public LinearFamilyTree () {

    }

    public String linearize(BinaryTree<String> tree) {
        return print(tree.getRoot());

    }

    private String print(BinaryTreeNode<String> n) {
        yo += " ( ";
        yo += n.getElement();
        if(!n.hasLeftChild() && !n.hasRightChild()){
            yo +=" )";
        }else{
            if(n.hasLeftChild()){
                print(n.getLeftChild());
            }
            if(n.hasRightChild()){
                print(n.getRightChild());
            }
            yo +=")";
        }
        return yo;

    }

}