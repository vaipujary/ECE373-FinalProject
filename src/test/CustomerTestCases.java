package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.Restaurant;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;
import FeastFast.OrderingAndTransactions.Receipt;
import FeastFast.ApplicationCore.FeastFastApplication;

class CustomerTestCases {

    private Customer customer;
    //private Menu menu;
    private MenuItem menuItem;
    private Order order;
    private Restaurant restaurant;
    private FeastFastApplication application;
    private Receipt receipt;

     @BeforeEach
     void setUp() {
         // Initialize your test objects here
         customer = new Customer();
         //menu = new Menu();
         menuItem = new MenuItem("Pizza", 9.99);
         order = new Order();
         application = new FeastFastApplication();
         restaurant = new Restaurant();
         receipt = new Receipt();

         // Let's assume the menu is populated with items
         restaurant.addMenuItem(menuItem);
     }

     @Test
     void testAddItemToOrder() {
         order.addItem(menuItem, 1); // Adding one quantity of menuItem to the cart
         assertTrue(order.containsItem(menuItem), "Shopping cart should contain the added item.");
     }

     @Test
     void testReceiveEmailNotification() {
    	 customer.setName("Vaidehi");
    	 customer.setEmail("vaipujary@arizona.edu");
    	 order.addItem(menuItem, 1);
         assertTrue(application.sendEmailToCustomer(customer, order), "Customer should receive the correct email notification.");
     }

     // TODO
//     @Test
//     void testUpdateContactInformationUnreachableNumber() {
//         customer.setPhoneNumber("unreachable_number");
//         application.sendSMSToCustomer(customer, "Test SMS");
//         assertTrue(customer.isAskedToUpdateContactInfo(), "Customer should be asked to update contact information if the number is unreachable.");
//     }

     @Test
     void testViewOrderDetails() {
     	order.addItem(menuItem, 1);
        order = customer.placeOrder();
        application.confirmOrder(order);
        receipt.setOrder(order);
        assertEquals(order.getItems().get(menuItem), receipt.getOrder().getItems().get(menuItem), "Customer should be able to view the details of their order.");
     }

     @Test
     void testOrderConfirmationNotification() {
    	 order.addItem(menuItem, 2);
    	 order = customer.placeOrder();
         application.confirmOrder(order);
         assertTrue(order.getStatus().equals(Order.Status.RestaurantReceived), "Customer should receive a confirmation notification.");
     }

     @Test
     void testBrowseMenu() {
         Menu browsedMenu = restaurant.getMenu();
         assertNotNull(browsedMenu, "Customer should be able to browse the menu.");
         assertTrue(browsedMenu.containsItem(menuItem), "Menu should contain the added menu items.");
     }


     @Test
     void testPlaceOrderWithItems() {
    	 order.addItem(menuItem, 2); // Adding two quantities of menuItem to the cart
         //order = customer.placeOrder();
         assertEquals(2, order.getItems().get(menuItem).intValue(), "Order should contain the correct quantity of the item.");
     }

     @Test
     void testOrderTotalCalculation() {
    	 order.addItem(menuItem, 3); // Adding three quantities of menuItem to the cart
         //order = customer.placeOrder();
         double expectedTotal = menuItem.getPrice() * 3;
         assertEquals(expectedTotal, order.getOrderPrice(), "Order total should be correctly calculated based on the cart items.");
     }

     @Test
     void testCheckoutProcess() {
    	 order.addItem(menuItem, 1);
         order = customer.placeOrder();
         application.checkoutOrder(order);
         assertEquals(Order.Status.SubmittedToRestaurant, order.getStatus(), "Order should be confirmed after checkout process.");
     }

}
