public class Person {
	private String name;
	private String address;
	private float salary;

	Person(String n, String a, float s) {
		name = n;
		address = a;
		salary = s;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public float getSalary() {
		return salary;
	}
}
