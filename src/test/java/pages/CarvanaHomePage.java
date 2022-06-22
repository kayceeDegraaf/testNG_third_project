package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper']")
    public WebElement logo;

    @FindBy(css = "div[data-qa='navigation-wrapper']>div>a")
    public List<WebElement> mainNavSectionItems;

    @FindBy(css = "a[data-cv-test='headerSignInLink']")
    public WebElement mainSignInLink;

    @FindBy(css = "div[data-cv-test='Header.Modal']")
    public WebElement signInModal;

    @FindBy(id="usernameField")
    public WebElement emailInputBox;

    @FindBy(id="passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement modalSignInButton;

    @FindBy(css="div[data-qa='error-message-container']")
    public WebElement errorMessage;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsLink;
}