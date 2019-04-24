import java.time.LocalDate;

/**
 * Manages storage locations for Stanley's Storage
 * CSC 143 P1
 * 04/09/2019
 * 
 * @author Alexi Most
 * @version 1
 */
public class StanleyStorage
{

    /**
     * Constructor for objects of class StanleyStorage
     */
    public StanleyStorage(){
        
    }

    /**
     * Main application method
     *
     * @param  args command-line arguments
     */
    public static void Main(String[] args){
           Location testLocation = new Location("WA01Seattle");
           Customer ben = new Customer("Ben", 0001112222);
           Customer tim = new Customer("Tim", 0001113333);
           testLocation.addCustomer(ben);
           testLocation.addCustomer(tim);
           String display = "";
           
           testLocation.getUnit(5, 5).rentUnit(ben, LocalDate.now(), 60.0);
           testLocation.chargeMonthlyRent();
           testLocation.chargeMonthlyRent();
           
           display = "This location has " + testLocation.getUnits(null, null).length + " units, "
                + testLocation.getUnits(null, Unit.Type.humidityControlled).length + " are humidity controlled";
           display += "\nCustomer " + tim.getName() + " decides to change his name";
           tim.setName("Bob");
           display += "\nTheir name is now " + tim.getName();
           display += "\nCustomer " + ben.getName() + " has rented a unit: " + testLocation.getUnit(5, 5).toString() 
                + " for $" + testLocation.getUnit(5, 5).getPrice();
           display += "\nAfter 2 months they owe: $" + testLocation.getUnit(5, 5).getCustomer().getDebt();
                 
           System.out.println(display);
           System.out.println(testLocation.toString());
    }
}
