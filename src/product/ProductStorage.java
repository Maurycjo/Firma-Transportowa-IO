package product;

import java.util.ArrayList;

public class ProductStorage
{
    private ArrayList<Product> productList = new ArrayList<Product>();
    public void showAllProducts()
    {
        for(int i=0; i<productList.size(); i++)
        {
            System.out.println(i + " " +  productList.get(i).toString());
        }
    }
    public void addProductToStorage(Product product)
    {
        this.productList.add(product);

    }
    public Product getProductByIndex(int idx)
    {
        return productList.get(idx);
    }

    public int howManyProducts()
    {
        return productList.size();
    }
    public void delProductByIndex(int idx)
    {
        productList.remove(idx);
    }
}
