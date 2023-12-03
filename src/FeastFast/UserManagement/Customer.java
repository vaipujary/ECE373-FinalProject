package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.Order;

// This is the customer class which inherits from the User class
public class Customer extends User {

	// Attributes
    private String phoneNumber;
    private String email;
    private Order order;
    private Restaurant restaurantInView;
    private String Address;
    
    // Constructors
    public Customer() {
        this.Address = "";
        this.phoneNumber = "";
        this.email = "";
        this.order = new Order();
        restaurantInView = new Restaurant();
    }

    public Customer(String name, String username,String password) {
    	super(name, username, password);
        this.Address = "";
        this.email =  "";
        this.order = new Order();
    }

    public boolean cancelOrder(Order order) {

        order.setStatus(Order.Status.Cancelled);

        if (order.getStatus() == Order.Status.Cancelled) {
            return true;
        }
        else {
            return false;
        }
    }

    // Method to place an order from the shopping cart
    public Order placeOrder() {
        order.setStatus(Order.Status.SubmittedToRestaurant);
        return order;
    }

    // TODO: Method to order previous order
    // TODO: Method to preorder items
    public void setOrder(Order o) {
        this.order = o;
    }

    public Order getOrder() {
        return this.order;
    }
    
    // Method for a customer to view their order details
    public Order viewOrderDetails(int orderId) {
        // Logic to view order details, possibly from a list of orders
        // For simplicity, returning a new order object
        return new Order(); // This would be replaced with actual order retrieval logic
    }

    // Method for a customer to select a restaurant from a list of restaurants
    public void selectRestaurant(Restaurant r) {
        this.restaurantInView = r;

        r.receiveOrder(order);
    }

    // Method for to get the restaurant being viewed by the customer
    public Restaurant getCurrentRestaurant() {
        return this.restaurantInView;
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getLastNotificationReceived() {
        return null;
    }

    // Method to determine the type of order
    public void selectOrderType(Order.Type t) {

        switch (t) {
            case HOME_DELIVERY:
                order.setDeliveryAddress(this.Address);
                System.out.println("Home Delivery");
                break;

            case PICKUP:
                order.setDeliveryAddress("null");
                break;

            default:
                order.setDeliveryAddress("null");

                break;
        }
        this.order.setOrderType(t);
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getAddress() {
        return this.Address;
    }

    public void specifyPickupTime(String time) {
        selectOrderType(Order.Type.PICKUP);

        this.order.setPickupTime(time);
    }
}
