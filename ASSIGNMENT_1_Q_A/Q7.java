//  Q7. Consider a scenario where you are tasked with developing a simple banking application 
// using Java, employing the concept of polymorphism. Your application should consist of three 
// classes: Account, SavingsAccount, and CurrentAccount. The Account class serves as the 
// base class with private attributes for account number and balance, along with abstract methods 
// for deposit and withdrawal. The SavingsAccount class, a subclass of Account, should include 
// an additional attribute for interest rate and override the deposit method to calculate interest, as 
// well as override the withdrawal method to ensure a sufficient balance. Similarly, the 
// CurrentAccount class, also a subclass of Account, should incorporate an overdraft limit 
// attribute and override the withdrawal method to check the overdraft limit. Implement the 
// classes as described, ensuring proper encapsulation and abstraction. Finally, create a 
// BankingApplication class (Main) to demonstrate the polymorphic behavior by creating 
// instances of both SavingsAccount and CurrentAccount, testing deposit and withdrawal 
// operations, and displaying account details

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
// An overdraft occurs when you don't have enough money in your account to cover
// a transaction, but the bank pays the transaction anyway.
// Overdraft limit account is a running account in which you can deposit/
// withdraw amount anytime up to the specified limit. The bank levies the
// interest on the overdraft amount used by the borrower at predefined rate. The
// interest is calculated daily and billed/debited to your on
class CurrentAccount extends Account {
    private double overdraftLimit;

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
public class Q7 {
    public static void main(String[] args) {
        // Create instances of SavingsAccount and CurrentAccount
        Account savingsAccount = new SavingsAccount(1234, 1000.0, 5.0);
        Account currentAccount = new CurrentAccount(1235, 2000.0, 500.0);

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
// output
// Savings Account Details:
// Account Number: 1234
// Savings Account Balance: 1325.0
//
// Current Account Details:
// Account Number: 1234
// Current Account Balance: 500.0
//

// OR WAY

// abstract class Account {
// private int accountNumber;
// private double balance;
//
// public Account(int accountNumber, double balance) {
// this.accountNumber = accountNumber;
// this.balance = balance;
// }
//
// public void deposit(double amount) {
// balance += amount;
// }
//
// protected void setBalance(double balance) {
// this.balance = balance;
// }
//
// public abstract void withdraw(double amount);
//
// public int getAccountNumber() {
// return accountNumber;
// }
//
// public double getBalance() {
// return balance;
// }
// }
//
// SavingsAccount.java
// class SavingsAccount extends Account {
// private double interestRate;
//
// public SavingsAccount(int accountNumber, double balance, double interestRate)
// {
// super(accountNumber, balance);
// this.interestRate = interestRate;
// }
//
// @Override
// public void withdraw(double amount) {
// if (amount <= getBalance()) {
// setBalance(getBalance() - amount);
// } else {
// System.out.println("Insufficient balance for withdrawal");
// }
// }
// }
//
// CurrentAccount.java
// class CurrentAccount extends Account {
// private double overdraftLimit;
//
// public CurrentAccount(int accountNumber, double balance, double
// overdraftLimit) {
// super(accountNumber, balance);
// this.overdraftLimit = overdraftLimit;
// }
//
// @Override
// public void withdraw(double amount) {
// if (amount <= getBalance() + overdraftLimit) {
// setBalance(getBalance() - amount);
// } else {
// System.out.println("Exceeds overdraft limit for withdrawal");
// }
// }
// }
//
// BankingApplication.java
// public class Q7 {
// public static void main(String[] args) {
// SavingsAccount savingsAccount = new SavingsAccount(12345, 1000, 0.05);
// CurrentAccount currentAccount = new CurrentAccount(67890, 2000, 500);
//
// savingsAccount.deposit(500);
// savingsAccount.withdraw(200);
//
// currentAccount.deposit(1000);
// currentAccount.withdraw(3000);
//
// System.out.println("Savings Account Balance: " +
// savingsAccount.getBalance());
// System.out.println("Current Account Balance: " +
// currentAccount.getBalance());
// }
// }
//