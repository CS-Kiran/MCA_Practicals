package Prog_sem1;

interface Depositable {
    void deposit(double amount);
}

interface Withdrawable {
    void withdraw(double amount);
}

interface InterestCalculable {
    double calculateSI(double principal, double rate, int time);
}

abstract class Account {
    int accountNumber;
    double balance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

// Saving Account class
class SavingAcc extends Account implements Depositable, Withdrawable, InterestCalculable {
    double interestRate;

    public SavingAcc(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

	public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double calculateSI(double principal, double rate, int time) {
        return (principal * rate * time) / 100;
    }
}

class CurrentAcc extends Account implements Depositable, Withdrawable {
    public CurrentAcc(int accountNumber) {
        super(accountNumber);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
    	if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class Prog6 {
    public static void main(String[] args) {
        SavingAcc savingAccount = new SavingAcc(1234, 5.0);
        CurrentAcc currentAccount = new CurrentAcc(1452);

        savingAccount.deposit(1000);
        savingAccount.withdraw(200);
        double si = savingAccount.calculateSI(savingAccount.getBalance(), savingAccount.interestRate, 2);
        System.out.println("Simple Interest for 2 years: " + si);

        currentAccount.deposit(500);
        currentAccount.withdraw(600);
    }
}
