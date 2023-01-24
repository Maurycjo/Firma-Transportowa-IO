package product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest{
    DataTest dataTest;

    @BeforeEach
    void setUp() {
        dataTest = new DataTest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCalculatePrice() {
        for(var o: dataTest.orders) {
            o.calculatePrice();
        }

        assertEquals(dataTest.orders.get(0).getPrice(),3400.0F);
        assertEquals(dataTest.orders.get(1).getPrice(),6800.0F);
        assertEquals(dataTest.orders.get(2).getPrice(),11800.0F);
    }

    @Test
    void testDisplayProductsInOrder() {
        // Read STDOUT to String :|
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream PS = new PrintStream(test);
        PrintStream old = System.out;
        System.setOut(PS);
        dataTest.orders.get(0).displayProductsInOrder();
        assertEquals("0 Cebula quantity: 100\n",test.toString());
    }
}