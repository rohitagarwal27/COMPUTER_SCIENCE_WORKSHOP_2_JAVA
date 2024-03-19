// Q7. Consider a scenario where you are tasked with developing a simple banking application 
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

// abstract class Account {
// private int accountNumber;
// private double balance;
// 
// public Account(int accountNumber, double balance) {
// this.accountNumber = accountNumber;
// this.balance = balance;
// }
// 
// public int getAccountNumber() {
// return accountNumber;
// }
// 
// public double getBalance() {
// return balance;
// }
// 
// public abstract void deposit(double amount);
// 
// public abstract void withdraw(double amount);
// }
// 
// SavingsAccount.java
// class SavingsAccount extends Account {
// private double interestRate;
// 
// public SavingsAccount(int accountNumber, double balance, double interestRate) {
// super(accountNumber, balance);
// this.interestRate = interestRate;
// }
// 
// public double getInterestRate() {
// return interestRate;
// }
// 
// public void deposit(double amount) {
// double interest = amount * interestRate / 100;
// super.deposit(amount + interest);
// }
// 
// public void withdraw(double amount) {
// if (amount <= getBalance()) {
// super.withdraw(amount);
// } else {
// System.out.println("Insufficient balance for withdrawal.");
// }
// }
// }

// CurrentAccount.java
// class CurrentAccount extends Account {
// private double overdraftLimit;
// 
// public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
// super(accountNumber, balance);
// this.overdraftLimit = overdraftLimit;
// }
// 
// public double getOverdraftLimit() {
// return overdraftLimit;
// }
// 
// public void deposit(double amount) {
// super.deposit(amount);
// }
// 
// public void withdraw(double amount) {
// if (amount <= getBalance() + overdraftLimit) {
// super.withdraw(amount);
// } else {
// System.out.println("Exceeded overdraft limit.");
// }
// }
// }
// 
// BankingApplication.java
// public class BankApplication {
// public static void main(String[] args) {
// Account savingsAccount = new SavingsAccount(1234, 1000, 5.0);
// Account currentAccount = new CurrentAccount(5678, 2000, 500);
// 
// Deposit and withdraw from savings account
// savingsAccount.deposit(500);
// savingsAccount.withdraw(200);
// System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
// 
// Deposit and withdraw from current account
// currentAccount.deposit(1000);
// currentAccount.withdraw(2500);
// System.out.println("Current Account Balance: " + currentAccount.getBalance());
// }
// }

abstract class Account {
    String accountNumber;
    double balance;

    // Constructor
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    // Abstract methods for deposit and withdrawal
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// SavingsAccount class
class SavingsAccount extends Account {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // Override deposit method to calculate interest
    @Override
    public void deposit(double amount) {
        double interest = amount * interestRate;
        super.balance += (amount + interest);
    }

    // Override withdrawal method to ensure sufficient balance
    @Override
    public void withdraw(double amount) {
        if (amount <= super.balance) {
            super.balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}

// CurrentAccount class
class CurrentAccount extends Account {
    private double overdraftLimit;

    // Constructor
    public CurrentAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdrawal method to check overdraft limit
    @Override
    public void withdraw(double amount) {
        if ((super.balance + overdraftLimit) >= amount) {
            super.balance -= amount;
        } else {
            System.out.println("Exceeded overdraft limit");
        }
    }

    public void deposit(double amount) {
        System.out.println(amount);
    }
}

// BankingApplication class (Main)
public class BankApplication {
    public static void main(String[] args) {
        // Create instances of SavingsAccount and CurrentAccount
        SavingsAccount savingsAccount = new SavingsAccount("SA001", 0.05);
        CurrentAccount currentAccount = new CurrentAccount("CA001", 1000);

        // Deposit and withdraw from both accounts
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(500);
        currentAccount.deposit(2000);
        currentAccount.withdraw(2500);

        // Display account details
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Balance: $" + savingsAccount.getBalance());
        System.out.println();

        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Balance: $" + currentAccount.getBalance());
    }
}