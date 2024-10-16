package mytests;
import base.CommonMethods;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(base.TestListener.class)
public class LoginTest extends CommonMethods {


    @Test
    public void LogoTest() throws InterruptedException {
        System.out.println("Hello");
       // driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("news", Keys.RETURN);
        sendTextEnter(google.search,"news");
        Thread.sleep(5000);

        //Assert.assertEquals(driver.findElement(By.xpath("//a[@aria-label='Amazon Business']")).isDisplayed(), true);
    }


}
