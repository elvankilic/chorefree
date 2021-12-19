package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_fileExistTest  {

    @Test
    public void isExist(){
        //Path of a file that we want to test
        String path="C:\\Users\\okili\\Desktop\\Sunflower.jpg";

        //We need JAVA to deal with Files
        boolean isExist=Files.exists(Paths.get(path));

        //If file exist,returns true otherwise returns false
        Assert.assertTrue(isExist);

    }








}
