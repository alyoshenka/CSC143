public class BinarySearch<E extends Comparable<E>> {

    private Node<E> overallRoot;
    private int size;

    private static class Node<E>{
        /** data this node holds */
        public E data;
        /** array position of the data */
        public int arrayPosition;
        /** the node to the left */
        public Node<E> left;
        /** the node to the right */
        public Node<E> right;

        /**
         * default node constructor
         */
        public Node(){
            left = right = null;
            data = null;
            arrayPosition = -1;
        }
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
     * @param item the item to add, must not be null
     * @param arrPos the array position of the item
     * @return whether item was added successfully
     */
    public boolean add(E item, int arrPos){
        if(null == item){
            return false;
        }
        if(null == overallRoot){
            overallRoot = new Node<>();
            overallRoot.data = item;
        } else{
            add(item, arrPos, overallRoot);
        }
        size++;
        return true;
    }

    /**
     * adds an item to the tree at a given node
     *
     * @param item the item to add
     * @param root the node to add it at
     * @return the node modified
     */
    private Node add(E item, int arrPos, Node<E> root){
        if(null == root){
            root = new Node<E>();
            root.data = item;
            root.arrayPosition = arrPos;
            size++;
        } else {
            /** compare value */
            int val = item.compareTo(root.data);
            if (val < 0){
                root.left = add(item, arrPos, root.left);
            } else if (val > 0){
                root.right = add(item, arrPos, root.right);
            } else{
                // duplicate value
            }
        }
        return root;
    }

    /**
     * gets an array of the items in order
     *
     * @return an in-order array of the items
     */
    public int[] inOrder(){
        int[] toReturn = new int[size];
        return inOrder(overallRoot, toReturn);
    }

    /**
     * gets an array of items in order from a node
     *
     * @param root the node to start at
     */
    private int[] inOrder(Node root, int[] arr){
        if(null != root){
            arr = inOrder(root.left, arr);
            int idx;
            for(idx = 0; arr[idx] != 0; idx++){
                // iterate to next spot
            }
            arr[idx] = root.arrayPosition;
            arr = inOrder(root.right, arr);
        }
        return arr;
    }
}
