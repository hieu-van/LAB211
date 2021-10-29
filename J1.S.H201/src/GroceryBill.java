import java.util.ArrayList;

public class GroceryBill {
	public Employee clerk;
	public ArrayList<Item> items = new ArrayList();

	public GroceryBill(Employee clerk) {
		this.clerk = clerk;
	}

	public void add(Item i) {
		items.add(i);
		System.out.printf("Added %s, price: %f, discount rate: %f.\n", i.getName(), i.getPrice(), i.getDiscount());
	}

	public double getTotal() {
		double t = 0;
		
		for (Item i : items) {
			t += i.getPrice();
		}

		return t;
	}

	public void printReceipt() {
		System.out.println("List of items:");
		items.forEach(i -> {
			System.out.printf("%s %20s\n", i.getName(), i.getPrice());
		});
	}
}
