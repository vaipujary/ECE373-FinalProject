package FeastFast.OrderingAndTransactions;

import java.util.HashMap;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.UserManagement.Restaurant;

public class CostCalculator {
    private HashMap<MenuItem, Integer> foodOrder = new HashMap<MenuItem, Integer>();    
    private Restaurant restaurant;

    private Double totalCost;
    private Double tip;

    public Double calculateTip() {
        return 0.0;
    }

}
