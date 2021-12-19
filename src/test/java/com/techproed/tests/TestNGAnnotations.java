package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    @BeforeMethod//to use set up the test cases
    public void setUp(){
        System.out.println("Set Up");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method");
    }
    @Test(priority = 3)
    public void test1(){
        System.out.println("Test1");

    }
    @Ignore
    @Test(priority = 2)
    public void test2(){
        System.out.println("Test2");

    }
    @Test(priority = 1)
    public void test3(){
        System.out.println("Test3");

    }
    @Test(priority = 4)
    public void test4(){
        System.out.println("Test4");

    }


}
