package com.saucedemo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.runner.Hooks;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;

    @Given("el usuario navega a la página de login")
    public void navegarLogin() {
        this.driver = Hooks.driver;
        this.driver.get("https://www.saucedemo.com/");
    }

    @When("inicia sesión con credenciales válidas")
    public void iniciarSesion() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Then("debería visualizarse que la sesión está iniciada")
    public void validarLogin() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isOnInventoryPage(), "Error: No se pudo iniciar sesión correctamente.");
    }
}