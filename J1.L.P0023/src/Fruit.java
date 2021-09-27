public class Fruit {
	private int id, price, quantity;
	private String name, origin;

	public Fruit(int id, String name, int price, int quantity, String origin) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.origin = origin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void update(int new_q) {
		this.setQuantity(new_q);
	}

	public Fruit pick(int q) {
		Fruit newF = new Fruit(this.getId(), this.getName(), this.getPrice(), this.getQuantity(), this.getOrigin());
		newF.setQuantity(q);

		return newF;
	}
}