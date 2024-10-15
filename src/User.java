import java.util.LinkedList;

public abstract class User {

    class Credentials {
        public String username;
        public String password;

        public Credentials(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    protected String firstName;
    protected String lastName;
    protected LinkedList<Cart> purchases;
    protected Credentials credentials;

    public User(String firstName, String lastName, String username,  String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        credentials = new Credentials(username, password);
        purchases = new LinkedList<Cart>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getUsername() {
        return credentials.username;
    }

    public String getPassword() {
        return credentials.password;
    }

    public void addPurchase(Cart cart) {
        purchases.add(cart);
    }

    public abstract void use(Organisation org);
    public abstract String toString();

}
