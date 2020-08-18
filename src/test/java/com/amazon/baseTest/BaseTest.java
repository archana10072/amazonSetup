package com.amazon.baseTest;

import com.amazon.base.BaseClass;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    @AfterSuite
    public void tearDown(){
        BaseClass.tearDown();
    }
}
