package src;
import java.util.Random;

public class Account {
	private int accountNumber;
	private String accountHolderName;
	private float balance;
	
	
	Account(String name){
		Random rand = new Random();
		this.accountNumber = rand.nextInt(999999999);
		this.balance = 0;
		this .accountHolderName = name;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void deposit(float amount) {
		balance += amount;
		System.out.println(amount + " are deposited to your account, now you have " + balance);
	}
	
	public void withdraw(float amount) {
		try {
			if (amount > balance) {
				throw new Exception();
			}
			else {
				balance -= amount;
				System.out.println(amount + " are withdrawn from your account, now you have " + balance);
			}
		}
		catch(Exception e) {
			System.out.println("Insufficient Balance.");
		}
	}
	
}
