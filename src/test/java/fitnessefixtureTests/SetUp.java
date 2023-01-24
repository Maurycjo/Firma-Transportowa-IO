package fitnessefixtureTests;

import Aplication.App;
import fit.Fixture;
import product.ProductStorage;

public class SetUp extends Fixture {
    //static ProductStorage storage;
    static App app;

    public SetUp(){
      //  storage = new ProductStorage();
        app = new App();

    }
}
