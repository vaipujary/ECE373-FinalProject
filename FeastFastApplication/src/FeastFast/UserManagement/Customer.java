package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.CustomerOrder;
import FeastFast.RestaurantManagement.MenuItem;
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

    public void placeOrder(CustomerOrder order) {
        // Assuming the ShoppingCart has a method to calculate the total and return items
        if (!shoppingCart.isEmpty()) {
            order.setStatus("Placed");
            // Transfer items from the shopping cart to the order
            // and calculate the total price, etc.
            // This is a simplified version of what would be a more complex process
            shoppingCart.transferItemsToOrder(order);
            shoppingCart.clear(); // Clear the cart after placing the order
        }
    }

    // Method to place an order from the shopping cart
    public CustomerOrder placeOrder(ShoppingCart shoppingCart) {
        CustomerOrder order = new CustomerOrder();
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

    public CustomerOrder viewOrderDetails(int orderId) {
        // Logic to view order details, possibly from a list of orders
        // For simplicity, returning a new order object
        return new CustomerOrder(); // This would be replaced with actual order retrieval logic
    }

    public void addToCart(MenuItem item, int quantity) {
        // Logic to add an item to the shopping cart
        shoppingCart.addItem(item, quantity);
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

    // Additional methods as needed for further functionality
}
