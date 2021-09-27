import java.util.ArrayList;

public class Order extends ArrayList<Fruit> {
	public boolean addItem(Fruit f, int q) {
		// Còn hàng không?

		if ((q <= f.getQuantity()) && (q > 0)) {
			// Trừ bớt số lượng sẵn có
			f.setQuantity(f.getQuantity() - q);
			this.add(f.pick(q));

			return true;
		}

		return false;
	}
}