package com.techproed.Homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartHomework extends TestBase {
    /*
    When user is on the page
    Click on Add to Cart
    And verifies the product is added to the cart
    And verifies the color,size,quantity,price shipping,total price
    And clicks on Proceed to checkOut
    Then verify Summary cart is displayed
    Then verify product is In stock
    Then verify the unit price matches the price that is on the Add to card page
    And user clicks on + sign
    Then verify the Total price is 2*price +shipping
    And click on proceed to checkout
    Then moves to Address stage
    And click on proceed to checkout

     */

    @Test
    public void addToCart() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");

        WebElement fadedShortSleeve=driver.findElement(By.xpath("(//div[@class='product-container'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(fadedShortSleeve).perform();
        driver.findElement(By.xpath("(//span[.='Add to cart'])[1]")).click();

        Thread.sleep(3000);
        WebElement successMessage= driver.findElement(By.xpath("//i[@class='icon-ok']"));
        Assert.assertTrue(successMessage.isDisplayed());

        String colorSize=driver.findElement(By.xpath("//span[.='Orange, S']")).getText();
        Assert.assertEquals(colorSize,"Orange, S");

        String quantity=driver.findElement(By.xpath("//strong[.='Quantity']")).getText();
        Assert.assertEquals(quantity,"Quantity");

        String quantityOfNumber=driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
        Assert.assertEquals(quantityOfNumber,"1");

        String total=driver.findElement(By.xpath("//strong[.='Total']")).getText();
        Assert.assertEquals(total,"Total");

        String totalPriceWithOutShipping=driver.findElement(By.xpath("//span[@id='layer_cart_product_price']")).getText();
        Assert.assertEquals(totalPriceWithOutShipping,"$16.51");

        String priceShipping=driver.findElement(By.xpath("(//strong[@class='dark'])[4]")).getText();
        Assert.assertEquals(priceShipping,"Total shipping ");

        String totalPrice=driver.findElement(By.xpath("(//strong[@class='dark'])[5]")).getText();
        Assert.assertEquals(totalPrice,"Total");

        WebElement proceedCheckOutButton= driver.findElement(By.xpath("(//i[@class='icon-chevron-right right'])[2]"));
        proceedCheckOutButton.click();

        WebElement title= driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(title.isDisplayed());
        Thread.sleep(2000);

       String inStock=driver.findElement(By.xpath("//*[.='In stock']")).getText();
       Assert.assertEquals(inStock,"In stock");

       String priceVerify=driver.findElement(By.xpath("(//span[@class='price'])[3]")).getText();
       Assert.assertEquals(priceVerify,"$16.51");

       WebElement plusSign= driver.findElement(By.xpath("//i[@class='icon-plus']"));
       plusSign.click();
       Thread.sleep(2000);

       String totalTwoProductPrice=driver.findElement(By.xpath("//span[@id='total_price']")).getText();
       Assert.assertEquals(totalTwoProductPrice,"$35.02");

       WebElement proceedToCheckout= driver.findElement(By.xpath("//*[.='Proceed to checkout']"));
       proceedToCheckout.click();

       WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
       email.sendKeys("older@gmail.com");
       WebElement password=driver.findElement(By.xpath("//input[@id='passwd']"));
       password.sendKeys("jr3ckq");
       WebElement signIn= driver.findElement(By.xpath("//i[@class='icon-lock left']"));
       signIn.click();

       driver.findElement(By.xpath("//i[@class='icon-chevron-right right']")).click();









    }
}
