package user;

import product.Product;
import product.ProductStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class Worker extends AUser
{
    private ArrayList<Client> clientList = new ArrayList<>();

    public Worker(String name, String surname, ProductStorage productStorage) {
        super(name, surname, productStorage);
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }

    public void addClientToClientList(Client c)
    {
        //tworzenie bazy clientow w main bedzie
        clientList.add(c);
    }

    public void displayClientList()
    {
        for(Client var : clientList)
        {
            System.out.println(var.toString());
        }
    }

    public void addProduct()
    {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String category = scanner.nextLine();
        int quantity = scanner.nextInt();
        float price = scanner.nextFloat();

        Product product = new Product(name, category, quantity, price);
        productStorage.addProductToStorage(product);
        scanner.close();
    }

    public void delProduct()
    {
        productStorage.showAllProducts();
        System.out.println("Which product you want to delete");

        Scanner scanner = new Scanner(System.in);

        int idx = scanner.nextInt();
        if(idx < 0 || idx >=productStorage.howManyProducts())
        {
            System.out.println("Wrong index");
        }
        else
        {
            productStorage.delProductByIndex(idx);
        }
        
        scanner.close();
    }

    @Override
    public String toString() {
        return "Worker: " + this.getName() + " " + this.getSurname();
    }
}