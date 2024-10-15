import java.util.LinkedList;

public class Customer extends User { // contains customer menu, shop method, view order history method

    public String[] menuOptions = {"1. View my details", "2. Shop", "3. View my order history", "4. Logout"};

    public Customer(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public void use(Organisation org) {
        while (true) {
        System.out.println("Welcome to the customer menu " + this.getFirstName() + ".");
        for (String option : menuOptions) {
            System.out.println(option);
        }
        System.out.print("Please enter a choice: ");
        String choice = In.nextLine();
            
        
            if (choice.equals("1")) {
                System.out.println(this.toString());
            } 
            else if (choice.equals("2")) {
                shop(org);
            } 
            else if (choice.equals("3")) {
                viewOrderHistory();
            } 
            else if (choice.equals("4")) {
                System.out.println("Thanks for using the Prog2 Warehouse Manager. Come again soon!");
                return;
            } else {
                System.out.println("Please enter a valid number, press 4 to logout.");
            }
        }
    }        

    private void shop(Organisation org) {
        while (true) {
            System.out.println("Where would you like to shop?");
            LinkedList<Supplier> supplierList = org.getSuppliers().getSuppliers();            
            for (int i = 0; i < supplierList.size(); i++) {
                System.out.println((i + 1) + ": " + supplierList.get(i).getRegion());  
            }
    
            System.out.print("Enter a choice: ");
            int supplierNo = In.nextInt();  
            
            
            if (supplierNo > 0 && supplierNo <= supplierList.size()) {
                Supplier supplier = supplierList.get(supplierNo - 1);  
                supplier.use(this);
                break;    
            } else {
                System.out.println("Invalid option entered!");
            }
        }
    }
    
    private void viewOrderHistory() {
        if (purchases.isEmpty()) {
            System.out.println("No purchase history!");
        } else {
            for (Cart cart : purchases) {
                System.out.println(cart.toString());
            }
        }
    }

    @Override
    public String toString() {
        return this.getFullName();
    }
}
