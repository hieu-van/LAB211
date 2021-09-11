import java.util.Map;

public class OrderListController {
	public static void addOrder(OrderList list, String customer, Order order) {
		list.put(customer, order);
	}

	public static void printAll(OrderList list) {
		if (list.isEmpty()) {
			System.out.println("No orders.");
			return;
		}

		list.forEach((customer, items) -> {
			System.out.println("Customer: " + customer);
			System.out.println("Product\tQuantity\tPrice\tAmount");

			int index = 0, total = 0;
			for (Map.Entry<Fruit,Integer> e : items.entrySet()) {
				Fruit f = e.getKey();
				int q = e.getValue();
				total += (f.price * q);

				System.out.printf("%d. %s\t%d\t%d$\t%d$\n", (++index), f.name, q, f.price, (f.price * q));
			}

			System.out.println("\nTotal: " + total + "$");
		});
	}
}