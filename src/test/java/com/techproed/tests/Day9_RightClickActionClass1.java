package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day9_RightClickActionClass1 extends TestBase {
    /*
    Create a method:contextClickMethod() and test the following scenario
    Given user is on yhe https://the-internet.herokuapp.com/context_menu
    When use Right clicks on the box
    Then verify the alert message is "You selected a context menu"
    Then accept the alert
     */
    @Test
    public void contextClickMethod(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        WebElement box= driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        String messageAlert=driver.switchTo().alert().getText();
        Assert.assertEquals(messageAlert,"You selected a context menu");
        driver.switchTo().alert().accept();

    }











}
