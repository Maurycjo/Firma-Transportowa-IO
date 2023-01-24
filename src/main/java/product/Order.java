package product;

import java.util.ArrayList;

public class Order
{
    public ArrayList<Product> getProductList() {
        return productList;
    }

    private ArrayList<Product> productList = new ArrayList<Product>();
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Order(ArrayList<Product> productList)
    {
        this.productList = productList;
        calculatePrice();
    }

    public void calculatePrice()
    {
        float sum = 0;
        for (Product var : productList)
        {
            sum += var.getPrice() * var.getQuantity();
        }

        this.price = sum;
    }


    public void displayProductsInOrder()
    {
        for(int i=0; i<productList.size(); i++)
        {
            System.out.println(i + " " +  productList.get(i).toString());
        }
    }

    public int howManyProducts()
    {
        return productList.size();
    }

    public void addProductToOrder(Product product){
        productList.add(product);
    }
}
