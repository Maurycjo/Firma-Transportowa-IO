package product;

public class Product implements IProduct
{
    private String name;
    private String category;
    private int quantity;
    private float price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        if(quantity < 0)
            throw new ArithmeticException("Quantity have to be greater than 0!");
        else
            this.quantity = quantity;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    public Product(String name, String category, int quantity, float price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String name, String category, float price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " quantity: " + this.quantity;
    }
}
