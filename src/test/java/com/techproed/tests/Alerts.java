package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts {

//   Go to https://the-internet.herokuapp.com/javascript_alerts
//   Create a class:Alerts
//   Create setUp method
//   Create 3 test methods:
//   acceptAlert() =>click on the first alert,verify the text "I am a JS Alert",click OK,and Verify "You successfully clicked an alert"
//   dismissAlert() => click on the second alert, verify text " I am a JS Confirm",click cancel,and Verify "You clicked :Cancel"
//   sendKeysAlert() => click on the third alert, verify text " I am a JS Prompt",type "Hello Word", click OK,and Verify "You entered:Hello Word"

WebDriver driver;
@BeforeMethod
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}
@Test
    public void acceptAlert() throws InterruptedException {
    WebElement firstButton= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
    firstButton.click();
    String actualTextOfFirstAlert=driver.switchTo().alert().getText();
    Thread.sleep(3000);
    Assert.assertEquals(actualTextOfFirstAlert,"I am a JS Alert");
    driver.switchTo().alert().accept();
    Thread.sleep(3000);
    String actualResultText=driver.findElement(By.id("result")).getText();
    Assert.assertEquals(actualResultText,"You successfully clicked an alert");

}
@Test
    public void dismissAlert() throws InterruptedException {
    WebElement secondAlert= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
    secondAlert.click();
    String actualSecondOfText=driver.switchTo().alert().getText();
    Thread.sleep(3000);
    Assert.assertEquals(actualSecondOfText,"I am a JS Confirm");
    driver.switchTo().alert().dismiss();
    Thread.sleep(3000);
    String actualResultCancel=driver.findElement(By.id("result")).getText();
    Assert.assertEquals(actualResultCancel,"You clicked: Cancel");


}
@Test
    public void sendKeysAlert() throws InterruptedException {
    WebElement thirdAlert= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
    thirdAlert.click();
    String actualThirdOfText=driver.switchTo().alert().getText();
    Thread.sleep(3000);
    Assert.assertEquals(actualThirdOfText,"I am a JS prompt");
    driver.switchTo().alert().sendKeys("Hello Word");
    driver.switchTo().alert().accept();
    String actualResultOfType=driver.findElement(By.id("result")).getText();
    Assert.assertEquals(actualResultOfType,"You entered: Hello Word");



    }
    @AfterMethod
    public void tearDown(){
    driver.close();
    }









}
