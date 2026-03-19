package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {


    private By title = By.className("title");
    private By backpackAddBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOnInventoryPage() {
        return getText(title).equals("Products");
    }


    public void addBackpackToCart() {
        click(backpackAddBtn);
    }


    public void goToCart() {
        click(cartLink);
    }
}