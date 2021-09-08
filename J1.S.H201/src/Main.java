import java.util.Scanner;

public class Main {
	private static final Scanner in = new Scanner(System.in);

	private static Employee emp = null;
	private static DiscountBill d_bill = null;

	private static void initialize() {
		// Create a new discount bill
		emp = new Employee("Employee 69");
		d_bill = new DiscountBill(emp, true);

		// Create some items and put them in the bill
		d_bill.add(new Item("Item 01", 1.35, 0.25));
		d_bill.add(new Item("Item 02", 4.48, 1.23));
		d_bill.add(new Item("Item 03", 6.25, 3.11));
	}

	public static void main(String[] args) {
		initialize();

		System.out.println("1. Get total");
		System.out.println("2. Get number of items discounted");
		System.out.println("3. Get discount amount");
		System.out.println("4. Get discount percent");

		do {
			System.out.print("\nChoose an option: ");
			int o = in.nextInt(); in.nextLine();

			switch (o) {
				case 1:
					System.out.println(d_bill.getTotal());
					break;
				case 2:
					System.out.println(d_bill.getDiscountCount());
					break;
				case 3:
					System.out.println(d_bill.getDiscountAmount());
					break;
				case 4:
					System.out.println(d_bill.getDiscountPercent());
					break;
				default:
					System.exit(0);
			}
		} while (true);
	}
}