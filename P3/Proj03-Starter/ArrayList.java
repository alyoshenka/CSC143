// You'll need to create this generic class, or
// bring in the code from the author, if you'd like
//
// No unit tests are needed, except on methods
// you add to the class

import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.io.Serializable;

/**
 * generic class to represent a list of items
 * @param <E> the type of items
 */
public class ArrayList<E> implements Serializable, Iterable<E>{

    /** data of list */
    private E[] data;
    /** the current capacity of the list */
    private int capacity;
    /** the number of item E in the list */
    private int size;
    /** the percentage the capacity increases by at resize */
    private double resizeValue;
    /** the class version */
    public static final long serialVersionUID = 1;

    /**
     * default ArrayList constructor, initialized to 50
     */
    public ArrayList() {
        this(50);
    }

    /**
     * ArrayList constructor
     *
     * @param capacity initial capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        if(capacity < 0){
            capacity = 0;
        }
        this.capacity = capacity;
        size = 0;
        resizeValue = 0.5; // CHECK
        data = (E[]) new Object[capacity];
    }

    /**
     * iterator of this list
     */
    private class ArrayListIterator implements Iterator<E>{

        /** current index iteration is at */
        private int idx;

        /**
         * iterator constructor
         */
        public ArrayListIterator() {
            idx = 0;
        }

        /**
         * check if there is another item in list, allows nulls
         *
         * @return true if there is another element
         */
        public boolean hasNext(){
            return idx < size;
        }

        /**
         * gets the next item in the array
         *
         * @return the next item in the array
         */
        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException("no more elements");
            }
            return data[idx++];
        }

        /**
         * removes the current element from the array
         */
        public void remove(){ // CHECK
            if(idx < 0){
                throw new IllegalStateException("cannot remove from before start of list");
            }
            ArrayList.this.remove(idx - 1); // TEST
            if(idx < 0){
                idx = 0;
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
        String rep = "ArrayList of size " + size
                + "\nValues: \n";
        // add item strings
        for(int i = 0; i < size; i++){
            if(data[i] == null){
                rep += "null\n";
            }
            else{
                rep += data[i].toString() + "\n";
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
     * @param item the value to check
     * @return whether the list contains the value
     */
    public boolean contains(E item){
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
        if(checkIndex(idx)){
            data[idx] = item;
        }
        // else do nothing
    }

    /**
     * clears the list
     */
    public void clear(){
        size = 0;
    }

    /**
     * gets an iterator for this list
     *
     * @return the list's iterator
     */
    public ArrayListIterator iterator(){
        return new ArrayListIterator();
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
        capacity = newCapacity;
    }

    /**
     * ensures there is enough capacity for size * resizeValue
     */
    private void ensureCapacity(){
        ensureCapacity((int)Math.ceil(capacity * (1 + resizeValue)) + 1);
    }

    /**
     * checks if given index is valid to access
     *
     * @param idx the index to check
     * @return true if valid index to access
     */
    private boolean checkIndex(int idx){
        return idx >= 0 && idx < size;
    }

    /**
     * compresses all non-null values to lower indexs
     */
    public void compressNulls(){ // TEST
        int nullCtr = 0;
        for(int i = 0; i < size; i++){
            data[i-nullCtr] = data[i];
            if(data[i] == null){
                nullCtr++;
            }
        }
        size -= nullCtr;
    }

    /**
     * gets an item at a specified index
     *
     * @param idx the index of the item
     * @return item ar given index
     */
    public E get(int idx){
        if(checkIndex(idx)){
            return data[idx];
        }
        else{
            return null;
        }
    }
}
