// You'll need to create this generic class, or
// bring in the code from the author, if you'd like
//
// No unit tests are needed, except on methods
// you add to the class

import java.util.Iterator;
import java.util.Arrays;

public class ArrayList<E> implements Iterable<E> { // PRECONDITIONS

    /** data of list */
    private E[] data;
    /** the current capacity of the list */
    private int capacity;
    /** the number of item E in the list */
    private int size;
    /** the percentate the capacity increases by at resize */
    private double resizeValue;

    /**
     * default ArrayList constructor
     */
    public ArrayList() {
        ArrayList(10); // CHECK
    }

    /**
     * ArrayList constructor
     *
     * @param capacity initial capacity
     */
    public ArrayList(int capacity){
        this.capacity = capacity;
        size = 0;
        resizeValue =0.5; // CHECK
        data = new E[capacity];
    }

    /**
     * iterator of this list
     */
    private Iterator<E> iterator(){
        /**
         * iterator constructor
         */
        Iterator<E> it = new Iterator<E>(){
            /** current index iteration is at */
            private int idx = 0;

            /**
             * check if there is another item in list, allows nulls
             *
             * @return true if there is another element
             */
            public boolean hasNext(){
                return idx < size; // allowing null values in list
            }

            /**
             * gets the next item in the array
             *
             * @return the next item in the array
             */
            public E next(){
                return data[idx++];
            }
        }
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
     * gets the string representation of the list
     *
     * @return the string representation of this list
     */
    public String toString(){
        /** string representation */
        String rep = "ArrayList of type " + E.getClass().getName() + " of size " + size
                + "\nValues: \n";
        // add item strings
        for(int i = 0; i < size; i++){
            if(data[i] == null){
                rep += "null\n";
            }
            else{
                data += data[i].toString() + "\n";
            }
        }

        return rep;
    }

    /**
     * returns the first index found of a given item, -1 if not found
     *
     * @param item to check
     * @return first index of item, -1 if not found
     */
    public int indexOf(E item){
        for(int i = 0; i < size; i++){
            if(data[i] == item){
                return i;
            }
        }
        return -1;
    }

    /**
     * gets whether list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * checks if the list contains a value
     *
     * @param the value to check
     * @return whether the list contains the value
     */
    public bool contains(E item){
        return indexOf(item) != -1;
    }

    /**
     * adds an item to the end of the list
     *
     * @param item the item to add
     */
    public void add(E item){
        ensureCapacity();
        data[size++] = item;
    }

    /**
     * adds an item at a specified index
     *
     * @param item the item to add
     * @param idx the index to add item
     */
    public void add(E item, int idx){
        ensureCapacity();
        // shift array over
        size++;
        for(int i = size; i > idx; i--){ // TEST
            data[i] = data[i-1];
        }
        data[idx] = item;
    }

    /**
     * removes at item at a specified index
     *
     * @param idx the index to remove
     */
    public void remove(int idx){
        data[idx] = null;
    }

    /**
     * sets the item at a given index
     *
     * @param item the new item
     * @param idx the index to set to the new item
     */
    public void set(E item, int idx){
        data[idx] = item;
    }

    /**
     * clears the list
     */
    public void clear(){
        size = 0;
    }

    /**
     * adds all items of a list to this list
     *
     * @param items the list of items to add
     */
    public void addAll(ArrayList<E> items){
        ensureCapacity(capacity + items.size());
        for(int 0; i < items.size(); i++){ // MORE EFFICIENT
            data[size++] = items[i];
        }
    }

    /**
     * ensures there is enough space for a given capacity
     * resizes array to make room, if needed
     *
     * @param newCapacity the capacity to check
     */
    public void ensureCapacity(int newCapacity){
        if(capacity < newCapacity){
            // make new array
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    /**
     * ensures there is enough capacity for size * resizeValue
     */
    private void ensureCapacity(){
        ensureCapacity(capacity * (1 + resizeValue));
    }

    /**
     * checks if given index is empty
     *
     * @param idx the index to check
     * @return true if item at index is null
     */
    private boolean checkIndex(int idx){
        return data[idx] == null;
    }

    /**
     * compresses all non-null values to lower indexs
     */
    public void compressNulls(){ // TEST
        int nullCtr = 0;
        for(int i = 0; i < size; i++){
            data[i] = data[i-nullCtr];
            if(data[i] == null){
                nullCtr++;
            }
        }
    }
}
