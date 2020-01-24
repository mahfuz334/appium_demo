package com.demo.iOSPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage {
    //user must be able to log out from the account


    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement accountBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement emailField;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement passField;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement logInbtn;
    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement accountInfo;
    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement logOutBtn;
    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement logOutPage;


    public void userMustBeAbleToLogOut() {
        accountBtn.click();
        emailField.sendKeys("abcd@gmail.com");
        passField.sendKeys("abcdef");
        logInbtn.click();
        accountInfo.isDisplayed();
        accountBtn.click();
        logOutBtn.click();
        logOutPage.isDisplayed();

    }
}
