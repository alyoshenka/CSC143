public class BinarySearchDuplicate<E extends Comparable<E>> {

    private NodeDuplicate<E> overallRoot;
    private int size;

    private static class NodeDuplicate<E>{
        /** the duplicate item list */
        public NodeDuplicateList<E> items;
        /** the left node */
        public NodeDuplicate<E> left;
        /** the right node */
        public NodeDuplicate<E> right;
        /** the size of the duplicate list */
        public int listSize;

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
                items = new NodeDuplicateList<>();
                items.data = item;
                items.arrayPosition = arrPos;
            } else {
                NodeDuplicateList temp;
                for(temp = items; temp.next != null; temp = temp.next){
                    // iterate to end
                }
                NodeDuplicateList end = new NodeDuplicateList();
                end.data = item;
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

    private static class NodeDuplicateList<E>{
        /** the stored data */
        public E data;
        /** the data's array position */
        public int arrayPosition;
        /** the next node of data */
        public NodeDuplicateList next;

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
     * @param item the item to ass
     * @param root the node to add it at
     */
    private NodeDuplicate add(E item, int arrPos, NodeDuplicate<E> root){
        if(null == root){
            root = new NodeDuplicate();
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
        size++;
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
