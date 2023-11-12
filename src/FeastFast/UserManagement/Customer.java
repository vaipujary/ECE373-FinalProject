package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.MenuItem;

import java.util.function.BooleanSupplier;

import FeastFast.OrderingAndTransactions.ShoppingCart;

public class Customer {

    private String name;
    private String phoneNumber;
    private String email;
    private ShoppingCart shoppingCart;
    private String lastSMSReceived;
    private String lastEmailReceived;
    private boolean askedToUpdateContactInfo;

    public Customer() {
        this.name = "";
        this.phoneNumber = "";
        this.email = "";
        this.shoppingCart = new ShoppingCart();
        this.lastSMSReceived = "";
        this.lastEmailReceived = "";
        this.askedToUpdateContactInfo = false;
    }

    public Customer(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shoppingCart = new ShoppingCart();
        this.lastSMSReceived = "";
        this.lastEmailReceived = "";
        this.askedToUpdateContactInfo = false;
    }

    public void placeOrder(Order order) {
        // Assuming the ShoppingCart has a method to calculate the total and return items
        if (!shoppingCart.isEmpty()) {
            order.setStatus(Order.Status.SubmittedToRestaurant);
            // Transfer items from the shopping cart to the order
            // and calculate the total price, etc.
            // This is a simplified version of what would be a more complex process
            shoppingCart.transferItemsToOrder(order);
            shoppingCart.clear(); // Clear the cart after placing the order
        }
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
    public Order placeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();

        shoppingCart.finalizeCart();
        shoppingCart.transferItemsToOrder(order);
        shoppingCart.clear(); // Clear the shopping cart after placing the order
        return order; // Return the newly created order
    }

    public Order placeOrder() {
        Order order = new Order();

        shoppingCart.finalizeCart();
        shoppingCart.transferItemsToOrder(order);
        shoppingCart.clear(); // Clear the shopping cart after placing the order
        return order; // Return the newly created order
    }

    public void receiveSMSNotification(String message) {
        this.lastSMSReceived = message;
        // If the phone number is unreachable, simulate asking to update contact info
        if ("unreachable_number".equals(this.phoneNumber)) {
            this.askedToUpdateContactInfo = true;
        }
    }

    public void receiveEmailNotification(String message) {
        this.lastEmailReceived = message;
    }

    public Order viewOrderDetails(int orderId) {
        // Logic to view order details, possibly from a list of orders
        // For simplicity, returning a new order object
        return new Order(); // This would be replaced with actual order retrieval logic
    }

    public void addToCart(MenuItem item, int quantity) {
        // Logic to add an item to the shopping cart
        this.shoppingCart.addItem(item, quantity);
    }

    public void addToCart(MenuItem item) {
        // Logic to add an item to the shopping cart
        this.shoppingCart.addItem(item, 1);
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getLastSMSReceived() {
        return lastSMSReceived;
    }

    public String getLastEmailReceived() {
        return lastEmailReceived;
    }

    public boolean isAskedToUpdateContactInfo() {
        return askedToUpdateContactInfo;
    }

    public String getLastNotificationReceived() {
        return null;
    }

    public BooleanSupplier isLoggedIn() {
        return null;
    }

    // Additional methods as needed for further functionality
}
