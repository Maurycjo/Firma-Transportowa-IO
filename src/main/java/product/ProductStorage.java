package product;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

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
    public void addProductToStorage(Product product) throws IllegalFormatCodePointException
    {
        this.productList.add(product);
    }

    public boolean checkIfNameExist(String name) throws IllegalFormatCodePointException
    {
        for(Product product : productList)
        {
            if(product.getName().equals(name)){
                return false;
            }
        }
        return true;
    }

    public void delProductByIndex(int idx) throws IllegalFormatCodePointException
    {
        productList.remove(idx);
    }

    public Product getProductByIndex(int idx) throws IllegalFormatCodePointException
    {
        return productList.get(idx);
    }

    public int howManyProducts() throws IllegalFormatCodePointException
    {
        return productList.size();
    }
}
