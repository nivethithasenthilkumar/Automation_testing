package com.nivethithasenthilkumar.automation.projects.saucedemo.testcases;

import com.nivethithasenthilkumar.automation.annotations.FrameworkAnnotation;
import com.nivethithasenthilkumar.automation.common.BaseTest;
import com.nivethithasenthilkumar.automation.enums.AuthorType;
import com.nivethithasenthilkumar.automation.enums.CategoryType;
import com.nivethithasenthilkumar.automation.projects.saucedemo.pages.SauceLoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("SauceDemo Automation")
@Feature("Authentication Feature")
public class SauceLoginTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.Nivethitha}, category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void testValidLogin() {
        SauceLoginPage saucePage = new SauceLoginPage();
        saucePage.openLoginPage()
                 .login("standard_user", "secret_sauce")
                 .verifyLoginSuccess();
    }

    @FrameworkAnnotation(author = {AuthorType.Nivethitha}, category = {CategoryType.REGRESSION})
    @Test(priority = 2, description = "Verify error message when logging in with locked out user")
    public void testLockedOutUser() {
        SauceLoginPage saucePage = new SauceLoginPage();
        saucePage.openLoginPage()
                 .login("locked_out_user", "secret_sauce")
                 .verifyErrorMessage("Sorry, this user has been locked out.");
    }

    @FrameworkAnnotation(author = {AuthorType.Nivethitha}, category = {CategoryType.REGRESSION})
    @Test(priority = 3, description = "Verify error message when logging in with invalid password")
    public void testInvalidPassword() {
        SauceLoginPage saucePage = new SauceLoginPage();
        saucePage.openLoginPage()
                 .login("standard_user", "invalid_password")
                 .verifyErrorMessage("Username and password do not match");
    }
}
