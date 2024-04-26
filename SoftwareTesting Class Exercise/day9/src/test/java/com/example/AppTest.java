package com.example;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest
{
    public WebDriver driver;
    public WebDriverWait wait; 

    @BeforeMethod
    public void BeforeTestMethode() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    @Test(priority = 1)
    public void loginCheck(){
        driver.findElement(By.cssSelector("#username")).sendKeys("S@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("P@ssword12");
        driver.findElement(By.id("submit")).click();
        wait.until(ExpectedConditions.urlContains("home"));
    }
    
    @Test(priority = 2)
    public void depositAmount(){
        driver.findElement(By.cssSelector("#username")).sendKeys("S@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("P@ssword12");
        driver.findElement(By.id("submit")).click();
        wait.until(ExpectedConditions.urlContains("home"));
        driver.findElement(By.cssSelector("#deposit-menu-item")).click();
        wait.until(ExpectedConditions.urlContains("deposit"));

        WebElement deposit = driver.findElement(By.cssSelector("#selectedAccount"));
        Select sel = new Select(deposit);
        sel.selectByIndex(1);

        driver.findElement(By.cssSelector("#amount")).sendKeys("5000");
        driver.findElement(By.cssSelector("#right-panel > div.content.mt-3 > div > div > div > div > form > div.card-footer > button.btn.btn-primary.btn-sm")).click();
    }

    @AfterMethod
    public void AfterTestMethode(){
        driver.quit();
    } 
}
