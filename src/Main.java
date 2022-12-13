import product.Product;
import product.ProductStorage;
import user.Client;

public class Main {
    public static void main(String[] args)
    {
        ProductStorage ps = new ProductStorage();
        ps.addProductToStorage(new Product("Ziemniaki", "zime", 1000, 50));
        ps.addProductToStorage(new Product("cebula", "polska", 100, 34));
        ps.addProductToStorage(new Product("Chleb", "niewarzywo", 10, 500));

        Client c = new Client(ps);
        c.createOrder();

    }
}