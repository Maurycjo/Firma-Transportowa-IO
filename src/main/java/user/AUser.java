package user;

import product.ProductStorage;

public abstract class AUser implements IUser
{
    public ProductStorage productStorage;
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AUser(String name, String surname, ProductStorage productStorage) {
        this.name = name;
        this.surname = surname;
        this.productStorage = productStorage;
    }
}
