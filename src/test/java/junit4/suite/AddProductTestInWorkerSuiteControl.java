package junit4.suite;

import intefaces.TestControl;
import intefaces.TestEntity;
import junit4.user.AddProductTestInWorker;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({AddProductTestInWorker.class})
@RunWith(Categories.class)
@Categories.IncludeCategory({TestControl.class, TestEntity.class})
public class AddProductTestInWorkerSuiteControl{
}
