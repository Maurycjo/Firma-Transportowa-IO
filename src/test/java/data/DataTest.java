package data;

import com.sun.tools.javac.Main;
import product.Order;
import product.Product;
import product.ProductStorage;
import user.Client;
import user.Worker;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataTest {

    public Main main;
    public ProductStorage productStorage = new ProductStorage();
    public ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Order> orders = new ArrayList<>();
    public ArrayList<Client> clientList = new ArrayList<>();
    public ArrayList<Worker> workerList = new ArrayList<>();

    public Product newProduct = new Product("Marchewka","Warzywo",10,50.0F);
    public DataTest(){
        // Fill products
        products.add(new Product("Cebula", "Warzywo", 100, 34.0F)); // Cebula quantity: 100
        products.add(new Product("Ziemniak", "Warzywo", 100, 34.0F)); // Ziemniak quantity: 100
        products.add(new Product("Pomidor", "Owoc", 10, 500.0F)); // Pomidor quantity: 10

        // Create productStorage
        for(var p: products) {
            productStorage.addProductToStorage(p);
        }

        // Create orders
        orders.add(new Order(new ArrayList<>(Arrays.asList(productStorage.getProductByIndex(0)))));
        orders.add(new Order(new ArrayList<>(Arrays.asList(productStorage.getProductByIndex(0),productStorage.getProductByIndex(1)))));
        orders.add(new Order(new ArrayList<>(Arrays.asList(productStorage.getProductByIndex(0),productStorage.getProductByIndex(1),productStorage.getProductByIndex(2)))));

        // Create clients
        clientList.add(new Client("Bartosz", "Jakis", productStorage));
        clientList.add(new Client("Joe", "Doe", productStorage));
        clientList.add(new Client("Parizad", "Uday", productStorage));

        // Create workers
        workerList.add(new Worker("Bob", "Pracownik", productStorage));
        workerList.get(0).setClientList(clientList);
    }
}
