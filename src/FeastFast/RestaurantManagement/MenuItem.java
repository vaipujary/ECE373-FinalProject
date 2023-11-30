package FeastFast.RestaurantManagement;

import java.util.ArrayList;

// This class handles the menu items in the restaurant menus
public class MenuItem {

	// Attributes
    private String id;
    private String name;
    private double price;
    private ArrayList<String> allergens;
    private ArrayList<String> ingredients;

    public MenuItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        allergens = new ArrayList<String>();
        ingredients = new ArrayList<String>();
    }

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public MenuItem() {
    	this.id = "";
    	this.name = "";
    	this.price = 0.0;
        allergens = new ArrayList<String>();
        ingredients = new ArrayList<String>();
    }

    public ArrayList<String> getAllergens(){
    	return this.allergens;
    }
    
    public void setAllergen(String allergen) {
    	allergens.add(allergen);
    }
    
    public ArrayList<String> getIngredients(){
    	return this.ingredients;
    }
    
    public void setIngredient(String ingredient) {
    	ingredients.add(ingredient);
    }
    
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

}
