package com.techproed.utilities;

import com.beust.jcommander.StringKey;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    //This class read the configuration.properties data file

    //Create Properties instance
   private static Properties properties;



   //to open configuration.properties file using FileInputStream
   //when create fileInputStream object it gave red,
   // hover over to red and select try-catch
   static  {
       //path of the configuration file
       String path="configuration.properties";
        try {
            FileInputStream  fileInputStream= new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            //close the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This method will get the key from properties file
    //And returns the value as String
    //We create this method to read the file
    public static String getProperty(String key){
       String value=properties.getProperty(key);
       return value;

    }
    //TEST IF LOGIC WORKS
    public static void main(String[] args) {
        System.out.println(properties.getProperty("username"));
    }



}
