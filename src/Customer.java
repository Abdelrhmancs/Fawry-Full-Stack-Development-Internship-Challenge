public class Customer {
    String name;
    double balance;
    Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Cart getCart() { return cart; }
    public double getBalance() { return balance; }
    public void deduct(double amt) { balance -= amt; }
}
