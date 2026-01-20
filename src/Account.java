public abstract class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited R" + amount + " into account " + accountNumber);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }


    public abstract void withdraw(double amount);

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
