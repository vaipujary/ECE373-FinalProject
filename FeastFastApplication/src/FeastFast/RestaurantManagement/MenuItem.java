package FeastFast.RestaurantManagement;

public class MenuItem {

    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Additional methods and logic as required by your application
    // For instance, equals and hashCode methods might be necessary for comparison in collections
}
