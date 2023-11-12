package FeastFast.RestaurantManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

import FeastFast.OrderingAndTransactions.CostCalculator;
import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.Restaurant;
import FeastFast.UserManagement.DeliveryDriver;

public class Order {

    public static enum Status {
        NotPlaced,
        SubmittedToRestaurant,
        RestaurantReceived,
        PreparingFood,
        InDelivery,
        ArrivedToDestination,
        DeliverdToCustomer,
        Cancelled
      }
    
    private Customer customer;
    private DeliveryDriver deliveryDriver;
    private Restaurant restaurant;

    private Status status;

    private String comments;

    private ArrayList<MenuItem> foodItems = new ArrayList<>();
    
    private CostCalculator costCalculator;

    public Order() {
        // Initialize default values
        this.status = Status.NotPlaced;
        
    }

    // Getter and setter for customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Getter and setter for deliveryDriver
    public DeliveryDriver getDeliveryDriver() {
        return deliveryDriver;
    }

    public void setDeliveryDriver(DeliveryDriver deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }

    // Getter and setter for restaurant
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // Getter and setter for status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter and setter for comments
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // Getter and setter for foodItems
    public ArrayList<MenuItem> getFoodItems() {
        return new ArrayList<>(foodItems); // Return a copy for encapsulation
    }

    public void setFoodItems(ArrayList<MenuItem> foodItems) {
        this.foodItems = new ArrayList<>(foodItems); // Create a new list for encapsulation
    }

    // Getter and setter for costCalculator
    public CostCalculator getCostCalculator() {
        return costCalculator;
    }

    public void setCostCalculator(CostCalculator costCalculator) {
        this.costCalculator = costCalculator;
    }

    
    

}
