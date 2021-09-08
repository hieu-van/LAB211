public class DiscountBill extends GroceryBill {
	public boolean preferred;

	public DiscountBill(Employee cl, boolean preferred) {
		super(cl);
		this.preferred = preferred;
	}

	public int getDiscountCount() {
		int c = 0;

		for (Item i : items) {
			if (i.getDiscount() > 0) {
				c++;
			}
		}
		
		return c;
	}

	public double getDiscountAmount() {
		double d = 0;

		for (Item i : items) {
			if (i.getDiscount() > 0) {
				d += i.getDiscount();
			}
		}

		return d;
	}

	public double getDiscountPercent() {
		return getDiscountAmount() / super.getTotal() * 100;
	}

	@Override
	public double getTotal() {
		return super.getTotal() - getDiscountAmount();
	}
}