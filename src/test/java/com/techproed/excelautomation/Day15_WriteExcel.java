package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day15_WriteExcel {

    @Test
    public void writeExcel() throws Exception {
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
        Cell cell4=row.createCell(3);
        cell4.setCellValue("POPULATION");

        //Create a cell on the 2nd row 4th cell(index),and write 150000
        sheet.getRow(1).createCell(3).setCellValue("150000");
        //Create a cell on the 3rd row 4th cell(index3),and write 250000
        sheet.getRow(2).createCell(3).setCellValue("250000");
        //Create a cell on the 4th row 4th cell(index3),and write 54000
        sheet.getRow(3).createCell(3).setCellValue(54000);
        //WHEN I RUN ABOVE CODE AND OPEN THE EXCEL SHEET,WE WON'T SEE ANY DATA ON THE EXCEL

        //WE USE fileOutputStream to WRITE on the excel sheet
        //write and save the values on the excel sheet
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //close the files
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();



    }
}
