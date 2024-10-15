import java.util.LinkedList;

public class Products {
    private LinkedList<Product> products;

    public Products() {
        this.products = new LinkedList<Product>();
    }

    public Products(LinkedList<Product> initialProducts) {
        this.products = initialProducts;
    }
    public LinkedList<Product> getProductList() {
        return this.products;
    }
    public void addProduct() {
        System.out.print("Name: ");
        String name = In.nextLine();
        System.out.print("Price: ");
            double price = Double.parseDouble(In.nextLine());
            System.out.print("Inital stock: ");
            int stock = In.nextInt();
            Product newProduct = new Product(name, price, stock);
            products.add(newProduct);
        
        
    }

    public void removeProduct() {
        while (true){
            System.out.print("Name: ");
            String name = In.nextLine();
            Product productToRemove = getProductByName(name);
            if (productToRemove != null) {
                products.remove(productToRemove);
                System.out.println(name + " successfully removed.");
                break;
            } 
        else {
            System.out.println("No such product. Try again");
        }
    }
}

    public void restockProduct() {
        while(true){
            System.out.print("Name: ");
            String name = In.nextLine();
           
           
                Product product = getProductByName(name);
            
                    if (product != null) {
                    System.out.print("Amount: ");
                    int amount = In.nextInt();
                    product.restock(amount);
                    System.out.println(name + " successfully updated.");
                    break;
                } 
            else {
                System.out.println("No such product. Try again");
            }
         
       
    }
}

    public void delistProduct() {
        while (true){
            System.out.print("Name: ");
            String name = In.nextLine();
            Product product = getProductByName(name);
                if (product != null) {
                    product.prune();
                    System.out.println(name + " successfully delisted.");
                    return;
        } 
        else {
            System.out.println("No such product. Try again");
        }
    }
}

public String availableProducts() {
    String s = "";
    int count = 0;
    for (Product p : products) {
        if (p.isAvailable()) {
            if (count > 0) {
                s += "\n"; 
            }
            s += p.toString();
            count++;
        }
    }
    return s;
}

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < products.size(); i++) {
        s += products.get(i).toString();
        if (i < products.size() - 1) { 
            s += "\n";
        }
    }
        return s;
    }
    

    public Product getProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
