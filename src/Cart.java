import java.text.DecimalFormat;
import java.util.LinkedList;

public class Cart { // customer cart options
    private Supplier supplier;
    private User user;
    private LinkedList<Order> orders;

    private String[] menuOptions = {"1. Add a product to your cart", "2. Remove a product from your cart", "3. View your order", "4. Cancel your order", "5. Checkout"};

    public Cart(Supplier supplier, User user) {
        this.supplier = supplier;
        this.user = user;
        this.orders = new LinkedList<Order>();
    }

    public void use() {
        while (true) {
            System.out.println("Welcome to the cart menu " + user.getFirstName());
            for (String option : menuOptions) {
                System.out.println(option);
            }
            System.out.print("Please enter a choice: ");
            String choice = In.nextLine();
            if (choice.equals("1")) {
                addProduct();
            } 
            else if (choice.equals("2")) {
                removeProduct();
            } 
            else if (choice.equals("3")) {
                System.out.println("Order from " + supplier.getRegion() + ": ");  
                System.out.println(this.toString());
            } 
            else if (choice.equals("4")) {
                orders.clear();
                System.out.println("Order cancelled!");
                return;

            } 
            else if (choice.equals("5")) {
                checkout();
                break;

            }
           
            else {
                System.out.println("Please enter a valid number, press 4 to cancel.");
            }
            
        }
    }

    private void addProduct() {
        System.out.println("Please select a product from the catalogue:");
        LinkedList<Product> products = supplier.products.getProductList();        
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ": " + products.get(i).getName() + " at $" + products.get(i).getPrice() + " (" + products.get(i).getStock() + ")");  
        }
        System.out.print("Product: ");
        int productInd = In.nextInt();
        if (productInd > 0 && productInd <= products.size()) {
            Product productToAdd = products.get(productInd - 1);
            if (productToAdd.isAvailable()) {
                System.out.print("Amount: ");
            try {
                int quantity = In.nextInt();
                if (productToAdd.has(quantity)) {
                    orders.add(new Order(productToAdd, quantity));
                    System.out.println("Product added to cart.");
                } else {
                    System.out.println("Not enough stock available!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a valid number.");
            }
        } else {
            System.out.println("try again.");
        }
    }
    }

    private void removeProduct() {
        while (true) {
            System.out.print("Which item would you like to remove?\n");
            for (int i = 0; i < orders.size(); i++) {
           System.out.println((i + 1) + ": " + orders.get(i).getProduct().getName() + " (" + orders.get(i).getQuantity() + ")");
        }
        System.out.print("Item: ");
        int choice = In.nextInt();
       
        if (choice > 0 && choice <= orders.size()) {
            Order orderToRemove = orders.get(choice - 1);
            orders.remove(orderToRemove);
            break;
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }
}

    private void checkout() {
    
        for (Order order : orders) {
            double saleAmount = order.getProduct().sell(order.getQuantity());
            supplier.profit += saleAmount;
        }
        user.addPurchase(this);
        orders.clear();
    }

   @Override
    public String toString() {
        if (orders.isEmpty()) {
            return "Your cart is empty.";
        }
       double total = 0.0;
        int orderSize = orders.size();

            for (int i = 0; i < orderSize; i++) {
                System.out.print(orders.get(i).toString()); 
                total += orders.get(i).getTotal();

   
        if (i < orderSize - 1) {
        System.out.println();
    }
}
    
        System.out.print("\nTotal Cost: " + formatted(total));
        return "";
        
    }

   public String formatted(double price) {
    return new DecimalFormat("###,##0.00").format(price);
}
}