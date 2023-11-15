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

    public void removeItem(MenuItem item) {
        menuItems.remove(item);
    }

    public void updateItem(MenuItem updatedItem) {
        // Find the item in the list with the same ID and replace it with the updated item
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem currentItem = menuItems.get(i);
            if (currentItem.getId().equals(updatedItem.getId())) {
                menuItems.set(i, updatedItem);
                break;
            }
        }
    }

    public boolean containsItem(MenuItem item) {
        return menuItems.contains(item);
    }

    public boolean containsItem(String itemName) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public MenuItem getItem(String itemName) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return menuItems.get(0);
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(menuItems); // Return a copy to prevent external modification
    }

}
