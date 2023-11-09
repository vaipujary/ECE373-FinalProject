package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.Restaurant;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.CustomerOrder;
import FeastFast.ApplicationCore.FeastFastApplication;
import FeastFast.OrderingAndTransactions.ShoppingCart;

class UseCasesTestCases {

    private FeastFastApplication app;
    private Customer customer;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        app = new FeastFastApplication();
        customer = new Customer();
        customer.setName("John Doe");
        
        cart = new ShoppingCart();
        
        // Set up the application with some restaurants
        Restaurant italianRestaurant = new Restaurant();
        italianRestaurant.setName("Italian Place");
        italianRestaurant.setMenu(new Menu());
        // Add items to the menu
        italianRestaurant.getMenu().addItem(new MenuItem("Pizza", 9.99));
        // Add the restaurant to the application
        app.addRestaurant(italianRestaurant);
        // ... add other restaurants as needed
    }

    @Test
    void testSelectRestaurant() {
        // Assuming app has a method to get a list of restaurants
        assertFalse(app.getRestaurants().isEmpty(), "There should be restaurants available for selection");

        // Customer selects a restaurant
        Restaurant selectedRestaurant = app.selectRestaurant("Italian Place");
        assertNotNull(selectedRestaurant, "Selected restaurant should not be null");
    }

    @Test
    void testViewMenu() {
        // Customer selects a restaurant and views its menu
        Restaurant selectedRestaurant = app.selectRestaurant("Italian Place");
        Menu selectedMenu = selectedRestaurant.getMenu();
        
        // Assuming the menu has items
        assertFalse(selectedMenu.getItems().isEmpty(), "Menu should have items to view");

        // Check details of a menu item
        assertTrue(selectedMenu.containsItem("Pizza"), "Menu item details should be available for viewing");
    }

    @Test
    void testUpdateCart() {
        // Customer adds items to the cart
        MenuItem pizza = new MenuItem("Pizza", 9.99);
        cart.addItem(pizza, 2);
        assertTrue(cart.containsItem(pizza), "Cart should contain Pizza");

        // Customer removes an item from the cart
        cart.removeItem(pizza);
        assertFalse(cart.containsItem(pizza), "Cart should not contain Pizza after removal");

        // Customer updates the quantity of an item
        cart.addItem(pizza, 1);
        cart.updateQuantity(pizza, 3);
        assertEquals(3, cart.getQuantityOfItem(pizza), "Quantity of Pizza should be updated to 3");

        // Customer proceeds to checkout
        CustomerOrder order = customer.placeOrder(cart);
        assertNotNull(order, "Order should be created after checkout");
        assertEquals(29.97, order.getTotalPrice(), "Total price should be correct after checkout");
    }
}
