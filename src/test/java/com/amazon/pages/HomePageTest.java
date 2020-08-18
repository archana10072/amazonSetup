package com.amazon.pages;

import com.amazon.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {


    @Test(priority = 1)
    public void verifyPageTitles() {
        SoftAssert softAssert = new SoftAssert();
        HomePageClass hp = new HomePageClass();
        //Print Amazon HP Title
        System.out.println("Title of Amazon HP: "+hp.getPageTitle());
        hp.gotoAmazonPayPage();
        //Verifying Amazon Pay page title
        softAssert.assertEquals(hp.getPageTitle(),"Amazon Pay","Amazon Pay page title are wrong");
        hp.navigateBack();
        //Verifying Amazon page title
        softAssert.assertEquals(hp.getPageTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Amazon Home page title are wrong");

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyAddToCart() throws InterruptedException {
        HomePageClass hp = new HomePageClass();

        hp.clickOnBedsheet();
        BedsheetListingPage blp = new BedsheetListingPage();
        String bedsheetListingPageUrl = blp.getListingPageUrl();
        //System.out.println("bedsheetListingPageUrl"+bedsheetListingPageUrl);
        blp.gotoBedsheet1AdPage();

        BedsheetAdPage ap = new BedsheetAdPage();
        ap.addBedsheet1();

        blp.gotoAnyPage(bedsheetListingPageUrl);

        blp.gotoBedsheet2AdPage();
        ap.addBedsheet2();

        CartPage cp = new CartPage();
        cp.gotoPaymentPage();
        LoginPage lp =new LoginPage();
        lp.logintoAmazon();

        AddressPage add=new AddressPage();
        add.enterAddress();

        Assert.assertEquals(add.getDeleveryPageText(),"Select a delivery address","Not redirected to Address options page");
        Thread.sleep(2000);
    }


}
