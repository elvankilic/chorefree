package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Day10_FileUpLoadTest extends TestBase {
    /*
    Method name:fileUploadTest
    When user goes to https://the-internet.herokuapp.com/upload
    And click on the chooseFile button
    And selects an image from the computer
    And click on the upload button
    Then verify the File Uploaded!Message displayed
    */
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");

        //We cannot click on this element directly,instead of this
        //we find the path of the file then send it  to the element
        WebElement chooseFileButton= driver.findElement(By.id("file-upload"));
        String path="C:\\Users\\okili\\Desktop\\Sunflower.jpg";
        chooseFileButton.sendKeys(path);

        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.click();

        String messageText=driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText();
        Assert.assertEquals(messageText,"File Uploaded!");


    }















}
