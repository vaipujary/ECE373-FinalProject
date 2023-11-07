import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import FeastFast.UserManagement.Customer;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.CustomerOrder;
import FeastFast.OrderingAndTransactions.ShoppingCart;
import FeastFast.ApplicationCore.FeastFastApplication;

class CustomerTestCases {

    private Customer customer;
    private Menu menu;
    private MenuItem menuItem;
    private ShoppingCart shoppingCart;
    private CustomerOrder order;
    private FeastFastApplication application;


    @BeforeEach
    void setUp() {
        // Initialize your test objects here
        customer = new Customer();
        menu = new Menu();
        menuItem = new MenuItem("Pizza", 9.99);
        shoppingCart = new ShoppingCart();
        order = new CustomerOrder();
        application = new FeastFastApplication();

        // Let's assume the menu is populated with items
        menu.addItem(menuItem);
    }

    @Test
    void testPlaceOrder() {
        customer.placeOrder(order);
        assertTrue(order.isPlaced(), "Order should be placed by customer.");
    }

    @Test
    void testReceiveSMSNotification() {
        String expectedSMS = "Your order status has been updated.";
        application.sendSMSToCustomer(customer, expectedSMS);
        String actualSMS = customer.getLastSMSReceived();
        assertEquals(expectedSMS, actualSMS, "Customer should receive the correct SMS notification.");
    }

    @Test
    void testReceiveEmailNotification() {
        String expectedEmail = "Your order has been confirmed.";
        application.sendEmailToCustomer(customer, expectedEmail);
        String actualEmail = customer.getLastEmailReceived();
        assertEquals(expectedEmail, actualEmail, "Customer should receive the correct email notification.");
    }

    @Test
    void testUpdateContactInformationUnreachableNumber() {
        customer.setPhoneNumber("unreachable_number");
        application.sendSMSToCustomer(customer, "Test SMS");
        assertTrue(customer.isAskedToUpdateContactInfo(), "Customer should be asked to update contact information if the number is unreachable.");
    }

    @Test
    void testViewOrderDetails() {
        customer.placeOrder(order);
        application.confirmOrder(order);
        CustomerOrder viewedOrder = customer.viewOrderDetails(order.getId());
        assertEquals(order, viewedOrder, "Customer should be able to view the details of their order.");
    }

    @Test
    void testOrderConfirmationNotification() {
        customer.placeOrder(order);
        application.confirmOrder(order);
        String confirmationMessage = customer.getLastNotificationReceived();
        assertTrue(confirmationMessage.contains("confirmed"), "Customer should receive a confirmation notification.");
    }

    @Test
    void testBrowseMenu() {
        Menu browsedMenu = application.getMenu();
        assertNotNull(browsedMenu, "Customer should be able to browse the menu.");
        assertTrue(browsedMenu.containsItem(menuItem), "Menu should contain the added menu items.");
    }

    @Test
    void testAddItemToCart() {
        customer.addToCart(menuItem, 1); // Adding one quantity of menuItem to the cart
        assertTrue(shoppingCart.containsItem(menuItem), "Shopping cart should contain the added item.");
    }

    @Test
    void testPlaceOrderWithItems() {
        customer.addToCart(menuItem, 2); // Adding two quantities of menuItem to the cart
        customer.placeOrder(order);
        assertTrue(order.containsItem(menuItem), "Order should contain the items added to the cart.");
        assertEquals(2, order.getQuantityOfItem(menuItem), "Order should contain the correct quantity of the item.");
    }

    @Test
    void testOrderTotalCalculation() {
        customer.addToCart(menuItem, 3); // Adding three quantities of menuItem to the cart
        customer.placeOrder(order);
        double expectedTotal = menuItem.getPrice() * 3;
        assertEquals(expectedTotal, order.getTotal(), "Order total should be correctly calculated based on the cart items.");
    }

    @Test
    void testCheckoutProcess() {
        customer.addToCart(menuItem, 1);
        customer.placeOrder(order);
        application.checkoutOrder(order);
        assertTrue(order.isConfirmed(), "Order should be confirmed after checkout process.");
    }

    @Test
    void testReceiveOrderConfirmation() {
        customer.addToCart(menuItem, 1);
        customer.placeOrder(order);
        application.checkoutOrder(order);
        String confirmationMessage = customer.getLastNotificationReceived();
        assertNotNull(confirmationMessage, "Customer should receive an order confirmation notification.");
        assertTrue(confirmationMessage.contains("confirmed"), "Confirmation message should contain 'confirmed'.");
    }

}
