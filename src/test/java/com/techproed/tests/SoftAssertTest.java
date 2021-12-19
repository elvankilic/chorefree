package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    //When user goes to google home page
    //And search for porcelain teapot
    //Then verify the page title include teapot

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }
    @Test
    public void searchTeaPot(){
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
        String title=driver.getTitle();
        //If assertion fails, you will see message
       // Assert.assertTrue(title.contains("teapot"),"Title doesn't contain teapot");
        //The lines after Hard Assert will run only if assertion pass
       // System.out.println("This is after HARD ASSERTION");

        //1.Create soft assert object
        SoftAssert softAssert=new SoftAssert();
        //2.Use Assertion
        softAssert.assertTrue(title.contains("teapot"),"teapot");

        softAssert.assertTrue(title.contains("tea pot"),"tea pot");

        softAssert.assertTrue(title.contains("porcelainn"),"porcelain");
        //We must use assertAll() to mark the test case as PASSED or FAILED
        //Note that if we don't use assertAll,we get incorrect report(pass report)
        softAssert.assertAll();
        System.out.println("This is after HARD ASSERTION");


    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
























}

