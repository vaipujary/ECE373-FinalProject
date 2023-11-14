package FeastFast.OrderingAndTransactions;

import java.util.HashMap;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.UserManagement.Restaurant;

public class CostCalculator {
    private HashMap<MenuItem, Integer> foodOrder = new HashMap<MenuItem, Integer>();    
    private Restaurant restaurant;

    private double totalCost;
    private double tip;

    public double calculateTip() {
        return 0.0;
    }

    public double calculateTotal() {
        return (totalCost + tip);
    }

}
