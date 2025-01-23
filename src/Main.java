import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        List<Product> products = Arrays.asList(
                new Product("A100", "apple", "local", Category.PRODUCE),
                new Product("B100", "banana", "local", Category.PRODUCE),
                new Product("P100", "pear", "local", Category.PRODUCE),
                new Product("L103", "lemon", "local", Category.PRODUCE),
                new Product("M201", "milk", "farm", Category.DAIRY),
                new Product("Y001", "yogurt", "farm", Category.DAIRY),
                new Product("C333", "cheese", "farm", Category.DAIRY),
                new Product("R777", "rice chex", "Nabisco", Category.CEREAL),
                new Product("G111", "granola", "Nat Valley", Category.CEREAL),
                new Product("BB11", "ground beef", "butcher", Category.MEAT),
                new Product("CC11", "chicken", "butcher", Category.MEAT),
                new Product("BC11", "bacon", "butcher", Category.MEAT),
                new Product("BC77", "coke", "coca cola", Category.BEVERAGE),
                new Product("BC88", "coffee", "value", Category.BEVERAGE),
                new Product("BC99", "tea", "herbal", Category.BEVERAGE)
        );

        for (Product product : products) {
            store.addInventoryItem(new InventoryItem(product, 100, 30, 50, 20, 1.5));
        }


        LocalDate date = LocalDate.of(2024, 2, 21);
        Cart cart1 = new Cart("CART123", date, "Physical");
        cart1.addItem(products.get(0), 20);
        cart1.addItem(products.get(4), 2);

        Cart cart2 = new Cart("CART124", LocalDate.now(), "Physical");
        cart2.addItem(products.get(3), 12);
        cart2.addItem(products.get(6), 2);

        Cart cart3 = new Cart("CART125", LocalDate.now(), "Virtual");
        cart3.addItem(products.get(7), 20);
        cart3.addItem(products.get(10), 4);

        store.manageStoreCarts(cart1);
        store.manageStoreCarts(cart2);
        store.manageStoreCarts(cart3);

        System.out.println("ORIGINAL CARTS:");
        System.out.println();

        store.showIfCartsRemoved(); //parodo original carts

        cart1.removeItem(products.get(6), 2);

        store.abandonCarts();

        System.out.println();
        System.out.println("ABANDONED CARTS AND REMOVED PRODUCT FROM CART: ");
        System.out.println();

        store.checkOutCart(cart1);//istrina 20 reserve is apple( array[0])

        store.showIfCartsRemoved(); //parodo viena removed product ir viena abandoned cart

        System.out.println();
        System.out.println("Store list by category");
        System.out.println();

        store.listProductsByCategory(Category.PRODUCE);

    }
}