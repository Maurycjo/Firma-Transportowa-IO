package fitnessefixtureTests;

import data.DataTest;
import fit.ColumnFixture;
import product.Product;
import user.Client;

public class TestOrder extends ColumnFixture {


    int orderIndex;
    int productIndex;

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

    public String getName() {
        return datatest.orders.get(orderIndex).getProductList().get(productIndex).getName();
    }

    public String getCategory() {
        return datatest.orders.get(orderIndex).getProductList().get(productIndex).getCategory();
    }

    public int getQuantity() {
        return datatest.orders.get(orderIndex).getProductList().get(productIndex).getQuantity();
    }

    public float getPrice() {
        return datatest.orders.get(orderIndex).getProductList().get(productIndex).getPrice();
    }

    String name;
    String category;
    int quantity;
    float price;

    public static DataTest datatest = new DataTest();
    Client client = SetUp.app.clientList.get(0);


        public float testCalculatePrice() {

            var myOrder = datatest.orders.get(orderIndex);
            client.getOrderList().add(myOrder);
            myOrder.calculatePrice();
            return myOrder.getPrice();
            }

        public int howManyProducts()
        {
            return datatest.orders.get(orderIndex).howManyProducts();
        }

        public boolean addProductToOrder() throws ArithmeticException{
            try {
                datatest.orders.get(orderIndex).addProductToOrder(new Product(name, category,quantity,price));
                return true;
            }catch (Exception e){}
            return false;


        }


    }
