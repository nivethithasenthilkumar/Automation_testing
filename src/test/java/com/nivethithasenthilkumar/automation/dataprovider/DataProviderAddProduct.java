package com.nivethithasenthilkumar.automation.dataprovider;

import com.nivethithasenthilkumar.automation.constants.FrameworkConstants;
import com.nivethithasenthilkumar.automation.helpers.ExcelHelpers;
import com.nivethithasenthilkumar.automation.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderAddProduct {
    @DataProvider(name = "data_provider_add_product")
    public Object[][] dataAddProduct() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir() + FrameworkConstants.EXCEL_CMS_DATA, "AddProduct", 2, 2);
        return data;
    }
}
