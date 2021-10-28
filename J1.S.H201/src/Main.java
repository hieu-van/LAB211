import java.util.Scanner;

public class Main {
	private DiscountBill disBill = null;

	private void seed() {
		// Create a new discount bill
		Employee emp = new Employee("Employee 69");
		disBill = new DiscountBill(emp, true);

		// Create some items and put them in the bill
		disBill.add(new Item("Item 01", 1.35, 0.25));
		disBill.add(new Item("Item 02", 4.48, 1.23));
		disBill.add(new Item("Item 03", 6.25, 3.11));
	}

	public static void main(String[] args) {
		Main m = new Main();

		m.seed();
		DiscountBill bill = m.disBill;

		System.out.println("1. Get total");
		System.out.println("2. Get number of items discounted");
		System.out.println("3. Get discount amount");
		System.out.println("4. Get discount percent");
		System.out.println("5. Exit");

		final Scanner in = new Scanner(System.in);

		do {
			int o;
			do {
				System.out.print("\nChoose an option: ");
				try {
					o = in.nextInt();
					if (o < 1 || o > 5)
						throw new Exception();
					in.nextLine();
					break;
				} catch (Exception e) {
					System.err.println("Invalid input!");
					in.nextLine();
				}
			} while (true);

			switch (o) {
				case 1:
					System.out.println(bill.getTotal());
					break;
				case 2:
					System.out.println(bill.getDiscountCount());
					break;
				case 3:
					System.out.println(bill.getDiscountAmount());
					break;
				case 4:
					System.out.println(bill.getDiscountPercent());
					break;
				case 5:
					System.exit(0);
			}
		} while (true);
	}
}