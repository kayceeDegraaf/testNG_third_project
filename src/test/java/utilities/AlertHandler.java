package utilities;

import org.openqa.selenium.WebDriver;

public class AlertHandler {

    public static void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }

    public static void sendKeysToAlert(WebDriver driver, String key){
        driver.switchTo().alert().sendKeys(key);
    }

    public static String getAlertSText(WebDriver driver){
        return driver.switchTo().alert().getText();
    }
}
