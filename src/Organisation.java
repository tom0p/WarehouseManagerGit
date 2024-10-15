import Exceptions.NoSuchUserException;

public class Organisation { // login and login error
    private Suppliers suppliers;
    private Users users;

    public Organisation(Suppliers suppliers, Users users) {
        this.suppliers = suppliers;
        this.users = users;
    }

    public void use() {
        System.out.println("Welcome to the Prog2 Warehouse Manager");
        
        while (true) {
            System.out.println("Please login below:");
            System.out.print("Username: ");
            String username = In.nextLine();
            System.out.print("Password: ");
            String password = In.nextLine();
            try {
                User user = users.validateUser(username, password);
                user.use(this);
                break;
            } catch (NoSuchUserException e) {
                System.out.print("No user found! Try again? (y/n): ");
                char again = In.nextChar();
                if (again == 'n' || again == 'N'){
                    System.out.println("Thanks for using the Prog2 Warehouse Manager. Come again soon!");
                    break;
                } 
                if (again == 'y' || again == 'Y'){

            }
            }
        }
    }
    // Best not to mess with this
    public static void main(String[] args) {
        Suppliers seededSuppliers = null;
        Users seededUsers = null;
        try { seededSuppliers = new Suppliers().seedData(); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { seededUsers = new Users().seedData(seededSuppliers); } catch (Exception e) { System.out.println(e.getMessage()); }
        new Organisation(seededSuppliers, seededUsers).use();
    }

    public Suppliers getSuppliers() {
        return this.suppliers;
    }
}
