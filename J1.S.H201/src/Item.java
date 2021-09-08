public class Item {
	public String name;
	private double price, dis;

	public Item(String name, double price, double dis) {
		this.name = name;
		this.price = price;
		this.dis = dis;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return dis;
	}
}