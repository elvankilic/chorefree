package com.techproed.Homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class IframeHomework extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.switchTo().frame(0);
        WebElement playVideo= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        playVideo.click();






    }









}
