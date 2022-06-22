package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;
import pages.CarvanaSearchPage;
import utilities.ConfigReader;
import utilities.ExpectedTexts;
import utilities.Waiter;

public class CarvanaTest extends Base{

    CarvanaHomePage carvanaHomePage;
    CarvanaSearchPage carvanaSearchPage;

    @BeforeClass
    public void setupPages(){
        carvanaHomePage = new CarvanaHomePage();
        carvanaSearchPage = new CarvanaSearchPage();
    }




    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testTitleAndUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("url"));
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
    }


    @Test(priority = 2, description = "Validate the Carvana logo")
    public void testLogo(){
        Assert.assertTrue(carvanaHomePage.logo.isDisplayed());
    }


    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testMainNavSectionItems(){
        //TODO replace this hard-coded wait with explicit wait
        Waiter.pause(3);
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(carvanaHomePage.mainNavSectionItems.get(i).getText(), ExpectedTexts.mainNavSectionItems[i]);
        }
    }



    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignInErrorMessage(){
        carvanaHomePage.mainSignInLink.click();
        carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.modalSignInButton.click();
        Assert.assertTrue(carvanaHomePage.errorMessage.isDisplayed());
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect Please try again or reset your password.");

    }


    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilterOptions(){
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/cars");
        String[] filterOptions1 = {"PAYMENT & PRICE",
                "MAKE & MODEL", "BODY TYPE",
                "YEAR & MILEAGE", "FEATURES",
                "MORE FILTERS"};
        for (int i = 0; i < carvanaSearchPage.filterOptions.size(); i++){
            Assert.assertTrue(carvanaSearchPage.filterOptions.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchPage.filterOptions.get(i).isEnabled());
            Assert.assertEquals(carvanaSearchPage.filterOptions.get(i).getText(), filterOptions1[i]);
        }

    }


    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchResultTiles(){
        Waiter.pause(3);
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("url") + "cars");
        carvanaSearchPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaSearchPage.goButton.click();

        while(carvanaSearchPage.paginationNextButton.isEnabled()){
            Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
            Waiter.pause(3);
            for (int i = 0; i < carvanaSearchPage.tiles.size(); i++) {
                Assert.assertTrue(carvanaSearchPage.tiles.get(i).isDisplayed());
                Assert.assertTrue(carvanaSearchPage.tileImages.get(i).isDisplayed());
                Assert.assertTrue(carvanaSearchPage.tileAddToFavoritesButtons.get(i).isDisplayed());
                Assert.assertTrue(carvanaSearchPage.tileInventoryTypes.get(i).isDisplayed());
                Assert.assertFalse(carvanaSearchPage.tileInventoryTypes.get(i).getText().isEmpty());
                Assert.assertNotNull(carvanaSearchPage.tileInventoryTypes.get(i).getText());
                Assert.assertTrue(carvanaSearchPage.tileMakeModelAndYears.get(i).isDisplayed());
                Assert.assertFalse(carvanaSearchPage.tileMakeModelAndYears.get(i).getText().isEmpty());
                Assert.assertNotNull(carvanaSearchPage.tileMakeModelAndYears.get(i).getText());
                Assert.assertTrue(carvanaSearchPage.tileTrimAndMileages.get(i).isDisplayed());
                Assert.assertFalse(carvanaSearchPage.tileTrimAndMileages.get(i).getText().isEmpty());
                Assert.assertNotNull(carvanaSearchPage.tileTrimAndMileages.get(i).getText());
                Assert.assertTrue(carvanaSearchPage.tilePrices.get(i).isDisplayed());
                Assert.assertTrue(Integer.parseInt(carvanaSearchPage.tilePrices.get(i).getText().replaceAll("[^0-9]", "")) > 0);
                Assert.assertTrue(carvanaSearchPage.tileMonthlyPayments.get(i).isDisplayed());
                Assert.assertFalse(carvanaSearchPage.tileMonthlyPayments.get(i).getText().isEmpty());
                Assert.assertNotNull(carvanaSearchPage.tileMonthlyPayments.get(i).getText());
                Assert.assertTrue(carvanaSearchPage.tileDownPayments.get(i).isDisplayed());
                Assert.assertFalse(carvanaSearchPage.tileDownPayments.get(i).getText().isEmpty());
                Assert.assertNotNull(carvanaSearchPage.tileDownPayments.get(i).getText());
                Assert.assertTrue(carvanaSearchPage.tileDeliveryChips.get(i).isDisplayed());
                Assert.assertFalse(carvanaSearchPage.tileDeliveryChips.get(i).getText().isEmpty());
                Assert.assertNotNull(carvanaSearchPage.tileDeliveryChips.get(i).getText());
            }
            carvanaSearchPage.paginationNextButton.click();
        }
    }
}