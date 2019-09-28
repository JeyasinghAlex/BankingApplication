import java.util.Scanner;

public class BankWebsite {
   static Customer customer[] = new Customer[3];
    static int count = 100;
    public static void main(String[] args) {
        //Customer customer[] = new Customer[3];
        Scanner scan = new Scanner(System.in);
        System.out.println("--------Welcome-------");
        System.out.println("Please select an option:");
        System.out.println("1) Sign up");
        System.out.println("2) Sign in");
        System.out.println("3) Check top users");
        System.out.print("Your selection: ");
        int selection = scan.nextInt();
        //Customer alex = new Customer();
        // alex.id = id++;
        // System.out.println("ok");
        customer[0] = new Customer(count++);//100->101
        customer[1] = new Customer(count++);//101->102
        customer[2] = new Customer(count++);//102
        switch(selection) {
            case 1: {
                customer[0].addCustomer();
                break;
            }
            case 2: {
                customer[0].verifyCustomer();
                break;
            }
        }
        System.out.println("Customer 0");
        System.out.println(customer[0].balance);
        System.out.println("Customer 1");
        System.out.println(customer[1].balance);
        System.out.println("Customer 2");
        System.out.println(customer[2].balance);
    }
    public static boolean transferAmount(int accountNumber, int amount){
        boolean result = false;
        for(int i = 0; i < customer.length; i++){
            if(customer[i].accountNumber == accountNumber){
                customer[i].depositAmount(amount);
                result = true;
                break;
            }
        }
        if(result == true){
            return true;
        }else{
            return false;
        }

    }
}
