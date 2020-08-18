package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BedsheetListingPage extends BaseClass {

    public void gotoBedsheet1AdPage(){
        click("bedsheet1AdLink_xpath");
    }

    public String getListingPageUrl(){
        return driver.getCurrentUrl();
    }

    public void gotoBedsheet2AdPage(){
        click("bedsheet2AdLink_xpath");
    }




}
