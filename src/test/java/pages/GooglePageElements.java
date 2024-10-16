package pages;

import base.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageElements extends CommonMethods {

    @FindBy(xpath="//textarea[@aria-label='Search']")
    public WebElement search;



    public GooglePageElements(){
        PageFactory.initElements(driver, this);
    }


}
