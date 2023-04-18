
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class account {


// all variables set to private to protect integrity of data//    
    private String accountNumber = new String();
    private String pin = new String();
    private String fullName = new String();
    private String DOB = new String();
    private String phoneNumber = new String();
    private double checkingBalance = 0;
    private double savingsBalance = 0;
    private ArrayList <String> checkingHistory = new ArrayList <String> ();
    private ArrayList <String> savingsHistory = new ArrayList <String> ();
    
// constructor for account object //
    
    public account (String accountNumber, String pin, String fullName, String DOB, String phoneNumber, double checkingBalance, double savingsBalance){
    
        this.accountNumber = accountNumber;
        this.fullName = fullName;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        
        }

// getter methods //   
    
    public String getAccountIdInfo() { return accountNumber; }
    public double getCheckingBalance () { return checkingBalance; }
    public double getSavingsBalance() { return savingsBalance; }

// setter methods //
    
    public void addCheckingBalance (double newBalance) { 
        
        checkingBalance = checkingBalance + newBalance;
        addCheckingHistory();

    }
    
    public void addSavingsBalance (double newBalance) { 
        
        savingsBalance = savingsBalance + newBalance;
        addSavingsHistory();
    }

    
// need to make sure balance is not less than 0//
    public void withdrawChecking (double amntTaken) {
   
        checkingBalance = checkingBalance - amntTaken;
        addCheckingHistory();
    
    }
 
// need to make sure balance is not less than 0//
    public void withdrawSavings (double amntTaken) {
        
        savingsBalance = savingsBalance - amntTaken;
        addSavingsHistory();
    
    
    }
    
// using import to generate date and time as string //    
    public String getTimeStamp () {

DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date_time = new Date();
        
        
        String timeStamp = date_time.toString();
        return timeStamp;
}
 // calls getTimeStamp() and getter method converted to string - concatenates strings then adds to arraylist of transaction history //
    public void addCheckingHistory () {
    
    String checkingEntry = "\n" + getTimeStamp() + "\n" + "Checking Account Balance: " + Double.toString(this.checkingBalance);
    
    this.checkingHistory.add(checkingEntry);
    
    
    }
    
   // calls getTimeStamp() and getter method converted to string - concatenates strings then adds to arraylist of transaction history //
   
   
    public void addSavingsHistory () {
    
    String savingsEntry = "\n" + getTimeStamp() + "\n" + "Savings Account Balance: "  + Double.toString(this.savingsBalance);
    
    this.savingsHistory.add(savingsEntry);
    
    
    }

}
