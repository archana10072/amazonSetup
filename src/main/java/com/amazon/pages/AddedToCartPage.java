package com.amazon.pages;

import com.amazon.base.BaseClass;

public class AddedToCartPage extends BaseClass {

    public CartPage gotoCartPage(){
        click("gotoCartbutton_xpath");
        return new CartPage();
    }

}
