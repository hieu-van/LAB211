import java.util.ArrayList;

public class GroceryBill {
	public Employee clerk;
	public ArrayList<Item> items = new ArrayList();

	public GroceryBill(Employee clerk) {
		this.clerk = clerk;
	}

	public void add(Item i) {
		items.add(i);
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
			System.out.println(i.name + "\t" + i.getPrice());
		});
	}
}
