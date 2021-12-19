package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day9_Synchronization1 extends TestBase {
    //Create a method: Synchronization1
    //Go to https://the-internet.herokuapp.com/dynamic_controls
    //Click on Remove button
    //And verify the message is equal to "It's gone!"
    //Then click on Add button
    //And verify the message is equal to "It's back!"
    @Test
    public void Synchronization1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement buttonRemove= driver.findElement(By.xpath("//button[.='Remove']"));
        buttonRemove.click();

        //This element won't be found if there is no wait
        //We get NoSuchElementException
        //1.Check if locator is correct(Element is correct)
        //2.Check if there is Synchronization issue
        String message1= driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(message1,"It's gone!");
        WebElement buttonAdd= driver.findElement(By.xpath("//button[.='Add']"));
        buttonAdd.click();
        String message2=driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(message2,"It's back!");
    }
    @Test
    public void Synchronization2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement buttonRemove= driver.findElement(By.xpath("//button[.='Remove']"));
        buttonRemove.click();

        //HOW CAN WE HANDLE USING EXPLICIT WAIT
        //1.Create WebDriverWait object:
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement message1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String message1Text= message1.getText();
        Assert.assertEquals(message1Text,"It's gone!");
        WebElement buttonAdd= driver.findElement(By.xpath("//button[.='Add']"));
        buttonAdd.click();
        WebElement message2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String message2Text=message2.getText();
        Assert.assertEquals(message2Text,"It's back!");




    }


















}
