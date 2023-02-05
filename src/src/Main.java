package src;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	static Account account;
	static SavingAcount savingAccount;
	static CheckingAccount checkingAccount;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter Your Name: ");
		String name = sc.next();
		float limitInt = inputNumber("for the limit");
		account = new Account(name);
		savingAccount = new SavingAcount(name);
		checkingAccount = new CheckingAccount(name, limitInt);
		boolean repeat = true;
		while(repeat) {
			System.out.println("\nSelect an account "+ name);
			System.out.println("[1] Main Account.");
			System.out.println("[2] Saving Account.");
			System.out.println("[3] Checking Account.");
			System.out.println("[4] Save Account Details And Exit.");
			String accSelection = sc.next();
			String action;
			switch(accSelection) {
			
			case "1":
				System.out.println("Selsct an Action.");
				System.out.println("[1] Check Balance.");
				System.out.println("[2] Withdraw.");
				System.out.println("[3] Deposit.");
				action = sc.next();
				switch(action) {
				case "1":
					System.out.println("Your Main Account has: " +account.getBalance());
					break;
				case "2":
					float withdrawAmount = inputNumber("to withdraw");
					account.withdraw(withdrawAmount);
					break;
				case "3":
					float depositAmount = inputNumber("to deposit");
					account.deposit(depositAmount);
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
				break;
				
			case "2":
				System.out.println("Selsct an Action.");
				System.out.println("[1] Check Balance.");
				System.out.println("[2] Withdraw.");
				System.out.println("[3] Deposit.");
				System.out.println("[4] Calculate Interest");
				action = sc.next();
				switch(action) {
				case "1":
					System.out.println("Your Main Account has: " +account.getBalance());
					break;
				case "2":
					float withdrawAmount = inputNumber("to withdraw");
					savingAccount.withdraw(withdrawAmount);
					break;
				case "3":
					float depositAmount = inputNumber("to deposit");
					savingAccount.deposit(depositAmount);
					break;
				case "4":
					float time = inputNumber("for the time");
					float rate = inputNumber("for the rate");
					System.out.println("The interest rate is:" + savingAccount.interestRate(rate, time));
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
				break;
				
			case "3":
				System.out.println("Selsct an Action.");
				System.out.println("[1] Check Balance.");
				System.out.println("[2] Withdraw.");
				System.out.println("[3] Deposit.");
				action = sc.next();
				switch(action) {
				case "1":
					System.out.println("Your Main Account has: " +account.getBalance());
					break;
				case "2":
					float withdrawAmount = inputNumber("to withdraw");
					checkingAccount.withdraw(withdrawAmount);
					break;
				case "3":
					float depositAmount = inputNumber("to deposit");
					checkingAccount.deposit(depositAmount);
					break;
				default:
					System.out.println("Invalid Input.");
					break;
				}
				break;
				
			case "4":
				try{
					FileWriter writer = new FileWriter("client data.txt");
					writer.write("===================================================================\n");
					writer.write(String.format("%20s %20s %20s\n", name , "Acount No." , "Balance"));
					writer.write(String.format("%20s %20s %20s\n", "Main Acount" , account.getAccountNumber() , account.getBalance()));
					writer.write(String.format("%20s %20s %20s\n", "Saving Acount" , savingAccount.getAccountNumber() , savingAccount.getBalance()));
					writer.write(String.format("%20s %20s %20s\n", "Checking Acount" , checkingAccount.getAccountNumber() , checkingAccount.getBalance()));
					writer.close();
				}
				catch(Exception e) {
					System.out.println("could not write file " + e);
				}
				repeat = false;
				break;
			default:
				System.out.println("Invalid Input.");
				break;
			}
		}
		
	}
	static float inputNumber(String keyWord) {
		while(true) {
			System.out.print("Enter the amount you want " + keyWord + ": ");
			String amountStr = sc.next();
			try {
			      float amountNum = Float.parseFloat(amountStr); 
			      return amountNum;
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid Input");
			}
		}
	}

}

