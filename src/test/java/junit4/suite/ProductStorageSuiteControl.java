package junit4.suite;


import intefaces.TestControl;
import intefaces.TestEntity;
import junit4.product.ProductStorageTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({ProductStorageTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory({TestControl.class, TestEntity.class})
public class ProductStorageSuiteControl{
}
