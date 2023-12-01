package FeastFast.UserManagement;

// This is the User superclass
public class User {

	// Attributes
    protected String name;
    protected boolean isLoggedIn;

    public User() {
    	name = "";
        isLoggedIn = false;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
    }

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }
}
