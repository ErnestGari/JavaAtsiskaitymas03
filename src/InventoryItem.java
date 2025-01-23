public class InventoryItem {
    private final Product product;
    private int total;
    private int reserve;
    private final int reorder;
    private final int low;
    private double salesPrice;

    public InventoryItem(Product product, int total, int reserve, int reorder, int low, double salesPrice) {
        this.product = product;
        this.total = total;
        this.reserve = reserve;
        this.reorder = reorder;
        this.low = low;
        this.salesPrice = salesPrice;
    }

    public Product getProduct() {
        return product;
    }

    public int getQtyTotal() {
        return total;
    }

    public int getQtyReserved() {
        return reserve;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void reserveItem(int quantity) {
        if (total >= quantity) {
            reserve += quantity;
            total -= quantity;
        }
    }

    public void releaseItem(int quantity) {
        if (reserve >= quantity) {
            reserve -= quantity;
            total += quantity;
        }
    }

    public void sellItem(int quantity) {
        if (reserve >= quantity) {
            reserve -= quantity;
        }
    }

    public void placeInventoryOrder() {
        if (total <= low) {
            total += reorder;
        }
    }

    @Override
    public String toString() {
        return "InventoryItem: " + "product=" + product + ", total=" + total + ", reserve=" + reserve + ", salesPrice=" + salesPrice;
    }
}