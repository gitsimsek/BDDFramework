package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaHelpMeSearchPage {

    public CarvanaHelpMeSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='leftSide']//h1[1]")
    public WebElement mainHeader;

    @FindBy(xpath = "//div[@class='leftSide']//h3[1]")
    public WebElement subHeader;

    @FindBy(xpath = "//a[@data-qa='router-link']")
    public WebElement carFinderLink;
}