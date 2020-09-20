package sales;

public class SalesItem {
	String itemName;
	double cost;
	int quantity;
	
	
	// Constructor
	/**
	 * @param itemName
	 * @param cost
	 * @param quantity
	 */
	public SalesItem(String itemName, double cost, int quantity) {
		this.itemName = itemName;
		this.cost = cost;
		this.quantity = quantity;
	}

	// Getters only
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String i,c,q;
		i = itemName;
		c = String.valueOf(cost);
		q = String.valueOf(quantity);
		return String.format("%-20s%-20s%-20s", i,"$"+c,q);
	}
	
}
