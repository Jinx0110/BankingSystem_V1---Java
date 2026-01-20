import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String customerId;
    private List<SavingsAccount> accounts;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<SavingsAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(SavingsAccount account) {
        accounts.add(account);
    }

    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (SavingsAccount account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
            }
        }
    }
}
