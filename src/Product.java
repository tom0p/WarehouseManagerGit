import java.text.DecimalFormat;

public class Product {
    private String name;
    private double price;
    private int stock;
    private boolean available;

    public Product(String name, double price, int initialStock) {
        this.name = name;
        this.price = price;
        this.stock = initialStock;
        this.available = initialStock > 0;
    }

    public String getName() {
        return this.name;
    }
    public int getStock() {
        return this.stock;
    }
    public double getPrice() {
        return this.price;
    }

    public boolean has(int amount) {
        return this.stock >= amount;
    }

    public double sell(int amount) {
        if (amount <= stock) {
            stock -= amount;
            if (stock == 0) {
                available = false;
            }
            return amount * price;
        } else {
            return 0;
        }
    }

    public void restock(int amount) {
        stock += amount;
        available = true;
    }

    public void prune() {
        
        available = false;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return name + " at $" + formatted(price) + " (" + stock + ")";
    }

    public String formatted(double price) {
        return new DecimalFormat("###,##0.00").format(price);
    }
}