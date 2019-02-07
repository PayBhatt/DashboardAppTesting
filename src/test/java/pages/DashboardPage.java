package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
* This class contains locators for the WebElements from DashboardPage
* */
public class DashboardPage {

    static WebDriver driver;

    //Using FindBy for locating elements
    @FindBy(how=How.XPATH, using="//div[@id='statsRow']/md-card//span[text()='Statistics']")
    public WebElement statistics;

    @FindBy(how=How.XPATH, using="//div[@id='statsRow']/md-card[@id='searchCard']")
    public WebElement controls;

    @FindBy(how=How.ID, using="input_0")
    public WebElement searchBox;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
}
