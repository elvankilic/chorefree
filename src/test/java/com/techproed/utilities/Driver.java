package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Similar to TestBase,This is a utilities class
   private static WebDriver driver;

    //setup,create,and return the driver instance
    public static WebDriver getDriver(){
        /*
        If driver is not being used,if it is not pointing anywhere,then instantiate the driver
        We want to use only one driver in the entire framework
         */
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case "chrome-headless"://NOT COMMON
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

            }
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return  driver;
    }//getDriver ends here

    //Create closeDriver method to close the driver
    public static void closeDriver(){
        if(driver!=null){//if driver is pointing anywhere
            driver.quit();//quit when I call closeDriver
            driver=null;//assign  the driver to  null so when we call getDriver,we can open the driver

        }

    }
}
