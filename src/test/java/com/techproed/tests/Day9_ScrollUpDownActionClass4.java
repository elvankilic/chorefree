package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day9_ScrollUpDownActionClass4 extends TestBase {
 /*
 Create test method:scrollUpDown()
 Go to amazon
 Scroll the page down
 Scroll the page up
 */
    /*
    NOTE:Some elements at the bottom of the page so the page may not load and may not visible
    Then we must scroll down the page
     */
@Test
    public void scrollUpDown() throws InterruptedException {
    driver.get("https://www.amazon.com/");
    Actions actions=new Actions(driver);

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.ARROW_DOWN).perform();

    WebElement text=driver.findElement(By.xpath("//div[.='See personalized recommendations']"));
    Assert.assertTrue(text.isDisplayed());//When I put this before scrollDowns,it failed because it wasn't visible on the page

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_UP).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_UP).perform();

    Thread.sleep(3000);
    actions.sendKeys(Keys.ARROW_UP).perform();


}













}
