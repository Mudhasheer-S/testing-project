package com.example;


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void shouldAnswerWithTrue()
    {
        try {
            
            FileInputStream file = new FileInputStream("C:\\Users\\mudha\\Downloads\\Book1.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(file);

            XSSFSheet sheet = wb.getSheet("Sheet1");

            Row row = sheet.getRow(0);

            System.out.println("---------------"+row.getCell(0));
            System.out.println(row.getCell(1));

        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
