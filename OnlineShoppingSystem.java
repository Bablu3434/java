import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(id + "  " + name + "  ₹" + price);
    }
}

public class OnlineShoppingSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    // Add products
    static void addProducts() {
        products.add(new Product(101, "Laptop", 55000));
        products.add(new Product(102, "Mobile Phone", 20000));
        products.add(new Product(103, "Headphones", 1500));
        products.add(new Product(104, "Keyboard", 800));
        products.add(new Product(105, "Mouse", 500));
        products.add(new Product(106, "Smart Watch", 3000));
    }

    // Display products
    static void showProducts() {

        System.out.println("\n========== PRODUCT LIST ==========");
        System.out.println("ID     Product              Price");
        System.out.println("----------------------------------");

        for (Product p : products) {
            p.display();
        }
    }

    // Search product
    static void searchProduct() {

        sc.nextLine();

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Product p : products) {

            if (p.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println("\nProduct Found:");
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    // Add product to cart
    static void addToCart() {

        showProducts();

        System.out.print("\nEnter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {

            if (p.id == id) {
                cart.add(p);

                System.out.println(
                    p.name + " added to cart successfully!"
                );

                return;
            }
        }

        System.out.println("Invalid Product ID.");
    }

    // Show cart
    static void showCart() {

        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        System.out.println("\n========== YOUR CART ==========");

        double total = 0;

        for (Product p : cart) {
            p.display();
            total += p.price;
        }

        System.out.println("--------------------------------");
        System.out.println("Total Amount = ₹" + total);
    }

    // Checkout
    static void checkout() {

        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        double total = 0;

        for (Product p : cart) {
            total += p.price;
        }

        System.out.println("\n========== CHECKOUT ==========");
        System.out.println("Total Amount: ₹" + total);

        sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Cash on Delivery");
        System.out.println("2. UPI");
        System.out.println("3. Card");

        System.out.print("Enter choice: ");
        int payment = sc.nextInt();

        String method;

        switch (payment) {

            case 1:
                method = "Cash on Delivery";
                break;

            case 2:
                method = "UPI";
                break;

            case 3:
                method = "Card";
                break;

            default:
                method = "Cash on Delivery";
                System.out.println("Invalid choice. COD selected.");
        }

        System.out.println("\n========== ORDER CONFIRMED ==========");
        System.out.println("Customer Name : " + name);
        System.out.println("Total Amount  : ₹" + total);
        System.out.println("Payment       : " + method);
        System.out.println("Order Status  : Confirmed");
        System.out.println("=====================================");

        cart.clear();
    }

    // Main method
    public static void main(String[] args) {

        addProducts();

        while (true) {

            System.out.println("\n====================================");
            System.out.println("       ONLINE SHOPPING SYSTEM");
            System.out.println("====================================");
            System.out.println("1. View Products");
            System.out.println("2. Search Product");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.println("====================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showProducts();
                    break;

                case 2:
                    searchProduct();
                    break;

                case 3:
                    addToCart();
                    break;

                case 4:
                    showCart();
                    break;

                case 5:
                    checkout();
                    break;

                case 6:
                    System.out.println(
                        "\nThank you for shopping with us!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice! Please try again."
                    );
            }
        }
    }
}
