public class Startup {
	private final String name;
	private final int initBal;

	public Startup(String n, int b) {
		name = n;
		initBal = b;
	}

	public String getName() {
		return name;
	}

	public int getInitBal() {
		return initBal;
	}
}
