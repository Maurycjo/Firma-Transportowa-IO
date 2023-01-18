package product;

import com.sun.jdi.event.ExceptionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    String productName;
    String productCategory;
    int productQuantity;
    float productPrice;
    ArrayList<Product> products = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.productName = "Cebula";
        this.productCategory = "Warzywo";
        this.productQuantity = 100;
        this.productPrice = 34.0F;
        products.add(new Product(productName, productCategory, productQuantity, productPrice)); // Cebula quantity: 100
        products.add(new Product("Ziemniak", "Warzywo", 100, 34)); // Ziemniak quantity: 100
        products.add(new Product("Pomidor", "Owoc", 10, 500)); // Pomidor quantity: 10
    }

    @AfterEach
    void tearDown() {
        products.clear();
    }

    @Test
    void testToString() {
        String expectedOutput1 = "Cebula quantity: 100";
        String expectedOutput2 = "Ziemniak quantity: 100";
        String expectedOutput3 = "Pomidor quantity: 10";

        assertEquals(products.get(0).toString(),expectedOutput1);
        assertEquals(products.get(1).toString(),expectedOutput2);
        assertEquals(products.get(2).toString(),expectedOutput3);
    }

    @Test
    void testIfQuantityThrowException() throws ArithmeticException{
        Assertions.assertThrows(ArithmeticException.class, () -> {
            products.get(0).setQuantity(-1);
        });
    }

    @Test
    void testIfQuantityIsZero() {
        products.get(0).setQuantity(0);
        assertEquals(products.get(0).getQuantity(),0);
    }
}