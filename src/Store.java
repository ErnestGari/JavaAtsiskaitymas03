import java.time.LocalDate;
import java.util.*;

public class Store {

    private List<InventoryItem> inventory;
    private List<Cart> carts;
    private List<InventoryItem> aisleInventory;

    public Store(){
        this.inventory = new ArrayList<>();
        this.carts = new ArrayList<>();
        this.aisleInventory = new ArrayList<>();
    }

    public void manageStoreCarts(Cart cart){
        carts.add(cart);
    }

    public void showIfCartsRemoved(){
        for (Cart i: carts){
            i.printSalesSlip();
            System.out.println();
        }
    }

    public void checkOutCart(Cart cart){

        for(Map.Entry<Product, Integer> i : cart.getProducts().entrySet()){
            Product product = i.getKey();
            int quantity = i.getValue();
            if(cart.getType().equals("Physical")) {
                for (InventoryItem j : aisleInventory) {
                    if (j.getProduct().equals(product)) {
                        j.sellItem(quantity);
                    }
                }
            }else if (cart.getType().equals("Virtual")){
                for (InventoryItem j : inventory) {
                    if (j.getProduct().equals(product)) {
                        j.sellItem(quantity);
                    }
                }
            }
        }
    }

    public void abandonCarts() {
        LocalDate today = LocalDate.now();
        int i = 0;
        while (i < carts.size()){
            if(!carts.get(i).getDate().equals(today)) {
                carts.remove(i);
                i = 0;
            }
            i++;
        }
    }

    public void listProductsByCategory(String category){
        for(InventoryItem i: aisleInventory){
            if(i.getProduct().getCategory().equals(category)){
                System.out.println(i + " From: " + i.getProduct().getCategory());
            }
        }
    }

    public void addInventoryItem(InventoryItem item) {
        inventory.add(item);
        if (item.getProduct().getCategory() != null) {
            aisleInventory.add(item);
        }
    }
}