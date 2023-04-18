
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
        
        System.out.println("Welcome to the NSA Banking 8===D " + "\n" + "\n");
        
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
         
            } else { System.out.println("\n" + "Incorrect input fucko gotta use 1,2 or 3...try...AGAIN!" + "\n");
                     }
        
        } catch (InputMismatchException e) {
         initialInput =0;
         System.out.println("Incorrect input fucko, use a number!!!" + "\n");
         validInput = false; 
         welcomeScreen(userInput);
            }
    } while (validInput == false);
               
      return initialInput;  
    }


     
public static void signIn() {

    
    
    
    
}






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


    // generate a random integer/convert to string and return that value for account number
    //create an object of the Random class
    // size of the stream
    // origin of each random number
    // bound of each random number

public static String AccountNum () {
    
    Random randoGen =new Random();
       int streamSize = 1;
       int randomNumberOrigin = +1000000;
       int randomNumberBound = 9999999;
       int i = randoGen.nextInt(); 
       String accountNumber = Integer.toString(i);
       return accountNumber;
    }


// try catch block for input mismatch exception since int is being asked for//
// catch will recursively call method to start process again//
// within try block scannner is used for input, while boolean value is false//
//INT input is converted to string, then a for-loop is used to make sure that 4 digits are used//
//process ends with correct input//
public static String makePIN (Scanner userInput)  {
    
    int pin = 0;
    int pinCount =0;
    boolean checker = false;
    String PIN = new String ();
    
    try {
        while (checker == false ) {      
            System.out.println("Enter a 4 digit PIN Number");   
            pin = userInput.nextInt();
            PIN = Integer.toString(pin);
        
            for (int i = 0; i < PIN.length(); i++) {
        
            pinCount++;
            if (pinCount == 4) {
                checker = true;
                break;
                }
            }
        }
        
        System.out.println("PIN is " + PIN);
        return PIN;  
    } catch ( InputMismatchException e) {
        System.out.println("Can only input 4 digit integer, try again!" + "\n");
        makePIN(userInput);
    }
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

// method to ask for input to generate date of birth as string
// while loop set to boolean condition will keep asking for input until valid input 
// inner for loop goes through user input and checks ASCII values - then changes while loop 
// condition if all inputs are valid

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
                 if (counter == 12) {
                 checker = true;
                 break;
                    }
            }
        System.out.println("number entered is: " + phoneNumber + "\n");        
        }
        
        return phoneNumber;
}


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



        

     
