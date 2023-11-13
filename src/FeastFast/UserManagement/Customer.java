package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.Order;

import java.util.function.BooleanSupplier;


public class Customer {

    private String name;
    private String phoneNumber;
    private String email;
    private Order order;
    private Boolean isLoggedIn;
    
    public Customer() {
        this.name = "";
        this.phoneNumber = "";
        this.email = "";
        this.order = new Order();
        this.isLoggedIn = true;
    }

    public Customer(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.order = new Order();
        this.isLoggedIn = true;
    }

    public boolean cancelOrder(Order order) {

        
        order.setStatus(Order.Status.Cancelled);

        if (order.getStatus() == Order.Status.Cancelled) {
            return true;
        }
        else {
            return false;
        }
    }

    // Method to place an order from the shopping cart
    public Order placeOrder() {

        order.setStatus(Order.Status.SubmittedToRestaurant);
        return order;
    }

    public void setOrder(Order o) {
        this.order = o;
    }
    public Order viewOrderDetails(int orderId) {
        // Logic to view order details, possibly from a list of orders
        // For simplicity, returning a new order object
        return new Order(); // This would be replaced with actual order retrieval logic
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

    public Boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    // Additional methods as needed for further functionality
}
