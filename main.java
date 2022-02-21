package com.company;

import javax.print.attribute.TextSyntax;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.*;

class BankDetails
{
    private String accno;
    private String name;
    private String acc_type;
    private String balance;
    double amt;
    double bal;
    Scanner in = new Scanner(System.in);

    public void openAccount() //New account for customer
    {
        System.out.print("Enter Account No: ");
        accno = in.next();        
        System.out.print("Enter Name: ");
        name = in.next();
        System.out.print("Enter Balance: ");
        balance = in.next();
        FileWriter fwrite = new FileWriter("C:accountrequest.txt");
        fwrite.write(name);
        fwrite.write(accno);
        fwrite.write(balance);
        fwrite.close();
        System.out.print("New account waiting for authorization by Employee.");
    }

    //method to display account details
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    //method to deposit money
    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = in.nextLong();
        balance = balance + amt;
    }

    //method to withdraw money
    public void withdrawal() {

        System.out.println("Enter the amount you want to withdraw: ");
        amt = in.nextLong();
        if (bal >= amt) {
            bal = bal - amt;
            System.out.println("Balance after withdrawal: " + bal);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    //method to search an account number
    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return (true);
        } else {
            return (false);
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
    BankDetails Bank1=new BankDetails();
    Bank1.openAccount();
     /*
     String name="Jeff Turner";
     String type; // type is an char for person type
     type="This is some text";
     try {
         FileWriter fwrite = new FileWriter("C:accounts.txt");
         fwrite.write(type);
         fwrite.close();
     }
     catch (IOException e) {System.out.println("Account file not accessable!");}
     */


    //create initial accounts
    Scanner in = new Scanner(System.in); // set up keyboard input
    System.out.println("Welcome to Turner Bank.");
    System.out.println("Are you a customer or an employee?");
    System.out.println("Enter 1 for customer or 2 for employee.");
    int choice1=in.nextInt();
    switch (choice1)
        {
            case 1:
                System.out.println("1. Apply for a new account.");
                System.out.println("2. View balance on an account.");
                System.out.println("3. Withdrawal or deposit on account.");
                System.out.println("4. Transfer money to another account.");
                System.out.println("5. Accept money from another account.");
                break;
            case 2:
                System.out.println("1. Approve or reject new account.");
                System.out.println("2. View Customer's Bank Accounts.");
                System.out.println("3. View log of all Transactions.");
        }
    int choice2=in.nextInt();
    if (choice2==1)
        {Bank1.openAccount();
         break;}
    if (choice2==2)
        {Bank1.showAccount();
         break;}
    if (choice2==3)
        {System.out.println("1. Withdrawal from your account.");
         System.out.println("2. Deposit to your account.");
         choice2=in.nextInt();
         if (choice2==1)
             {Bank1.withdrawal();
              break;}
         if (choice2==2)
             {Bank1.deposit();
              break;}
        }
    if (choice2==4)
       {System.out.println("What is the account number that you wish to transfer to?");
        int transferacc=in.nextInt();
        System.out.println("How much do you want to transfer?");
        double transferamt=in.nextDouble();
	if (transferamt>balance)
             System.out.println("You don't have enough money for the transfer.");
             break;
        balance=-tranferamt;
        FileWriter fwrite = new FileWriter("C:transferrequest.txt");
        fwrite.write(transferacc);
        fwrite.write(transferamt);
        fwrite.close();
        System.out.print("Transfer complete.");
       }




}

