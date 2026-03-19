package com.saucedemo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.runner.Hooks;
import org.testng.Assert;
import com.saucedemo.pages.LoginPage;

public class FlujoCompraSteps {

    WebDriver driver;

    @When("agrega un producto al carrito")
    public void agregarProducto() {
        this.driver = Hooks.driver;
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
    }

    @And("va al carrito de compras")
    public void irAlCarrito() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.goToCart();
    }

    @And("elimina el producto del carrito")
    public void eliminarProducto() {
        CartPage cartPage = new CartPage(driver);
        cartPage.removeFirstItem();
    }

    @Then("el producto debería verse en el carrito")
    public void validarCarrito() {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }

    @And("completa la compra")
    public void completarCompra() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInformation("Mercedes", "Hourcade", "6360");
        checkoutPage.finishOrder();
    }

    @Then("debería ver el mensaje de confirmación")
    public void mensajeConfirmacion() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!");
    }

    @And("vuelve a la página de productos")
    public void volverAProductos() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickContinueShopping();
    }

    @When("el usuario hace logout")
    public void hacerLogout() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.realizarLogout();
    }

    @Then("debería volver al estado no logueado")
    public void validarEstadoNoLogueado() {
        LoginPage loginPage = new LoginPage(driver);

        // Simplemente le pedimos a la LoginPage que verifique si está en su pantalla
        boolean isEnLogin = loginPage.isOnLoginPage();

        org.testng.Assert.assertTrue(isEnLogin, "El usuario no fue redirigido a la pantalla de login tras hacer logout");
    }
}