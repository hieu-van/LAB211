import java.time.Instant;
import java.util.HashMap;

public class OrderList extends HashMap<String,Order> {
	public void addOrder(String customer, Order order) {
		// Thêm mốc thời gian vào sau tên của khách hàng
		customer += ("#" + Instant.now().getEpochSecond());

		this.put(customer, order);
	}

	public void printAll() {
		if (this.isEmpty()) {
			System.out.println("No orders.");
			return;
		}

		this.forEach((customer, items) -> {
			System.out.println("Customer: " + customer.split("#")[0]);
			System.out.println("Product\tQuantity\tPrice\tAmount");

			int index = 0, total = 0;
			for (Fruit f : items) {
				total += (f.getPrice() * f.getQuantity());

				System.out.printf("%d. %s\t%d\t%d$\t%d$\n", (++index), f.getName(), f.getQuantity(), f.getPrice(), (f.getPrice() * f.getQuantity()));
			}

			System.out.println("\nTotal: " + total + "$");
		});
	}
}
