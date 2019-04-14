import java.time.LocalDate;

/**
 * A Stanley's Storage Storage Unit
 *
 * @author Alexi Most
 * @version 1
 */
public abstract class Unit
{
    /** the width of the unit */
    private int width;
    /** the length of the unit */
    private int length;
    /** the height of the unit */
    private int height;
    /** the customer this unit belongs to */
    private Customer customer;
    /** the date the unit was rented on */
    private LocalDate date;
    /** the Location of this unit */
    private Location location;

    /**
     * Constructor for objects of class Unit
     *
     * @param width    the width of the unit, multiple of 4, greater than 0
     * @param length   the length of the unit, multiple of 4, greater than 0
     * @param height   the height of the unit, multiple of 2, greater than 0
     * @param location the location of this unit
     */
    public Unit(int width, int length, int height, Location location)
    {
        // validate dimensions
        if(width <= 0 || length <= 0 || height <= 0){
            throw new IllegalArgumentException("dimensions must be > 0");
        }
        if(width % 4 != 0 || length % 4 != 0 || height % 2 != 0){
            throw new IllegalArgumentException("width and height must be multiples of 4, height must be a multiple of 2");
        }

        this.width = width;
        this.length = length;
        this.height = height;
        customer = null; // no customer until it is rented
        date = LocalDate.now();
        this.location = location;
    }
    
    /**
     * gets the length of the unit
     * 
     * @return the unit length
     */
    public int getLength(){
        return length;
    }
    
    /**
     * gets the width of the unit
     * 
     * @return the unit width
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * gets the height of the unit
     * 
     * @return the unit height
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * gets the last date the unit was rented on
     * if the unit has not been rented, returns the initialization date
     * 
     * @return rental date
     */
    LocalDate getRentalDate(){
        return date;
    }
    
    /**
     * gets the Customer associated with the unit
     * 
     * @return the customer renting this unit
     */
    public Customer getCustomer(){ 
        return customer;
    }
    
    /**
     * gets the price this unit was rented at 
     * 
     * @return the rented price
     */
    abstract Double getPrice();
    
    /**
     * rents the unit to a new customer
     * 
     * @param customer the customer
     * @param date     the date rented
     * @param rentedPrice     the price it was rented for
     */
    public void rentUnit(Customer customer, LocalDate date, double rentedPrice){
        this.customer = customer;
        this.date = date;
    }
    
    /** 
     * unrents the unit
     */
    public void releaseUnit(){
        customer = null;
    }
    
    /**
     * gets a string representation of the object
     * 
     * @return String the string representation of the unit
     */
    public String toString(){
        String customerString = customer == null ? "none" : customer.toString();
        return width + "x" + length + "x" + height + ", Customer: " +  customerString
            + ", " + date;
    }
}
