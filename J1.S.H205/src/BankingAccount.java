public class BankingAccount {
	private int pennies;

	public BankingAccount(Startup s) {
		pennies = s.getInitBal();
	}

	public void debit(Debit d) {
		pennies += d.getAmount();
	}

	public void credit(Credit c) {
		pennies -= c.getAmount();
	}

	public int getBalance() {
		return pennies;
	}

	public void setBalance(int pennies) {
		this.pennies = pennies;
	}
}
