public class FruitListController {
	public static Fruit findById(FruitList fruits, int id) {
		Fruit target;

		target = fruits.stream().filter(f -> (id == f.id)).findFirst().orElse(null);
		return target;
	}

	public static void addFruitToList(FruitList fruits, String name, int p, int q, String o) {
		// Lấy ID cuối cùng (bắt đầu từ 1)
		int last_id;
		try {
			last_id = fruits.get(fruits.size() - 1).id;
		} catch (IndexOutOfBoundsException e) {
			last_id = 0;
		}

		fruits.add(new Fruit(last_id + 1, name, p, q, o));
	}

	public static void addNewFruits(FruitList fruits, FruitList new_fruits) {
		fruits.addAll(new_fruits);
	}

	public static void printAll(FruitList fruits) {
		System.out.println("List of fruits:\nItem\tFruit name\tOrigin\tPrice");
		fruits.forEach(f -> System.out.printf("%d\t%s\t%s\t%d$\n", f.id, f.name, f.origin, f.price));
	}

	public static void printNewlyCreated(FruitList new_fruits) {
		System.out.println("\nList of fruits created:\nID\tName\tPrice\tQuantity\tOrigin");
		new_fruits.forEach(f -> System.out.printf("%d\t%s\t%d$\t%d\t%s\n", f.id, f.name, f.price, f.quantity, f.origin));
	}
}
