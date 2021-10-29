import java.util.Scanner;

public class Main {
	private DiscountBill disBill = null;

	private void seed() {
		// Create a new discount bill
		Employee emp = new Employee("Employee 002");
		disBill = new DiscountBill(emp, true);

		// Create some items and put them in the bill
		disBill.add(new Item("Water Bottle", 1.35, 0));
		disBill.add(new Item("Computer", 4.48, 1.23));
		disBill.add(new Item("Car", 6.25, 3.11));
		disBill.add(new Item("Mobile Phone", 15, 7.6));
		disBill.add(new Item("House", 25, 2.1));
//		disBill.add(new Item("Bicycle", 65, 3));
//		disBill.add(new Item("Wallet", 8, 1.4));
//		disBill.add(new Item("Chair", 18, 2.5));
	}

	public static void main(String[] args) {
		Main m = new Main();

		m.seed();
		DiscountBill bill = m.disBill;

		System.out.println("\n1. Get total");
		System.out.println("2. Get number of items discounted");
		System.out.println("3. Get discount amount");
		System.out.println("4. Get discount percent");
		System.out.println("5. Exit");
		System.out.println("6. Print receipt");

		final Scanner in = new Scanner(System.in);

		do {
			int o;
			do {
				System.out.print("\nChoose an option: ");
				try {
					o = in.nextInt();
					if (o < 1 || o > 6)
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
					System.out.println("Cost of all items in regular bill: " + bill.getTotal());
					break;
				case 2:
					System.out.println("Number of discounted items: " + bill.getDiscountCount());
					break;
				case 3:
					System.out.println("Total discount: " + bill.getDiscountAmount());
					break;
				case 4:
					System.out.printf("Discounted total is %.2f%% of non-discounted total.\n", bill.getDiscountPercent());
					break;
				case 5:
					System.exit(0);
				case 6:
					bill.printReceipt();
					break;
			}
		} while (true);
	}
}