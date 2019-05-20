public class BinarySearchDuplicate<E> {

    private NodeDuplicate<E> overallRoot;
    private int size;

    public class NodeDuplicate<E>{
        public NodeDuplicateList items;
        public NodeDuplicate<E> left;
        public NodeDuplicate<E> rigth;
    }

    public class NodeDuplicateList<E>{
        public E data;
        public int arrayPosition;
        public NodeDuplicateList next;
    }

    /**
     * Binary Search constructor
     */
    public BinarySearchDuplicate(){
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
    private void add(E item, NodeDuplicate root){

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
    private int[] inOrder(NodeDuplicate root){
        return null;
    }
}
