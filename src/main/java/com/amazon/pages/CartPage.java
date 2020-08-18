package com.amazon.pages;

import com.amazon.base.BaseClass;

public class CartPage extends BaseClass {
    public AddressPage gotoPaymentPage(){
        click("proceedToCheckout");
        return new AddressPage();
    }


}
