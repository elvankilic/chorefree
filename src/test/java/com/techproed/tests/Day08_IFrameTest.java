package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day08_IFrameTest extends TestBase {
    //Create a class:day08_IFrameTest
    //Create a method:iframeTest
    //Go to https://the-internet.herokuapp.com/iframe
    //Verify the Bolded text contains "Editor"
    //Locate the text box
    //Delete the text in the text box
    //Type "This text box is inside the iframe"
    //Verify the text Elemental Selenium text is displayed on the page

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String boldedText= driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));

     //Find the number of iframe
        int numOfIframe=driver.findElements(By.tagName("iframe")).size();
        System.out.println("There is "+numOfIframe+" iframe");

     //We are getting inside the iframe
       // driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");
       // driver.switchTo().frame("//iframe[@id='mce_0_ifr']");//It is not common usage
        driver.findElement(By.xpath("//p")).clear();

        driver.findElement(By.xpath("//p")).sendKeys("This text box is inside the iframe");
        Thread.sleep(3000);

     //We are getting outside the iframe
        driver.switchTo().parentFrame();//takes us to 1 upper level
        //OR
       // driver.switchTo().defaultContent();//takes to the root content.
        WebElement elementSelenium= driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        Assert.assertTrue(elementSelenium.isDisplayed());



















    }










}
