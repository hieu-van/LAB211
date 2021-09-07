import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;	// Hashtable đã lỗi thời, thay thế bằng HashMap
import java.util.Map;

public class Main {
	private static final Scanner in = new Scanner(System.in);
	private static int choice;
	private static int id_c = 0;

	private static ArrayList<Fruit> fruits = new ArrayList();
	// Trong HashMap đơn hàng, key là tên người mua, value là HashMap con
	// có key là loại quả, value là số lượng muốn mua
	private static HashMap<String,HashMap<Fruit,Integer>> orders = new HashMap();

	private static void createFruit() {
		System.out.print("Enter fruit name: ");
		String name = in.nextLine();

		System.out.print("Enter fruit price: ");
		int p = in.nextInt(); in.nextLine();

		System.out.print("Enter fruit quantity: ");
		int q = in.nextInt(); in.nextLine();

		System.out.print("Enter origin of fruit: ");
		String o = in.nextLine();

		id_c++;
		fruits.add(new Fruit(id_c, name, p, q, o));

		System.out.println("Added new fruit.");
	}

	private static void updateFruit() {
		Fruit target;

		System.out.print("Enter fruit ID: ");
		int id = in.nextInt();
		in.nextLine();

		target = fruits.stream().filter(f -> (id == f.id)).findFirst().orElse(null);
		if (target != null) {
			System.out.print("Enter new quantity of this fruit: ");
			int new_q = in.nextInt(); in.nextLine();

			target.quantity = new_q;

			System.out.println("Fruit updated.");
		} else {
			System.out.println("No fruit with such ID found.");

			add_fruit_loop_2: do {
				System.out.print("Do you want to create a new one (Yes/No)? ");
				String inp = in.next();

				switch (inp) {
					case "Yes":
						createFruit();
						break;
					case "No":
						break add_fruit_loop_2;
					default:
						System.out.println("Please enter \"Yes\" or \"No\".");
				}
			} while (true);
		}
	}

	private static void viewOrders() {
		if (orders.isEmpty()) {
			System.out.println("No orders.");
			return;
		}

		orders.forEach((customer, items) -> {
			System.out.println("Customer: " + customer);
			System.out.println("Product\tQuantity\tPrice\tAmount");

			int index = 0, total = 0;
			for (Map.Entry<Fruit,Integer> e : items.entrySet()) {
				Fruit f = e.getKey();
				int q = e.getValue();
				total += (f.price * q);

				System.out.printf("%d. %s\t%d\t%d$\t%d$", (index++), f.name, q, f.price, (f.price * q));
			}

			System.out.println("Total: " + total + "$");
		});
	}

	private static void shop() {
		HashMap<Fruit,Integer> cart = new HashMap();

		pick_fruit: do {
			System.out.println("List of fruits:\nItem\tFruit name\tOrigin\tPrice");
			fruits.forEach(f -> System.out.printf("%d\t%s\t%s\t%d$\n", f.id, f.name, f.origin, f.price));

			System.out.print("\nSelect a fruit by ID: ");
			int id = in.nextInt(); in.nextLine();
			Fruit target = fruits.stream().filter(f -> (id == f.id)).findFirst().get();

			System.out.println("You selected: " + target.name);
			System.out.print("Enter quantity: ");
			int q = in.nextInt(); in.nextLine();

			cart.put(target, q);

			System.out.print("Do you want to check out (Y/N)? ");
			String r = in.next();

			switch (r) {
				case "N":
					System.out.println();
					shop();
					break;
				case "Y":
					break pick_fruit;
			}
		} while (true);

		System.out.print("Please enter your name: ");
		String c_name = in.nextLine();

		orders.put(c_name, cart);

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
				choice = in.nextInt();
				in.nextLine();

				switch (choice) {
					case 1:
						createFruit();

						add_fruit_loop: do {
							System.out.print("Do you want to add another fruit (Y/N)? ");
							String inp = in.next();

							switch (inp) {
								case "Y":
									createFruit();
									break;
								case "N":
									break add_fruit_loop;
								default:
									System.out.println("Please enter \"Y\" or \"N\".");
							}
						} while (true);

						System.out.println("\nList of fruits created:\nID\tName\tPrice\tQuantity\tOrigin");
						fruits.forEach(f -> System.out.printf("%d\t%s\t%d$\t%d\t%s\n", f.id, f.name, f.price, f.quantity, f.origin));

						break;
					case 2:
						updateFruit();
						break;
					case 3:
						viewOrders();
						break;
					case 4:
						shop();
						break;
					case 5:
						System.exit(0);
					default:
						System.out.println("No operation with that number found. Please enter again.");
				}
			} catch (NullPointerException | NumberFormatException | InputMismatchException e) {
				System.out.println("Invalid input. Please enter again.");
				in.nextLine();
			}
		} while (true);
	}
}
