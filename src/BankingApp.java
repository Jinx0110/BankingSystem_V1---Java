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
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
//                System.out.print("Enter customer name: ");
//                String name = scanner.nextLine();
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
                bank.displayAllCustomers();

            } else if (choice == 3) {
                System.out.println("Thank you for using the banking system. Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
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
