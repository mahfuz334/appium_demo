package com.demo.androidTestCases;

import com.demo.androidPages.HomePage;
import com.demo.base.TestBase;
import org.testng.annotations.Test;

;

public class TestHomepage extends TestBase {
    HomePage homePage = null;


    @Test(enabled = false)
    public void validateHeaderButtonsAreWorking() {
        homePage.clickAndGoBackToAllHeaders();
    }


}



