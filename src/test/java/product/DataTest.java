package product;

import java.util.ArrayList;
import java.util.Arrays;

public class DataTest {

    ProductStorage productStorage = new ProductStorage();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    DataTest(){
        // Fill products
        products.add(new Product("Cebula", "Warzywo", 100, 34.0F)); // Cebula quantity: 100
        products.add(new Product("Ziemniak", "Warzywo", 100, 34.0F)); // Ziemniak quantity: 100
        products.add(new Product("Pomidor", "Owoc", 10, 500.0F)); // Pomidor quantity: 10

        // Create storage
        for(var p: products) {
            productStorage.addProductToStorage(p);
        }

        // Create orders
        orders.add(new Order(new ArrayList<>(Arrays.asList(productStorage.getProductByIndex(0)))));
        orders.add(new Order(new ArrayList<>(Arrays.asList(productStorage.getProductByIndex(0),productStorage.getProductByIndex(1)))));
        orders.add(new Order(new ArrayList<>(Arrays.asList(productStorage.getProductByIndex(0),productStorage.getProductByIndex(1),productStorage.getProductByIndex(2)))));
    }
}
