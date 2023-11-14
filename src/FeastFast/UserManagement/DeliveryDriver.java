package FeastFast.UserManagement;

import java.util.ArrayList;
import java.util.List;

import FeastFast.RestaurantManagement.Order;

public class DeliveryDriver extends User{

    private boolean isAvailable;
    private String currentLocation;
    private String phoneNumber;
    private int rating;
    private double earnings;
    private ArrayList<Order> previousOrders = new ArrayList<Order>();

    public DeliveryDriver() {
        // Initialize default values
        this.isAvailable = true;
        this.currentLocation = "";
        // this.phoneNumber = "000-000-0000"; // Placeholder value
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
    public void acceptOrder(FeastFast.RestaurantManagement.Order order) {
        
        order.setStatus(Order.Status.InDelivery);
        order.setDeliveryDriver(this);

        previousOrders.add(order);
    }

    // Method to simulate picking up an order
    public void pickUpOrder(FeastFast.RestaurantManagement.Order order) {
        // Logic to handle order pickup
    }

    // Method to simulate delivering an order
    public void deliverOrder(Order order) {
        // Logic to handle order delivery
        this.addEarnings(order.getCostCalculator().calculateTip()); // Assuming there is a getTip method in Order
        order.setStatus(Order.Status.DeliveredToCustomer);

    }

    // Method to simulate reporting an issue
    public void reportIssue(FeastFast.RestaurantManagement.Order order, String issue) {
        order.setComments(issue); // Assuming there is a setIssueReported method in Order
    }

    // Method to simulate completing an order
    public void completeOrder(FeastFast.RestaurantManagement.Order order, double tipAmount) {
        // Logic to complete the order
        addEarnings(tipAmount);
    }

    // Method to simulate rating a driver
    public void rateDriver(int newRating) {
        setRating(newRating);
    }


    public List<Order> viewDeliveries() {
        return previousOrders;
    }
}

