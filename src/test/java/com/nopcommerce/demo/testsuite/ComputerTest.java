package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Create class “ComputerTest” into testsuite package
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu.
 * 1.2 Click on Desktop
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop
 * 2.3 Select Sort By position "Name: A to Z"
 * 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class.
 * 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]"
 * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
 * [+$5.00]"
 * 2.11 Verify the price "$1,475.00"
 * 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.15 Verify the message "Shopping cart"
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service”
 * 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!”
 * 2.21Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field
 * 2.23 Click on “CONTINUE”
 * 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 2.33 Verify Total is “$2,950.00”
 * 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You”
 * 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store”
 */
public class ComputerTest extends BaseTest {

    ComputerPage computerPage = new ComputerPage();


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        computerPage.MouseHoverToComputerMenuAndClickOnDesktopsMenu();
        computerPage.sortByProducts(computerPage.DescOrderText);
        List<String> actualProductNames = computerPage.verifyProductOrder();
        List<String> expectedProductNames = computerPage.reverseProductOrder(actualProductNames);
        Assert.assertEquals(actualProductNames, expectedProductNames);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        //2.2 Click on Desktop
        computerPage.MouseHoverToComputerMenuAndClickOnDesktopsMenu();
        //2.3 Select Sort By position "Name: A to Z"
        computerPage.sortByProducts(computerPage.AscOrderText);
        computerPage.waitUntilVisibilityTag();
        Thread.sleep(2000);
        //2.4 Click on "Add To Cart"
        computerPage.clickOnElement();
        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = computerPage.getVerificationText(computerPage.buildText);
        Assert.assertEquals(actualText, expectedText);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        computerPage.select(computerPage.processor, "1");
        //2.7.Select "8GB [+$60.00]" using Select class.
        computerPage.select(computerPage.ram, "5");
        Thread.sleep(2000);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        computerPage.clickOnElement(computerPage.hdd400Gb);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        computerPage.clickOnElement(computerPage.osVistaPremium);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        computerPage.clickOnElement(computerPage.softwareTotalCommander);
        Thread.sleep(2000);
        //2.11 Verify the price "$1,475.00"
        expectedText = "$2,950.00";
        actualText = computerPage.getVerificationText(computerPage.totalPrice);
        Assert.assertEquals(actualText, expectedText);
        //2.12 Click on "ADD TO CARD" Button.
        computerPage.clickOnElement(computerPage.addToCartButton);
        //2.13 Verify the Message "The product has been added to your shopping cart" on To green Bar After that close the bar clicking on the cross button.
        expectedText = "The product has been added to your shopping cart";
        actualText = computerPage.getVerificationText(computerPage.confirmationMessage);
        Assert.assertEquals(actualText, expectedText);
        computerPage.clickOnElement(computerPage.closeButton);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        computerPage.mouseHoverToElementAndClick(computerPage.shoppingCartLink);
        computerPage.clickOnElement(computerPage.goToCartButton);
        //2.15 Verify the shoppingCartMessage "Shopping cart"
        expectedText = "Shopping cart";
        actualText = computerPage.getVerificationText(computerPage.shoppingCartMessage);
        Assert.assertEquals(actualText, expectedText);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        computerPage.clickOnElement(computerPage.qtyUp);
        //2.17 Verify the Total"$2,950.00"
        expectedText = "$2,950.00";
        actualText = computerPage.getVerificationText(computerPage.updatedTotal);
        Assert.assertEquals(actualText, expectedText);
        //2.18 clickOn on checkbox “I agree with the terms of service”
        computerPage.clickOnElement(computerPage.agreeTermsCheckBox);
        //2.19 Click on “CHECKOUT”
        computerPage.clickOnElement(computerPage.checkOutButton);
        //2.20 Verify the Text “Welcome, Please Sign In!”
        expectedText = "Welcome, Please Sign In!";
        actualText = computerPage.getVerificationText(computerPage.welcomeMessage);
        Assert.assertEquals(actualText, expectedText);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        computerPage.clickOnElement(computerPage.guestCheckoutButton);
        //2.22 Fill the all mandatory field
        computerPage.sendTextToElement(computerPage.firstName, "Yatri");
        computerPage.sendTextToElement(computerPage.lastName, "Hirani");
        computerPage.sendTextToElement(computerPage.emailId, "hiryatri2587@gmail.com");
        computerPage.select(computerPage.country, "133");
        computerPage.sendTextToElement(computerPage.city, "London");
        computerPage.sendTextToElement(computerPage.address1, "Manor court");
        computerPage.sendTextToElement(computerPage.zipCode, "HA9 7AJ");
        computerPage.sendTextToElement(computerPage.phoneNumber, "0987987987");
        //2.23 Click on “CONTINUE”
        computerPage.clickOnElement(computerPage.continueButton);
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        computerPage.clickOnElement(computerPage.radioButtonNextDay);
        //2.25 Click on “CONTINUE”
        Thread.sleep(1000);
        computerPage.clickOnElement(computerPage.continueDelivery);
        //2.26 Select Radio Button “Credit Card”
        computerPage.clickOnElement(computerPage.radioButtonCredit);
        computerPage.clickOnElement(computerPage.continutToPayment);
        //2.27 Select “Master card” From Select credit card dropdown
        computerPage.select(computerPage.creditCardDropdown, "MasterCard");
        //2.28 Fill all the details
        computerPage.sendTextToElement(computerPage.cardHolderName, "Yatri Hirani");
        computerPage.sendTextToElement(computerPage.creditCardNumber, "5413330089010640");
        computerPage.select(computerPage.expiryYear, "2028");
        computerPage.sendTextToElement(computerPage.cardCVV, "727");
        //2.29 Click on “CONTINUE”
        computerPage.clickOnElement(computerPage.continuePayment);
        //2.30 Verify “Payment Method” is “Credit Card”
        expectedText = "Credit Card";
        actualText = computerPage.getVerificationText(computerPage.creditCardText);
        Assert.assertEquals(actualText, expectedText);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        expectedText = "Next Day Air";
        actualText = computerPage.getVerificationText(computerPage.deliveryMethodText);
        Assert.assertEquals(actualText, expectedText);
        //2.33 Verify Total is “$2,950.00”
        expectedText = "$2,950.00";
        actualText = computerPage.getVerificationText(computerPage.totalAmount);
        Assert.assertEquals(actualText, expectedText);
        //2.34 Click on “CONFIRM”
        computerPage.clickOnElement(computerPage.confirmButton);
        //2.35 Verify the Text “Thank You”
        expectedText = "Thank you";
        actualText = computerPage.getVerificationText(computerPage.thankYouMessage);
        Assert.assertEquals(actualText, expectedText);
        //2.36 Verify the shoppingCartMessage “Your order has been successfully processed!”
        expectedText = "Your order has been successfully processed!";
        actualText = computerPage.getVerificationText(computerPage.proceedMessage);
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(2000);
        //2.37 Click on “CONTINUE”
        computerPage.clickOnElement(computerPage.finalContinue);
        //2.37 Verify the text “Welcome to our store”
        expectedText = "Welcome to our store";
        actualText = computerPage.getVerificationText(computerPage.welcomeText);
        Assert.assertEquals(actualText, expectedText);
    }

}
