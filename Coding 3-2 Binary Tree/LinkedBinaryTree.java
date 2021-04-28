

public class LinkedBinaryTree<E> implements BinaryTree<E>{

    private LinkedBinaryTreeNode<E> root = new LinkedBinaryTreeNode<>(null,null);

    // public LinkedBinaryTree (){
    // }
    public BinaryTreeNode<E> getRoot() {
        return root;
    }
    public void addRoot(E e) {
        root = new LinkedBinaryTreeNode<>(e,root);
    }

    public boolean hasRoot() {
        if(root==null){
            return false;
        }
        else{
            return true;
        }

    }
}
