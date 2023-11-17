package FeastFast.OrderingAndTransactions;

import java.util.HashMap;
import java.util.Map;

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
    	//restaurant = new Restaurant();
    	foodOrder = new HashMap<MenuItem, Integer>();    
    }
    
    public double getTip() {
    	return tip;
    }
    
    public void setTip(double tip) {
    	this.tip = tip;
    }
    
    public double calculateTip(double percent) {
        return (tip + (percent*tip));
    }

    public double calculateTotal(HashMap<MenuItem, Integer> foodOrder) {
    	
    	for (Map.Entry<MenuItem, Integer> entry: foodOrder.entrySet()) {
    		totalCost = (entry.getKey().getPrice())*(entry.getValue());
    	}
    	
    	return totalCost;
    }

}
