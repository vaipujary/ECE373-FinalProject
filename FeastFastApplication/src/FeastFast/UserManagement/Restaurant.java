package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.CustomerOrder;

import java.util.HashSet;
import java.util.Set;

public class Restaurant {

    private String restaurantId;
    private String name;
    private String contactNumber;
    private String address;
    private String password;
    private Menu menu;
    private Set<CustomerOrder> customerOrders;
    private boolean loggedIn;

    public Restaurant() {
        this.customerOrders = new HashSet<>();
        this.menu = new Menu();
    }

    // Getters and setters for restaurant attributes
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
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
    public void receiveOrder(CustomerOrder order) {
        this.customerOrders.add(order);
    }

    // Method to update the status of an order
    public void updateOrderStatus(CustomerOrder order, String status) {
        order.setStatus(status);
    }

    // Method to handle customer queries
    public String handleCustomerQuery(String query) {
        // Placeholder for query handling logic
        // You would need to implement this based on your application's requirements
        return "Response to the query: " + query;
    }

    // Additional methods and logic as required by your application
}
