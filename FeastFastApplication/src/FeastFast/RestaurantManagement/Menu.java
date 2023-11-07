package FeastFast.RestaurantManagement;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public boolean containsItem(MenuItem item) {
        return menuItems.contains(item);
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(menuItems); // Return a copy to prevent external modification
    }

    // Additional methods and logic as required by your application
    // For instance, methods to remove items, update items, etc.
}
