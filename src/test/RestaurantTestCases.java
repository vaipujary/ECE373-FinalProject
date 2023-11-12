package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import FeastFast.UserManagement.Restaurant;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;


class RestaurantTestCases {

    private Restaurant restaurant;
    private Menu menu;
    private MenuItem menuItem;
    private Order order;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant();
        menu = new Menu();
        menuItem = new MenuItem();
        order = new Order();

        // Set up a menu item
        menuItem.setName("Burger");
        menuItem.setPrice(8.99);
        menuItem.setId("12345");
        // Add the item to the menu
        menu.addItem(menuItem);

        // Set up the restaurant
        restaurant.setMenu(menu);
    }

    @Test
    void testRestaurantCreation() {
        assertNotNull(restaurant, "Restaurant instance should be created.");
    }

    @Test
    void testAddMenuItem() {
        restaurant.getMenu().addItem(new MenuItem("Pizza", 10.99));
        assertTrue(restaurant.getMenu().containsItem("Pizza"), "Menu should contain the added item.");
    }

    @Test
    void testRemoveMenuItem() {
        restaurant.getMenu().removeItem(menuItem);
        assertFalse(restaurant.getMenu().containsItem("Burger"), "Menu should not contain the removed item.");
    }

    @Test
    void testUpdateMenuItem() {
        menuItem.setPrice(9.99);
        restaurant.getMenu().updateItem(menuItem);
        assertEquals(9.99, restaurant.getMenu().getItem("Burger").getPrice(), "Menu item price should be updated.");
    }

    @Test
    void testReceiveOrder() {
        restaurant.receiveOrder(order);
        assertTrue(restaurant.getOrders().contains(order), "Restaurant should have the received order in its list.");
    }

    @Test
    void testUpdateOrderStatus() {
        restaurant.receiveOrder(order);

        assertEquals(Order.Status.RestaurantReceived, order.getStatus(), "Order status should be updated to 'Preparing'.");
    }

    @Test
    void testLoginAndLogout() {
        restaurant.setLoggedIn(true);
        assertTrue(restaurant.isLoggedIn(), "Restaurant should be logged in.");

        restaurant.setLoggedIn(false);
        assertFalse(restaurant.isLoggedIn(), "Restaurant should be logged out.");
    }

    @Test
    void testHandleCustomerQuery() {
        String customerQuery = "Is the veggie burger gluten-free?";
        String response = restaurant.handleCustomerQuery(customerQuery);
        assertNotNull(response, "Restaurant should provide a response to customer queries.");
    }

    // ... Additional tests for other functionalities

    // Note: The above tests assume that you have corresponding methods in your classes.
    // You would need to implement these methods in your actual system.
}
