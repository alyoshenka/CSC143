
import java.util.regex.Matcher;

/**
 * Stanley's Storage Customer
 *
 * @author Alexi Most
 * @version 1
 */
public class Customer{
    private String name;
    private int phone;
    private double debt; 

    /**
     * Constructor for objects of class Customer
     * 
     * @param _name customer name, customers can name themselves however they want
     * @param _phone phone number, must be 10 digits
     */
    public Customer(String _name, int _phone){
        
        // no validation for name, customers can name themselves however they want
        
        validatePhone(_phone);
        name = _name;
        phone = _phone;
        debt = 0.0;
    }  
    
    
    /**
     * Validates customer phone
     * 
     * @param _phone the phone number to validate
     */
    private void validatePhone(int _phone){ 
        if(_phone < 0){
            throw new IllegalArgumentException("Invalid phone. Must be 10 digits");
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
    public int getPhone(){
        return phone;
    }
    
    /**
     * sets customer name
     * 
     * @param _name the Customer's new name
     */
    public void setName(String _name){
        name = _name;
    }
    
    /** 
     * sets the customer phone number, must still follow phone number guidelines
     * 
     * @param _phone the new phone number
     */
    public void setPhone(int _phone){
        validatePhone(_phone);
        phone = _phone;
    }
    
    /**
     * Charges customer a given amount
     * 
     * @param charge amount
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
     * @param payment amount
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
