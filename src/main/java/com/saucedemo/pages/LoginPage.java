package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class LoginPage extends BasePage {


        private By userField = By.id("user-name");
        private By passField = By.id("password");
        private By loginBtn = By.id("login-button");

        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void loginAs(String user, String pass) {
            type(userField, user);
            type(passField, pass);
            click(loginBtn);
        }

        public boolean isOnLoginPage() {
            return isElementVisible(loginBtn);
        }
    }
