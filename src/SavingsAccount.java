public class SavingsAccount extends Account {
    private double interestRate; // e.g., 2.5 for 2.5%
    private static final double MIN_BALANCE = 100.0;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Withdrawal denied: balance cannot go below minimum of $" + MIN_BALANCE);
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn $" + amount + " from Savings Account " + getAccountNumber());
        }
    }

    public void calculateInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of $" + interest + " added to Savings Account " + getAccountNumber());
    }
}
