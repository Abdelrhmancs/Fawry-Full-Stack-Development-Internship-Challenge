import java.util.*;
public class ShippingService {
    public static double calculateShipping(List<Shippable> items) {
        double totalWeight = 0;

        System.out.println("** Shipment notice **");
        for (Shippable item : items) {
            double weight = item.getWeight();
            totalWeight += weight;
            System.out.printf("%s\t%.0fg\n", ((Product)item).getName(), weight * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
        return totalWeight * 30; // السعر لكل كيلو
    }
}
