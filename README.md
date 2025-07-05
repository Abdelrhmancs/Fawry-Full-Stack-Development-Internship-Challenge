
# Simple E-Commerce System (Java OOP)

This project simulates a basic e-commerce system using object-oriented programming in Java. It supports:

- Products (with name, price, quantity)
- Expirable products (e.g., Cheese, Biscuits)
- Shippable products with weight (e.g., Cheese, TV)
- Virtual products (e.g., Scratch Cards)
- Cart system
- Checkout with:
  - Expiry check
  - Stock check
  - Shipping cost (30 EGP per kg)
  - Balance validation
  - Console receipt

---

## How to Run

1. Open the project in IntelliJ IDEA or any Java IDE.
2. Compile all `.java` files.
3. Replace the `main` method with any test case below.
4. Run the program.
5. Check the console output.

---

## Test Cases (Code + Output Combined)

---

### Test Case 1

```java
Customer customer = new Customer("Abdelrahman", 1000);

Cheese cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
Biscuits biscuits = new Biscuits("Biscuits", 150, 3, LocalDate.now().plusDays(2), 0.7);
ScratchCard scratchCard = new ScratchCard("Scratch Card", 25, 10);

Cart cart = customer.getCart();
cart.addProduct(cheese, 2);
cart.addProduct(biscuits, 1);
cart.addProduct(scratchCard, 1);

CheckoutService.checkout(customer);
```

```
** Shipment notice **
Cheese	400g
Biscuits	700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese       200
1x Biscuits     150
1x Scratch Card 25
----------------------
Subtotal        375
Shipping        33
Amount          408
```

---

### Test Case 2

```java
Customer customer = new Customer("Ali", 1000);
TV tv = new TV("TV", 5000, 2, 5.0);

Cart cart = customer.getCart();
cart.addProduct(tv, 3);
CheckoutService.checkout(customer);
```

```
Exception: TV out of stock
```

---

### Test Case 3

```java
Customer customer = new Customer("Salma", 800);
Cart cart = customer.getCart();
CheckoutService.checkout(customer);
```

```
Exception: Cart is empty
```

---

### Test Case 4

```java
Customer customer = new Customer("Youssef", 1000);
Cheese expiredCheese = new Cheese("Cheese", 100, 5, LocalDate.now().minusDays(1), 0.2);

Cart cart = customer.getCart();
cart.addProduct(expiredCheese, 1);
CheckoutService.checkout(customer);
```

```
Exception: Cheese is expired
```

---

### Test Case 5

```java
Customer customer = new Customer("Nada", 100);
TV tv = new TV("TV", 5000, 2, 5.0);

Cart cart = customer.getCart();
cart.addProduct(tv, 1);
CheckoutService.checkout(customer);
```

```
Exception: Insufficient balance!
```

---
