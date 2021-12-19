package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class Day11_ConfigReaderTest extends TestBase {
    @Test
    public void googleTitleTest(){
        //driver.get("https://www.google.com");//hard coded
        //https://www.google.com is the value of the url
        //We can read url by using getProperty method
        //We can just call getProperty method the class name
        driver.get(ConfigReader.getProperty("url"));


    }







}
