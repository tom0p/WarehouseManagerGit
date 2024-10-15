public class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " (" + quantity + ")";
    }

    public String formatted(double price) {
        return new java.text.DecimalFormat("###,##0.00").format(price);
    }
}
