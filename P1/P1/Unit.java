import java.time.LocalDate;

/**
 * A STanley's Storage Storage Unit
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
    /** the price this uit was rented at */
    private double rentedPrice;
    /** the standard price for a unit */
    private double standardPrice; // DO I NEED?
    /** the date the unit was rented on */
    private LocalDate date;

    /**
     * Constructor for objects of class Unit
     * 
     * @param _type     the type of unit
     * @param _width    the width of the unit
     * @param _length   the length of the unit
     * @param _customer the customer renting this unit
     */
    public Unit(Type _type, int _width, int _length, int _height, Customer _customer)
    {
        type = _type;
        width = _width;
        length = _length;
        height = _height;
        customer = _customer;   
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
     * gets the Customer associated with the unit
     * 
     * @return the customer renting this unit
     */
    public Customer getCustomer(){ // String??
        return customer;
    }
    
    /**
     * gets the price this unit was rented at 
     * 
     * @return the rented price
     */
    public Double getPrice(){
        return rentedPrice;
    }
    
    /**
     * rents the unit to a new customer
     * 
     * @param _customer the customer
     * @param _date     the date rented
     * @param price     the price it was rented for
     */
    public void rentUnit(Customer _customer, LocalDate _date, double price){
        customer = _customer;
        date = _date;
        rentedPrice = price;
    }
    
    /** 
     * unrents the unit
     */
    public void releaseUnit(){ // do any more???
        customer = null;
    }
    
    /**
     * gets a string representation of the object
     * 
     * @return String   the string representation of the unit
     */
    public String toString(){
        return type + ", " + width + "x" + length + "x" + height + ", " + customer.toString() 
            + ", $" + rentedPrice + ", " + date;
    }
}
