package com.nivethithasenthilkumar.automation.projects.cms.testcases;

import com.nivethithasenthilkumar.automation.common.BaseTest;
import com.nivethithasenthilkumar.automation.constants.FrameworkConstants;
import com.nivethithasenthilkumar.automation.helpers.ExcelHelpers;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Regression Test CMS")
@Feature("Order Product Test")
public class OrderTest extends BaseTest {

    @Test
    public void TC_OrderProduct() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageCMS().loginSuccessWithCustomerAccount(excel.getCellData(4, "email"), excel.getCellData(4, "password"));
        getOrderPage().order("Delivery as soon as possible");
    }

}
