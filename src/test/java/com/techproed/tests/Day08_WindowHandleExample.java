package com.techproed.tests;

import com.techproed.utilities.TestBase;
import javafx.scene.effect.SepiaTone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day08_WindowHandleExample extends TestBase {
    //Method name:windowHandle
    //Given user is on the https://the-internet.herokuapp.com/windows
    //Then user verifies the text:"Opening a new window"
    //Then user verifies the title of the page is "The Internet"
    //When user clicks on the "Click Here" button
    //Then user verifies the new window title is "New Window"
    //When user goes back to the previous window and then verifies the title :"The Internet"

    @Test
    public void windowHandle(){

        driver.get("https://the-internet.herokuapp.com/windows");
        //Getting the handle of current window(window1)
        String window1handle= driver.getWindowHandle();
        System.out.println(window1handle);

        String window1text=driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        Assert.assertEquals(window1text,"Opening a new window");
        String window1title= driver.getTitle();
        Assert.assertEquals(window1title,"The Internet");


        WebElement clickHereButton=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();

        Set<String> allWindows=driver.getWindowHandles();
        System.out.println(allWindows);

        //REMEMBER driver IS ON window1Handle
        //We want to switch window2Handle
        for (String eachWindow:allWindows) {
            //loop1:eachWindow=window1handle
            //loop2:eachWindow=window2handle
            if (!eachWindow.equals(window1handle)) {
                driver.switchTo().window(eachWindow);
            }
        }
        String window2Title= driver.getTitle();
        Assert.assertEquals(window2Title,"New Window");









    }














}
