/** a linked list with objects of type E */
public class LinkedList<E> implements java.io.Serializable {
    /** the start of the list */
    private Node head;
    /** the end of the list */
    private Node tail;
    /** the number of items in the list */
    private int size;

    /** a list node */
    private class Node{
        /** the next Node in the list */
        public Node prev;
        /** the previous Node in the list */
        public Node next;
        /** the data */
        public E data;
    }

    /**
     * LinkedList constructor
     */
    public LinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * gets the start of the list
     *
     * @return the head Node
     */
    public Node start(){
        return head;
    }

    /**
     * gets the end of the list
     *
     * @return the tail Node
     */
    public Node end(){
        return tail;
    }

    /**
     * gets the size of the list
     *
     * @return the size of the list
     */
    public int size(){
        return size;
    }

    /**
     * gets the data at a specified position in the list
     *
     * @param idx the index to get data from
     * @return the data at specified index, null if out of bounds
     */
    public E dataAt(int idx){
        if(idx < 0 || idx >= size){
            return null;
        }

        // iterate through list
        Node current = head;
        for(int i = 0; i <= idx; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * adds an item to the end of the list
     *
     * @param item the item to add
     */
    public void add(E item){
        Node newNode = new Node();
        newNode.prev = tail;
        newNode.next = null;
        newNode.data = item;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * adds an item at a specified index in the list
     *
     * @param item the item to add
     * @param idx the index to add it
     * @return whether the add was successful, ie idx within bounds
     */
    public boolean addAt(E item, int idx){
        int i;
        Node next;
        Node current = head;
        for(i = 0; i < idx; i++){
            if(null == current.next){
                break;
            }
            current = current.next;
        }
        next = current.next;
        
    }

    /**
     * removes an item from the list
     *
     * @param item the item to remove
     * @return whether removing was successful, ie item was found
     */
    public boolean remove(E item){
        return false;
    }

    /**
     * removes an item from and index in the list
     *
     * @param idx the index to remove from
     * @return whether removing was successful, ie idx was in range
     */
    public boolean remove(int idx){
        return false;
    }

    /**
     * moves an item up in the list
     *      will return false if item not in list or spaces out of bounds
     *      if spaces out of bounds, item will still be moved as many spaces
     *      as it can
     *
     * @param item the item to move
     * @param positions the number of spaces to move
     * @return whether move was successful
     */
    public boolean move(E item, int positions){
        return false;
    }
}
