package FeastFast.RestaurantManagement;

import java.util.HashMap;
import java.util.Map;

public class CustomerOrder {

    enum Status {
        NotPlaced,
        Placed,
        Receieved,
        Preparing,
        InDelivery,
        Arrived,
        Deliverd;

        
      }

    private Status status;
    private String pickupLocation;
    private String deliveryLocation;
    private String issueReported;
    private double tip;
    private Map<MenuItem, Integer> items = new HashMap<>();
    private double totalPrice;

    public CustomerOrder() {
        // Initialize default values
        this.status = Status.NotPlaced;
        this.pickupLocation = "";
        this.deliveryLocation = "";
        this.issueReported = "";
        this.tip = 0.0;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getIssueReported() {
        return issueReported;
    }

    public void setIssueReported(String issueReported) {
        this.issueReported = issueReported;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    // Method to add an item with its quantity to the order
    public void addItem(MenuItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
        calculateTotalPrice();
    }

    // Method to calculate the total price of the order
    private void calculateTotalPrice() {
        totalPrice = items.entrySet().stream()
                          .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                          .sum() + tip;
    }

    // Method to get the total price of the order
    public double getTotalPrice() {
        return totalPrice;
    }

    // Method to clear all items from the order
    public void clearItems() {
        items.clear();
        totalPrice = 0.0;
    }

    public int getId() {
        return 0;
    }

    public Map<MenuItem, Integer> getItems() {
        return null;
    }

}
