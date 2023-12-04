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
    	totalCost = 0.0;
        for (Map.Entry<MenuItem, Integer> entry : foodOrder.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            totalCost += item.getPrice() * quantity;
        }
       
    	
    	return totalCost;
    }
    public double calculateServiceFee() {
    	//Using a temp $5 delivery fee and a 3% operating cost fee
    	double fee = (totalCost * 0.03) + 5.0;
    	totalCost = totalCost + fee;
    	return fee;
    	
    }
    
    public double calculateSalesTax() {
    	//Using AZ sales tax 5.6%
    	double tax = (totalCost * 0.056);
    	totalCost = totalCost + tax;
    	return tax;
    }
    
    // TODO: Method to calculate sales tax
    
    // TODO: Method to calculate service fee

}
