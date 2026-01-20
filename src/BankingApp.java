import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("MyBank");

        System.out.println("Welcome to " + bank.getName() + " Banking System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Display All Customers");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                // Add Customer
                String name = "";
                while (true) {
                    System.out.print("Enter customer name: ");
                    name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty. Please enter a valid name.");
                    } else {
                        break;
                    }
                }

                String customerId = "C" + (bank.getCustomersCount() + 1);

                Customer customer = new Customer(name, customerId);

                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();

                double initialBalance = readDoubleWithValidation(scanner, "Enter initial balance (use '.' or ',' as decimal separator): ");

                double interestRate = readDoubleWithValidation(scanner, "Enter interest rate (for savings account, use '.' or ',' as decimal separator): ");

                SavingsAccount account = new SavingsAccount(accountNumber, initialBalance, interestRate);
                customer.addAccount(account);

                bank.addCustomer(customer);

                System.out.println("Customer and account created successfully!");
                System.out.println("Customer ID: " + customerId);

            } else if (choice == 2) {
                // Display all customers
                bank.displayAllCustomers();

            } else if (choice == 3) {
                // Deposit
                if (bank.getCustomersCount() == 0) {
                    System.out.println("No customers available. Please add customers first.");
                    continue;
                }
                Customer customer = selectCustomer(scanner, bank);
                if (customer == null) continue;

                SavingsAccount account = selectAccount(scanner, customer);
                if (account == null) continue;

                double amount = readDoubleWithValidation(scanner, "Enter amount to deposit: ");
                if (amount <= 0) {
                    System.out.println("Deposit amount must be positive.");
                } else {
                    account.deposit(amount);
                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                }

            } else if (choice == 4) {
                // Withdraw
                if (bank.getCustomersCount() == 0) {
                    System.out.println("No customers available. Please add customers first.");
                    continue;
                }
                Customer customer = selectCustomer(scanner, bank);
                if (customer == null) continue;

                SavingsAccount account = selectAccount(scanner, customer);
                if (account == null) continue;

                double amount = readDoubleWithValidation(scanner, "Enter amount to withdraw: ");
                if (amount <= 0) {
                    System.out.println("Withdrawal amount must be positive.");
                } else {
                    account.withdraw(amount);
                    System.out.println("Withdrawal processed. Current balance: " + account.getBalance());
                }

            } else if (choice == 5) {
                System.out.println("Thank you for using the banking system. Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static Customer selectCustomer(Scanner scanner, Bank bank) {
        System.out.println("Select a customer by entering their ID:");
        bank.displayAllCustomers();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine().trim().toUpperCase();

        Customer customer = bank.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
        }
        return customer;
    }

    private static SavingsAccount selectAccount(Scanner scanner, Customer customer) {
        if (customer.getAccounts().isEmpty()) {
            System.out.println("This customer has no accounts.");
            return null;
        }
        System.out.println("Select an account by entering the account number:");
        for (SavingsAccount acc : customer.getAccounts()) {
            System.out.println("Account Number: " + acc.getAccountNumber() + ", Balance: " + acc.getBalance());
        }
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim().toLowerCase();

        for (SavingsAccount acc : customer.getAccounts()) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    private static double readDoubleWithValidation(Scanner scanner, String prompt) {
        double value = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            // Replace comma with dot to handle decimal separator
            input = input.replace(',', '.');

            try {
                value = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number using digits and optionally '.' or ',' as decimal separator.");
            }
        }

        return value;
    }
}
