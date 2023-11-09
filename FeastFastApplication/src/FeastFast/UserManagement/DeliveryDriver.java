package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.CustomerOrder;

public class DeliveryDriver {

    private boolean isAvailable;
    private String currentLocation;
    private String phoneNumber;
    private int rating;
    private double earnings;

    public DeliveryDriver() {
        // Initialize default values
        this.isAvailable = false;
        this.currentLocation = "";
        this.phoneNumber = "000-000-0000"; // Placeholder value
        this.rating = 0;
        this.earnings = 0.0;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void moveToLocation(String location) {
        // Simulate moving to a location
        this.currentLocation = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getEarnings() {
        return earnings;
    }

    public void addEarnings(double amount) {
        this.earnings += amount;
    }

    // Method to simulate accepting an order
    public void acceptOrder(FeastFast.RestaurantManagement.CustomerOrder order) {
        if (isAvailable) {
            order.setStatus(CustomerOrder.Status.InDelivery);
        }
    }

    // Method to simulate picking up an order
    public void pickUpOrder(FeastFast.RestaurantManagement.CustomerOrder order) {
        // Logic to handle order pickup
    }

    // Method to simulate delivering an order
    public void deliverOrder(FeastFast.RestaurantManagement.CustomerOrder order) {
        // Logic to handle order delivery
        addEarnings(order.getTip()); // Assuming there is a getTip method in CustomerOrder
        order.setStatus(CustomerOrder.Status.DeliverdToCustomer);

    }

    // Method to simulate reporting an issue
    public void reportIssue(FeastFast.RestaurantManagement.CustomerOrder order, String issue) {
        order.setIssueReported(issue); // Assuming there is a setIssueReported method in CustomerOrder
    }

    // Method to simulate completing an order
    public void completeOrder(FeastFast.RestaurantManagement.CustomerOrder order, double tipAmount) {
        // Logic to complete the order
        addEarnings(tipAmount);
    }

    // Method to simulate rating a driver
    public void rateDriver(int newRating) {
        setRating(newRating);
    }
}

