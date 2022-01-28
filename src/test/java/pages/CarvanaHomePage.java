package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaHomePage {

    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-cv-test='headerCarFinderLink']")
    public WebElement carFinder;

    @FindBy(xpath = "//a[@data-cv-test='headerTradesLink']")
    public WebElement sellTrade;

    @FindBy(xpath = "(//a[@data-qa='menu-button-wrapper']//span)[3]")
    public WebElement financing;

    @FindBy(xpath = "//a[@data-cv-test='headerFinanceLoanCalc']")
    public WebElement loanCalculator;


}
