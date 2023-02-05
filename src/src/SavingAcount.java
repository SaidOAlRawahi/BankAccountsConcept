package src;

public class SavingAcount extends Account{
	SavingAcount(String name) {
		super(name);
	}
	public float interestRate(float rate, float time) {
		float interest = getBalance() * rate * time;
		return interest;
	}
}
