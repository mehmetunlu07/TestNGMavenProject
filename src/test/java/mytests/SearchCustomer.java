package mytests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchCustomer {

    @Test(priority=1)
    public void setUp(){
        System.out.println("Open browser");
    }

    @Test(priority=3)
    public void searchCustomer(){
        System.out.println("Searching a customer.....");
        Assert.assertEquals(2,2);
    }

    @Test(priority=2)
    public void addCustomer(){
        System.out.println("Adding a customer...");
    }

    @Test(priority=4)
    public void tearDown(){
        System.out.println("Close browser");
    }


}
