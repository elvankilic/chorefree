package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropdown {
    //Go to https://www.amazon.com/
    // Find the element of the dropdown element.
    //Print the first selected option and assert if it equals "All Departments"
    //Select the 4th option by index(index of option) and assert if the name is "Baby"
    //Print all the dropdown options
    //Print the total number of options ın the dropdown
    //Check if Baby is a dropdown option.Print true if "Baby" is an option.Print false otherwise
    //BONUS:Check if the dropdown is in Alphabetical Order


    @Test
    public void dropdownAll() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");

        WebElement all= driver.findElement(By.id("searchDropdownBox"));
        Select actualAllOptions=new Select(all);
        String actualFirstOption=actualAllOptions.getFirstSelectedOption().getText();
        System.out.println("Actual first option of ALL: "+actualFirstOption);
        Assert.assertEquals(actualFirstOption,"All Departments");

        String actualFourthOption= actualAllOptions.getOptions().get(3).getText();
        Assert.assertEquals(actualFourthOption,"Baby");

        List<WebElement> allOptions=actualAllOptions.getOptions();

        for (WebElement eachOptions:allOptions) {
            System.out.println(eachOptions.getText());
        }

        int flag=0;
        for (WebElement eachOptions:allOptions) {
           if (eachOptions.getText().contains("Baby")){
               System.out.println("True");
               flag=1;
               break;
        }else{
               System.out.println("False");
           }
        }

        Integer numOfOptions = actualAllOptions.getOptions().size();
        System.out.println("Number of option of All: " + numOfOptions);

       List<String> originalList=new ArrayList<>();
        for (WebElement w:actualAllOptions.getOptions()) {
            originalList.add(w.getText());
        }

        List<String> tempList=originalList;
        Collections.sort(tempList);
        Assert.assertEquals(tempList,originalList,"Dropdown list is Alphabetical");

    }
















}
