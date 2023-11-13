package FeastFast.RestaurantManagement;

import java.util.HashMap;

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

    private HashMap<MenuItem, Integer> foodOrder;
    
    private CostCalculator costCalculator;

    public Order() {
        // Initialize default values
        this.status = Status.NotPlaced;
        foodOrder = new HashMap<MenuItem, Integer>();
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
    public HashMap<MenuItem, Integer> getFoodItems() {
        return this.foodOrder; // Return a copy for encapsulation
    }


    // Getter and setter for costCalculator
    public CostCalculator getCostCalculator() {
        return costCalculator;
    }

    public void setCostCalculator(CostCalculator costCalculator) {
        this.costCalculator = costCalculator;
    }

    // Method to find a MenuItem by its name
    public MenuItem findMenuItemByName(String itemName) {
        for (MenuItem item : foodOrder.keySet()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Return null if the item is not found
    }

    // Method to add an item to the order
    public void addItem(MenuItem item, int quantity) {
        Integer itemQuantity = foodOrder.getOrDefault(item, 0);

        if (itemQuantity == 0) {
            foodOrder.put(item, quantity);
        }
        else {
            foodOrder.put(item, quantity + itemQuantity);

        }
    }

    // Method to add an item to the order
    public void addItem(MenuItem item) {
        foodOrder.put(item, foodOrder.getOrDefault(item, 0) + 1);
    }

    // Method to remove an item from the order
    public void removeItem(MenuItem item) {
        foodOrder.remove(item);
    }

    // Method to remove an item from the order
    public void removeItem(String itemName) {
        MenuItem item = findMenuItemByName(itemName);
        foodOrder.remove(item);
    }

    // Method to update the quantity of an item in the order
    public void updateQuantity(String itemName, int newQuantity) {
        MenuItem item = findMenuItemByName(itemName);
        updateQuantity(item, newQuantity);
    }

    // Method to update the quantity of an item in the order
    public void updateQuantity(MenuItem item, int newQuantity) {
        if (foodOrder.containsKey(item)) {
            foodOrder.put(item, newQuantity);
        }
    }

    // Method to get the quantity of an item in the order
    public int getQuantityOfItem(String itemName) {
        MenuItem item = findMenuItemByName(itemName);
        return foodOrder.getOrDefault(item, 0);
    }

    // Method to get the quantity of an item in the order
    public int getQuantityOfItem(MenuItem item) {
        return foodOrder.getOrDefault(item, 0);
    }

    // Method to check if an item is in the order
    public boolean containsItem(String itemName) {
        MenuItem item = findMenuItemByName(itemName);
        return foodOrder.containsKey(item);
    }

    // Method to check if an item is in the order
    public boolean containsItem(MenuItem item) {
        return foodOrder.containsKey(item);
    }

    // Method to calculate the total price of the order
    public double getTotalPrice() {
        return 0.0;
    }

    // Method to check if the order is placed
    public boolean isPlaced() {
        return this.status != Status.NotPlaced;
    }

    // Existing setStatus method...

    // Method to get a copy of the items in the order
    public HashMap<MenuItem, Integer> getItems() {
        return new HashMap<>(foodOrder);
    }
    

}
