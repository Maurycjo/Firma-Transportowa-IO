package junit4.product;

import data.DataTest;
import intefaces.TestControl;
import intefaces.TestEntity;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import product.ProductStorage;
import user.Client;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category({TestControl.class, TestEntity.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class OrderTest {
    static DataTest dataTest;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Parameterized.Parameter
    public Client clientParam;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        dataTest = new DataTest();
        ProductStorage storage = dataTest.productStorage;
        Object[][] data1 =
                new Object[][]{
                        {new Client("Bartosz","Ostrowski",storage)},
                        {new Client("Bartosz","Ostrowski",storage)}
                };
        return Arrays.asList(data1);
    }

    @Before
    public void setUp() {
        dataTest = new DataTest();
    }
    @Test
    public void testCalculatePrice() {
        for(var o: dataTest.orders) {
            o.calculatePrice();
        }

        assertEquals(dataTest.orders.get(0).getPrice(),3400.0F);
        assertEquals(dataTest.orders.get(1).getPrice(),6800.0F);
        assertEquals(dataTest.orders.get(2).getPrice(),11800.0F);
    }

    @Test
    public void testDisplayProductsInOrder() {
        // Read STDOUT to String :|
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream PS = new PrintStream(test);
        PrintStream old = System.out;
        System.setOut(PS);
        dataTest.orders.get(0).displayProductsInOrder();
        assertEquals("0 Cebula quantity: 100\n",test.toString());
    }
}