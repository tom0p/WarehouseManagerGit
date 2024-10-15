import java.text.DecimalFormat;
import java.util.LinkedList;

public class Supplier {

    private String name;
    private String region;
    private String address;
    protected Products products;
    protected double profit;

    private String[] menuOptions = {"1. View supplier details", "2. View products", "3. View profit", "4. Order"};
    private String[] managerOptions = {"1. View supplier details", "2. View all products", "3. View available products", "4. Add a product", "5. Remove a product", "6. Restock a product", "7. Delist a product", "8. View profit", "9. Order"};

    public Supplier(String name, String region, String address, LinkedList<Product> products) {
        this.name = name;
        this.region = region;
        this.address = address;
        this.products = new Products(products);
        this.profit = 0;
    }

    public void use(User user) {
        String[] options = user instanceof Manager ? managerOptions : menuOptions;
    
        while (true) {
            System.out.println("Welcome to " + this.getName());
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Please enter a choice: ");
            String choice = In.nextLine();
        
            if (user instanceof Manager) {
                if (choice.equals("1")) {
                    System.out.println(this.toString());
                } 
                else if (choice.equals("2")) {
                    System.out.println(products.toString());
                } 
                else if (choice.equals("3")) {
                    System.out.println(products.availableProducts());
                } 
                else if (choice.equals("4")) {
                    products.addProduct();
                } 
                else if (choice.equals("5")) {
                    products.removeProduct();
                } 
                else if (choice.equals("6")) {
                    products.restockProduct();
                } 
                else if (choice.equals("7")) {
                    products.delistProduct();
                } 
                else if (choice.equals("8")) {
                    System.out.println("Profit: " + formatted(profit));
                } 
                else if (choice.equals("9")) {
                    Cart cart = new Cart(this, user);
                    cart.use();  
                    break;
                } else if (choice.equalsIgnoreCase("X")) {
                    return;
                } else {
                    System.out.println("Please enter a valid number, or press X to exit.");
                }
            } else {
                
                if (choice.equals("1")) {
                    System.out.println(this.toString());
                } 
                else if (choice.equals("2")) {
                    System.out.println(products.toString());
                } 
                else if (choice.equals("3")) {
                    System.out.println("Total Profit: " + formatted(profit));
                } 
                else if (choice.equals("4")) {
                    Cart cart = new Cart(this, user);
                    cart.use();
                      
                } else if (choice.equalsIgnoreCase("X")) {
                    System.out.println("Thanks for shopping at " + this.getName());
                    return;
                } else {
                    System.out.println("Please enter a valid number, or press X to exit.");
                }
            }
        }
    }
    
    
    public String getRegion() {
        return this.region;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + " (" + region + "), " + address;
    }

    public String formatted(double price) {
        return new DecimalFormat("###,##0.00").format(price);
    }
}
