package FeastFast.OrderingAndTransactions;

import java.util.HashMap;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.UserManagement.Restaurant;

public class CostCalculator {
    private HashMap<MenuItem, Integer> foodOrder;    
    private Restaurant restaurant;

    private double totalCost;
    private double tip;

    public CostCalculator() {
    	tip = 0.0;
    	totalCost = 0.0;
    	restaurant = new Restaurant();
    	foodOrder = new HashMap<MenuItem, Integer>();    
    }
    
    public double calculateTip(double percent) {
        return 0.0;
    }

    public double calculateTotal() {
        return (totalCost + tip);
    }

}
