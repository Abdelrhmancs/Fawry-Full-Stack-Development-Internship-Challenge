abstract class Product {
    public String name;
    public double price;
    public int quantity;


    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public  int setQuantity(int quantity){
       return this.quantity = quantity;
    }
    public void decreaseQuantity(int q) { quantity -= q; }
    public abstract boolean isExpired();

}
