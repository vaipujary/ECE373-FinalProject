package FeastFast.OrderingAndTransactions;

import FeastFast.RestaurantManagement.Order;
// import FeastFast.UserManagement.Customer;

public class Receipt {
    
	private Order order;
	
	public Receipt() {
		
	}

	public void setOrder(Order o) {
		this.order = o;
	}

	public Order getOrder() {
		return this.order;
	}
	
	
}
