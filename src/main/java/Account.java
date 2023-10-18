public abstract class Account {

    protected String accountType;
    protected double apr;
    protected double balance;

    public Account(double balance, double apr, String accountType) {
        this.apr = apr;
        this.balance = balance;
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public double getAPR() {
        return apr;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            balance = 0;
        } else {
            balance = balance - amount;
        }
    }

}
