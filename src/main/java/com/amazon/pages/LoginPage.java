package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

    public void logintoAmazon() throws InterruptedException {
        type("email_xath",config.getProperty("loginEmail"));

        if(isElementPresent(By.xpath(locators.getProperty("continue_xpath")))) {
            click("continue_xpath");
            type("password_xpath", config.getProperty("loginPassword"));

        }
        else {
            type("password_xpath", config.getProperty("loginPassword"));
        }
        click("login_xpath");
        Thread.sleep(2000);
    }


}
