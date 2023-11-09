package FeastFast.ApplicationCore;

import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.DeliveryDriver;
import FeastFast.UserManagement.Restaurant;

import java.util.ArrayList;
import java.util.List;

import FeastFast.RestaurantManagement.CustomerOrder;
// import FeastFast.OrderingAndTransactions.ShoppingCart;
import FeastFast.RestaurantManagement.Menu;

public class FeastFastApplication {
    private List<Restaurant> restaurants = new ArrayList<>();;
    // private List<Customer> customers = new ArrayList<>();;

    public void addRestaurant(Restaurant r) {
        restaurants.add(r);
    }
    // Method to send SMS to a customer
    public void sendSMSToCustomer(Customer customer, String message) {
        // Implementation to send SMS
        customer.receiveSMSNotification(message);
    }

    // Method to send Email to a customer
    public void sendEmailToCustomer(Customer customer, String message) {
        // Implementation to send Email
        customer.receiveEmailNotification(message);
    }

    // Method to confirm an order
    public void confirmOrder(CustomerOrder order) {
        // Implementation to confirm the order
        order.setStatus(CustomerOrder.Status.RestaurantReceived);
    }

    // Method to get the menu
    public Menu getMenu() {
        // Implementation to return the current menu
        return new Menu(); // This should return the actual menu object
    }

    // Method to checkout an order
    public void checkoutOrder(CustomerOrder order) {
        // Implementation to checkout the order
        order.setStatus(CustomerOrder.Status.SubmittedToRestaurant);
    }

    public void sendSMS(String phoneNumber, String message) {
        // Implementation to send SMS
        // This could involve interacting with an SMS API
    }

    public void reportIssue(DeliveryDriver driver, CustomerOrder order, String issue) {
        // Implementation to report an issue
        order.setIssueReported(issue);
    }

    public void rateDriver(DeliveryDriver driver, int rating) {
        // Implementation to rate a driver
        driver.setRating(rating);
    }

    public void completeOrder(DeliveryDriver driver, CustomerOrder order, double tipAmount) {
        // Implementation to complete an order and update driver's earnings
        driver.addEarnings(tipAmount);
        order.setStatus(CustomerOrder.Status.DeliverdToCustomer);
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant selectRestaurant(String restaurantName) {
        for(Restaurant r: restaurants) {
            if (restaurantName == r.getName()) {
                return r;
            }
            
        }

        return restaurants.get(0);
    }
    public Customer registerCustomer(String name, String email, String password) {
        return new Customer(name, email, password);
    }
    public void placeOrder(Customer customer, CustomerOrder order) {
    }
    public String trackOrder(CustomerOrder order) {
        return null;
    }

    
}
