package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    //@Parameters({"browser"})
    @BeforeMethod(alwaysRun=true)
    public WebDriver setup(){
    String browserName="chrome";
        switch(browserName){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            default:
                System.out.println("Please pass the correct browser..");
        }
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        PageInitializer.initialize();
        return driver;

    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
