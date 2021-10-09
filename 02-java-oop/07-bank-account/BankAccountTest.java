
class BankAccountTest {

    public static void main(String[] args) {

        BankAccount b = new BankAccount ();

        b.deposit(500.52, "checking");
        b.deposit(1000.33, "savings");
        
        System.out.println("Checking Account: $" + (b.get_checking_balance()));
        System.out.println("Savings Account: $" + (b.get_savings_balance()));

        b.withdraw (750.00, "checking");
        b.withdraw (250.00, "savings");

        b.display_balances();

        


    }



}