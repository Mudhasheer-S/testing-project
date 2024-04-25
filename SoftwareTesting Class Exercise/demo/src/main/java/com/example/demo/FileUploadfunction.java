package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FileUploadfunction {

    public void uploadFile(WebDriver driver) {
        try {
            // upload file
            Thread.sleep(1000);
            driver.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\mudha\\Pictures\\Screenshots\\day5 2.png");

            // first name input
            driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")).sendKeys("hi");

            // country selector
            Thread.sleep(3000);
            WebElement coun = driver
                    .findElement(
                            By.xpath("/html/body/section/div/div/div[2]/form/div[10]/div/span/span[1]/span"));
            coun.click();
            Thread.sleep(2000);
            coun.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[6]")).click();

            //
            Thread.sleep(1000);
            driver.findElement(By.id("checkbox1")).click();

            //
            WebElement year = driver.findElement(By.id("yearbox"));
            Select se = new Select(year);
            se.selectByIndex(3);

            // language selector
            Thread.sleep(1000);
            coun = driver
                    .findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select"));
            coun.click();
            Thread.sleep(500);
            coun.findElement(
                    By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[1]/a"))
                    .click();

            //
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[5]/div/label[1]/input")).click();
        } catch (Exception e) {
            System.out.println("----------------" + e + "-----------------------------");
        }
    }
}
