import java.util.ArrayList;
import java.util.Iterator;

/** 
 * Models a Bank that has a collection of BankAccounts 
 * 
 * @author      Bill Barry, adapted from CSC department code
 * @version     2019-03-27
 */
public class Bank {

    /** the collection of accounts the bank maintains   */
    private ArrayList<BankAccount> accounts;

    /** the interest rate charged by the bank           */
    private double interestRate; 

    /**
     * Constructs a bank with no BankAccounts
     * 
     * @param   initialInterestRate     the interest rate to be charged on accounts
     *                                  (e.g., 0.02 for 2%); must be 0.0 or greater 
     *                                  and less than 1.0
     */
    public Bank(double initialInterestRate) {
        if (initialInterestRate < 0.0 || initialInterestRate >= 1.0) {
            throw new IllegalArgumentException("Initial interest must be in the range 0 <= rate < 1");
        }
        accounts = new ArrayList<BankAccount>();
        interestRate = initialInterestRate;
    }

    /**
     * Retrieves the account at the specified index in the list
     * 
     * @param   index       the index of the account you wish to retrieve
     * @return              the specified account
     */
    public BankAccount getAccount(int index) {
        return accounts.get(index);
    }

    /**
     * Retrieves the account with the specified account number
     * 
     * @param   account     the account id to search for
     * @return              the specified account, or null if not found
     */
    public BankAccount getAccount(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        for (BankAccount acct : accounts) {
            if (acct.getId().equals(id)) {
                return acct;
            }
        }
        return null;
    }

    /**
     * Open a new account in the Bank
     * 
     * @param   account     the account to add to the list; must not be a null reference
     */
    public void openAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account reference must not be null");
        }
        accounts.add(account);
    }

    /**
     * Update the interest rate for this bank
     * 
     * @param   newRate     the new interest rate (e.g., 0.02 for 2%); must be at least 0 and less than 1
     */
    public void setInterestRate(double newRate) {
        if (newRate < 0 || newRate >= 1) {
            throw new IllegalArgumentException("Rate must be in the range 0 to 1, inclusive");
        }
        interestRate = newRate;
    }

    /**
     * Retrieves the current interest rate at this Bank
     * 
     * @return     the current interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Close an account
     * 
     * @param   account     a reference to the account to be closed
     * @return              true if the account was located and closed; false if the account was not located
     */
    public boolean closeAccount(BankAccount account) {
        return accounts.remove(account);
    }

    /**
     * Return the summed balances of all the accounts
     * 
     * @return      the total of all balances in this bank
     */
    public double getTotalBalance() {
        double totalBal = 0.0;
        for (BankAccount acct : accounts) {
            totalBal += acct.getBalance();
        }
        return totalBal;
    }

    /**
     * Creates a list of all accounts that are below the given value
     * 
     * @param   value       the threshhold to test accounts against
     * @return              an array of BankAccounts whose balance is less than the specified value
     */
    public BankAccount[] getAcctsBelowAmt(double value) {
        ArrayList<BankAccount> belowAccts = new ArrayList<BankAccount>();
        for (BankAccount acct : accounts) {
            if (acct.getBalance() < value) {
                belowAccts.add(acct);
            }
        }
        return belowAccts.toArray(new BankAccount[0]);
    }
}