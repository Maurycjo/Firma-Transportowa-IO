package user;
import product.Order;
import product.Product;
import product.ProductStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class Client extends AUser
{
    private ArrayList<Order> orderList = new ArrayList<>();

    public Client(String name, String surname, ProductStorage productStorage) {
        super(name, surname, productStorage);
    }

    public void createOrder()
    {
        int idx;
        int quan;
        int maxProducts;
        int checkQuan;
        String cond;
        boolean leave = true;
        ArrayList<Product> productInOrder = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (leave)
        {
            productStorage.showAllProducts();
            System.out.println("Select product by index");
            idx = scanner.nextInt();

            
            maxProducts = productStorage.howManyProducts();            
            if (idx < 0 || idx >= maxProducts) {
                System.out.println("Wrong index, select again");
                continue;
            }
            
            checkQuan = productStorage.getProductByIndex(idx).getQuantity();

            if(checkQuan<= 0) {
                System.out.println("Product out of stock!");
                continue;
            }

            Product originalProduct = productStorage.getProductByIndex(idx);
            Product product = new Product(originalProduct.getName(), originalProduct.getCategory(), originalProduct.getPrice());

            System.out.println("How many? Please choose between <0, " + originalProduct.getQuantity() + ">");

            quan = scanner.nextInt();
            System.out.println(quan);

            while (quan > (originalProduct.getQuantity()) || quan <=0)
            {
                System.out.println("Wrong quantity, please choose between <0, " + originalProduct.getQuantity() + ">");
                quan = scanner.nextInt();
            }

            product.setQuantity(quan);
            originalProduct.setQuantity(originalProduct.getQuantity()-quan);
            //do poprawy jezeli dwa razy ten sam product

            System.out.println("Do you want to continue? y, n ");

            cond = scanner.next();

            productInOrder.add(product);

            if(!cond.equals("y"))
                break;
        }

        scanner.close();

        Order order = new Order(productInOrder);

        orderList.add(order);
    }

    public void displayOrders()
    {
        if(orderList.size() <= 0){
            System.out.println("No orders!");  
        } 
        else {
            for(int i = 0 ; i < orderList.size(); i++)
            {
                System.out.println("Order " + i);
                orderList.get(i).displayProductsInOrder();
            }
        }
    }

    @Override
    public String toString() {
        return "Client: " + this.getName() + " " +  this.getSurname();
    }
}
