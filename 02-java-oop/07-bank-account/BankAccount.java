
public class BankAccount {

    private double checking_balance;
    private double savings_balance;
    private static int accountTotal;
    private static double balance = 0;

    public BankAccount () {
        checking_balance = 0.0;
        savings_balance = 0.0;
        accountTotal++;
        System.out.println("This banking location has " + accountTotal + " active user account(s)." );
    }
    
    public double get_checking_balance() {
        return (checking_balance);
    }

    public double get_savings_balance() {
        return (savings_balance);
    }

    public void deposit(double money, String account){
        if (account == "checking") {
            this.checking_balance += money;
        }
        if (account == "savings"){
            this.savings_balance += money;
        }
        balance += money;
    }


    public void withdraw (double money, String account) {
        if (account == "checking") {
            if (this.checking_balance < money) {
                System.out.println("The amount you are seeking to withdraw from your checking account, $" + money + ",  exceeds your current balance of $" + checking_balance + ".  Please try again.");
            }
            else {
                this.checking_balance -= money;
                balance -= money;
            }
        }
        if (account == "savings") {

            if (this.savings_balance < money) {
                System.out.println("The amount you are seeking to withdraw from your savings account, $" + money + ", exceeds your current balance of $" + savings_balance + ".  Please try again.");
            }
            else {
                this.savings_balance -= money;
                balance -= money;
            }

        }

    }

    
    public void display_balances() {
        System.out.println("Your current checking account balance is: $" + checking_balance + ".");
        System.out.println("Your current savings account balance is: $" + savings_balance + ".");
        System.out.println("The total amount of money you have in your account is: $" + balance + ".");
    }
    
        
}

