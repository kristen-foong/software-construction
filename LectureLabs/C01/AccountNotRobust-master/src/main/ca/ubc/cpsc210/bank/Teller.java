package ca.ubc.cpsc210.bank;

import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;

import java.util.Scanner;

/*
 * Bank teller using Programming by Contract.
 */

public class Teller {
    private static Account cheq;
    private static Account sav;
    private static Scanner input;
    
    /*
     * Process user input
     */
    public static void main(String[] args) {
        boolean keepGoing = true;
        String command = null;
        
        init();
        
        while(keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();
            
            if(command.equals("d"))
                doDeposit();
            else if(command.equals("w"))
                doWithdrawal();
            else if(command.equals("t"))
                doTransfer();
            else if(command.equals("q"))
                keepGoing = false;  
            else
                System.out.println("Selection not valid...");
        }
        
        System.out.println("\nGoodbye!");
    }
    
    /*
     * Initialize accounts and scanner
     */
    private static void init() {
        cheq = new Account("Joe", 145.00);
        sav = new Account("Joe", 256.50);
        input = new Scanner(System.in);
    }
    
    /*
     * Display main menu of options to user
     */
    private static void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\td -> deposit");
        System.out.println("\tw -> withdraw");
        System.out.println("\tt -> transfer");
        System.out.println("\tq -> quit");
    }
    
    /*
     * Conduct a deposit transaction
     */
    private static void doDeposit() {
        Account selected = selectAccount();
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();

        /*
        if(amount >= 0.0)
            selected.deposit(amount);
        else
            System.out.println("Cannot deposit negative amount...\n");
         */

        try {
            selected.deposit(amount);
        } catch (NegativeAmountException e) {
            System.out.println("Cannot deposit negative amount...\n");
        } finally {
            printBalance(selected);
        }

    }
    
    /*
     * Conduct a withdraw transaction
     */
    private static void doWithdrawal() {
        Account selected = selectAccount();
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();

        /*
        if(amount < 0.0)
            System.out.println("Cannot withdraw negative amount...\n");
        else if(selected.getBalance() < amount)
            System.out.println("Insufficient balance on account...\n");
        else
            selected.withdraw(amount);

         */

        try {
            selected.withdraw(amount);
        } catch (NegativeAmountException e) {
            System.out.println("Cannot withdraw negative amount...\n");
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance on account...\n");
        } finally {
            printBalance(selected);
        }

    }
    
    /*
     * Conduct a transfer from one account to another
     */
    private static void doTransfer() {
        System.out.println("\nTransfer from?");
        Account source = selectAccount();
        System.out.println("Transfer to?");
        Account destination = selectAccount();
        
        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();

        /*
        if(amount < 0.0)
            System.out.println("Cannot transfer negative amount...\n");
        else if(source.getBalance() < amount)
            System.out.println("Insufficient balance on source account...\n");
        else {
            source.withdraw(amount);
            destination.deposit(amount);
        }

         */

        try {
            source.withdraw(amount);
            destination.deposit(amount);
        } catch (NegativeAmountException e){
            System.out.println("Cannot transfer negative amount...\n");
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance on source account...\n");
        } finally {
            System.out.print("Source ");
            printBalance(source);
            System.out.print("Destination ");
            printBalance(destination);
        }

        
    }
    
    /*
     * Allows user to select an account and returns selected account
     */
    private static Account selectAccount() {
        String selection = "";  // force entry into loop
        
        while(!(selection.equals("c") || selection.equals("s"))) {
            System.out.println("c for chequing");
            System.out.println("s for savings");
            selection = input.next();
            selection = selection.toLowerCase();
        }
        
        if(selection.equals("c"))
            return cheq;
        else
            return sav;        
    }
    
    /*
     * Prints balance of selected account on the screen
     */
    private static void printBalance(Account selected) {
        System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
}
