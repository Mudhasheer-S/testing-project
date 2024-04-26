package com.example;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{

    public WebDriver driver;
    public WebDriverWait wait;
    public XSSFWorkbook workbook;
    public String search;

    @BeforeTest
    public void BeforeTestMethode() throws IOException{
        driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        workbook = new XSSFWorkbook("C:\\Users\\mudha\\Downloads\\testing-cc2\\src\\excel\\Book1.xlsx");

        XSSFSheet sheet = workbook.getSheetAt(0);

        search = sheet.getRow(0).getCell(0).getStringCellValue();
    }
    
    @Test
    public void searching(){
        
        WebElement book = driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[1]/a"));
        book.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[1]/a")));
        book.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys(search);
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/span/button")).click();

        wait.until(ExpectedConditions.urlContains("chetan%20bhagat"));
        String str = driver.findElement(By.cssSelector("#searchGrid > div > section.plp-white-space-search > section.plp-filter-selection > div > div.row.flex.justify-content-between.ml-0.mr-0 > div.result-showing-text.pl-md-m > h1")).getText();

        if(str.contains(search)){
            System.out.println("-------------------------------------"+str);
        }
    }

    @Test
    public void 
}
