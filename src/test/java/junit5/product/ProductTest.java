package junit5.product;

import data.DataTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    DataTest dataTest;

    @BeforeEach
    void setUp() {
        dataTest = new DataTest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        String expectedOutput1 = "Cebula quantity: 100";
        String expectedOutput2 = "Ziemniak quantity: 100";
        String expectedOutput3 = "Pomidor quantity: 10";

        assertEquals(expectedOutput1,dataTest.products.get(0).toString());
        assertEquals(expectedOutput2,dataTest.products.get(1).toString());
        assertEquals(expectedOutput3,dataTest.products.get(2).toString());
    }

    @Test
    void testIfQuantityThrowException() throws ArithmeticException{
        Assertions.assertThrows(ArithmeticException.class, () -> {
            dataTest.products.get(0).setQuantity(-1);
        });
    }

    @Test
    void testIfQuantityIsZero() {
        dataTest.products.get(0).setQuantity(0);
        assertEquals(0,dataTest.products.get(0).getQuantity());
    }
}