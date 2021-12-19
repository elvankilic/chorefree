package com.techproed.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    private Workbook workBook;
    private Sheet workSheet;
    private String path;

    public ExcelUtil(String path,String sheetName){//This Constructor is to open and access the excel file
        this.path=path;
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            workBook= WorkbookFactory.create(fileInputStream);
            workSheet=workBook.getSheet(sheetName);
            //Asserting if sheet has data or not
            Assert.assertNotNull(workSheet,"Worksheet:\""+ sheetName +"\" was not found\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //This will GET the list of the data in the EXCEL FILE
    //This is a list of map of String.This takes the data as string and will return
    public List<Map<String,String>> getDataList(){
      //Getting all columns
      List<String> columns=getColumnsNames();
      //Method will return this
      List<Map<String,String>> data=new ArrayList<>();
      for(int i=1; i<rowCount();i++){
          //get each row
          Row row=workSheet.getRow(i);
          //creating map of the row using the column and value
          //key=column, value=cell
          Map<String,String> rowMap=new HashMap<String, String>();
          for(Cell cell :row){
              int columnIndex=cell.getColumnIndex();
              rowMap.put(columns.get(columnIndex),cell.toString());
          }
          data.add(rowMap);

      }
      return data;

    }
    //Getting the number of columns in a specific single row
    public int columnCount(){
        return workSheet.getRow(0).getLastCellNum();
    }
    //How do you get the last row number?Index start at 0
    public int rowCount(){
        return workSheet.getLastRowNum()+1; }//adding 1 to get the actual count

    //When you enter row and column number,then you get the data
    public String getCellData(int rowNum,int colNum){
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //Going to the first row and reading each column one by one
    public List<String> getColumnsNames(){
        List<String> columns=new ArrayList<>();
        for(Cell cell:workSheet.getRow(0)){
            columns.add(cell.toString());
        }
        return  columns;
    }

    //Getting all data into two dimensional array and returning the data
    public String[][] getDataArray(){
        String[][] data=new String[rowCount()][columnCount()];
        for(int i=0; i<rowCount(); i++){
            for(int j=0; j<columnCount(); j++){
                String value=getCellData(i,j);
            }
        }
        return data;
    }

    //When you enter the row and column number,returning the value
    public void setCellData(String value,int rowNum,int colNum){
        Cell cell;
        Row row;
        row=workSheet.getRow(rowNum);
        cell=row.getCell(colNum);

        try {
        if (cell==null){//if there is no value,create a cell
            cell=row.createCell(colNum);
            cell.setCellValue(value);
        }else {
            cell.setCellValue(value);
        }
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workBook.write(fileOutputStream);
        fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }










    }

