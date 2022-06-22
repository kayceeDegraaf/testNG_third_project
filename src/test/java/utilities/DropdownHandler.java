package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandler {

    public static void selectOptionByIndex(WebElement dropdown, int index){
        new Select(dropdown).selectByIndex(index);
    }

    public static void selectOptionByValue(WebElement dropdown, String value){
        new Select(dropdown).selectByValue(value);
    }

    public static void selectOptionByVisibleText(WebElement dropdown, String visibleText){
        new Select(dropdown).selectByVisibleText(visibleText);
    }
}