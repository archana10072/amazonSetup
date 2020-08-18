package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

public class BedsheetAdPage extends BaseClass {

    public void addBedsheet1(){
        switchtoChildWindow();
        click("addToCart1_xpath");
    }

    public void addBedsheet2(){
        switchto2ndChildWindow();
        click("addToCart2_xpath");
    }



}
