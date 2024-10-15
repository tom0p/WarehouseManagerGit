import java.util.LinkedList;

public class Manager extends User { // manager menu, manage a supplier method, view my details needs completing

    private Suppliers suppliers;
    private String[] menuOptions = {"1. View my details.", "2. List all your suppliers", "3. Manage a particular supplier", "4. Logout"};

    public Manager(String firstName, String lastName, String username, String password, LinkedList<Supplier> suppliers) {
        super(firstName, lastName, username, password);
        this.suppliers = new Suppliers(suppliers);
    }

    public void use(Organisation org) {
        while (true) {
            System.out.println("Welcome to the manager menu " + this.getFirstName() + ".");
            for (String option : menuOptions) {
                System.out.println(option);
            }
       
        System.out.print("Please enter a choice: ");
        String choice = In.nextLine();

        if (choice.equals("1")) {
            System.out.println(this.toString());
        } 
        else if (choice.equals("2")) {
            System.out.println("All suppliers:");
            System.out.println(this.suppliers.toString());
        } 
        else if (choice.equals("3")) {
            while(true){
            System.out.println("Which supplier would you like to manage?");
            LinkedList<Supplier> supplierList = this.suppliers.getSuppliers(); 
            for (int i = 0; i < supplierList.size(); i++) {
                System.out.println((i + 1) + ". " + supplierList.get(i).getRegion());
                  
            }
            
        
            System.out.print("Supplier: ");
            int supplierIndex = In.nextInt();
        
            if (supplierIndex > 0 && supplierIndex <= supplierList.size()) {
                Supplier supplierToManage = supplierList.get(supplierIndex - 1);  
                supplierToManage.use(this); 
                 break;
            } else {
                System.out.println("No such supplier!");
            }
            }
        } else if (choice.equals("4")) {
            System.out.println("Thanks for using the Prog2 Warehouse Manager. Come again soon!");
            return;
        } else {
            System.out.println("Please enter a valid number, press 4 to logout.");
        }
    }
}

    public Suppliers getSuppliers() {
        return this.suppliers;
    }

    @Override
public String toString() {
    String s = this.getFullName() + ", manager for: \n";
    
    if (suppliers != null && !suppliers.getSuppliers().isEmpty()) {
        for (int i = 0; i < suppliers.getSuppliers().size(); i++) {
            s += suppliers.getSuppliers().get(i).getRegion().trim();
            if (i < suppliers.getSuppliers().size() - 1) {
                s += ("\n");  
            }
        }
    } else {
        s += "No suppliers.";
    }
    
    return s;
}
}
