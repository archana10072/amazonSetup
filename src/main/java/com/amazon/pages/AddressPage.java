package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;

public class AddressPage extends BaseClass {

    public void enterAddress(){
        scrollToView("pincode");
        type("pincode","560077");
        type("addressLine1","Flat no 10");
        type("addressLine2","Thanisandra MAin Road");
        dropdown("addressType",1);
        click("submitAddress");
    }

    public String getDeleveryPageText(){
        return driver.findElement(By.className("a-spacing-base")).getText();

    }

}
