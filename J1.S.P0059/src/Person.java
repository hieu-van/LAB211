public class Person {
	private String name, address;
	private float money;

	public Person(String name, String addr, float m) {
		this.name = name;
		this.address = addr;
		money = m;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
}