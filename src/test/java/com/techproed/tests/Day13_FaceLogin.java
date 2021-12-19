package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

//This is the test class,it is used to write test cases
public class Day13_FaceLogin {
    FaceLoginPage faceLoginPage;

    @Test
    public void logIn() throws InterruptedException {
        Driver.getDriver().get("https://www.facebook.com");
        faceLoginPage=new FaceLoginPage();
        faceLoginPage.username.sendKeys("Ayse Kos");
        faceLoginPage.password.sendKeys("123456");
        faceLoginPage.loginButton.click();

        Thread.sleep(2000);
        Assert.assertEquals(faceLoginPage.errorMessage.getText(),"The password you’ve entered is incorrect. Forgot Password?");

    }
}
