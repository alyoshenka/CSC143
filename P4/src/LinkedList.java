
/** a linked list with objects of type E */
public class LinkedList<E> implements java.io.Serializable {
    /** the start of the list */
    private Node head;
    /** the end of the list */
    private Node tail;
    /** the number of items in the list */
    private int size;

    /** a list node */
    private class Node implements java.io.Serializable {
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
    public E itemAt(int idx){
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
     *      if idx greater than size, will add item at end and return false
     *      if idx less than 0, will return false and not add item
     */
    public boolean addAt(E item, int idx){
        if(idx < 0){
            return false;
        }
        if(null == head || idx >= size){
            add(item);
            return 0 == idx;
        }
        
        Node n = new Node();
        n.data = item;
        if(idx == size - 1){
            n.prev = tail;
            tail.next = n;
            tail = n;
            size++;
            return true;
        }
        
        Node current = head;
        for(int i = 0; i < idx; i++){
            current = current.next;
        }
        n.prev = current.prev;
        current.prev = n;
        n.next = current;
        if(0 == idx){
            head = n;
        }
        size++;
        return true;
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
               if(moving == head){
                   head = moving.next;
               }else{
                   moving.prev.next = moving.next;
               }
               if(null != moving.next){                   
                   moving.next.prev = moving.prev;
               }
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
                moving.next = null;
                tail = moving;
                return false;
            }
            current = current.next;
        }

        moving.next = current.next;
        // if at end
        if(null == current.next){
            tail = moving;
        }else{
            moving.next.prev = moving;
        }
        current.next = moving;
        moving.prev = current;

        return true;
    }

    /**
     * moves the last occurrence of an item up the list
     *
     * @param item the item to move
     * @param positions the number of positions to move it
     *                  will move as many as possible if out of bounds
     * @return whether moving was successful, ie item found and positions within range
     */
    public boolean moveUp(E item, int positions){
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
        for(moving = tail; null != moving; moving = moving.prev){
           if(moving.data.equals(item)){
               // take out item
               if(moving == tail){
                   tail = moving.prev;
               }else{
                   moving.next.prev = moving.prev;
               }
               if(null != moving.prev){
                   moving.prev.next = moving.next;
                }
               found = true;
               break;
           }
        }

        // item not in list or at beginning of list
        if(!found || moving == head){
            return false;
        }

        // iterate to position
        Node current = moving;
        for(int i = 0; i < positions; i++){
            // if at head
            if(null == current.prev){
                head.prev = moving; // is copy so should have next but check
                moving.next = head;
                moving.prev = null;
                head = moving;
                return false;
            }
            current = current.prev;
        }

        // if at beginning
        if(null == current.prev){
            head = moving;
        }else{
            moving.prev.next = moving;
        }
        moving.next = current;
        current.prev = moving;

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
            s += "\n" + n.data;
        }
        return s;
    }
}
