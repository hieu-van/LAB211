public class BankingAccount {
	private int pennies = 0;

	public BankingAccount(Startup s) {
		pennies = s.bal;
	}

	public void debit(Debit d) {
		pennies += d.amount;
	}

	public void credit(Credit c) {
		pennies -= c.amount;
	}

	public int getBalance() {
		return pennies;
	}
}
