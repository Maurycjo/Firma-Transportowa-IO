package junit4.product;

import data.DataTest;
import intefaces.TestControl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category({TestControl.class})
@RunWith(Parameterized.class)
public class CalculatePriceTest{
    static DataTest dataTest;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Rule
    public TestName name = new TestName();

    @Parameterized.Parameter(value=0)
    public int orderNumber;
    @Parameterized.Parameter(value=1)
    public float price;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 =
                new Object[][]{
                        {0, 3400.0F},
                        {1, 6800.0F},
                        {2, 11800.0F},
                        {3, -100.0F}
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

        System.out.println("Test: " + name.getMethodName());
        System.out.println("Current order "+orderNumber);

        if(orderNumber == 3) {
            System.out.println("Exception case");
            exception.expect(IndexOutOfBoundsException.class);
            exception.expectMessage("Index 3 out of bounds for length 3");
            dataTest.orders.get(orderNumber).displayProductsInOrder();
        }

        System.out.println("Current price: "+dataTest.orders.get(orderNumber).getPrice()+"\n");
        assertEquals(dataTest.orders.get(orderNumber).getPrice(),price);
    }
}
