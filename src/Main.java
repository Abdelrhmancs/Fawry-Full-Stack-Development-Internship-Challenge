import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Abdelrahman", 1000);


        Cheese cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 3, LocalDate.now().plusDays(2), 0.7);
        TV tv = new TV("TV", 5000, 10, 5.0);
        ScratchCard scratchCard = new ScratchCard("Scratch Card", 25, 10);


        Cart cart = customer.getCart();
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 1);


        CheckoutService.checkout(customer);


    }
}
