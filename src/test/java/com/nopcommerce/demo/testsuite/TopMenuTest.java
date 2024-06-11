package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * . create class "TopMenuTest" into testsuite package
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */
public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();

    public void selectMenu(String menuName) {
        // Click on element
        homePage.clickOnMenu(menuName);
    }

    @Test
    public void verifyPageNavigation() {
        String menuName = "Computers"; // Example menu item
        selectMenu(menuName);

        // Verify that the page has navigated correctly
        String expectedTitle = "nopCommerce demo store. " + menuName;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
    }
}
