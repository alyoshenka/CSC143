/**
 * manages a binary tree with duplicate entries
 *
 * @param <E> the type of data to hold
 */
public class BinarySearchDuplicate<E extends Comparable<E>> {

    /** the starting node of the tree */
    private NodeDuplicate<E> overallRoot;
    /** the number of items in the tree */
    private int size;

    /**
     * a node of the tree
     *
     * @param <E> the type of data to hold
     */
    private static class NodeDuplicate<E extends Comparable<E>>{
        /** the duplicate item list */
        public NodeDuplicateList<E> items;
        /** the left node */
        public NodeDuplicate<E> left;
        /** the right node */
        public NodeDuplicate<E> right;
        /** the size of the duplicate list */
        public int listSize;

        /**
         * manages the list of items
         *
         * @param <E> the type of data to hold
         */
        private static class NodeDuplicateList<E>{
            /** the stored data */
            public E data;
            /** the data's array position */
            public int arrayPosition;
            /** the next node of data */
            public NodeDuplicateList<E> next;

            /**
             * default constructor
             */
            public NodeDuplicateList(){
                data = null;
                next = null;
                arrayPosition = -1;
            }
        }

        /**
         * duplicate node constructor
         */
        public NodeDuplicate(){
            items = null;
            left = right = null;
            listSize = 0;
        }

        /**
         * adds an item to the end of the list
         *
         * @param item the item to add
         * @param arrPos the array position of the item
         */
        public void add(E item, int arrPos){
            if(null == items){
                items = new NodeDuplicateList<E>();
                items.data = item;
                items.arrayPosition = arrPos;
            } else {
                NodeDuplicateList<E> temp;
                for(temp = items; temp.next != null; temp = temp.next){
                    // iterate to end
                }
                NodeDuplicateList<E> end = new NodeDuplicateList<E>();
                end.data = item;
                end.arrayPosition = arrPos;
                temp.next = end;
            }
            listSize++;
        }

        /**
         * gets an array of all the position data in the list
         *
         * @return the list of position data
         */
        public int[] getPositionData(){
            int[] dat = new int[listSize];
            NodeDuplicateList cur = items;
            for(int i = 0; i < listSize; i++){
                dat[i] = cur.arrayPosition;
                cur = cur.next;
            }
            return dat;
        }
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
     * @param arrPos the position of the item to add
     * @return whether item was added successfully
     */
    public boolean add(E item, int arrPos){
        if(null == item){
            return false;
        }
        if(null == overallRoot){
            overallRoot = new NodeDuplicate<>();
            overallRoot.add(item, arrPos);
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
     * @param arrPos the array position of the item
     * @param root the node to add it at
     * @return the node to continue from
     */
    private NodeDuplicate add(E item, int arrPos, NodeDuplicate<E> root){
        if(null == root){
            root = new NodeDuplicate<E>();
            root.add(item, arrPos);
        } else {
            /** compare value */
            int val = item.compareTo(root.items.data);
            if (val < 0){
                root.left = add(item, arrPos, root.left);
            } else if (val > 0){
                root.right = add(item, arrPos, root.right);
            } else{
                // duplicate value
                root.add(item, arrPos);
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
     * @param arr array to put items in
     * @return array of items
     */
    private int[] inOrder(NodeDuplicate root, int[] arr){
        if(null != root){
            arr = inOrder(root.left, arr);

            // add list's array into return array
            int idx;
            for(idx = 0; arr[idx] != 0; idx++){
                // iterate to next spot
            }
            int[] miniArr = root.getPositionData();
            for(int i = 0; i < miniArr.length; i++){
                arr[idx++] = miniArr[i];
            }

            arr = inOrder(root.right, arr);
        }
        return arr;
    }

}
