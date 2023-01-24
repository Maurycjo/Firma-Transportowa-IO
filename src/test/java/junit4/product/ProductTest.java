package junit4.product;

import data.DataTest;
import intefaces.TestControl;
import intefaces.TestEntity;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category({TestControl.class, TestEntity.class})
public class ProductTest {
    static DataTest dataTest;

    @Before
    public void setUp() {
        dataTest = new DataTest();
    }

    @Test
    public void testToString() {
        String expectedOutput1 = "Cebula quantity: 100";
        String expectedOutput2 = "Ziemniak quantity: 100";
        String expectedOutput3 = "Pomidor quantity: 10";

        assertEquals(expectedOutput1,dataTest.products.get(0).toString());
        assertEquals(expectedOutput2,dataTest.products.get(1).toString());
        assertEquals(expectedOutput3,dataTest.products.get(2).toString());
    }

    @Test
    public void testIfQuantityThrowException() throws ArithmeticException{
        Assertions.assertThrows(ArithmeticException.class, () -> {
            dataTest.products.get(0).setQuantity(-1);
        });
    }

    @Test
    public void testIfQuantityIsZero() {
        dataTest.products.get(0).setQuantity(0);
        assertEquals(0,dataTest.products.get(0).getQuantity());
    }
}