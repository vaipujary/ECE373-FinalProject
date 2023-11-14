package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.Restaurant;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;
import FeastFast.ApplicationCore.FeastFastApplication;

class UseCasesTestCases {

    private FeastFastApplication app;
    private Customer customer;
    private Order order;
    private Restaurant italianRestaurant;

    @BeforeEach
    void setUp() {
        app = new FeastFastApplication();

        customer = new Customer();
        customer.setName("John Doe");

        order = new Order();
        customer.setOrder(order);        
        // Set up the application with some restaurants
        this.italianRestaurant = new Restaurant();
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
    void testUpdateOrder() {
        // Customer adds items to the order
        MenuItem pizza = new MenuItem("Pizza", 9.99);
        order.addItem(pizza, 2);
        assertTrue(order.containsItem(pizza), "Order should contain Pizza");

        // Customer removes an item from the order
        order.removeItem(pizza);
        assertFalse(order.containsItem(pizza), "Order should not contain Pizza after removal");

        // Customer updates the quantity of an item
        order.addItem(pizza, 1);
        order.updateQuantity(pizza, 3);
        assertEquals(3, order.getQuantityOfItem(pizza), "Quantity of Pizza should be updated to 3");

        
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
        MenuItem pizza = new MenuItem("Pizza",9.13);
        MenuItem salad = new MenuItem("Salad",9.13);
        MenuItem burger = new MenuItem("Burger", 7.99);

        order.addItem(pizza, 1); // Add a new item
        order.addItem(burger, 1); // Add a new item
        order.addItem(salad, 1); // Add a new item

        order.removeItem("Salad"); // Remove an item
        order.updateQuantity("Burger", 3); // Update the quantity of an existing item
    
        // Assuming app has a method to submit the modified order
        Order modifiedOrder = order;
        assertNotNull(modifiedOrder, "Modified order should not be null");
        assertEquals(3, modifiedOrder.getQuantityOfItem("Burger"), "Quantity of Burger should be updated to 3");
        assertTrue(modifiedOrder.containsItem("Pizza"), "Order should contain the new item Pizza");
        assertFalse(modifiedOrder.containsItem("Salad"), "Order should not contain the removed item Salad");
    }

    @Test
    void testTrackOrder() {
        // Assuming the customer has placed an order
        customer.placeOrder();
        assertTrue(order.isPlaced(), "Order should be placed");

        // Customer tracks the order
        // Assuming app has a method to track an order
        String orderStatus = app.trackOrder(order);
        assertNotNull(orderStatus, "Order status should be retrievable");
        assertTrue(orderStatus.matches("NotPlaced|SubmittedToRestaurant|RestaurantReceived|PreparingFood|InDelivery|ArrivedToDestination|DeliverdToCustomer|Cancelled"), "Order status should be one of the defined states");
    }

    @Test
    void testCancelOrder() {
        // Preconditions
        customer.placeOrder();
        italianRestaurant.receiveOrder(order);
        order.setStatus(Order.Status.Cancelled);

        // Action
        boolean cancelResult = customer.cancelOrder(order);

        // Post conditions
        if (order.getStatus().equals(Order.Status.Cancelled)) {
            assertTrue(cancelResult, "Order should be successfully canceled.");
        } else {
            assertFalse(cancelResult, "Order should not be canceled if it's already being prepared or prepared.");
        }
    }

    @Test
    void testPlaceOrder() {
        // Preconditions
        MenuItem pizza = new MenuItem("Pizza", 11.99);
        MenuItem burger = new MenuItem("burger", 7.99);

        order.addItem(pizza, 2);
        order.addItem(burger);

        // Action
        Order placedOrder = customer.placeOrder();

        // Post conditions
        assertNotNull(placedOrder, "An order should be successfully placed.");
        assertEquals(1, placedOrder.getQuantityOfItem("Burger"), "First item in the order should be Burger.");
        assertEquals(2, placedOrder.getQuantityOfItem("Pizza"), "Quantity of Pizza should be 2.");
    }

    @Test
    void testSelectOrderTypeDelivery() {
        // Preconditions
        assertTrue(customer.isLoggedIn(), "Customer should be logged in to select order type");
        customer.selectRestaurant(italianRestaurant);

        // Action
        customer.selectOrderType(Order.Type.HOME_DELIVERY);
        customer.setAddress("123 Maple Street Springfield, ST 98765 United States");

        // Post conditions
        assertEquals(Order.Type.HOME_DELIVERY, order.getOrderType(), "Order type should be Home Delivery");
        assertNotNull(order.getDeliveryAddress(), "Delivery address should be provided for Home Delivery");


    }

    @Test
    void testSelectOrderTypePickup() {
        // Preconditions
        assertTrue(customer.isLoggedIn(), "Customer should be logged in to select order type");
        customer.selectRestaurant(italianRestaurant);

        // Repeat for Pickup option
        customer.selectOrderType(Order.Type.PICKUP);
        customer.specifyPickupTime("12:00 PM");

        // Post conditions for Pickup
        assertEquals(Order.Type.PICKUP, order.getOrderType(), "Order type should be Pickup");
        assertEquals("12:00 PM", order.getPickupTime(), "Pickup time should be specified");
    }

    @Test
    void testSendEmailToCustomer() {
        // Preconditions
        customer.placeOrder();
        assertTrue(order.isPlaced(), "Order should be placed");

        // Action
        boolean emailSent = app.sendEmailToCustomer(order);

        // Post conditions
        assertTrue(emailSent, "Email should be sent successfully to the customer");
    }

    @Test
    void testViewPendingOrders() {
        // Preconditions
        MenuItem pizza = new MenuItem("Pizza", 11.99);
        customer.selectRestaurant(italianRestaurant);
        order.addItem(pizza, 2);
        customer.placeOrder();

        assertTrue(italianRestaurant.isLoggedIn(), "Restaurant should be logged in to view orders");

        // Action
        List<Order> pendingOrders = italianRestaurant.viewPendingOrders();

        // Post conditions
        assertNotNull(pendingOrders, "Pending orders list should not be null");
        assertFalse(pendingOrders.isEmpty(), "There should be pending orders available");
    }

    @Test
    void testConfirmOrder() {
        // Preconditions
        MenuItem pizza = new MenuItem("Pizza", 11.99);
        customer.selectRestaurant(italianRestaurant);
        order.addItem(pizza, 2);
        customer.placeOrder();
        
        Order pendingOrder = italianRestaurant.viewPendingOrders().get(0);
        assertNotNull(pendingOrder, "There should be a pending order to confirm");

        // Action
        boolean confirmationResult = italianRestaurant.confirmOrder(pendingOrder);

        // Post conditions
        assertTrue(confirmationResult, "Order should be successfully confirmed");
        assertEquals(Order.Status.RestaurantReceived, pendingOrder.getStatus(), "Order status should be set to Confirmed");
    }


}
