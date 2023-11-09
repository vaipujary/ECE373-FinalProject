package FeastFast.ApplicationCore;

import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.DeliveryDriver;
import FeastFast.RestaurantManagement.CustomerOrder;
// import FeastFast.OrderingAndTransactions.ShoppingCart;
import FeastFast.RestaurantManagement.Menu;

public class FeastFastApplication {
    

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

    
}
