import java.util.*;
public class CheckoutService {
    public static void checkout(Customer customer) {
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            if (p instanceof Expirable && ((Expirable) p).isExpired()) {
                System.out.println("Error: " + p.getName() + " is expired.");
                return;
            }

            if (qty > p.getQuantity()) {
                System.out.println("Error: Not enough stock for " + p.getName());
                return;
            }

            subtotal += item.getTotalPrice();

            if (p instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                    toShip.add((Shippable) p);
                }
            }
        }

        double shippingCost = ShippingService.calculateShipping(toShip);
        double total = subtotal + shippingCost;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.deduct(total);

        for (CartItem item : cart.getItems()) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-10s\t%.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal \t%.0f\n", subtotal);
        System.out.printf("Shipping \t%.0f\n", shippingCost);
        System.out.printf("Amount   \t%.0f\n", total);

        cart.clear();
    }
}
