package FeastFast.OrderingAndTransactions;

import FeastFast.RestaurantManagement.Order;
// import FeastFast.UserManagement.Customer;

// This class handles the customer's receipt, which displays the customer's order along with their 
// individual prices and total cost
public class Receipt {
    
	// Attributes
	private Order order;
	
	// Constructor
	public Receipt() {
		order = new Order();
	}

	public void setOrder(Order o) {
		this.order = o;
	}

	public Order getOrder() {
		return this.order;
	}
	
	
}
