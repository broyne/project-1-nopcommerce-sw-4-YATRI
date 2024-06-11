package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Utility {

    public By generateMenuLink(String menu){
        By menuLink = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(), '" + menu + "')]");
        return menuLink;
    }

    public void clickOnMenu(String menuName){
        By menuLink = generateMenuLink(menuName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        clickOnElement(menuLink);
    }

}
