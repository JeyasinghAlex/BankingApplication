
import java.util.Scanner;

public class Customer {
    static String name;
    String password;
    static Scanner scan = new Scanner(System.in);
    int balance;
    int accountNumber;
    public Customer(int customerId){
        this.accountNumber = customerId;
    }
    public void addCustomer(){
        System.out.print("Enter your name: ");
        this.name = scan.nextLine();
        System.out.print("Enter your password: ");
        this.password = scan.nextLine();

        System.out.println("Hi "+name+". Please log in...");
        this.verifyCustomer();
    }

    public void verifyCustomer(){
        System.out.println("Please enter your login details:");
        System.out.println("Enter your username: ");
        String tempName = scan.nextLine();
        if(name.equals(tempName)) {
            System.out.println("Enter your password: ");
            String tempPassword = scan.nextLine();
            if(password.equals(tempPassword)){
                System.out.println("You are successfully logged in");
                balance = 1000;
                showNextScreen();
            }
        }else{
            System.out.println("Username not found.");
        }
    }

    public void showNextScreen(){
        System.out.println("Please select an option");
        System.out.println("1) Balance enquiry");
        System.out.println("2) Withdrawal");
        System.out.println("3) Deposit");
        System.out.println("4) Transfer");
        System.out.println("5) Exit");
        System.out.print("Your selection: ");
        int selection = scan.nextInt();
        switch(selection) {
            case 1: {
                checkBalance();
                break;
            }
            case 2: {
                withdraw();
                break;
            }
            case 3: {
                deposit();
                break;
            }
            case 4: {
                transfer();
                break;
            }
            case 5: {
                return;
            }
        }

    }

    public void checkBalance(){
        System.out.println("Your balance is "+ balance);
        showNextScreen();
    }
    public void withdraw(){
        System.out.print("Enter the amount to withdraw :");
        int amount = scan.nextInt();
        if(amount < balance) {
            balance = balance - amount;
            System.out.println("Your new balance is "+ balance);
            showNextScreen();
        } else {
            System.out.println("Insufficient balance.");
            withdraw();
        }
    }
    public void deposit(){
        System.out.print("Enter the amount to deposit :");
        int amount = scan.nextInt();
        balance = balance + amount;
        showNextScreen();
    }

    public void depositAmount(int amount){
        balance = balance + amount;
    }

    public void transfer(){
        System.out.println("Enter the account number to transfer: ");
        int accountNumber = scan.nextInt();
        System.out.println("Enter the amount to transfer: ");
        int amount = scan.nextInt();
        if(amount < balance) {
            boolean result = BankWebsite.transferAmount(accountNumber, amount);
            if(result == true){
                balance = balance - amount;
                System.out.println("Successfully transferred");
                showNextScreen();
            } else {
                System.out.println("Transaction failed,No account number found");
                showNextScreen();
            }
        } else {
            System.out.println("Insufficient balance.");
            System.out.println("Would you like to deposit...?");
            System.out.println("1) Yes");
            System.out.println("2) No, I would like to exit");
            System.out.print("Your selection: ");
            int selection = scan.nextInt();
            switch(selection) {
                case 1: {
                    deposit();
                    break;
                }
                case 2: {
                    return;
                }
            }
        }
    }
}
