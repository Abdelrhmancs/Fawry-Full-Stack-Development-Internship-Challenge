
public class CartItem {
     Product product;
     int quantity;
     public CartItem(Product product, int quantity) {
         this.product = product;
         this.quantity = quantity;
     }

     public double getTotalPrice() {
         return product.price * quantity;
     }
     public Product getProduct() {
         return product;
     }
     public int getQuantity() {
         return quantity;
     }


}
