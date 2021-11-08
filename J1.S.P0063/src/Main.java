import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private Person[] people = new Person[3];

	private Person inputPersonInfo() {
		Scanner sc = new Scanner(System.in);

		String name;
		do {
			System.out.print("Enter name: ");
			name = sc.nextLine();

			if (name.isEmpty()) {
				System.err.println("Name must not be empty!");
			} else
				break;
		} while (true);

		String addr;
		do {
			System.out.print("Enter address: ");
			addr = sc.nextLine();

			if (addr.isEmpty()) {
				System.err.println("Address must not be empty!");
			} else
				break;
		} while (true);

		float sal;
		do {
			try {
				System.out.print("Enter salary: ");
				sal = sc.nextFloat();
				if (! (sal > 0)) {
					throw new InputMismatchException();
				}
				sc.nextLine();

				break;
			} catch (InputMismatchException e) {
				System.err.println("Invalid input! Please enter a positive number.");
				sc.nextLine();
			}
		} while (true);

		return new Person(name, addr, sal);
	}

	private void displayPersonInfo(Person p) {
		System.out.println("Information of person:");
		System.out.printf("Name: %s\nAddress: %s\nSalary: %.1f\n\n",
			p.getName(),
			p.getAddress(),
			p.getSalary());
	}

	private Person[] sortBySalary(Person[] people) {
		Person[] sorted = people.clone();

		for (int i = 0; i < sorted.length - 1; ++i)
			for (int j = 0; j < sorted.length - i - 1; ++j)
				if (sorted[j].getSalary() > sorted[j + 1].getSalary()) {
					Person temp = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = temp;
				}

		return sorted;
	}

	public void fnc1() {
		for (int i = 0; i < people.length; ++i) {
			people[i] = inputPersonInfo();
			System.out.println();
		}
	}

	public void fnc2() {
		people = sortBySalary(people);

		for (Person person : people) {
			displayPersonInfo(person);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.fnc1();
		m.fnc2();
	}
}