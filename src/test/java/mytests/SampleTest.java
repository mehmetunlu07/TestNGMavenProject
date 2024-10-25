package mytests;

import base.CommonMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Listeners(base.TestListener.class)
public class SampleTest extends CommonMethods {


    @Test
    public void test() throws InterruptedException, IOException {
        /*
        Task:
        1.Navigate https://liquidation.com
        2.Fetch web page URL and Title
        3.Search furniture
        4.Select all products related with furniture and write to console and select first Truckload product
        5. Take the screenshot of Truckload product
        6.Find the Auction Id and write to the console
        */

        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println(url + "  -  " + title);

       driver.findElement(By.xpath("//input[@id='searchparam_words']")).sendKeys("furniture",Keys.ENTER);
       List<WebElement> list=driver.findElements(By.cssSelector(".shortDesc"));

       for(WebElement e:list){
           String product=e.getText();
           System.out.println(product);

           if(product.contains("Truckload")){
               e.click();
               break;
           }
       }

        Thread.sleep(2000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/test/java/screenshots/screenshot.png");
        FileUtils.copyFile(srcFile, destFile);

        WebElement el=driver.findElement(By.xpath("//div[@id='modalSellerRatings']/following-sibling::div[2]//div[2]"));
        String auctionId=el.getText();
        System.out.println("Auction Id: "+auctionId);



    }


}
