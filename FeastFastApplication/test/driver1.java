package test;

import FeastFast.ApplicationCore.FeastFastApplication;
import FeastFast.OrderingAndTransactions.Review;
import FeastFast.OrderingAndTransactions.ShoppingCart;
import FeastFast.RestaurantManagement.CustomerOrder;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.Restaurant;

public class Driver {

    public static void main(String[] args) {
        // Create an instance of the FeastFastApplication to simulate the system
        FeastFastApplication feastFastApp = new FeastFastApplication();

        // Create a new customer
        Customer customer = new Customer("cust123", "John Doe", "john.doe@example.com", "123 Main St", "password123", false);
        feastFastApp.addCustomer(customer);

        // Customer logs in
        customer.logIn();

        // Customer searches for a restaurant
        Restaurant restaurant = feastFastApp.searchRestaurant("Italian Cuisine");

        // Customer views the menu
        Menu menu = restaurant.getMenu();

        // Customer adds items to the shopping cart
        ShoppingCart cart = new ShoppingCart();
        for (MenuItem item : menu.getMenuItems()) {
            cart.addItem(item, 2); // Add 2 quantities of each item
        }

        // Customer places an order
        CustomerOrder order = customer.placeOrder(cart, "Credit Card");

        // Customer tracks the order
        String orderStatus = feastFastApp.trackOrder(order.getCustomerOrderId());

        // Customer receives the order
        System.out.println("Order Status: " + orderStatus);

        // Customer writes a review
        Review review = new Review(customer.getUserId(), customer.getName(), restaurant.getRestaurantId(), restaurant.getName(), true, 5, "Great food and service!");
        feastFastApp.submitReview(review);

        // Print out the receipt for the customer
        Receipt receipt = feastFastApp.generateReceipt(order);
        System.out.println(receipt);

        // Customer logs out
        customer.logOut();
    }
}

// Note: The above classes like FeastFastApplication, Customer, Restaurant, Menu, MenuItem, ShoppingCart, CustomerOrder, Review, and Receipt are assumed to be part of the system and should be implemented with their respective attributes and methods.

