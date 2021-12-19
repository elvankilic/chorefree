package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBaseDemo extends TestBase {

    //Create a test class:TestBaseDemo
    //Create two methods:Test1,Test2
    //test1 search "porcelain teapot" on google
    //then verify page contains "porcelain teapot"
    //-------------------
    //test2 search "porcelain teapot" on Amazon
    //then verify page contains "porcelain teapot"


    //Since we are using TestBase class,we don't add before and after methods in this test class

    @Test
    public void test1(){
        driver.get("https://www.google.com");
        WebElement searchBox= driver.findElement(By.name("q"));
        searchBox.sendKeys("porcelain teapot"+ Keys.ENTER);
        String pageSource=driver.getPageSource();
        Assert.assertTrue(pageSource.contains("porcelain teapot"));

    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com/");
        WebElement searchBoxAmazon= driver.findElement(By.xpath("//input[@type='text']"));
        searchBoxAmazon.sendKeys("porcelain teapot"+Keys.ENTER);
        String pageSourceAmazon= driver.getPageSource();
        Assert.assertTrue(pageSourceAmazon.contains("porcelain teapot"));
    }























}
