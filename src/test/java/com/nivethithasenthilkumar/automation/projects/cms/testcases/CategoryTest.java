package com.nivethithasenthilkumar.automation.projects.cms.testcases;

import com.nivethithasenthilkumar.automation.common.BaseTest;
import com.nivethithasenthilkumar.automation.constants.FrameworkConstants;
import com.nivethithasenthilkumar.automation.helpers.ExcelHelpers;
import com.nivethithasenthilkumar.automation.projects.cms.CommonPageCMS;
import com.nivethithasenthilkumar.automation.projects.cms.admin.pages.category.CategoryPage;
import com.nivethithasenthilkumar.automation.projects.cms.admin.pages.logins.LoginPageCMS;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {

    LoginPageCMS loginPageCMS;
    CategoryPage categoryPage;
    CommonPageCMS commonPageCMS;
    ExcelHelpers excelHelpers;

    public CategoryTest() {
        commonPageCMS = new CommonPageCMS();
        loginPageCMS = new LoginPageCMS();
        excelHelpers = new ExcelHelpers();
    }

    @Test
    public void TC_AddCategory() {
        loginPageCMS.loginSuccessAdminPage();
        categoryPage = commonPageCMS.clickMenuProducts().clickMenuCategory();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_CMS_DATA, "Category");
        //category_name   order_number   meta_title  description
        categoryPage.clickAddNewButton()
                .inputDataCategory(
                        excelHelpers.getCellData("category_name", 1),
                        excelHelpers.getCellData("order_number", 1),
                        excelHelpers.getCellData("meta_title", 1),
                        excelHelpers.getCellData("description", 1)
                )
                .clickSaveButton()
                .checkCategoryDisplayed(excelHelpers.getCellData("category_name", 1));
    }

}
