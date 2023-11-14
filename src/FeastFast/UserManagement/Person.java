package FeastFast.UserManagement;

public class Person {

    String name;
    Boolean isLoggedIn;

    public Person() {
        isLoggedIn = false;
    }

    public void LogIn() {
        this.isLoggedIn = true;
    }

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }
}
