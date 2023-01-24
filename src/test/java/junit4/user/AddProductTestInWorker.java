package junit4.user;

import intefaces.TestControl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import product.Product;
import product.ProductStorage;
import user.Worker;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Category({TestControl.class})
public class AddProductTestInWorker {
    @Test
    public void addProduct() {
        ProductStorage storage = new ProductStorage();
        Worker worker = new Worker("Maurycy", "Niewczas", storage);

        storage.addProductToStorage(new Product("cebula", "polska", 100, 34));
        storage.addProductToStorage(new Product("Chleb", "pieczywo", 10, 500));

        assertEquals("cebula", storage.getProductByIndex(0).getName());
        assertEquals("polska", storage.getProductByIndex(0).getCategory());
        assertEquals(100, storage.getProductByIndex(0).getQuantity());
        assertEquals(34, storage.getProductByIndex(0).getPrice());
        assertEquals("Chleb", storage.getProductByIndex(1).getName());
    }




}