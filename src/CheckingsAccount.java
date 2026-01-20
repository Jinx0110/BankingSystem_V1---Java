public class CheckingsAccount extends Account {
    private double overdraftLimit;

    public CheckingsAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (getBalance() - amount < -overdraftLimit) {
            System.out.println("Withdrawal denied: overdraft limit exceeded.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn $" + amount + " from Checking Account " + getAccountNumber());
        }
    }
}
