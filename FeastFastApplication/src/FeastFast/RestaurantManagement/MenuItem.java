package FeastFast.RestaurantManagement;

public class MenuItem {

    private String id;
    private String name;
    private double price;

    public MenuItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public MenuItem() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    // Additional methods and logic as required by your application
    // For instance, equals and hashCode methods might be necessary for comparison in collections
}
