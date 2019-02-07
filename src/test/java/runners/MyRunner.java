package runners;

import java.io.*;
import com.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import stepdefinitions.WebDriverInstance;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true,

        tags = {"@runit,@run","~@ignore"},
        features = {"src/test/resources"},
        glue = {"stepdefinitions"}
)

public class MyRunner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(getReportConfigPath()));
        WebDriverInstance.getdriver().close();
        WebDriverInstance.getdriver().quit();
    }

    public static String getReportConfigPath(){
        String reportConfigPath =  System.getProperty("user.dir") + "/configs/extent-config.xml";   //properties.getProperty("reportConfigPath");
        System.out.println("report config path: " + reportConfigPath);
        return reportConfigPath;
    }
}
