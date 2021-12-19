package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day9_KeysUpDownActionClass3 extends TestBase {
    /*
    Create test method :keysUpDown()
    Go to google
    Send iphone X prices'==>convert small letter capital vice versa.
    Highlight the search box by double clicking
    */

    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com/");
        WebElement searchBox= driver.findElement(By.name("q"));
        Actions actions=new Actions(driver);
        //We want to press shift and type
        actions.keyDown(searchBox, Keys.SHIFT).sendKeys("iphone X prices").keyUp(searchBox,Keys.SHIFT).perform();



    }













}
