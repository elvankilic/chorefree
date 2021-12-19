package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnMethods {
    //I want to order the tests like this login->homePage->search->results
    //homePage testcase depends on login

    @Test()
    public void logIn(){
        System.out.println("Login test");
    }

    @Test(dependsOnMethods ="logIn")
    public void homePage(){
        System.out.println("Home page test");
    }

    @Test(priority = 3)
    public void search(){
        System.out.println("Search test");
    }

    @Test(priority = 4)
    public void results(){
        System.out.println("Result Test");
    }

   
}
