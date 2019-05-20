public class BinarySearch<E> {

    private Node<E> overallRoot;
    private int size;

    public class Node<E>{
        public E data;
        public int arrayPosition;
        public Node<E> left;
        public Node<E> rigth;
    }

    /**
     * Binary Search constructor
     */
    public BinarySearch(){
        overallRoot = null;
        size = 0;
    }

    /**
     * adds an item to the tree
     *
     * @param item the item to add, must not be duplicate
     * @return whether item was added successfully
     */
    public boolean add(E item){
        return false;
    }

    /**
     * adds an item to the tree at a given node
     *
     * @param item the item to ass
     * @param root the node to add it at
     */
    private void add(E item, Node root){

    }

    /**
     * gets an array of the items in order
     *
     * @return an in-order array of the items
     */
    public int[] inOrder(){
        return null;
    }

    /**
     * gets an array of items in order from a node
     *
     * @param root the node to start at
     */
    private int[] inOrder(Node root){
        return null;
    }
}
