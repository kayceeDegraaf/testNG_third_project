package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.Driver;

public class Base {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        //TODO if there is a failure, take screenshot and attach it to the report
        Driver.quitDriver();
    }
}