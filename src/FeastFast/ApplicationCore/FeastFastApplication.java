package FeastFast.ApplicationCore;

import FeastFast.UserManagement.Admin;
import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.DeliveryDriver;
import FeastFast.UserManagement.Restaurant;
import FeastFast.UserManagement.User;

import java.util.*;

import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class FeastFastApplication {
	 private static FeastFastApplication instance;
	
	// Attributes
	private ArrayList<Admin> administrators;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<DeliveryDriver> drivers;
    private ArrayList<Customer> customers;


	public static void main(String args[]) {
		//Test restaurants
		FeastFastApplication ffa = new FeastFastApplication();
		
		MainPage mainFrame = new MainPage(ffa);
    	mainFrame.setVisible(true);
    	
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
    	
    	// Creating new menu items to add to menus
    	MenuItem burger = new MenuItem("Burger", 5.55);
    	MenuItem fries = new MenuItem("Fries", 1.11);
    	MenuItem ketchup = new MenuItem("Ketchup", 2.00);
    	MenuItem onionRings = new MenuItem("Onion Rings", 6.55);
    	MenuItem pizza = new MenuItem("Pizza", 3.33);
    	
    	
    	
    	
		Restaurant restaurant1 = new Restaurant("McDeez");
		restaurant1.getMenu().addItem(burger);
		restaurant1.getMenu().addItem(fries);
		restaurant1.getMenu().addItem(ketchup);
		restaurant1.getMenu().addItem(onionRings);
		restaurant1.getMenu().addItem(pizza);
		
		Restaurant restaurant2 = new Restaurant("WenDeez");
		Restaurant restaurant3 = new Restaurant("DennEez");
		Restaurant restaurant4 = new Restaurant("5GuYeez");
		Restaurant restaurant5 = new Restaurant("EeGeez");
		this.addRestaurant(restaurant1);
		this.addRestaurant(restaurant2);
		this.addRestaurant(restaurant3);
		this.addRestaurant(restaurant4);
		this.addRestaurant(restaurant5);
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
    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    // Method to select a specific restaurant from a list of restaurants
    public Restaurant selectRestaurant(String restaurantName) {
        for(Restaurant r: restaurants) {
            if (restaurantName.equals(r.getName())) {
                return r;
            }
        }
        return restaurants.get(0);
    }
    
    // Method to register a customer on the application
    public Customer registerCustomer(String name, String username, String password) {
        return new Customer(name, username, password);
    }
    
    public Restaurant registerRestaurant(String name, String username, String password) {
    	return new Restaurant(name, username, password);
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
