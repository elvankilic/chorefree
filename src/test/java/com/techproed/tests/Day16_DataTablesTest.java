package com.techproed.tests;

import com.techproed.pages.DataTablesPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_DataTablesTest {

    DataTablesPage dataTablesPage;

  @Test
    public void dataTables()  {
      Driver.getDriver().get(ConfigReader.getProperty("dt_url"));
      dataTablesPage=new DataTablesPage();
      dataTablesPage.newButton.click();
      dataTablesPage.firstName.sendKeys("Jimmy");
      dataTablesPage.lastName.sendKeys("Carrey");
      dataTablesPage.position.sendKeys("SDET");
      dataTablesPage.office.sendKeys("Dallas");
      dataTablesPage.extension.sendKeys("1234");
      dataTablesPage.startDate.sendKeys("2021-01-19");
      dataTablesPage.salary.sendKeys("1000000");
      dataTablesPage.crateButton.click();
      dataTablesPage.searchBox.sendKeys("Jimmy");
      String actualName=dataTablesPage.nameField.getText();
      Assert.assertTrue(actualName.contains("Jimmy"));

  }


}
