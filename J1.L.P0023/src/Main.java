import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static final Scanner in = new Scanner(System.in);
	private static String inp;

	// Các biến chứa dữ liệu
	private static final FruitList fruits = new FruitList();
	private static final OrderList orders = new OrderList();

	private static void createFruitView() {
		final FruitList new_fruits = new FruitList();
		int p, q;
		String o;

		do {
			System.out.print("\nEnter fruit name: ");
			String name = in.nextLine();

			System.out.print("Enter fruit price: ");
			p = in.nextInt(); in.nextLine();

			System.out.print("Enter fruit quantity: ");
			q = in.nextInt(); in.nextLine();

			System.out.print("Enter origin of fruit: ");
			o = in.nextLine();

			new_fruits.addFruitToList(name, p, q, o);

			System.out.println("Added new fruit.");

			input_loop: do {
				System.out.print("\nDo you want to add another fruit (Y/N)? ");
				inp = in.nextLine();

				switch (inp) {
					case "Y":
					case "N":
						break input_loop;
					default:
						System.err.println("Please enter \"Y\" or \"N\".");
				}
			} while (true);
		} while (inp.equals("Y"));

		fruits.addNewFruits(new_fruits);
		new_fruits.printNewlyCreated();
	}

	private static void updateFruitView() {
		Fruit target;

		System.out.print("Enter fruit ID: ");
		int id = in.nextInt(); in.nextLine();

		target = fruits.findById(id);

		if (target != null) {
			System.out.print("Enter new quantity of this fruit: ");
			int new_q = in.nextInt(); in.nextLine();

			target.update(new_q);

			System.out.println("Fruit updated.");
		} else {
			System.out.println("No fruit with such ID found.");

			add_fruit_loop: do {
				System.out.print("Do you want to create a new one (Yes/No)? ");
				inp = in.nextLine();

				switch (inp) {
					case "Yes":
						createFruitView();
						break add_fruit_loop;
					case "No":
						break add_fruit_loop;
					default:
						System.err.println("Please enter \"Yes\" or \"No\".");
				}
			} while (true);
		}
	}

	private static void viewOrders() {
		orders.printAll();
	}

	private static void shopView() {
		Order new_order = new Order();
		int q;
		String rep;

		pick_fruit: do {
			select_by_id: do {
				System.out.print("\nSelect a fruit by ID: ");
				int id = in.nextInt(); in.nextLine();

				Fruit target = fruits.findById(id);

				if (target != null) {
					System.out.println("You selected: " + target.getName());

					if (target.getQuantity() > 0) {
						do {
							System.out.print("Enter quantity: ");
							q = in.nextInt(); in.nextLine();

							if (new_order.addItem(target, q)) {
								break select_by_id;
							} else {
								System.out.println("Sorry, the quantity you requested is out of availability (" + target.getQuantity() + ").");
							}
						} while (true);
					} else
						System.out.println("Sorry, this item is out of stock.");
				} else {
					System.out.println("No product with such ID found.");
				}
			} while (true);

			input_loop: do {
				System.out.print("Do you want to check out (Y/N)? ");
				rep = in.nextLine();

				switch (rep) {
					case "Y":
						break pick_fruit;
					case "N":
						break input_loop;
					default:
						System.err.println("Please enter \"Y\" or \"N\".");
				}
			} while (true);
		} while (true);

		System.out.print("\nPlease enter your name: ");
		String c_name = in.nextLine();

		orders.addOrder(c_name, new_order);

		System.out.println("Order placed.");
	}

	public static void main(String[] args) {
		System.out.println("FRUIT SHOP SYSTEM");
		System.out.println("\t1. Create fruit");
		System.out.println("\t2. Update fruit");
		System.out.println("\t3. View orders");
		System.out.println("\t4. Shopping (for buyer)");
		System.out.println("\t5. Exit");

		do {
			try {
				System.out.print("\nSelect an operation: ");
				int choice = in.nextInt();
				in.nextLine();

				switch (choice) {
					case 1 -> createFruitView();
					case 2 -> updateFruitView();
					case 3 -> viewOrders();
					case 4 -> shopView();
					case 5 -> System.exit(0);
					default -> System.err.println("No operation with that number found. Please enter again.");
				}
			} catch (NullPointerException | NumberFormatException | InputMismatchException e) {
				System.err.println("Invalid input. Please enter again.");
				in.nextLine();
			}
		} while (true);
	}
}
