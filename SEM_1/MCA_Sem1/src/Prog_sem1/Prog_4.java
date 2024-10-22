package Prog_sem1;

import java.util.Scanner;

class BankAccount{
	long accno = 123;
	double balance = 100;
	
	void display() {
		System.out.println("Account : "+this.accno);
		System.out.println("BAlance : "+this.balance);
	}
	
	void deposit(int money) {
		this.balance += money;
	}
	void withdraw(int money) {
		if(this.balance < money) {
			System.out.println("Insufficient Balance. No Operation Performed!!");
		} else {			
			this.balance -= money;
		}
	}
}

class SavingAccount extends BankAccount{
	void display() {
		System.out.println("Saving Account");
		System.out.println("Account : "+this.accno);
		System.out.println("BAlance : "+this.balance);
	}
}

class CurrentAccount extends BankAccount{
	void display() {
		System.out.println("Current Account");
		System.out.println("Account : "+this.accno);
		System.out.println("Balance : "+this.balance);
	}
}

public class Prog_4 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("1. Current Account   2. Saving Account");
			System.out.print("Enter your choice : ");
			int c = sc.nextInt();
			CurrentAccount ca = new CurrentAccount();
			SavingAccount sa = new SavingAccount();
			
			switch(c) {
			case 1 :
				
				System.out.println(" ");
				System.out.println("Current Account details : ");
				ca.display();
				System.out.println(" ");
				
				System.out.println("1. Deposit Account   2. Withdraw Account");
				System.out.print("Enter your choice : ");
				int c1 = sc.nextInt();
				

				switch(c1) {
				case 1:
					System.out.print("Enter your amonut : ");
					int m1 = sc.nextInt();
					ca.deposit(m1);
					System.out.println(" ");
					ca.display();
					System.out.println(" ");
					break;
				case 2:
					System.out.print("Enter your amonut : ");
					int m2 = sc.nextInt();
					ca.withdraw(m2);
					System.out.println(" ");
					ca.display();
					System.out.println(" ");
					break;
				default:
					System.out.println("Wrong choice!!");
				}
				break;
			case 2 :
				
				System.out.println(" ");
				System.out.println("Saving Account details : ");
				sa.display();
				System.out.println(" ");
				
				System.out.println("1. Deposit Account   2. Withdraw Account");
				System.out.print("Enter your choice : ");
				int c2 = sc.nextInt();
				

				switch(c2) {
				case 1:
					System.out.print("Enter your amonut : ");
					int m1 = sc.nextInt();
					sa.deposit(m1);
					System.out.println(" ");
					sa.display();
					System.out.println(" ");
					break;
				case 2:
					System.out.print("Enter your amonut : ");
					int m2 = sc.nextInt();
					sa.withdraw(m2);
					System.out.println(" ");
					sa.display();
					System.out.println(" ");
					break;
				default:
					System.out.println("Wrong choice!!");
				}
				break;
			default:
				System.out.println("Wrong choice!!");
			}
		} catch (Exception e) {
			System.out.println("Error occured with Scanner : "+e);
		}
	}

}
