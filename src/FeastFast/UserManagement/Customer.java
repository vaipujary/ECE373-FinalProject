package FeastFast.UserManagement;

import java.util.ArrayList;

import FeastFast.OrderingAndTransactions.Review;
import FeastFast.RestaurantManagement.Order;

// This is the customer class which inherits from the User class
public class Customer extends User {

	// Attributes
    private String phoneNumber;
    private String email;
    private Order order;
    private ArrayList<Order> pastOrders;
    private ArrayList<Review> pastReviews;
    private Restaurant restaurantInView;
    private String Address;
    private String preferredPaymentMethod;
    
    // Constructors
    public Customer() {
        this.Address = "";
        this.phoneNumber = "";
        this.email = "";
        this.preferredPaymentMethod = "";
        this.order = new Order();
        this.pastOrders = new ArrayList<Order>();
        this.pastReviews = new ArrayList<Review>();
        restaurantInView = new Restaurant();
    }

    public Customer(String name, String username,String password) {
    	super(name, username, password);
        this.Address = "";
        this.email =  "";
        this.order = new Order();
        this.preferredPaymentMethod = "";
        this.pastOrders = new ArrayList<Order>();
        this.pastReviews = new ArrayList<Review>();
    }

    public void addPastReview(Review customerReview) {
    	this.pastReviews.add(customerReview);
    }
    
    public ArrayList<Review> getPastReviews(){
    	return this.pastReviews;
    }
    
    public void addPastOrder(Order pastOrder) {
    	this.pastOrders.add(pastOrder);
    }
    
    public ArrayList<Order> getPastOrders(){
    	return this.pastOrders;
    }
    
    // Method to cancel a customer's order
    public boolean cancelOrder(Order order) {

        order.setStatus(Order.Status.Cancelled);

        if (order.getStatus() == Order.Status.Cancelled) {
            return true;
        }
        else {
            return false;
        }
    }

 // Method to set the customer's preferred payment method
    public void setPreferredPaymentMethod(String ppm) {
    	this.preferredPaymentMethod = ppm;
    }
    
    // Method to get the customer's preferred payment method
    public String getPreferredPaymentMethod() {
    	return this.preferredPaymentMethod;
    }
    
    // Method to place an order from the shopping cart
    public Order placeOrder() {
        order.setStatus(Order.Status.SubmittedToRestaurant);
        return order;
    }

    // TODO: Method to order previous order
    // TODO: Method to preorder items
    public void setOrder(Order o) {
        this.order = o;
    }

    public Order getOrder() {
        return this.order;
    }
    
    // Method for a customer to view their order details
    public Order viewOrderDetails(int orderId) {
        // Logic to view order details, possibly from a list of orders
        // For simplicity, returning a new order object
        return new Order(); // This would be replaced with actual order retrieval logic
    }

    // Method for a customer to select a restaurant from a list of restaurants
    public void selectRestaurant(Restaurant r) {
        this.restaurantInView = r;

        r.receiveOrder(order);
    }

    // Method for to get the restaurant being viewed by the customer
    public Restaurant getCurrentRestaurant() {
        return this.restaurantInView;
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getLastNotificationReceived() {
        return null;
    }

    // Method to determine the type of order
    public void selectOrderType(Order.Type t) {

        switch (t) {
            case HOME_DELIVERY:
                order.setDeliveryAddress(this.Address);
                System.out.println("Home Delivery");
                break;

            case PICKUP:
                order.setDeliveryAddress("null");
                break;

            default:
                order.setDeliveryAddress("null");

                break;
        }
        this.order.setOrderType(t);
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getAddress() {
        return this.Address;
    }

    public void specifyPickupTime(String time) {
        selectOrderType(Order.Type.PICKUP);

        this.order.setPickupTime(time);
    }
}
