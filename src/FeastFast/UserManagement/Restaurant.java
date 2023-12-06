package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;
import FeastFast.OrderingAndTransactions.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// This is the Restaurant class which inherits from the User class
public class Restaurant extends User {

	// Attributes
    private String restaurantId;
    private boolean isOpen; 
    private double averageRating;
    private int totalRating;
    private String contactNumber;
    private String address;
    private Menu menu;
    private ArrayList<Order> Orders;
    private ArrayList<Review> restaurantReviews;

    public Restaurant(String name) {
    	super(name);
    	this.menu = new Menu();
    	averageRating = 0.0;
    	totalRating = 0;
    	this.restaurantReviews = new ArrayList<Review>();
    }
    
    public Restaurant(String name, String username,String password) {
    	super(name, username, password);
    	restaurantId = "";
    	contactNumber = "";
    	address = "";
    	isOpen = false;
        this.Orders = new ArrayList<>();
        this.menu = new Menu();
        this.restaurantReviews = new ArrayList<Review>();
        averageRating = 0.0;
        totalRating = 0;
    }
    
    public Restaurant() {
    	restaurantId = "";
    	name = "";
    	contactNumber = "";
    	address = "";
    	isOpen = false;
        this.Orders = new ArrayList<>();
        this.menu = new Menu();
        this.restaurantReviews = new ArrayList<Review>();
        averageRating = 0.0;
        totalRating = 0;
    }

    // Getters and setters for restaurant attributes
    public void addRating(int customerRating) {
    	this.totalRating += customerRating;
    }
    
    public int getTotalRating() {
    	return this.totalRating;
    }
    
    public double getAverageRating() {
    	return this.averageRating;
    }
    
    public void setAverageRating(double avgRating) {
    	this.averageRating = avgRating;
    }
    
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    
    public ArrayList<Review> getRestaurantReviews(){
    	return this.restaurantReviews;
    }

    public void addRestaurantReview(Review review) {
    	this.restaurantReviews.add(review);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    // Method to add a menu item
    public void addMenuItem(MenuItem item) {
        this.menu.addItem(item);
    }

    // Method to remove a menu item
    public void removeMenuItem(MenuItem item) {
        this.menu.removeItem(item);
    }

    // Method to update a menu item
    public void updateMenuItem(MenuItem item) {
        this.menu.updateItem(item);
    }

    // Method to receive an order
    public void receiveOrder(Order order) {
        this.Orders.add(order);

        order.setStatus(Order.Status.RestaurantReceived);
    }

    // Method to update the status of an order
    public void updateOrderStatus(Order order, Order.Status status) {
        order.setStatus(status);
    }

    // Method to handle customer queries
    public String handleCustomerQuery(String query) {
        // Placeholder for query handling logic
        // Implement this based on your application's requirements
        return "Response to the query: " + query;
    }

    public List<Order> viewPendingOrders() {
        return getOrders();
    }

    public boolean confirmOrder(Order pendingOrder) {

        if (Orders.contains(pendingOrder)) {
            pendingOrder.setStatus(Order.Status.RestaurantReceived);
            return true;
        }
        return false;
    }

    public ArrayList<Order> getReadyOrders() {
        ArrayList<Order> readyOrders = new ArrayList<Order>();
        for (Order o : Orders) {
            if (o.getStatus() == Order.Status.PreparingFood) {
                readyOrders.add(o);
            }
        }
        return readyOrders;
    }

}
