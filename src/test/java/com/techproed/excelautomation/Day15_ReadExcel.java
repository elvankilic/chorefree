package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day15_ReadExcel {

    @Test
    public void readTest() throws Exception {
        //We are locating  the path of the excel workbook(Capitals)
        //We get the path from Recourse->Capital.xlsx->copy->absolute path(You can delete the part before "src")
        String path=".\\src\\test\\java\\Resources\\Capitals.xlsx";

        //To open the file
        FileInputStream fileInputStream=new FileInputStream(path);
        //To open Workbook using fileInputstream
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //To open yhe first worksheet
        Sheet sheet=workbook.getSheetAt(0);//Reading the first sheet
        //To go to first ROW
        Row row=sheet.getRow(0);
        //To go to first cell on that first row and print
        Cell cell=row.getCell(0);
        System.out.println(cell);//COUNTRY


        //We can chain sheet,row,cell
        Cell usaCell=sheet.getRow(1).getCell(0);
        System.out.println(usaCell);//USA

        //If we need to get as a string(to use string's methods)
        String dcCell=sheet.getRow(1).getCell(1).toString();
        System.out.println(dcCell.length());//2
        Assert.assertEquals(dcCell,"DC");

        //We have some ready methods
        //Find the number of ROW
        int lastRowNum=sheet.getLastRowNum()+1;//index starts at 0,I need to add 1 to find the length of ROW
        System.out.println("Row Num: "+lastRowNum);

        System.out.println(sheet.getPhysicalNumberOfRows());//Return only the used row numbers.Index starts at 1.

        //Print country,capital key value pairs as map object
        //{USA,DC},{France,Paris}....
        Map<String,String> worldCapitals=new HashMap<>();
        int countryColumn=0;
        int capitalColumn=1;
       for (int rowNum=1;rowNum<lastRowNum;rowNum++){
           String country=sheet.getRow(rowNum).getCell(countryColumn).toString();
           //System.out.println(country);
           String capitals=sheet.getRow(rowNum).getCell(capitalColumn).toString();
           //System.out.println(capitals);
           worldCapitals.put(country,capitals);

       }
        System.out.println(worldCapitals);

       fileInputStream.close();
       workbook.close();




    }







}
