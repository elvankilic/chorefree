package com.techproed.excelautomation;

import com.techproed.pages.DataTablesPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Day16_ExcelAutomation {

    ExcelUtil excelUtil;
    List<Map<String,String>> testData;




    DataTablesPage dataTablesPage;
@Test
    public void excelAutomation() throws InterruptedException {
    excelUtil=new ExcelUtil(".\\src\\test\\java\\Resources\\exceldata.xlsx","datatablessheet");
    testData=excelUtil.getDataList();
    //System.out.println(testData);//GIVES ME THE ENTIRE LIST

    //I will get each key value pairs inside the Map from the List
    for(Map<String,String > each:testData) {
        System.out.println(each);//GIVES ME THE ENTIRE MAP


        Driver.getDriver().get(ConfigReader.getProperty("dt_url"));
        dataTablesPage=new DataTablesPage();
        dataTablesPage.newButton.click();
        dataTablesPage.firstName.sendKeys(each.get("First Name"));
        dataTablesPage.lastName.sendKeys(each.get("Last Name"));
        dataTablesPage.position.sendKeys(each.get("Position"));
        dataTablesPage.office.sendKeys(each.get("Office"));
        dataTablesPage.extension.sendKeys(each.get("Extension"));

        String oldDateString=each.get("Start Date");
        LocalDate datetime=LocalDate.parse(oldDateString, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String newDateString=datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        dataTablesPage.startDate.sendKeys(newDateString);

        dataTablesPage.salary.sendKeys(each.get("Salary"));
        dataTablesPage.crateButton.click();
        dataTablesPage.searchBox.sendKeys(each.get("First Name"));
        Thread.sleep(2000);
        String actualName=dataTablesPage.nameField.getText();
        Assert.assertTrue(actualName.contains(each.get("First Name")));

        //map has a method.When you send key,it returns the value
        //each.get("firstname");//In map,get() method takes a key,returns value
        //System.out.println("FIRST NAME: "+each.get("First Name"));
        //System.out.println("START DATES: "+each.get("Start Date"));




    }
}
}
