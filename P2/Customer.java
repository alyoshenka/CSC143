
import java.util.regex.Matcher;

/**
 * Stanley's Storage Customer
 *
 * @author Alexi Most
 * @version 1
 */
public class Customer{
    /** the customers name */
    private String name;
    /** the customers phone number */
    private String phone;
    /** the amount the customer owes stanleys' storage */
    private double debt; 

    /**
     * Constructor for objects of class Customer
     * 
     * @param name customer name, customers can name themselves however they want
     * @param phone phone number, must be 10 digits
     */
    public Customer(String name, String phone){
        
        validateName(name);
        validatePhone(phone);

        this.name = name;
        this.phone = phone;
        debt = 0.0;
    }

    /**
     * validates customer name
     *
     * @param newName attempted name
     */
    private void validateName(String newName){
        if(newName == null || newName.length() < 1){
            throw new IllegalArgumentException("name length must be > 1 and not null");
        }
    }

    /**
     * Validates customer phone
     * 
     * @param phone the phone number to validate
     */
    private void validatePhone(String phone){  // test
        if(! phone.matches("[0-9]{10}")){
            throw new IllegalArgumentException("phone must be 10 digits");
        }
    }
    
    
    /**
     * Gets customer name
     * 
     * @return customer name
     */
    public String getName(){
        return name;
    }
    
    
    /**
     * Gets customer phone number
     * 
     * @return phone number
     */
    public String getPhone(){
        return phone;
    }
    
    /**
     * sets customer name
     * 
     * @param name the Customer's new name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /** 
     * sets the customer phone number, must still follow phone number guidelines
     * 
     * @param phone the new phone number
     */
    public void setPhone(String phone){
        validatePhone(phone);
        this.phone = phone;
    }
    
    /**
     * Charges customer a given amount
     * 
     * @param amount the amount to charge
     */
    public void charge(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("cannot charge negative");
        }
        
        debt += amount;
    }
    
    
    /**
     * Credits customer a given amount
     * 
     * @param amount the amount the customer pays
     */
     public void credit(double amount){
         if(amount < 0){
            throw new IllegalArgumentException("cannot charge negative");
        }
        
         debt -= amount;
         if(debt < 0){
            // cannot owe customer money
        }
    }
    
    /**
     * gets the amount owed by the Customer
     * 
     * @return Customer's debt 
     */
    public double getDebt(){
        return debt;
    }
    
    
    /**
     * Makes string representation of object
     * 
     * @return string representation
     */
    public String toString(){
        return name + " " + phone + " " + debt;
    }            
}
