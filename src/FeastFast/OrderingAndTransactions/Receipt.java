package FeastFast.OrderingAndTransactions;

import FeastFast.RestaurantManagement.Order;
import FeastFast.UserManagement.Customer;

public class Receipt {
    
	private Customer customer;
	private ShoppingCart shoppingCart;
	private Order order;
	
	public Receipt() {
		
		this.customer = new Customer();
		shoppingCart = new ShoppingCart();
		order = new Order();
		
	}
	
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}
	
	public void setShoppingCart(ShoppingCart s) {
		shoppingCart = s;
	}

	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order co) {
		this.order = co;
	}

	public Customer getCustomer() {
		return this.customer;
	}
	
}
