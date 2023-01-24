package junit4.suite;


import intefaces.TestControl;
import intefaces.TestEntity;
import junit4.product.CalculatePriceTest;
import junit4.product.DisplayProductInOrderTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({CalculatePriceTest.class,DisplayProductInOrderTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory({TestControl.class, TestEntity.class})
public class OrderTestSuiteControl {
}