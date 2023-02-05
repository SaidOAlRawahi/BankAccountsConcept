package src;


public class CheckingAccount extends Account{
	private float limit;
	
	CheckingAccount(String name, float limit) {
		super(name);
		this.limit = limit;
	}
	
	@Override
	public void withdraw(float amount) {
		try {
			if (amount > getBalance()) {
				throw new Exception();
			}
			else if (amount > limit) {
				throw new Exception("limit_exceeded");
			}
			else {
				setBalance(getBalance() - amount);
				System.out.println(amount + " are withdrawn from your account, now you have " + getBalance());
			}
		}
		catch(Exception e) {
			System.out.println("withdraw is larger than the balance or the limit.");
		}
	}
}
