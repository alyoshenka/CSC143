
/** manages parts of word processing documents */
public class ListManager<E> {
    /** the list of data */
    private LinkedList<E> items;

    /**
     * ListManager constructor
     */
    public ListManager(){
        items = new LinkedList<E>();
    }

    /**
     * ListManager constructor
     *
     * @param items the items in the list, default initializes if null
     */
    public ListManager(LinkedList<E> items) {
        if (null == items){
            items = new LinkedList<E>();
        }
        else {
            this.items = items;
        }
    }

    /**
     * gets the number of items in the list
     *
     * @return the number of items in the list
     */
    public int getCount(){
        return items.size();
    }

    /**
     * gets an item at an index in the list
     *
     * @param idx the index to get from
     * @return the item at the index
     */
    public E getItem(int idx){
        return items.itemAt(idx);
    }

    /**
     * adds an item to the list
     *
     * @param item the item to add
     */
    public void add(E item){
        items.add(item);
    }

    /**
     * adds an item to a specific point in the list
     *
     * @param item the item to add
     * @param idx the index to add it
     * @return whether adding was successful
     */
    public boolean addAt(E item, int idx){
        return items.addAt(item, idx);
    }

    /**
     * removes an item from the list
     *
     * @param item the item to remove
     * @return whether removing was successful
     */
    public boolean remove(E item){
        return items.remove(item);
    }

    /**
     * gets a string representation of this object
     *
     * @return a string representation of this object
     */
    public String toString(){
        return "Items: " + items.toString();
    }
}
