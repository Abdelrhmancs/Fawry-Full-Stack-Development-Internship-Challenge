import java.time.LocalDate;

public class Biscuits extends  Product implements Expirable , Shippable{
    private LocalDate expiryDate;
    private double weight;

    public Biscuits(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public  double getWeight() {
        return weight;
    }
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
