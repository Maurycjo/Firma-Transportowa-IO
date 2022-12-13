package user;

import product.ProductStorage;

public abstract class AUser implements IUser
{

    protected ProductStorage productStorage;
    private String name;
    private String surname;
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AUser(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }
}
