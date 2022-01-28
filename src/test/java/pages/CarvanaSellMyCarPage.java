package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaSellMyCarPage {

    public CarvanaSellMyCarPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'BrandTwo-sc-13s4tcn-6')]")
    public WebElement mainHeading;

    @FindBy(xpath = "//div[contains(@class,'BodyOne-sc-13s4tcn-17')]")
    public WebElement subHeading;

    @FindBy(xpath = "//button[@data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(xpath = "//div[@data-cv-test='heroVinEntryInput']//input[1]")
    public WebElement vinInput;

    @FindBy(xpath = "//button[@data-cv-test='heroGetMyOfferButton']")
    public WebElement getOffer;



}
