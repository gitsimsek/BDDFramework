package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaGetOfferPage {
    public CarvanaGetOfferPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[contains(@class,'TextField__Wrapper-qlseg8-0 fTSDos')]//div)[2]")
    public WebElement errorMessage;
}