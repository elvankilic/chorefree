package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day9_HoverOverActionClass2 extends TestBase {
    /*
    >Create a method :hoverOver()
    Given user is on the https://www.amazon.com/
    when use click on "Account" link
    Then verify the page title contain  "Your Account"

    */
    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        WebElement accountList=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        //Hover overing overt the account list element
        actions.moveToElement(accountList).perform();
        driver.findElement(By.linkText("Account")).click();
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }











}
