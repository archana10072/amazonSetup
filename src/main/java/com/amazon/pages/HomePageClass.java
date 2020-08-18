package com.amazon.pages;

import com.amazon.base.BaseClass;

public class HomePageClass extends BaseClass {

    public BedsheetListingPage clickOnBedsheet(){
        click("bedSheet_xpath");
        return new BedsheetListingPage();
    }

    public String getPageTitle(){
       // log.info(driver.getTitle());
        System.out.println("Title: "+driver.getTitle());
       return driver.getTitle();

    }

    public void gotoAmazonPayPage(){
        click("amazon_pay_xpath");
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void gotoLink(String url){
        driver.get(url);
    }






}
