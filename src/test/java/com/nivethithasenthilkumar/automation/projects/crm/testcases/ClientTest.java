/*
 * Test Automation Framework
 * Automation Framework Selenium
 */

package com.nivethithasenthilkumar.automation.projects.crm.testcases;

import com.nivethithasenthilkumar.automation.annotations.FrameworkAnnotation;
import com.nivethithasenthilkumar.automation.common.BaseTest;
import com.nivethithasenthilkumar.automation.dataprovider.DataProviderManager;
import com.nivethithasenthilkumar.automation.enums.AuthorType;
import com.nivethithasenthilkumar.automation.enums.CategoryType;

import static com.nivethithasenthilkumar.automation.keywords.WebUI.*;

import com.nivethithasenthilkumar.automation.projects.crm.pages.Clients.ClientPageCRM;
import com.nivethithasenthilkumar.automation.projects.crm.pages.Dashboard.DashboardPageCRM;
import com.nivethithasenthilkumar.automation.projects.crm.pages.SignIn.SignInPageCRM;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Client Test")
public class ClientTest extends BaseTest {

    private SignInPageCRM signInPageCRM;
    private DashboardPageCRM dashboardPageCRM;
    private ClientPageCRM clientPageCRM;

    public ClientTest() {
        signInPageCRM = new SignInPageCRM();
    }

    @FrameworkAnnotation(author = {AuthorType.Nivethitha}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "Test Add New Client", dataProvider = "getClientDataHashTable", dataProviderClass = DataProviderManager.class)
    public void testAddClient(Hashtable<String, String> data) {
        dashboardPageCRM = signInPageCRM.signInWithAdminRole();
        clientPageCRM = dashboardPageCRM.openClientPage();
        clientPageCRM.openClientTabPage();
        clientPageCRM.addClient(data);
        clientPageCRM.verifyClientDetail(data);
    }

    @FrameworkAnnotation(author = {AuthorType.QAEngineer}, category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 2, description = "TC06_testSearchClient")
    public void testSearchClient() {
        dashboardPageCRM = signInPageCRM.signInWithAdminRole();
        clientPageCRM = dashboardPageCRM.openClientPage();
        clientPageCRM.openClientTabPage();
        // Search the first
        clientPageCRM.enterDataSearchClient("Adrain Ondricka");
        checkContainsValueOnTableByColumn(2, "Adrain Ondricka");
        // Search the second
        clientPageCRM.enterDataSearchClient("Birdie Erdman");
        checkContainsValueOnTableByColumn(2, "Birdie Erdman");

    }

}