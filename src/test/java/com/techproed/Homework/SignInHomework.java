package com.techproed.Homework;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInHomework {
    WebDriver driver;

  @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

    }

    @Test
    public void signIn(){
       WebElement signIn= driver.findElement(By.xpath("//a[@class='login']"));
       signIn.click();

       WebElement email= driver.findElement(By.xpath("//input[@id='email_create']"));
       email.sendKeys("older@gmail.com");

       WebElement createAccount= driver.findElement(By.xpath("//i[@class='icon-user left']"));
       createAccount.click();

       WebElement createText= driver.findElement(By.xpath("//h1[.='Create an account']"));
       String actualText=createText.getText();
       String expectedText="CREATE AN ACCOUNT";
       Assert.assertEquals(actualText,expectedText);

       WebElement infoText= driver.findElement(By.xpath("//h3[.='Your personal information']"));
       String actualInfoText=infoText.getText();
       String expectedInfoText="YOUR PERSONAL INFORMATION";
       Assert.assertEquals(actualInfoText,expectedInfoText);

       WebElement titleText= driver.findElement(By.xpath("//label[.='Title']"));
       String actualTitleText=titleText.getText();
       String expectedTitleText="Title";
       Assert.assertEquals(actualTitleText,expectedTitleText);

       WebElement gender= driver.findElement(By.id("id_gender2"));
       gender.click();

       Faker faker=new Faker();

       WebElement firstname= driver.findElement(By.id("customer_firstname"));
       firstname.sendKeys("Ayse");


       WebElement lastName= driver.findElement(By.id("customer_lastname"));
       lastName.sendKeys("Kos");

       WebElement password= driver.findElement(By.id("passwd"));
       String pass=faker.lorem().characters(5,10);
       System.out.println(pass);
       password.sendKeys(pass);


       WebElement dateOfBirtday= driver.findElement(By.id("days"));
       Select optionsDays=new Select(dateOfBirtday);
       optionsDays.selectByIndex(1);

       WebElement dateOfBirtMonth= driver.findElement(By.xpath("//select[@id='months']"));
       Select optionsMonths=new Select(dateOfBirtMonth);
       optionsMonths.selectByIndex(2);

       WebElement dateOfBirtYear= driver.findElement(By.xpath("//select[@id='years']"));
       Select optionsYears=new Select(dateOfBirtYear);
       optionsYears.selectByIndex(3);

       WebElement newsletter= driver.findElement(By.xpath("//input[@id='newsletter']"));
       newsletter.click();

       WebElement firstName2= driver.findElement(By.xpath("//input[@id='firstname']"));
       firstName2.sendKeys("Ayse");

       WebElement lastName2= driver.findElement(By.xpath("//input[@id='lastname']"));
       lastName2.sendKeys("Kos");

       WebElement company= driver.findElement(By.xpath("//input[@id='company']"));
       company.sendKeys(faker.name().title());

       WebElement address1= driver.findElement(By.xpath("//input[@id='address1']"));
       address1.sendKeys(faker.address().fullAddress());

       WebElement address2= driver.findElement(By.xpath("//input[@id='address2']"));
       address2.sendKeys(faker.address().buildingNumber());

       WebElement city=driver.findElement(By.xpath("//input[@id='city']"));
       city.sendKeys(faker.address().cityName());

       WebElement state=driver.findElement(By.xpath("//select[@id='id_state']"));
       state.sendKeys(faker.address().state());

       WebElement zipCode=driver.findElement(By.xpath("//input[@id='postcode']"));
       zipCode.sendKeys("12345");

       WebElement country=driver.findElement(By.xpath("//select[@id='id_country']"));
       Select countryOptions=new Select(country);
       countryOptions.selectByIndex(1);



       WebElement mobilePhone=driver.findElement(By.xpath("//input[@id='phone_mobile']"));
       mobilePhone.sendKeys(faker.phoneNumber().cellPhone());

       WebElement assignAddress=driver.findElement(By.xpath("//input[@id='alias']"));
       assignAddress.sendKeys(faker.address().streetAddress());

       WebElement register=driver.findElement(By.xpath("//span[.='Register']"));
       register.click();

       driver.close();








































    }
























}
