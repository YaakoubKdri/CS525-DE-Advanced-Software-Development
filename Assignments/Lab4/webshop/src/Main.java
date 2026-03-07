//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Category catalog = new Category("Product Catalog");
        Category phones = new Category("Phones");
        Category laptops = new Category("Laptops");

        Product iphone = new Product("P101", "iPhone", 900);
        Product galaxy = new Product("P102", "Samsung Galaxy", 800);
        Product macbook = new Product("P201", "MacBook", 2100);
        Product dell = new Product("P202", "Dell XPS", 1300);

        phones.add(iphone);
        phones.add(galaxy);
        laptops.add(macbook);
        laptops.add(dell);
        catalog.add(phones);
        catalog.add(laptops);
        catalog.print();
    }
}