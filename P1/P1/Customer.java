
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
     * @param _name customer name
     * @param _phone phone number
     */
    public Customer(String _name, int _phone){
        validateName(_name);
        validatePhone(_phone);
        name = _name;
        phone = _phone;
        debt = 0.0;
    }
    
    /**
     * Validates customer name
     * 
     * @param _name the name to validate
     */
    private void validateName(String _name){
        if(! _name.matches("[A-Za-z/p{Punct}")){
            throw new IllegalArgumentException("Invalid name."+
                " Name can only include a-z, A-Z, and standard punctuation !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
        }
    }
    
    
    /**
     * Validates customer phone
     * 
     * @param _phone the phone number to validate
     */
    private void validatePhone(int _phone){        
        if(! Integer.toString(_phone).matches("[0-9]{10}")){
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
     public void credit(int amount){
         if(amount < 0){
            throw new IllegalArgumentException("cannot charge negative");
        }
        
         debt -= amount;
         if(debt < 0){
            // cannot owe customer money
        }
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
