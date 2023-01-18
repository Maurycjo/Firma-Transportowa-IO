package product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProductStorageTest {
    DataTest dataTest;
    @BeforeEach
    void setUp() {
        dataTest = new DataTest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testShowAllProducts() {
        // Read STDOUT to String :|
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream PS = new PrintStream(test);
        PrintStream old = System.out;
        System.setOut(PS);
        dataTest.productStorage.showAllProducts();
        assertEquals("0 Cebula quantity: 100\n" +
                "1 Ziemniak quantity: 100\n" +
                "2 Pomidor quantity: 10\n",test.toString());
    }

    @Test
    void testAddProductToStorage() {

    }

    @Test
    void testCheckIfNameExist() {
        assertEquals(true, dataTest.productStorage.checkIfNameExist("Seler"));
        assertEquals(false, dataTest.productStorage.checkIfNameExist("Ziemniak"));
    }

    @Test
    void testDelProductByIndex() {
    }

    @Test
    void testGetProductByIndex() {
        assertEquals(dataTest.products.get(0),dataTest.productStorage.getProductByIndex(0));
        assertEquals(dataTest.products.get(1),dataTest.productStorage.getProductByIndex(1));
        assertEquals(dataTest.products.get(2),dataTest.productStorage.getProductByIndex(2));
    }

    @Test
    void testHowManyProducts() {
        assertEquals(dataTest.productStorage.getProductByIndex(0).getQuantity(),100);
        assertEquals(dataTest.productStorage.getProductByIndex(1).getQuantity(),100);
        assertEquals(dataTest.productStorage.getProductByIndex(2).getQuantity(),10);
    }
}