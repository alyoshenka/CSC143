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
    public E dataAt(int idx){ // iterate backwards for efficiency
        if(idx < 0 || idx >= size){
            return null;
        }

        // iterate through list
        Node current = head;
        for(int i = 0; i < idx; i++){
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
        newNode.next = null;
        newNode.data = item;
        if(null == head) { // && null == tail is implied
            head = newNode;
            tail = newNode;
            newNode.prev = null;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
        if(null == head || idx > size){
            add(item);
            return 0 == idx;
        }

        Node next;
        Node current = head;
        for(int i = 0; i < idx; i++){
            if(null == current.next){
                break;
            }
            current = current.next;
        }
        next = current.next;
        if(null == next){ // not needed (?)
            add(item);
            return false;
        } else{
            Node newNode = new Node();
            newNode.next = next;
            newNode.prev = current;
            newNode.data = item;
            next.prev = newNode;
            current.next = newNode;
            size++;
            return true;
        }
    }

    /**
     * removes all instances of an item from the list
     *
     * @param item the item to remove
     * @return whether removing was successful, ie item was found
     */
    public boolean remove(E item){
        boolean found = false;
        for(Node n = head; null != n; n = n.next){
            if(n.data == item){
                n.prev.next = n.next;
                n.next.prev = n.prev;
                found = true;
            }
        }
        return found;
    }

    /**
     * removes an item from and index in the list
     *
     * @param idx the index to remove from
     * @return whether removing was successful, ie idx was in range
     */
    public boolean remove(int idx){
        Node current = head;
        for(int i = 0; i < idx; i++){
            if(null == current){
                return false;
            }
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return true;
    }

    /**
     * moves an item in the list
     *      will return false if item not in list or spaces out of bounds
     *      if spaces out of bounds, item will still be moved as many spaces
     *      as it can
     *
     * @param item the item to move
     * @param positions the number of spaces to move (can be negative)
     * @return whether move was successful
     */
    public boolean move(E item, int positions){ // check bad positions
        if(positions == 0){
            return true;
        }
        boolean found = false;
        Node active;
        for(active = head; null != active; active = active.next){
            if(active.data.equals(item)){
                found = true;
                break;
            }
        }
        if(!found){
            return false;
        }
        active.prev.next = active.next;
        if(active != tail){
            active.next.prev = active.prev;
        }
        Node current = active;
        for(int i = 0; i != positions; i += positions > 0 ? 1 : -1){
            current = positions > 0 ? current.next : current.prev;
        }
        active.next = current.next;
        active.prev = current;
        current.next = active;
        return found;
    }

    /**
     * moves the first occurrence of an item down the list
     *
     * @param item the item to move
     * @param positions the number of positions to move it
     *                  will move as many as possible if out of bounds
     * @return whether moving was successful, ie item found and positions within range
     */
    public boolean moveDown(E item, int positions){
        // preconditions
        if(positions < 0){
            return false;
        }
        if(0 == positions){
            return true;
        }

        // find item
        boolean found = false;
        Node moving;
        for(moving = head; null != moving; moving = moving.next){
           if(moving.data.equals(item)){
               moving.prev.next = moving.next;
               moving.next.prev = moving.prev;
               found = true;
               break;
           }
        }

        // item not in list or at end of list
        if(!found || moving == tail){
            return false;
        }

        // iterate to position
        Node current = moving;
        for(int i = 0; i < positions; i++){
            // if at tail
            if(null == current.next){
                tail.next = moving; // is copy so should have prev but check
                moving.prev = tail;
                return false;
            }
            current = current.next;
        }

        // if at end
        if(null == current.next){
            tail = moving;
        }
        moving.next = current.next;
        current.next = moving;
        moving.prev = current;

        return true;
    }

    /**
     * makes a string representation of this object
     *
     * @return the String representation of this object
     */
    public String toString(){
        String s = "Size: " + size + " Data:";
        for(Node n = head; null != n; n = n.next){
            s += " " + n.data;
        }
        return s;
    }
}
