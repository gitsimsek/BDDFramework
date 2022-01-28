package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaAutoLoanCalculatorPage {

    public CarvanaAutoLoanCalculatorPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement costOfCar;

    @FindBy(id = "creditBlock")
    public WebElement creditScore;

    @FindBy(name = "loanTerm")
    public WebElement loanTerm;

    @FindBy(name = "downPayment")
    public WebElement downPayment;

    @FindBy(className = "loan-calculator-display-value")
    public WebElement monthlyPayment;
}
