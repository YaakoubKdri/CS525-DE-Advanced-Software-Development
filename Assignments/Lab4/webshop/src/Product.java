public class Product extends CatalogComponent{
    private String id;
    private double price;

    public Product(String name, String id, double price) {
        super(name);
        this.id = id;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.println("Product: " + name + " | ID: " + id + " | Price: $" + price);
    }
}
