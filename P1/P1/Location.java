import java.util.regex.Matcher;

/**
 * A Stanley's Storage Storage Location
 *
 * @author Alexi Most
 * @version 1
 */
public class Location
{
    /** the array resize value when the number of customers exceeds array size */
    private static int RESIZE_VALUE;
    /** the number of rows of units */
    private static int ROWS;
    /** the number of columns of units */
    private static int COLUMNS;
    /** the name of this location */
    private String name;
    /** the storage units at this location */
    private Unit[][] units;
    /** the customers that have rented at this location */
    private Customer[] customers;
    /** the number of customers registered at this location */
    private int customerCount;

    
    /**
     * Constructor for objects of class Location
     * 
     * @param _name the name of this location 
     *      Name must start with 2 capital letters for state abbreviation
     *      This must be folllowed by 2 digit area number
     *      This must be followed with city name, capitalized
     */
    public Location(String _name)
    {
        // check that name follows conventions
        validateName(_name);
        name = _name;
        
        RESIZE_VALUE = 100;
        ROWS = 12;
        COLUMNS = 20;
        
        customers = new Customer[RESIZE_VALUE];
        units = new Unit[COLUMNS][ROWS];
        
        customerCount = 0;
        
        // initialize units
        for(int col = 0; col < COLUMNS; col++){
            for(int row = 0; row < ROWS; row++){
                if(row >=8){
                    units[col][row] = new Unit(Unit.Type.standard, 4, 8, 2, 10.0);
                }
                else if(row >= 4){
                    units[col][row] = new Unit(Unit.Type.humidityControlled, 4, 8, 2, 10.0);
                }
                else{
                    units[col][row] = new Unit(Unit.Type.temperatureControlled, 4, 8, 2, 10.0);
                }
            }
        }
    }
    
    
    /**
     * method to validate location name
     * 
     * @param _name the attemped name
     */
    private void validateName(String _name){
        if(_name.length() < 5){
            throw new IllegalArgumentException("Name does not fulfill parameters, not long enough");
        }
        
        if(! _name.substring(0, 1).matches("[A-Z]")){
            throw new IllegalArgumentException("First two characters must be capitals indicating state");
        }
        
        if(! _name.substring(2, 3).matches("[0-9]")){
            throw new IllegalArgumentException("Third and fourth characters must be integers");
        }
        
        if(! _name.substring(4).matches("[A-Z]")){
            throw new IllegalArgumentException("City must start with a capital letter");
        }
        
        if(_name.length() > 5 && ! _name.substring(5).matches("[a-z]")){
            throw new IllegalArgumentException("City name must be in characters");
        }
    }

    
    /**
     * resizes the customer array if it exceeds bounds
     */    
    private void resizeCustomersArray(){
        Customer newCustomers[] = new Customer[customers.length + RESIZE_VALUE];
        for(int i = 0; i < customers.length; i++){
            newCustomers[i] = customers[i];
        }
        customers = newCustomers;
    }
    
    
    /**
     * gets the location's name
     * 
     * @return the location's name
     */
    public String getName(){
        return name;
    }
    
    
    /**
     * gets unit from the units at this location
     * 
     * @param row       the row of the unit
     * @param column    the column of the unit
     * 
     * @return unit     the unit at the given index
     */
    public Unit getUnit(int column, int row){
        return units[column][row];
    }
    
    
    /**
     * add a Customer to the customers array
     * 
     * @param customer the new Customer
     */
    public void addCustomer(Customer customer){
        
        if(customerCount >= customers.length - 1){
            resizeCustomersArray();
        }
        
        customers[customerCount] = customer;
        customerCount++;
        
    }
    
    
    /**
     * gets a customer from the array of registered customers
     * 
     * @param index the index to return the customer for
     * 
     * @return the Customer at the given index
     */
    public Customer getCustomer(int index){
        return customers[index];
    }
    
    
    /**
     * gets the number of Customers registered at this location
     * 
     * @return the customer count
     */
     public int getCustomerCount(){
         return customerCount;
    }
    
    
    /**
     * returns the units that match specified conditions      
     *      To return a Customer's Units:
     *          provide a Customer and a null Type
     *      To return empty Units:
     *          provide a null Customer and a null Type
     *      To return empty Units of a given Type:
     *          provide a null Customer and the specified Type
     *      Providing a Customer and a Type will return all Units
     *      of the Type the Customer is renting
     * 
     * @param customer the Customer to check against
     * @param type Unit Type to check against
     * 
     * @return the Units the given Customer is renting
     */
    public Unit[] getUnits(Customer customer, Unit.Type type){
         /** the number of units fitting parameter */
         int count = 0;
         /** the units array, initialized after determining size */
         Unit[] tempUnits;
         /** Customer declaration for comparison */
         Customer currentCustomer;
         /** Unit declaration for comparison */
         Unit currentUnit;
         
         // get number of units matching parameters
         for(int col = 0; col < units.length; col++){
             for(int row = 0; row < units[0].length; row++){
                 
                 currentUnit = units[col][row];
                 currentCustomer = currentUnit.getCustomer();
                 
                 if(currentCustomer == customer){
                     
                     if(type == null){
                         count++;
                     }
                     
                     if(units[col][row].getType() == type){
                        count++;                      
                     }
                 }
                 
                 if(currentCustomer == null){
                     
                     if(type == null){
                         count++;
                     } 
                     
                     if(type == units[col][row].getType()){
                         count++;
                     }   
                 }
             }
         }
         
         // make array of given size
         tempUnits = new Unit[count];
         // reset count to use as array index
         count = 0;
         
         // fill in array            
         for(int col = 0; col < units.length; col++){
             for(int row = 0; row < units[0].length; row++){
                 
                 currentUnit = units[col][row];
                 currentCustomer = currentUnit.getCustomer();
                 
                 if(currentCustomer == customer){
                     
                     if(type == null){
                         tempUnits[count++] = currentUnit;
                     }
                     
                     if(units[col][row].getType() == type){
                        tempUnits[count++] = currentUnit;                        
                     }
                 }
                 
                 if(currentCustomer == null){
                     
                     if(type == null){
                         tempUnits[count++] = currentUnit;
                     } 
                     
                     if(type == units[col][row].getType()){
                         tempUnits[count++] = currentUnit;
                     }   
                 }
             }
         }
         
         // return array   
         return tempUnits;
    }
     
    /**
     * Adds monthly charge to Customer's balance
     */
    public void chargeMonthlyRent(){
         // Unit Has-A Customer, but Customer does not Have-A Unit
         // so iterate through Units and get customers
         
         /** Customer instance to test against */
         Customer tempCustomer;
         /** Unit instance to test against */
         Unit tempUnit;
         
         for(int col = 0; col < units.length; col++){
             for(int row = 0; row < units[0].length; row++){
                 
                 tempUnit = units[col][row];
                 tempCustomer = tempUnit.getCustomer();
                 
                 if(tempCustomer != null){
                     tempCustomer.charge(tempUnit.getPrice());
                 }
             }
         }
    }
     
    /**
     * gets String representation of this object
     * 
     * @return String representation of this object
     */
    public String toString(){
        return name + ", " + "Units[" + COLUMNS + "][" + ROWS + "], Customers[" 
            + customerCount + "]";
    }
}
