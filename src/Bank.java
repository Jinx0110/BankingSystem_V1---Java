import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String getName() {
        return name;
    }

    public int getCustomersCount() {
        return customers.size();
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equalsIgnoreCase(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayAllCustomers() {
        if (!customers.isEmpty()) {
            System.out.println("Bank: " + name);
            for (Customer customer : customers) {
                customer.displayCustomerInfo();
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("ERROR: Zero Accounts Found");
        }
    }
}
