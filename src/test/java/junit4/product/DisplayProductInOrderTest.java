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
import org.junit.rules.TestName;
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

@Category({TestControl.class})
@RunWith(Parameterized.class)
public class DisplayProductInOrderTest{
    static DataTest dataTest;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Rule
    public TestName name = new TestName();

    @Parameterized.Parameter(value=0)
    public int orderNumber;
    @Parameterized.Parameter(value=1)
    public String text;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        dataTest = new DataTest();
        ProductStorage storage = dataTest.productStorage;
        Object[][] data1 =
                new Object[][]{
                        {0,"0 Cebula quantity: 100\n"},
                        {1,"0 Cebula quantity: 100\n1 Ziemniak quantity: 100\n"},
                        {2,"0 Cebula quantity: 100\n1 Ziemniak quantity: 100\n2 Pomidor quantity: 10\n"},
                };
        return Arrays.asList(data1);
    }

    @Before
    public void setUp() {
        dataTest = new DataTest();
    }

    @Test
    public void testDisplayProductsInOrder() {
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream PS = new PrintStream(test);
        PrintStream old = System.out;
        System.setOut(PS);
        dataTest.orders.get(orderNumber).displayProductsInOrder();
        assertEquals(text,test.toString());
        System.setOut(old);
        System.out.println("Test: " + name.getMethodName());
        System.out.println("Expected displays:");
        dataTest.orders.get(orderNumber).displayProductsInOrder();
        System.out.println("Test passed\n");
    }
}
