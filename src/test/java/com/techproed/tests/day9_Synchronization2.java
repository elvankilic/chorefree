package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day9_Synchronization2 extends TestBase {
    /*
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click enable Button
    And verify the message is equal to "It's enabled!"
    And verify the textbox is enabled (I can type in the box)
    And click on Disable button
    And verfy the message is equal to "It's disabled"
    And verify the textbox is disabled (I cannot type in the box)
     */
    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton= driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();
        WebElement enabledMessage= driver.findElement(By.xpath("//p[@id='message']"));
        String enabledMessageText= enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

        WebElement disableButton= driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        disableButton.click();
        WebElement disabledMessage= driver.findElement(By.xpath("//p[@id='message']"));
        String disabledMessageText= disabledMessage.getText();
        Assert.assertEquals(disabledMessageText,"It's disabled!");

        WebElement inputElement= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(!inputElement.isEnabled());



    }















}
