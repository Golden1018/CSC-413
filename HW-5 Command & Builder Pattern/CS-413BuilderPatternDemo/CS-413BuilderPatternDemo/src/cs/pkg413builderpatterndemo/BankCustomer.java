package cs.pkg413builderpatterndemo;

public class BankCustomer {
    // Attributes of the BankCustomer class
    private final String name;
    private final String email;
    private final String accountNumber;

    // Private constructor to enforce the use of Builder
    private BankCustomer(BankCustomerBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.accountNumber = builder.accountNumber;
    }

    // Getters for each field
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Static Builder Class
    public static class BankCustomerBuilder {
        private String name;
        private String email;
        private String accountNumber;

        // Setter methods for name, email, and accountNumber
        public BankCustomerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BankCustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public BankCustomerBuilder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        // Build method to construct and return a new BankCustomer object
        public BankCustomer build() {
            return new BankCustomer(this);
        }
    }

    // Main method to test the Builder pattern
    public static void main(String[] args) {
        BankCustomer customer = new BankCustomerBuilder()
                .setName("Golden D")
                .setEmail("GDendt1234@example.com")
                .setAccountNumber("123456789")
                .build();

        System.out.println("BankCustomer Created!!");
        System.out.println("Name:" + customer.getName());
        System.out.println("Email:" + customer.getEmail());
        System.out.println("Account Number:" + customer.getAccountNumber());
    }
}
