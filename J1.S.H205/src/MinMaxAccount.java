public class MinMaxAccount extends BankingAccount {
	private int min, max;

	public MinMaxAccount(Startup s) {
		super(s);
		min = s.bal;
		max = s.bal;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
}
