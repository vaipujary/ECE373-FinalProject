package FeastFast.OrderingAndTransactions;

import java.util.HashMap;
import java.util.Map;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.UserManagement.Restaurant;

// This class calculates costs 
public class CostCalculator {
	
	// Attributes
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
    
    // Method to retrieve a driver's tip
    public double getTip() {
    	return tip;
    }
    
    // Method to set a driver's tip
    public void setTip(double tip) {
    	this.tip = tip;
    }
    
    // Method to calculate the total tip
    public double calculateTip(double percent) {
        return (tip + (percent*tip));
    }

    // Method to calculate the order total
    public double calculateTotal(HashMap<MenuItem, Integer> foodOrder) {
    	
    	for (Map.Entry<MenuItem, Integer> entry: foodOrder.entrySet()) {
    		totalCost = (entry.getKey().getPrice())*(entry.getValue());
    	}
    	
    	return totalCost;
    }
    
    // TODO: Method to calculate sales tax
    
    // TODO: Method to calculate service fee

}
