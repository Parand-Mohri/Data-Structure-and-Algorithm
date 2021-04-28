public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {
    private BinaryTreeNode<E> leftnode;
    private BinaryTreeNode<E> rightnode;
    private BinaryTreeNode<E> parent;
    private E data;

    public LinkedBinaryTreeNode(E e, LinkedBinaryTreeNode<E> p) {
        data = e;
        parent = p;
        leftnode =null;
        rightnode =null;
    }

    public E getElement() {
        return data;
    }

    public void setElement(E e) {
        data = e;
    }

    public BinaryTreeNode<E> getParent() {
        return parent;

    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftnode;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightnode;
    }

    public void addLeftChild(E element) {
        
        LinkedBinaryTreeNode<E> tempLeft = new LinkedBinaryTreeNode<>(element, this);
        leftnode = (BinaryTreeNode) tempLeft;
    }

    public void addRightChild(E element) {
    	LinkedBinaryTreeNode<E> tempright = new LinkedBinaryTreeNode<>(element, this);
    	rightnode = (BinaryTreeNode) tempright;

    }

    public boolean hasLeftChild() {
        if (leftnode == null) {
            return false;
        } else {
            return true;
        }

    }

    public boolean hasRightChild() {
        if (rightnode == null) {
            return false;
        }
        return true;
    }

    public void delete() {
        parent = null;
        data = null;
        rightnode = null;
        leftnode = null;
    }

}
