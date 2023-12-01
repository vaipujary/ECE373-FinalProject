package FeastFast.UserManagement;

import FeastFast.RestaurantManagement.MenuItem;

public class Admin extends User {

	// Can add menu item, remove menu item
	
	// Constructor
	public Admin() {
		
		
		
	}
	// Method to add a menu item
    public void addMenuItem(Restaurant restaurant, MenuItem item) {
        restaurant.getMenu().addItem(item);
    }

    // Method to remove a menu item
    public void removeMenuItem(Restaurant restaurant, MenuItem item) {
    	restaurant.getMenu().removeItem(item);
    }
}
