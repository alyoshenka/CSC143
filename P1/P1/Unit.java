import java.time.LocalDate;

/**
 * A Stanley's Storage Storage Unit
 *
 * @author Alexi Most
 * @version 1
 */
public class Unit
{
    /** unit types */
    public enum Type {standard, humidityControlled, temperatureControlled};
    
    /** the type of this unit */
    private Type type;
    /** the width of the unit */
    private int width;
    /** the length of the unit */
    private int length;
    /** the height of the unit */
    private int height;
    /** the customer this unit belongs to */
    private Customer customer;
    /** the standard price for the unit */
    private double standardPrice;
    /** the price this unit was rented at */
    private double rentedPrice; 
    /** the date the unit was rented on */
    private LocalDate date;

    /**
     * Constructor for objects of class Unit
     * 
     * @param _type     the type of unit
     * @param _width    the width of the unit
     * @param _length   the length of the unit
     */
    public Unit(Type _type, int _width, int _length, int _height, double _standardPrice)
    {
        // validate dimensions
        if(_width % 4 != 0 || _length % 4 != 0 || _height % 2 != 0){
            throw new IllegalArgumentException("width and height must be multiples of 4, height must be a multiple of 2");
        }
            
        type = _type;
        width = _width;
        length = _length;
        height = _height;
        standardPrice = _standardPrice;
        customer = null; // no customer until it is rented  
        rentedPrice = 0.0; // no price until it is rented
        date = LocalDate.now();
    }

    /**
     * gets the type of unit
     * 
     * @return the unit type
     */
    public Type getType(){
        return type;
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
    public Double getPrice(){
        if(customer == null){
            return standardPrice;
        }
        else{
            return rentedPrice;
        }
    }
    
    /**
     * rents the unit to a new customer
     * 
     * @param _customer the customer
     * @param _date     the date rented
     * @param _rentedPrice     the price it was rented for
     */
    public void rentUnit(Customer _customer, LocalDate _date, double _rentedPrice){
        customer = _customer;
        date = _date;
        rentedPrice = _rentedPrice;
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
     * @return String   the string representation of the unit
     */
    public String toString(){
        return type + ", " + width + "x" + length + "x" + height + ", " + customer.toString() 
            + ", $" + standardPrice + ", $" + rentedPrice + ", " + date;
    }
}
