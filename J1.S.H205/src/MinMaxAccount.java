public class MinMaxAccount extends BankingAccount {
	private int min, max;

	public MinMaxAccount(Startup s) {
		super(s);
		min = s.getInitBal();
		max = s.getInitBal();
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	private void updateMinMax() {
		if (max < getBalance()) {
			max = getBalance();
		}

		if (min > getBalance()) {
			min = getBalance();
		}
	}

	public void debit(Debit d) {
		setBalance(getBalance() + d.getAmount());
		updateMinMax();
	}

	public void credit(Credit c) {
		setBalance(getBalance() - c.getAmount());
		updateMinMax();
	}
}
