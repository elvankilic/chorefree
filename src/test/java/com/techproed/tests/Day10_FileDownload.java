package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_FileDownload extends TestBase {
    /*
    Create method:downloadTest()
    In the downloadTest() method,do following test:
    Go to https://the-internet.herokuapp.com/download
    Download Sunflower.jpg file
    Then verify if the file downloaded successfully
     */
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("Sunflower.jpg")).click();
        //After click,file wil be downloaded on the downloads folder
        //Get the path of the file that is in download folder
        //And check is the path exist

        Thread.sleep(1000);//Waiting for 1 second to complete the download
        //Pointing to the Sunflower.jpg in the Downloads folder

        String userFolder=System.getProperty("user.home");// C:\Users\okili ==>your home folder
        //System.out.println(userFolder);
        String path=userFolder+"\\Downloads\\Sunflower.jpg";
        //System.out.println(path);
        boolean isDownloaded= Files.exists(Paths.get(path));
        Assert.assertTrue(isDownloaded);

             //OR
        //Assert.assertTrue(driver.getPageSource().contains("Sunflower.jpg"));

    }











}
