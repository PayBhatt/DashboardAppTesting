package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInstance {

    public static WebDriver driver;

    public static WebDriver getdriver(){
        if (driver == null){
            String chromeDriver = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new ChromeDriver();
            return driver;
        }else{
            return driver;
        }
    }
}
