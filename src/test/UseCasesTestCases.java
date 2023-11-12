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
    private CustomerOrder order;
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        app = new FeastFastApplication();
        customer = new Customer();
        customer.setName("John Doe");
        
        cart = new ShoppingCart();
        order = new CustomerOrder();
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

    @Test
    void testCreateAccount() {
        String name = "John Doe";
        String email = "john.doe@example.com";
        String password = "SecurePassword123";

        // Assuming app has a method to register a customer
        Customer newCustomer = app.registerCustomer(name, email, password);
        assertNotNull(newCustomer, "Customer account should be created");
        assertTrue(newCustomer.isLoggedIn(), "Customer should be logged in after account creation");
    }

    @Test
    void testModifyOrder() {
        // Assuming the customer is logged in and has an active order
        assertTrue(customer.isLoggedIn(), "Customer should be logged in");
        assertNotNull(order, "There should be an active order");

        // Customer modifies the order
        // Assuming app has a method to modify an order
        MenuItem pizza = new MenuItem("Pizza",9.13);
        order.addItem(pizza, 1); // Add a new item
        order.removeItem("Salad"); // Remove an item
        order.updateQuantity("Burger", 3); // Update the quantity of an existing item
    
        // Assuming app has a method to submit the modified order
        CustomerOrder modifiedOrder = order;
        assertNotNull(modifiedOrder, "Modified order should not be null");
        assertEquals(3, modifiedOrder.getQuantity("Burger"), "Quantity of Burger should be updated to 3");
        assertTrue(modifiedOrder.containsItem("Pizza"), "Order should contain the new item Pizza");
        assertFalse(modifiedOrder.containsItem("Salad"), "Order should not contain the removed item Salad");
    }

    @Test
    void testTrackOrder() {
        // Assuming the customer has placed an order
        app.placeOrder(customer, order);
        assertTrue(order.isPlaced(), "Order should be placed");

        // Customer tracks the order
        // Assuming app has a method to track an order
        String orderStatus = app.trackOrder(order);
        assertNotNull(orderStatus, "Order status should be retrievable");
        assertTrue(orderStatus.matches("Order Received|Order being prepared|Order Complete|Order canceled|Order out for delivery|Order ready for pickup|Order delivered|Order picked up"), "Order status should be one of the defined states");
    }

    @Test
    void testCancelOrder() {
        // Preconditions
        customer.placeOrder(order);
        restaurant.receiveOrder(order);
        order.setStatus(CustomerOrder.Status.Cancelled);

        // Action
        boolean cancelResult = customer.cancelOrder(order);

        // Post conditions
        if (order.getStatus().equals(CustomerOrder.Status.Cancelled)) {
            assertTrue(cancelResult, "Order should be successfully canceled.");
        } else {
            assertFalse(cancelResult, "Order should not be canceled if it's already being prepared or prepared.");
        }
    }

    @Test
    void testReorder() {
        // Preconditions
        // CustomerOrder pastOrder = customer.getPreviousOrder();
        // assertNotNull(pastOrder, "There should be a past order for reordering.");

        // // Action
        // // CustomerOrder newOrder = customer.reorder(pastOrder);

        // // Post conditions
        // assertNotNull(newOrder, "A new order should be created for the reorder.");
        // assertEquals(pastOrder.getItems(), newOrder.getItems(), "Reordered items should match the past order.");
    }

    @Test
    void testPlaceOrder() {
        // Preconditions
        MenuItem pizza = new MenuItem("Pizza", 11.99);
        MenuItem burger = new MenuItem("burger", 7.99);

        customer.addToCart(pizza, 2);
        customer.addToCart(burger);

        // Action
        CustomerOrder placedOrder = customer.placeOrder();

        // Post conditions
        assertNotNull(placedOrder, "An order should be successfully placed.");
        assertEquals(1, placedOrder.getItems().get("pizza"), "First item in the order should be Pizza.");
        assertEquals(2, placedOrder.getItems().get("burger"), "Quantity of Pizza should be 2.");
    }

}
