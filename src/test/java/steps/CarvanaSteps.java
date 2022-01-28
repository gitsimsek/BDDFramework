package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import texts.ExpectedTexts;
import utilities.Driver;
import utilities.Waiter;

public class CarvanaSteps {

    public WebDriver driver;
    public CarvanaHomePage carvanaHomePage;
    public CarvanaHelpMeSearchPage carvanaHelpMeSearchPage;
    public CarvanaHelpMeSearchQaPage carvanaHelpMeSearchQaPage;
    public CarvanaSellMyCarPage carvanaSellMyCarPage;
    public CarvanaGetOfferPage carvanaGetOfferPage;
    public CarvanaAutoLoanCalculatorPage carvanaAutoLoanCalculatorPage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaHelpMeSearchPage = new CarvanaHelpMeSearchPage(driver);
        carvanaHelpMeSearchQaPage = new CarvanaHelpMeSearchQaPage(driver);
        carvanaSellMyCarPage = new CarvanaSellMyCarPage(driver);
        carvanaGetOfferPage = new CarvanaGetOfferPage(driver);
        carvanaAutoLoanCalculatorPage = new CarvanaAutoLoanCalculatorPage(driver);
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String key) {
        Waiter.waitForWebElementToBeClickable(driver, 30, carvanaHomePage.carFinder);

        switch (key) {
            case ExpectedTexts.sellTradeBar:
                Waiter.waitForWebElementToBeVisible(driver, 30, carvanaHomePage.sellTrade);
                carvanaHomePage.sellTrade.click();
                break;
            case ExpectedTexts.carFinder:
                carvanaHomePage.carFinder.click();
                break;
            case ExpectedTexts.autoLoan:
                Waiter.waitForWebElementToBeVisible(driver, 30, carvanaHomePage.loanCalculator);
                carvanaHomePage.loanCalculator.click();
            default:
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String key) {
        Assert.assertEquals(driver.getCurrentUrl(),key);
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String key) {
        switch(key){
            case ExpectedTexts.mainHeader:
                Assert.assertEquals(key, carvanaHelpMeSearchPage.mainHeader.getText());
                break;
            case ExpectedTexts.subHeader:
                Assert.assertEquals(key, carvanaHelpMeSearchPage.subHeader.getText());
                break;
            case ExpectedTexts.mainHeader2:
                Assert.assertEquals(key, carvanaHelpMeSearchQaPage.header.getText());
                break;
            case ExpectedTexts.subHeader2:
                Assert.assertEquals(key, carvanaHelpMeSearchQaPage.subHeading.getText());
                break;
            case ExpectedTexts.mainHeader3:
                Assert.assertEquals(key, carvanaSellMyCarPage.mainHeading.getText());
                break;
            case ExpectedTexts.subHeader3:
                Assert.assertEquals(key, carvanaSellMyCarPage.subHeading.getText());
                break;
            case ExpectedTexts.errorMessage:
                Waiter.waitForWebElementToBeVisible(driver, 40, carvanaGetOfferPage.errorMessage);
                Assert.assertEquals(key, carvanaGetOfferPage.errorMessage.getText());
            default:
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String key) {
        Assert.assertTrue(carvanaHelpMeSearchPage.carFinderLink.isDisplayed());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String key) {
        carvanaHelpMeSearchPage.carFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String key) {
        if(key.equals(ExpectedTexts.vinButton)) carvanaSellMyCarPage.vinButton.click();
        else carvanaSellMyCarPage.getOffer.click();
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        carvanaSellMyCarPage.vinInput.sendKeys(key);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String key) {
        Actions actions = new Actions(driver);
        actions.moveToElement(carvanaHomePage.financing).perform();
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String key, String key2) {
        if(key.equals(ExpectedTexts.costOfCar))
        carvanaAutoLoanCalculatorPage.costOfCar.sendKeys(key2);
        else
            carvanaAutoLoanCalculatorPage.downPayment.sendKeys(key2);
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String key, String key2) {
        Select select;
        if(key.equals(ExpectedTexts.creditScore)) {
           select = new Select(carvanaAutoLoanCalculatorPage.creditScore);
        }
        else {
            select = new Select(carvanaAutoLoanCalculatorPage.loanTerm);
        }
        select.selectByVisibleText(key2);
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String key) {
        Assert.assertEquals(key, carvanaAutoLoanCalculatorPage.monthlyPayment.getText());
    }
}