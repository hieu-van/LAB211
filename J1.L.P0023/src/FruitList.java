import java.util.ArrayList;

public class FruitList extends ArrayList<Fruit> {
	public Fruit findById(int id) {
		Fruit target;

		target = this.stream().filter(f -> (id == f.getId())).findFirst().orElse(null);
		return target;
	}

	public void addFruitToList(String name, int p, int q, String o) {
		// Lấy ID cuối cùng (bắt đầu từ 1)
		int last_id;
		try {
			last_id = this.get(this.size() - 1).getId();
		} catch (IndexOutOfBoundsException e) {
			last_id = 0;
		}

		this.add(new Fruit(last_id + 1, name, p, q, o));
	}

	public void addNewFruits(FruitList new_fruits) {
		this.addAll(new_fruits);
	}

	public void printNewlyCreated() {
		System.out.println("\nList of fruits created:\nID\tName\tPrice\tQuantity\tOrigin");
		this.forEach(f -> System.out.printf("%d\t%s\t%d$\t%d\t%s\n", f.getId(), f.getName(), f.getPrice(), f.getQuantity(), f.getOrigin()));
	}
}