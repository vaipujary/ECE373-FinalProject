package FeastFast.OrderingAndTransactions;

import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.MenuItem;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private int shoppingCartId;
    private Map<MenuItem, Integer> itemsInCart;
    private double totalPrice;
    private boolean isCartFinal;

    public ShoppingCart() {
        this.shoppingCartId = 1;
        this.itemsInCart = new HashMap<>();
        this.totalPrice = 0.0;
        this.isCartFinal = false;
    }

    public void addItem(MenuItem item, int quantity) {
        if (itemsInCart.containsKey(item)) {
            itemsInCart.put(item, itemsInCart.get(item) + quantity);
        } else {
            itemsInCart.put(item, quantity);
        }
        calculateTotalPrice();
    }

    public void removeItem(MenuItem item) {
        itemsInCart.remove(item);
        calculateTotalPrice();
    }

    public boolean containsItem(MenuItem item) {
        return itemsInCart.containsKey(item);
    }

    public void updateQuantity(MenuItem item, int quantity) {
        if (itemsInCart.containsKey(item)) {
            itemsInCart.put(item, quantity);
        }
        calculateTotalPrice();
    }

    public void clear() {
        itemsInCart.clear();
        totalPrice = 0.0;
        isCartFinal = false;
    }

    public boolean isEmpty() {
        return itemsInCart.isEmpty();
    }

    private void calculateTotalPrice() {
        totalPrice = itemsInCart.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void finalizeCart() {
        isCartFinal = true;
    }

    // Getters and Setters
    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Map<MenuItem, Integer> getItemsInCart() {
        return itemsInCart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isCartFinal() {
        return isCartFinal;
    }

    public void transferItemsToOrder(Order order) {
        if (!isCartFinal) {
            throw new IllegalStateException("Cart must be finalized before transferring items to an order.");
        }

        order.clearItems(); // Clear any existing items in the order

        for (Map.Entry<MenuItem, Integer> entry : itemsInCart.entrySet()) {
            MenuItem item = entry.getKey();
            Integer quantity = entry.getValue();

            order.addItem(item, quantity); // Add each item and its quantity to the order
        }

        // Assuming the total price is calculated within the Order class
        this.clear(); // Optionally clear the cart after transferring items
    }

    public Integer getQuantityOfItem(MenuItem item) {
        if (itemsInCart.containsKey(item)) {
            return itemsInCart.get(item);
        }

        return -1;
    }

    
}
