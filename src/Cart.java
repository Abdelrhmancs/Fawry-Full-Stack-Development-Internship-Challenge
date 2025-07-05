import java.util.*;
public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product p, int qty) {
        if (qty > p.getQuantity())
            throw new IllegalArgumentException("Not enough stock for " + p.getName());
        items.add(new CartItem(p, qty));
    }

    public List<CartItem> getItems() { return items; }
    public boolean isEmpty() { return items.isEmpty(); }
    public void clear() { items.clear(); }
}
