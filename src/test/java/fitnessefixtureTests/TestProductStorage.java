package fitnessefixtureTests;
import fit.ColumnFixture;
import product.Product;

import java.util.IllegalFormatCodePointException;


public class TestAddProductToStorage extends ColumnFixture{

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String name;
    public String category;
    public int quantity;
    public float price;

    //static ProductStorage storage;

    public void setNumber(int number) {
        number = number;
    }

    public int number;

    public int indexToRemove;

   public boolean addProductToStorage() throws IllegalFormatCodePointException {
       int s1 = howManyProducts();
    try {
        SetUp.storage.addProductToStorage(new Product(name, category, quantity, price));
        int s2 = howManyProducts();
        return (s1 != s2);
        } catch(IllegalFormatCodePointException e){}
    return false;
   }

   public boolean removeProductFromStorage()
   {
       if(indexToRemove<0||indexToRemove>=howManyProducts()) {
           return false;
       }
       SetUp.storage.delProductByIndex(indexToRemove);

       return true;
   }

   public int howManyProducts(){
       return SetUp.storage.howManyProducts();
   }
   public int getNumber()
   {
       return number;
   }




}
