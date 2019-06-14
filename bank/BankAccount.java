package bank;

public class BankAccount {
	int balance=1000;
	public int getBalance() {
		
		return balance;
	}
	public int deposit(int amount) {
		balance=balance+amount;
		return balance;
	}
	public int withdrawal(int amount) {
		balance=balance+amount;
		return balance;
	}
}
