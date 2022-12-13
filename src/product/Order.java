package product;

import java.util.ArrayList;

public class Order
{
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float price;
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice() {
        return price;
    }

    public Order(ArrayList<Product> productList)
    {
        this.productList = productList;
        calculatePrice();

    }

    private void calculatePrice()
    {
        float sum = 0;
        for (Product var : productList)
        {
            sum += var.getPrice() * var.getQuantity();
        }

        this.price = sum;
    }

    public void displayProductInOrders()
    {
        for(int i=0; i<productList.size(); i++)
        {
            System.out.println(i + " " +  productList.get(i).toString());
        }
    }

}
