import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final String id;
    private final Map<Product, Integer> productsAndQuantity;
    private final LocalDate date;
    private final String type;

    public Cart(String id, LocalDate date, String type) {
        this.id = id;
        this.productsAndQuantity = new HashMap<>();
        this.date = date;
        this.type = type;
    }

    public void addItem(Product product, int quantity) {
        productsAndQuantity.put(product, quantity);
    }

    public void removeItem(Product product, int quantity) {
        productsAndQuantity.remove(product, quantity);
    }

    public void printSalesSlip() {
        System.out.println("Cart ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Type: " + type);
        System.out.println("Items:");

        for(Map.Entry<Product, Integer> i : productsAndQuantity.entrySet()){
            System.out.println(i.getKey().getName() + " Quantity: " + i.getValue());
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public Map<Product, Integer> getProducts() {
        return productsAndQuantity;
    }

    @Override
    public String toString() {
        return "Cart: " + "id='" + id + ", products=" + productsAndQuantity + ", date=" + date + ", type='" + type;
    }
}
