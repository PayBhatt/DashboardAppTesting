package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.DashboardPage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;


public class Test1StepDefinition {
    static WebDriver driver;
    static DashboardPage page;


    @Given("^I launch Chrome Browser and go to ([^\"]*) link$")
    public void I_launch_Chrome_Browser(String goToLink) {
        // Write code here that turns the phrase above into concrete actions
        driver = WebDriverInstance.getdriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(goToLink);
        driver.manage().window().maximize();
        page = new DashboardPage(driver);
        PageFactory.initElements(driver, page);
    }

    @When("^I am on ([^\"]*) page$")
    public void iAmOnPage(String title) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.getTitle().equals(title));

    }

    @Then("^I verify Statistics block is displayed$")
    public void iVerifyStatisticsBlockIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(verifyElementIsDisplayed(page.statistics));
    }

    @Then("^I verify Controls block is displayed$")
    public void iVerifyControlsBlockIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(verifyElementIsDisplayed(page.controls));
    }

    @Then("^I verify Search textbox is displayed$")
    public void iVerifySearchTextBoxIsDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(verifyElementIsDisplayed(page.searchBox));
    }

    @When("^I search for ([^\"]*)$")
    public void iSearchForDivision(String searchText) {
        // Write code here that turns the phrase above into concrete actions
        page.searchBox.clear();
        page.searchBox.sendKeys(searchText);
    }

    @Then("^I get all ([^\"]*) division records displayed$")
    public void iGetDivisionRecordsDisplayedFor(String divisionName) {
        List<WebElement> webElements = driver.findElements(By.className("projCard"));
        for (WebElement we: webElements)
            assertTrue("Incorrect division record found!", we.findElement(By.xpath("//div[2]/span")).getText().contains(divisionName));
    }

    @Then("^I get no records displayed$")
    public void iGetNoRecordsDisplayed() {
        try{
            WebElement webElement = driver.findElement(By.className("projCard"));
            assertTrue("Record list is not empty!", webElement == null);
        } catch (NoSuchElementException e){ }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("^I get records having all property values ([^\"]*)$")
    public void iGetAllRecordsHavingAllPropertyValues(String searchText) {
        List<WebElement> records = driver.findElements(By.className("projCard"));
        String[] propertyName = searchText.split(" AND ");
        boolean matchFound = true;
        for (WebElement record: records){
            matchFound = true;
            for (int i=0; i<propertyName.length; i++) {
                if (!record.getText().contains(propertyName[i]))
                {
                    matchFound = false;
                    break;
                }
            }
            assertTrue("Incorrect record found!", matchFound);
        }
    }

    @Then("^I get records having either property values ([^\"]*)$")
    public void iGetRecordsHavingEitherPropertyValues(String searchText) {
        List<WebElement> records = driver.findElements(By.className("projCard"));
        String[] propertyName = searchText.split(" OR ");
        boolean matchFound = true;
        for (WebElement record: records){
            matchFound = false;
            for (int i=0; i<propertyName.length; i++) {
                if (record.getText().contains(propertyName[i]))
                {
                    matchFound = true;
                    break;
                }
            }
            assertTrue("Incorrect record found!", matchFound);
        }
    }

    public boolean verifyElementIsDisplayed(WebElement elementName){
        return elementName.isDisplayed();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                Files.copy(sourcePath, destinationPath);
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
