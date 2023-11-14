package FeastFast.UserManagement;


public class User {

    protected String name;
    protected  Boolean isLoggedIn;

    public User() {
        isLoggedIn = false;
    }

    public void LogIn() {
        this.isLoggedIn = true;
    }

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }
}
