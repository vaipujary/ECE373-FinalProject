package FeastFast.UserManagement;

// This is the User superclass
public class User {

	// Attributes
    protected String name;
    private String password;
    private String username;
    protected boolean isLoggedIn;

    public User() {
    	name = "";
        isLoggedIn = false;
        password = null;
        username = "";
        
    }
    
    public User(String name) {
    	this.name = name;
    }
    
    public User(String name, String username, String password) {
    	this.name = name;
        isLoggedIn = false;
        this.password = password;
        this.username = username;
    }
    public String getUserName() {
    	return username;
    }
    public void setUserName(String username) {
    	this.username = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
    }

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }
}
