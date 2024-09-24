package mytests;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    @Test(priority=1)
    public void loginPageTest() throws InterruptedException {
        System.out.println("Selam");
        Assert.assertEquals(driver.getTitle(),"Google");
        Thread.sleep(3000);

    }

    @Test(priority=2)
    public void LogoTest() throws InterruptedException {
        System.out.println("Hello");
        driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("news", Keys.RETURN);
        Thread.sleep(2000);

        //Assert.assertEquals(driver.findElement(By.xpath("//a[@aria-label='Amazon Business']")).isDisplayed(), true);
    }


}
