public class OrderController {
	// Trả về true nếu còn hàng
	public static boolean addItem(Order o, Fruit f, int q) {
		// Còn hàng không?
		if ((q <= f.quantity) && (q > 0)) {
			// Trừ bớt số lượng sẵn có
			f.quantity =- q;
			o.put(f, q);

			return true;
		}

		return false;
	}
}
