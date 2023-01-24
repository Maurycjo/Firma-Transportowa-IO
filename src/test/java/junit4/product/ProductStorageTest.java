package junit4.product;

import data.DataTest;
import intefaces.TestControl;
import intefaces.TestEntity;
import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category({TestControl.class, TestEntity.class})
public class ProductStorageTest {
    static DataTest dataTest;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Rule
    public TestName name = new TestName();

    @Before
    public void setUp() {
        dataTest = new DataTest();
    }

    @Test
    public void testShowAllProducts() {
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
    public void testAddProductToStorage() {
        dataTest.productStorage.addProductToStorage(dataTest.newProduct);
        assertEquals(false,dataTest.productStorage.checkIfNameExist("Marchewka"));
    }

    @Test
    public void testCheckIfNameExist() {
        assertEquals(true, dataTest.productStorage.checkIfNameExist("Seler"));
        assertEquals(false, dataTest.productStorage.checkIfNameExist("Ziemniak"));
    }

    @Test
    public void testDelProductByIndex() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            dataTest.productStorage.delProductByIndex(5);
        });
    }

    @Test
    public void testGetProductByIndex() {
        assertEquals(dataTest.products.get(0),dataTest.productStorage.getProductByIndex(0));
        assertEquals(dataTest.products.get(1),dataTest.productStorage.getProductByIndex(1));
        assertEquals(dataTest.products.get(2),dataTest.productStorage.getProductByIndex(2));
    }

    @Test
    public void testHowManyProducts() {
        assertEquals(dataTest.productStorage.getProductByIndex(0).getQuantity(),100);
        assertEquals(dataTest.productStorage.getProductByIndex(1).getQuantity(),100);
        assertEquals(dataTest.productStorage.getProductByIndex(2).getQuantity(),10);
    }
}