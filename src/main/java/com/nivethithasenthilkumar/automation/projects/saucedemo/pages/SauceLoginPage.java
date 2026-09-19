package com.nivethithasenthilkumar.automation.projects.saucedemo.pages;

import com.nivethithasenthilkumar.automation.keywords.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SauceLoginPage {

    private static final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";

    // Locators
    private By inputUsername = By.id("user-name");
    private By inputPassword = By.id("password");
    private By buttonLogin = By.id("login-button");
    private By titleProducts = By.xpath("//span[@class='title']");
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    @Step("Navigate to SauceDemo Login page")
    public SauceLoginPage openLoginPage() {
        WebUI.openWebsite(SAUCE_DEMO_URL);
        WebUI.waitForPageLoaded();
        return this;
    }

    @Step("Login with username: {0} and password: {1}")
    public SauceLoginPage login(String username, String password) {
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        return this;
    }

    @Step("Verify login success and Products page is displayed")
    public void verifyLoginSuccess() {
        WebUI.waitForElementVisible(titleProducts, 5);
        boolean isDisplayed = WebUI.verifyElementVisible(titleProducts, "Products title was not displayed.");
        Assert.assertTrue(isDisplayed, "Expected to be navigated to Products page after login.");
        String text = WebUI.getTextElement(titleProducts);
        Assert.assertEquals(text, "Products", "Products title does not match.");
    }

    @Step("Verify error message contains: {0}")
    public void verifyErrorMessage(String expectedMessage) {
        WebUI.waitForElementVisible(errorMessage, 5);
        boolean isDisplayed = WebUI.verifyElementVisible(errorMessage, "Error message was not displayed.");
        Assert.assertTrue(isDisplayed, "Expected error message element to be visible.");
        String actualError = WebUI.getTextElement(errorMessage);
        Assert.assertTrue(actualError.contains(expectedMessage),
                "Expected error message to contain: '" + expectedMessage + "', but was: '" + actualError + "'");
    }
}
