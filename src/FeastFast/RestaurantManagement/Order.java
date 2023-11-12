package FeastFast.RestaurantManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

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

    public Order() {
        // Initialize default values
        this.status = Status.NotPlaced;
        
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status s) {
        this.status = s;
    }

    
    }

}
