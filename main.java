
import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class main {
    
    public static void main (String args []) {
        
        System.out.println("Welcome " + "\n" + "\n");
        
        Scanner userInput = new Scanner(System.in);
        int initialInput = welcomeScreen(userInput);

        if (initialInput == 1) { signIn(); }
        if (initialInput ==2) { createAccount(userInput); }
        if (initialInput == 3) {
        System.out.println("\n"  + "\n" + "See yah!!");
        return;
        }  
    }


// welcomeScreen () sets up a scanner and asks for specific int user input//
// try-catch is inside do-while loop dependent on boolean variable//    ** MAY NOT NEED BOOLEAN VARIABLE **
// try block is where user input is accepted//
// if else statement within try block to ensure that user input is desired value of 1 2 or 3//
// acceptable value allows for exit of do-while loop with break statement //
// catch block handles input mismatch exception and recursively calls welcomeScreen() ask for correct input//

public static int welcomeScreen(Scanner userInput) {
    
    System.out.println("To sign in press 1" + "\n" + "To create an acccount press 2" + "\n" + "To logout press 3" + "\n");
    
    int initialInput;
    boolean validInput = false;

    do {  
        try {
              
        initialInput = userInput.nextInt(); 
        
        
        if(initialInput == 1 || initialInput == 2 || initialInput == 3) {  
        break;
         
            } else { System.out.println("\n" + "Incorrect input use 1,2 or 3...try...AGAIN!" + "\n");
                     }
        
        } catch (InputMismatchException e) {
         initialInput =0;
         System.out.println("Incorrect input, use a number!!!" + "\n");
         userInput.next();
            }
    } while (validInput == false);
               
      return initialInput;  
    }



     
public static void signIn() {

    
  
}


//this method relies on other methods to generate data that will be used to create account object//
//once object is created, the addCheckingHistory() and addSavingsHistory() methods are called to log initial amounts//
//welcomeScreen() method is called to send user back to initial options//
public static void createAccount(Scanner userInput) { 
    
    
    String accountNumber = AccountNum();
    
    System.out.println("Your account number is: " + accountNumber);
    
    
    String PIN= makePIN(userInput);
    String DOB = generateDOB(userInput);
    String fullName = nameMaker();
    String phoneNumber = takeNumber(userInput);
    double checkingBalance = setChecking(userInput);
    double savingsBalance = setSavings(userInput);

   
    account createdAccount = new account (accountNumber, PIN, DOB, fullName, phoneNumber, checkingBalance, savingsBalance);
    createdAccount.addCheckingHistory();
    createdAccount.addSavingsHistory();
    
    
    System.out.println("Your account number is: " + accountNumber + "\n");
    
    int initialInput = welcomeScreen(userInput);
    

}


    // generate a random integer/convert to string and return that value for account number//
    // random class is used to create new account numbers//
    // size of the stream//
    // origin and bound ensure that all account numbers are positive and uniform in digit length//

public static String AccountNum () {
    
    Random randoGen =new Random();
       int streamSize = 1;
       int randomNumberOrigin = 1000000;
       int randomNumberBound = 9999999;
       int i = randoGen.nextInt(); 
       if (i < 0) { i = i*-1;}
       String accountNumber = Integer.toString(i);
       return accountNumber;
    }



//INT input is converted to string, then a for-loop is used to make sure that 4 digits are used//
//process ends with correct input//
public static String makePIN (Scanner userInput)  {
    
    int pin = 0;
    int pinCount =0;
    boolean checker = false;
    String PIN = new String ();
    
    
        while (checker == false ) {      
            System.out.println("Enter a 4 digit PIN Number");   
            pin = userInput.nextInt();
            PIN = Integer.toString(pin);
        
            for (int i = 0; i < PIN.length(); i++) {
        
            pinCount++;
                }
            if (pinCount == 4) {
                checker = true;
                break;
                } 
            pinCount = 0;
            System.out.println("Number must be 4 digits");
        }
        
        System.out.println("PIN is " + PIN);
        return PIN;  
    }


// buffered reader used to get user input with space for first and last name//
// try catch used to handle potential IO exception//
// for loop within while loop checks for white space and breaks process if correct user input is there//
public static String nameMaker () {
    
    String fullName = new String();
    boolean checker = false;   
    
    try {
    
    BufferedReader nameReader = new BufferedReader ( new InputStreamReader(System.in));
        while (checker == false) {
     
    System.out.println("\n" + "Enter your first and last name with a space to separate: ");
    fullName = nameReader.readLine();

        for (int i = 0;  i < fullName.length(); i++) {
            if (fullName.charAt(i) == ' ') {
                checker = true;   
                break; 
                } 
            }
        } 
        
        return fullName;
        
        } catch (IOException ex) {
        System.out.println("Something went wrong with input");}
    
    return fullName;
    }

// method to ask for input to generate date of birth as string//
// while loop set to boolean condition will keep asking for input until correct format is used//
// inner for loop goes through user input and checks ASCII values - and will change boolean condition for outer while loop//

public static String generateDOB (Scanner userInput) {

String DOB = new String();
boolean checker = false;
int counter = 0;

    System.out.println("\n" +"Enter your DOB in format MM/DD/YYYY"); 
    while (checker == false) { 
            
            counter = 0;   
            DOB = userInput.nextLine();        
            
            for (int i =0; i < DOB.length(); i++) {
                 char valueCheck  = DOB.charAt(i);
                 int ascIIval = (int)valueCheck;
                 
                 if (ascIIval >= 47 && ascIIval <= 57) {
                     counter ++;
                    }
                 
                    }
            
            if (counter == 10) {
                 checker = true;
                 
            }
   
        }
        System.out.println("DOB entered is: " + DOB + "\n");  
        return DOB;
    }
  
//while loop runs until boolean variable checker changes//
//inner for loop ensures that only desired characters are used and counts input//
//if conditions for input are met while loop is exited and phone number is returned as string//
public static String takeNumber (Scanner userInput) {

String phoneNumber = new String();
boolean checker = false;
int counter = 0;

    while (checker == false) { 
                   
            System.out.println("\n" + "Enter your phone number in format xxx-xxx-xxxx");    
            phoneNumber = userInput.nextLine(); 
            for (int i =0; i < phoneNumber.length(); i++) {
                 char valueCheck  = phoneNumber.charAt(i);
                 int ascIIval = (int)valueCheck;
                 
                 if (ascIIval >= 47 && ascIIval <= 57 || ascIIval == 45) {
                     counter ++;
                    }
                             }
                 if (counter == 12) {
                 checker = true;
                 break;
                    }                       
        System.out.println("number entered is: " + phoneNumber + "\n");        
        }
        
        return phoneNumber;
}

//NEED TO MAKE SURE checkingBalance is DOUBLE//
public static double setChecking(Scanner userInput) {

double checkingBalance = 0;
boolean checker = false;
    
while (checker == false) {
    try { 

        while (checker == false) { 
            System.out.println("Enter initial amount to deposit");    
            checkingBalance = userInput.nextDouble();   
            
            if (checkingBalance != 0) {
                checker = true;
                break;               
            } 
        }
        
        System.out.println("Amount in account is now " + checkingBalance + "\n");
        return checkingBalance;  
    } catch ( InputMismatchException e) {
        System.out.println("Only number inputs and '.' allowed!");
        } 
    }


    return checkingBalance;
}

// NEED TO MAKE SURE savingsBalance is DOUBLE//
public static double setSavings(Scanner userInput){

double savingsBalance = 0;
boolean checker = false;
    
while (checker == false) {
    try { 

        while (checker == false) { 
            System.out.println("Enter initial amount to deposit");    
            savingsBalance = userInput.nextDouble();   
            
            if (savingsBalance != 0) {
                checker = true;
                break;               
            } 
        }
        
        System.out.println("Amount in account is now " + savingsBalance + "\n");
        return savingsBalance;  
    } catch ( InputMismatchException e) {
        System.out.println("Only number inputs and '.' allowed!");
        } 
    }


    return savingsBalance;
}


public static void storeAccounts (account account) {

ArrayList <account> storeAccount = new ArrayList <account>();

storeAccount.add(account);

}


}
