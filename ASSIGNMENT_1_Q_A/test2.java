// Account.java
abstract class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}

// SavingsAccount.java
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(double amount) {
        double interest = amount * interestRate / 100;
        setBalance(getBalance() + amount + interest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}

// CurrentAccount.java
class CurrentAccount extends Account {
    private double overdraftLimit;

    // An overdraft occurs when you don't have enough money in your account to cover
    // a transaction, but the bank pays the transaction anyway.
    // Overdraft limit account is a running account in which you can deposit/
    // withdraw amount anytime up to the specified limit. The bank levies the
    // interest on the overdraft amount used by the borrower at predefined rate. The
    // interest is calculated daily and billed/debited to your on
    public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    //
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Exceeded overdraft limit.");
        }
    }
}

// BankingApplication.java
public class test2 {
    public static void main(String[] args) {
        // Create instances of SavingsAccount and CurrentAccount
        Account savingsAccount = new SavingsAccount(1234, 1000, 5.0);
        Account currentAccount = new CurrentAccount(1234, 2000, 500);

        // Deposit and withdraw from savings account
        savingsAccount.deposit(500);
        savingsAccount.withdraw(200);
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());

        System.out.println();

        // Deposit and withdraw from current account
        currentAccount.deposit(1000);
        currentAccount.withdraw(2500);
        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Current Account Balance: " + currentAccount.getBalance());
        // currentAccount.withdraw(1000);
        // System.out.println("Current Account Balance: " +
        // currentAccount.getBalance());

        System.out.println();

    }
}
