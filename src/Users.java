import java.util.Arrays;
import java.util.LinkedList;
import Exceptions.NoSuchUserException;
import Exceptions.ConstructorException;

public class Users {
    private LinkedList<User> users;

    public Users() {
        this.users = new LinkedList<User>();
    }

    public Users(LinkedList<User> initialUsers) {
        this.users = initialUsers;
    }

    public LinkedList<User> getUsers() {
        return this.users;
    }

    //You should not ever have to call this.
    //It is already called once for you
    public Users seedData(Suppliers stores) throws ConstructorException {
        this.users.add(new Customer("David", "Dyer", "davey", "pass"));
        this.users.add(new Customer("Aziz", "Shavershian", "1", "1"));
        this.users.add(new Customer("Lee", "Yeoreum", "lee123", "wjsn"));
        this.users.add(new Customer("Kim", "Dahyun", "dah-yun", "twice"));

        this.users.add(new Manager("David", "Dyer", "2", "2", new LinkedList<Supplier>(Arrays.asList(
            stores.getByRegion("Penshurst"),
            stores.getByRegion("Hurstville"),
            stores.getByRegion("Allawah"),
            stores.getByRegion("Carlton"),
            stores.getByRegion("Kogarah"),
            stores.getByRegion("Waterfall"),
            stores.getByRegion("Engadine")
        ))));
        this.users.add(new Manager("Big", "Paulie", "paul89", "huge", new LinkedList<Supplier>(Arrays.asList(
            stores.getByRegion("Heathcote"),
            stores.getByRegion("Loftus"),
            stores.getByRegion("Sutherland"),
            stores.getByRegion("Mortdale")
        ))));
        this.users.add(new Manager("Rishik", "Sood", "rishik", "pass", new LinkedList<Supplier>(Arrays.asList(
            stores.getByRegion("Banksia"),
            stores.getByRegion("Arncliffe")
        ))));
        this.users.add(new Manager("Angela", "Huo", "admin", "admin", new LinkedList<Supplier>(Arrays.asList(
            stores.getByRegion("Wolli Creek"),
            stores.getByRegion("Sydenham")
        ))));
        this.users.add(new Manager("Zohair", "Gandhi", "zohair45", "ted", new LinkedList<Supplier>(Arrays.asList(
            stores.getByRegion("Redfern"),
            stores.getByRegion("Central")
        ))));
        if (((Manager)(this.users.get(4))).getSuppliers() == null) {
            System.out.println("Exception occured when attempting to seed data.\nHave you implemented the Manager constructor?");
        }
        return this;
    }

    public User validateUser(String username, String password) throws NoSuchUserException {
        for (User u : this.users) {
            if (username.equals(u.credentials.username) && password.equals(u.credentials.password)) {
                return u;
            }
        }
        throw new NoSuchUserException();
    }
}
