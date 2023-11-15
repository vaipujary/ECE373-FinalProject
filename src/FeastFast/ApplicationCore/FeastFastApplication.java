package FeastFast.ApplicationCore;

import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.DeliveryDriver;
import FeastFast.UserManagement.Restaurant;

import java.util.*;

import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.Menu;

public class FeastFastApplication {
    private List<Restaurant> restaurants;
    private ArrayList<DeliveryDriver> drivers;
    // private List<Customer> customers = new ArrayList<>();

    public FeastFastApplication() {
    	restaurants = new ArrayList<>();
    	drivers = new ArrayList<DeliveryDriver>();
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
        // This could involve interacting with an SMS API
    }

    public void reportIssue(DeliveryDriver driver, Order order, String issue) {
        // Implementation to report an issue
        order.setComments(issue);
    }

    public void rateDriver(DeliveryDriver driver, int rating) {
        // Implementation to rate a driver
        driver.setRating(rating);
    }

    public void completeOrder(DeliveryDriver driver, Order order, double tipAmount) {
        // Implementation to complete an order and update driver's earnings
        driver.addEarnings(tipAmount);
        order.setStatus(Order.Status.DeliveredToCustomer);
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant selectRestaurant(String restaurantName) {
        for(Restaurant r: restaurants) {
            if (restaurantName == r.getName()) {
                return r;
            }
        }
        return restaurants.get(0);
    }
    public Customer registerCustomer(String name, String email, String password) {
        return new Customer(name, email, password);
    }
    public void placeOrder(Customer customer, Order order) {
    }
    public String trackOrder(Order order) {
        return order.getStatus().name();
    }

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


    public ArrayList<DeliveryDriver> getAvailableDeliveryDrivers() {
        ArrayList<DeliveryDriver> availableDrivers = new ArrayList<DeliveryDriver>();

        for (DeliveryDriver driver: drivers) {
            if (driver.isAvailable()) { availableDrivers.add(driver); }
        }

        return availableDrivers;
    }

    public void addDeliveryDriver(DeliveryDriver d) {
        drivers.add(d);
    }

    
}
