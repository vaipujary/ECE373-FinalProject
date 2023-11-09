package FeastFast.OrderingAndTransactions;

import FeastFast.RestaurantManagement.CustomerOrder;
import FeastFast.UserManagement.Customer;

public class Receipt {
    
	private Customer customer;
	private ShoppingCart shoppingCart;
	private CustomerOrder order;
	
	public Receipt() {
		
		customer = new Customer();
		shoppingCart = new ShoppingCart();
		order = new CustomerOrder();
		
	}
	
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}
	
	public void setShoppingCart(ShoppingCart s) {
		shoppingCart = s;
	}

	public CustomerOrder getOrder() {
		return order;
	}
	
	public void setOrder(CustomerOrder co) {
		this.order = co;
	}
	
}
