package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.CustomerOrder;
import FeastFast.OrderingAndTransactions.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Restaurant extends User {

    private String restaurantId;
    private String name;
    private String contactNumber;
    private String address;
    private String password;
    private Menu menu;
    private ArrayList<Order> Orders;
    private Set<CustomerOrder> customerOrders;
    private ArrayList<Review> restaurantReviews;
    private boolean loggedIn;

    public Restaurant() {
        this.Orders = new ArrayList<>();
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

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public void setLoggedIn(Boolean b) {
        this.isLoggedIn = b;
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
        // You would need to implement this based on your application's requirements
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
