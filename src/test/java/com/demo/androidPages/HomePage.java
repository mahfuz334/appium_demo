package com.demo.androidPages;

import com.demo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends TestBase {

    //User must be able to click on all the header on the bank app and go back to previous one
    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement accountBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement viewAccountBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement transferBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement depositBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement sendMoneyBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement payABillBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement backBtn;

    @FindBy(xpath = "LOCATOR FOR THE ELEMENT")
    private WebElement productsBtn;


    public void clickOnAccount() {
        accountBtn.click();
    }


    public void clickAndGoBackToAllHeaders() {
        accountBtn.click();
        backBtn.click();
        transferBtn.click();
        backBtn.click();
        depositBtn.click();
        backBtn.click();
        sendMoneyBtn.click();
        backBtn.click();
        payABillBtn.click();
        backBtn.click();
    }

}
