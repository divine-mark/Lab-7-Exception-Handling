public class BankAccount {

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    // now throws a checked exception on insufficient funds
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Cannot withdraw " + amount + "; balance is " + balance,
                amount - balance);
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return accountNumber + " balance=" + balance;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 500);

        try {
            acc.deposit(250);
            System.out.println("After deposit: " + acc);

            acc.withdraw(100);
            System.out.println("After withdraw 100: " + acc);

            acc.withdraw(5000); // will throw
            System.out.println("This line is NOT reached");

        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        } finally {
            System.out.println("Final state: " + acc);
        }
    }
}