package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By checkoutBtn = By.id("checkout");
    private By itemName = By.className("inventory_item_name");
    private By removeBtn = By.xpath("//button[text()='Remove']");
    // Agregamos el botón para volver
    private By continueShoppingBtn = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout() {
        click(checkoutBtn);
    }

    public String getProductName() {
        return getText(itemName);
    }

    public void removeFirstItem() {
        click(removeBtn);
    }

    // Nuevo método para volver a los productos
    public void clickContinueShopping() {
        click(continueShoppingBtn);
    }
}