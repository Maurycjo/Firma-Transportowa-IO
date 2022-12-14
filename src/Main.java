import java.util.ArrayList;

import product.Product;
import product.ProductStorage;
import user.Client;
import user.Worker;

public class Main {
    public static void main(String[] args)
    {
        ProductStorage ps = new ProductStorage();
        ps.addProductToStorage(new Product("Ziemniaki", "zime", 1000, 50));
        ps.addProductToStorage(new Product("cebula", "polska", 100, 34));
        ps.addProductToStorage(new Product("Chleb", "niewarzywo", 10, 500));

        ArrayList<Client> clientList  = new ArrayList<>();
        clientList.add(new Client("Bartosz", "Jakis", ps));
        clientList.add(new Client("Joe", "Doe", ps));
        clientList.add(new Client("Parizad", "Uday", ps));

        ArrayList<Worker> workerList = new ArrayList<>();
        workerList.add(new Worker("Bob", "Pracownik", ps));
        workerList.get(0).setClientList(clientList);

        for (Client client : clientList) {
            System.out.println(client);
        }    

        for (Worker worker : workerList) {
           System.out.println(worker); 
        }

        // Usecase
        Client c = clientList.get(0);
        Worker w = workerList.get(0);

        // for client
        c.displayOrders();
        // c.createOrder();
        // c.displayOrders();

        // for worker
        w.displayClientList();
    }
}