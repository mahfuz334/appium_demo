package com.demo.iOSTestCases;

import com.demo.base.TestBase;
import com.demo.iOSPages.LogOutPage;
import com.demo.iOSPages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestLogInAndLogOutPages extends TestBase {
    LoginPage loginPage = null;
    LogOutPage logOutPage = null;

    @BeforeMethod
    public void setup() {
        loginPage = PageFactory.initElements(appiumDriver, LoginPage.class);
        logOutPage = PageFactory.initElements(appiumDriver, LogOutPage.class);
    }

    @Test
    public void validatingUserAbleToLogInAndLogOut() {
        loginPage.userMustBeAbleToLogin();
        logOutPage.userMustBeAbleToLogOut();
    }

}
