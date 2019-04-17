
/**
 * Stanley Storage Part 2
 *
 * @author Alexi Most
 * @version 1
 */
public class Main
{
    /**
     * main application method
     * 
     * @param args command-line arguments
     */
    public static void Main(String[] args){
        Location display = new Location("WA01Seattle");
        
        Customer c1 = new Customer("Tim", "0001112222");
        Customer c2 = new Customer("Bob", "1110003333");
        
        display.addCustomer(c1);
        display.addCustomer(c2);
        
        StandardUnit s = new StandardUnit(4,4,2,display);
        TemperatureUnit t = new TemperatureUnit(4,4,2,display,60);
        
        System.out.println("4*4*2 Standard Unit at " + display.getName() + " = $" + s.getPrice());
        System.out.println("4*4*2 60 degree Temperature Unit at " + display.getName() + " = $" + t.getPrice());
        
        display.getUnit(0, 0).rentUnit(c1);
        display.getUnit(0, 1).rentUnit(c2);
        display.getUnit(0, 2).rentUnit(c2);
        display.chargeMonthlyRent();
        
        System.out.println("1 Standard Unit: $" + c1.getDebt() + "s Standard Units: $" + c2.getDebt());
        
        System.out.println(display.toUnitMap());
        
        System.out.println(display.toString());
    }
}
