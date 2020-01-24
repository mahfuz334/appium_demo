package com.demo.iOSPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    //user must be able to login and validate he is in side the account;
    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement accountBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement emailField;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement passField;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement logInField;
    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement accountInfo;


    public void userMustBeAbleToLogin() {
        accountBtn.click();
        emailField.sendKeys("abcd@gmail.com");
        passField.sendKeys("abcdef");
        logInField.click();
        accountInfo.isDisplayed();
    }
}
