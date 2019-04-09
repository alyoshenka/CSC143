/** 
 * Simulates a simple bank account object
 * 
 * @author      Bill Barry, adapted from CSC department code
 * @version     2019-03-27
 */
public class BankAccount {

    /** the account owner's name                    */
    private String owner;
    
    /** the account's identification number         */
    private String acctId;
    
    /** the account's balance, always 0 or greater  */
    private double balance;    

    /** 
     * Constructs a BankAccount object 
     * 
     * @param     name                owner of the account
     * @param     id                  account ID
     * @param     initialBalance      starting balance; must be 0 or greater
     */
    public BankAccount(String name, String id, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Cannot create a BankAccount with a negative balance");
        }
        owner = name;
        acctId = id;
        balance = initialBalance;
    }

    /** 
     * Retrieves the owner of this account 
     * 
     * @return    account owner
     */
    public String getOwner() {
        return owner;
    }

    /** 
     * Retrieves the account ID of this account 
     * 
     * @return    account ID
     */
    public String getId() {
        return acctId;
    }

    /** 
     * Retrieves the current balance 
     * 
     * @return    account balance
     */
    public double getBalance() {
        return balance;
    }

    /** 
     * Deposits money into this account
     * 
     * @param     amount    amount to be deposited; must be 0 or greater
     * @return              balance after this transaction
     */
    public double deposit(double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount: " + amount);
        }
        balance += amount;
        return balance;
    }

    /** 
     * Withdraw money from the account
     * 
     * @param   amount      amount to be withdrawn; must be in the range 0 to account balance
     * @return              balance after this transaction
     */
    public double withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount: " + amount);
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Cannot withdraw more than the current balance of this BankAccount");
        }
        balance -= amount;
        return balance;
    }

    /** 
     * Retrieves a text representation of this BankAccount
     * 
     * @return  basic information about the account, in single-line format
     */
    public String toString() {
        return "BankAccount ID: " + acctId + ", owner: " + owner + ", balance: $" + balance;
    }

}
