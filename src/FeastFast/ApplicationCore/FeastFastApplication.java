package FeastFast.ApplicationCore;

import FeastFast.UserManagement.Admin;
import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.DeliveryDriver;
import FeastFast.UserManagement.Restaurant;
import FeastFast.UserManagement.User;

import java.util.*;

import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.Menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class FeastFastApplication {
	
	// Attributes
	private ArrayList<Admin> administrators;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<DeliveryDriver> drivers;
    private ArrayList<Customer> customers;


	public static void main(String args[]) {
		
		FeastFastApplication ffa = new FeastFastApplication();
//		  JUnitCore junit = new JUnitCore();
//		  junit.addListener(new TextListener(System.out));
//		  Result result = junit.run(FeastFastApplication.class); 
//		  if (result.getFailureCount() > 0) {
//		    System.out.println("Test failed.");
//		    System.exit(1);
//		  } else {
//		    System.out.println("Test finished successfully.");
//		    System.exit(0);
//		  }
		}

    public FeastFastApplication() {
    	administrators = new ArrayList<Admin>();
    	restaurants = new ArrayList<Restaurant>();
    	drivers = new ArrayList<DeliveryDriver>();
    	customers = new ArrayList<Customer>();
		
    	MainPage mainFrame = new MainPage();
    	mainFrame.setVisible(true);
    	
//		LoginPage loginFrame = new LoginPage();
//		loginFrame.setVisible(true);
    }
    
    public void addCustomer(Customer c) {
    	customers.add(c);
    }
    
    public ArrayList<Customer> getCustomers(){
    	return this.customers;
    }
    
    public void addRestaurant(Restaurant r) {
        restaurants.add(r);
    }

    // Method to confirm an order
    public void confirmOrder(Order order) {
        // Implementation to confirm the order
        order.setStatus(Order.Status.RestaurantReceived);
    }

    // Method to get the menu
    public Menu getMenu() {
        // Implementation to return the current menu
        return new Menu(); // This should return the actual menu object
    }

    // Method to checkout an order
    public void checkoutOrder(Order order) {
        // Implementation to checkout the order
        order.setStatus(Order.Status.SubmittedToRestaurant);
    }

    public void sendSMS(String phoneNumber, String message) {
        // Implementation to send SMS
        // TODO
    }

    public void reportIssue(DeliveryDriver driver, Order order, String issue) {
        // Implementation to report an issue
        order.setComments(issue);
    }

    // Method to rate a delivery driver
    public void rateDriver(DeliveryDriver driver, int rating) {
        // Implementation to rate a driver
        driver.setRating(rating);
    }

    public void completeOrder(DeliveryDriver driver, Order order, double tipAmount) {
        // Implementation to complete an order and update driver's earnings
        driver.addEarnings(tipAmount);
        order.setStatus(Order.Status.DeliveredToCustomer);
    }
    
    // Method to retrieve all the restaurants in the application
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    // Method to select a specific restaurant from a list of restaurants
    public Restaurant selectRestaurant(String restaurantName) {
        for(Restaurant r: restaurants) {
            if (restaurantName == r.getName()) {
                return r;
            }
        }
        return restaurants.get(0);
    }
    
    // Method to register a customer on the application
    public User registerUser(String name, String username, String password) {
        return new User(name, username, password);
    }
    
    // Method for a customer to place an order with a restaurant
    public void placeOrder(Customer customer, Order order) {
    }
    
    // Method for customer to track their order
    public String trackOrder(Order order) {
        return order.getStatus().name();
    }

    // Method to send a confirmation email to customers
    public boolean sendEmailToCustomer(Customer customer, Order order) {
      
    	try {
    		if(customer.getEmail() != null) {
    			new EmailService("smtp.gmail.com", 587, "feastfastapplication@gmail.com", "tssu ybfh cdjs odsv").sendMail("feastfastapplication@gmail.com", customer.getEmail(),"Confirmation Email from Feast Fast Application","Dear " + customer.getName() + ",\nThank you for ordering from Feast Fast. You will receive updates about your order shortly.");
    			return true;
    		}
    		else {
    			return false;
    		}
    	} 
    	
    	catch (Exception e) {
			e.printStackTrace();
			return false;
		}      
 }

    // Method to retrieve the list of available drivers
    public ArrayList<DeliveryDriver> getAvailableDeliveryDrivers() {
        ArrayList<DeliveryDriver> availableDrivers = new ArrayList<DeliveryDriver>();

        for (DeliveryDriver driver: drivers) {
            if (driver.isAvailable()) { availableDrivers.add(driver); }
        }

        return availableDrivers;
    }

    // Method to add a new delivery driver
    public void addDeliveryDriver(DeliveryDriver d) {
        drivers.add(d);
    }

    
}
