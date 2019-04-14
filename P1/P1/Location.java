    import java.util.regex.Matcher;
    
    /**
     * A Stanley's Storage Storage Location
     *
     * @author Alexi Most
     * @version 1
     */
    public class Location
    {
        // constants
        /** the array resize value when the number of customers exceeds array size */
        private static int RESIZE_VALUE;
        /** the minimum controlled humidity */
        public final int MIN_HUMIDITY;
        /** the maximum controlled humidity */
        public final int MAX_HUMIDITY;
        /** premium humidity limit */
        public final int SPEC_HUMIDITY;
        /** the minimum controlled temperature */
        public final int MIN_TEMP;
        /** the maximum controlled temperature */
        public final int MAX_TEMP;
        /** low premium temperature limit */
        public final int SPEC_TEMP_LOW;
        /** high premium temperature limit */
        public final int SPEC_TEMP_HIGH;

        /** number of standard rows */
        private int rowsStandard;
        /** number of standard columns */
        private int colsStandard;
        /** number of humidity rows */
        private int rowsHumidity;
        /** number of humidity columns */
        private int colsHumidity;
        /** number of temperature rows */
        private int rowsTemperature;
        /** number of temperature columns */
        private int colsTemperature;

        /** base unit price */
        private int baseUnitPrice;
        /** price for special humidity */
        private int specHumidPrice;
        /** price for special temperature */
        private int specTempPrice;
        /** discount for multiple units, percent expressed as decimal */
        private double multiUnitDiscoount;
        /** added rate for standard unit */
        private double standardFlatRate;
        /** added rate for humidity unit, multiplied by floor squared footage */
        private double humidSquaredRate;
        /** added rate for temperature unit, multiplied by unit area cubed */
        private double tempCubedRate;

        /** location name */
        private String name;
        /** units at location */
        private Unit[][] units;
        /** customers registered at location */
        private Customer[] customers;

        /**
         * main application method
         *
         * @param args command line arguments
         */
        public static void Main(String[] args){

        }

        /**
         * Constructor for objects of class Location
         * 
         * @param name the name of this location
         *      Name must start with 2 capital letters for state abbreviation
         *      This must be followed by 2 digit area number
         *      This must be followed with city name, capitalized
         */
        public Location(String name)
        {
            // set constants
            RESIZE_VALUE = 100;
            MIN_HUMIDITY = 20;
            MAX_HUMIDITY = 60;
            SPEC_HUMIDITY = 29;
            MIN_TEMP = 45;
            MAX_TEMP = 70;
            SPEC_TEMP_LOW = 49;
            SPEC_TEMP_HIGH = 65;

            // check that name follows conventions
            validateName(name);
            this.name = name;
            

            
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
         * @param newName the attemped name
         */
        private void validateName(String newName){
            
            if(newName.length() < 5){
                throw new IllegalArgumentException("Name does not fulfill parameters, not long enough");
            }
            
            if(! newName.substring(0, 1).matches("[A-Z]")){
                throw new IllegalArgumentException("First two characters must be capitals indicating state");
            }
            
            if(! newName.substring(2, 3).matches("[0-9]")){
                throw new IllegalArgumentException("Third and fourth characters must be integers");
            }
            
            if(! Character.toString(newName.charAt(4)).matches("[A-Z]")){
                throw new IllegalArgumentException("City must start with a capital letter");
            }
            
            if(newName.length() > 5 && ! newName.substring(5).matches("[a-zA-Z]+")){
                throw new IllegalArgumentException("City name must be in characters");
            }
        }
    
        
        /**
         * resizes the customer array if it exceeds bounds
         */    
        private void resizeCustomersArray(){
            Customer newCustomers[] = new Customer[customers.length + RESIZE_VALUE];
            System.arraycopy(customers, 0, newCustomers, 0, customers.length);
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
                 
                     if (customer == null){
                     
                         if(type == null){
                             count++;
                         }
                         else if (units[col][row].getType() == type){
                             count++;                      
                         }
                     }             
                     else if (customer == currentCustomer){
                     
                         if (type == null){
                             count++;
                         } 
                         else if (type == units[col][row].getType()){
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
                 
                     if(customer == null){
                     
                        if(type == null){
                             tempUnits[count++] = currentUnit;
                        }
                        else if(units[col][row].getType() == type){
                            tempUnits[count++] = currentUnit;                        
                        }
                    }
                    else if(customer == currentCustomer){
                     
                        if(type == null){
                            tempUnits[count++] = currentUnit;
                        } 
                        else if(type == units[col][row].getType()){
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
