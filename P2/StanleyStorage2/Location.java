    import java.text.DecimalFormat;
    
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
            public final int MIN_TEMPERATURE;
            /** the maximum controlled temperature */
            public final int MAX_TEMPERATURE;
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
            /** total number of rows */
            private int rows;
            /** total number of columns */
            private int cols;
    
            /** base unit price */
            private double baseUnitPrice;
            /** price for special humidity */
            private double specialHumidityPrice;
            /** price for special temperature */
            private double specialTemperaturePrice;
            /** discount for multiple units, percent expressed as decimal */
            private double multiUnitDiscoount;
            /** added rate for standard unit */
            private double standardFlatRate;
            /** added rate for humidity unit, multiplied by floor squared footage */
            private double humiditySquaredRate;
            /** added rate for temperature unit, multiplied by unit area cubed */
            private double temperatureCubedRate;
    
            /** location name */
            private String name;
            /** units at location */
            private Unit[][] units;
            /** customers registered at location */
            private Customer[] customers;
            /** number of resistered customers */
            private int customerCount;
    
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
                MIN_TEMPERATURE = 45;
                MAX_TEMPERATURE = 70;
                SPEC_TEMP_LOW = 49;
                SPEC_TEMP_HIGH = 65;
    
                // initialize unit counts
                rowsStandard = 7;
                colsStandard = 10;
                rowsHumidity = 3;
                colsHumidity = 8;
                rowsTemperature = 2;
                colsTemperature = 6;
    
                // initialize prices
                baseUnitPrice = 50.0; // arbitrarily set
                standardFlatRate = 75.0;
                humiditySquaredRate = 5.0;
                temperatureCubedRate = 1.0;
    
                customerCount = 0;
    
                // check that name follows conventions
                validateName(name);
                this.name = name;
                
                cols = colsStandard + colsTemperature + colsHumidity;
                customers = new Customer[RESIZE_VALUE];
                units = new Unit[cols][];
                
                // initialize units
                for(int col = 0; col < cols; col++){
                    if(col < colsStandard){
                        units[col] = new StandardUnit[rowsStandard];
                        // initialize
                        for(int i = 0; i < rowsStandard; i++){
                            units[col][i] = new StandardUnit(4, 4, 2, this);
                        }
                    }
                    else if(col < colsStandard + colsHumidity){
                        units[col] = new HumidityUnit[rowsHumidity];
                        // initialize
                        for(int i = 0; i < rowsHumidity; i++){
                            units[col][i] = new HumidityUnit(4, 4, 2, this, 40);
                        }
                    }
                    else{
                        units[col] = new TemperatureUnit[rowsTemperature];
                        // initialize
                        for(int i = 0; i < rowsTemperature; i++){
                            units[col][i] = new TemperatureUnit(4, 4, 2, this, 60);
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
            if(!newName.matches("[A-Z]{2}[0-9]{2}[A-Z]{1}[A-Za-z]{0,}")){ // place names can be 1 letter
                throw new IllegalArgumentException("invalid name, check parameter comments");
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
         * @param classType class of unit to check against, ClassName.class
         * 
         * @return the Units the given Customer is renting
         */
        public Unit[] getUnits(Customer customer, Class classType){
             /** the number of units fitting parameter */
             int count = 0;
             /** the units array, initialized after determining size */
             Unit[] tempUnits;
             /** Customer declaration for comparison */
             Customer currentCustomer;
             /** Unit declaration for comparison */
             Unit currentUnit;

             /** start index to search from (inclusive) */
             int start;
             /** end index to search to (exclusive) */
             int end;

             // establish range to search
            if(classType == units[0][0].getClass()){ // standard
                start = 0;
                end = colsStandard;
            } else if(classType == units[colsStandard][0].getClass()){ // humidity
                start = colsStandard;
                end = colsStandard + colsHumidity;
            }
            else if(classType == units[colsStandard + colsHumidity][0].getClass()){ // temperature
                start = colsStandard + colsHumidity;
                end = cols;
            }else{ // any
                start = 0;
                end = colsStandard + colsHumidity + colsTemperature;
            }

             // get number of units matching parameters
             for(int col = start; col < end; col++){
                 for(int row = 0; row < units[col].length; row++){

                     // store current unit and customer to reduce number of times calling gets
                     currentUnit = units[col][row];
                     currentCustomer = currentUnit.getCustomer();
                 
                     if (customer == null){ // if searching for class only
                         count++;
                     }             
                     else if (customer == currentCustomer){ // if searching for customer only
                        count++;
                     }
                 }                                                                 
             }

             // make array of given size
             tempUnits = new Unit[count];
             // reset count to use as array index
             count = 0;
         
             // fill in array            
             for(int col = start; col < units.length; col++){
                 for(int row = 0; row < units[col].length; row++){
                 
                     currentUnit = units[col][row];
                     currentCustomer = currentUnit.getCustomer();
                 
                     if(customer == null){
                         tempUnits[count++] = currentUnit; // casting done from other side
                     }
                     else if(customer == currentCustomer){
                         tempUnits[count++] = currentUnit; // casting done from other side
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
                         // apply discount for multi-unit renters
                         if(getUnits(tempCustomer, null).length >= 2){
                             // MAKE MORE EFFICIENT
                             tempCustomer.charge(tempUnit.getPrice() * (1.0 - multiUnitDiscoount));
                         }else{
                             tempCustomer.charge(tempUnit.getPrice());
                         }
                     }
                 }
             }
        }

        /**
         * gets the base price of a unit
         *
         * @return the unit base price
         */
        public double getBasePrice(){
            return baseUnitPrice;
        }

        /**
         * sets the base price of a unit
         *
         * @param price the new base price
         */
        public void setBasePrice(double price){
            // validate
            if(price > 0){
                baseUnitPrice = price;
            }
        }
        
        /**
         * gets the price of a standard unit
         *
         * @return the standard unit price
         */
        public double standardFlatRate(){
            return standardFlatRate;
        }

        /**
         * gets the price for a premium humidity unit
         *
         * @return the premium humidity unit rate
         */
        public double getSpecialHumidityPrice(){
            return specialHumidityPrice;
        }

        /**
         * gets the price for a premium temperature unit
         *
         * @return the premium humidity unit rate
         */
        public double getSpecialTemperaturePrice(){
            return specialTemperaturePrice;
        }

        /**
         * gets the humidity rate per squared foot
         *
         * @return humidity price per square foot
         */
        public double getHumditySquaredPrice(){
            return humiditySquaredRate;
        }
        /**
         * gets the temperature rate per cubic foot
         *
         * @return temperature price per cubic foot
         */
        public double getTemperatureCubedPrice(){
            return temperatureCubedRate;
        }

        /**
         * gets String representation of this object
         *
         * @return String representation of this object
         */
        public String toString(){ // FINISH

            // format doubles to 2 digits after decimal
            DecimalFormat df = new DecimalFormat("#.00");

            String unitData = "Units[" + cols + "][" + rows + "], "
                    + " Standard: " + colsStandard * rowsStandard
                    + ", Humidity: " + colsHumidity * rowsHumidity
                    + ", Temperature: " + colsTemperature * rowsTemperature;
            String customerData = "\nCustomers["+ customerCount + "]";
            String rateData = "\nRates: Standard = " + df.format(standardFlatRate)
                    + " Humidity = $" + df.format(humiditySquaredRate) +  "sq/ft"
                    + " Humidity Premium = $" + df.format(specialHumidityPrice)
                    + " Temperature = $" + df.format(humiditySquaredRate) + "cub/ft"
                    + " Temperature Premium = $" + df.format(specialTemperaturePrice);

            return unitData + customerData + rateData;
        }
}
