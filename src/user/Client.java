package user;
import product.Order;
import product.Product;
import product.ProductStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class Client extends AUser
{
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    private float saldo;    //niezaimplementowane
    private ArrayList<Order> orderList;

    public Client(ProductStorage productStorage) {
        super(productStorage);
    }

    @Override
    public String toString() {
        return this.getName() + this.getSurname();
    }

    public void createOrder()
    {
        int idx;
        int quan;
        String cond;
        ArrayList<Product> productInOrder = new ArrayList<>();

        while (true)
        {

            productStorage.showAllProducts();

            System.out.println("Select product by index");
            Scanner scanner = new Scanner(System.in);
            idx = scanner.nextInt();
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

            System.out.println("halo");
            product.setQuantity(quan);
            originalProduct.setQuantity(originalProduct.getQuantity()-quan);
            //do poprawy jezeli dwa razy ten sam product

            System.out.println("Do you want to continue? y, n ");

            cond = scanner.next();

            productInOrder.add(product);

            if(!cond.equals("y"))
                break;
        }

        Order order = new Order(productInOrder);
        orderList.add(order);
    }

    public void displayOrders()
    {
        for(int i = 0 ;i < orderList.size(); i++)
        {
            System.out.println("Order " + i);
            orderList.get(i).displayProductInOrders();
        }
    }

}
