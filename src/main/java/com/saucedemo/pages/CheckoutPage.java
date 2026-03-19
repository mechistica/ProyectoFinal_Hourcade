package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By completeHeader = By.className("complete-header");
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutBtn = By.id("logout_sidebar_link");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInformation(String fName, String lName, String zip) {
        type(firstName, fName);
        type(lastName, lName);
        type(zipCode, zip);
        click(continueBtn);
    }

    public void finishOrder() {
        click(finishBtn);
    }

    public String getSuccessMessage() {
        return getText(completeHeader);
    }
    public void realizarLogout() {
        click(menuBtn);
        click(logoutBtn);
    }
}