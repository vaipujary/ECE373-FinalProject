package FeastFast.UserManagement;


public class User {

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
