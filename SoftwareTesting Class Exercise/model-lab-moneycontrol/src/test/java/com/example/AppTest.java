package com.example;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    public WebDriver driver;

    @BeforeTest
    public void Before() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com");
        Thread.sleep(1000);
    }

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"search_str\"]"));
        search.sendKeys("Reliance Industries");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")).click();

        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"ff_id\"]")));
        dropdown.selectByVisibleText("Axis Mutual Fund");
        Thread.sleep(1000);
        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"im_id\"]")));
        dropdown1.selectByValue("MAA587");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"invamt\"]")).sendKeys("100000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"stdt\"]")).sendKeys("2021-08-02");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"endt\"]")).sendKeys("2023-08-17");
        Thread.sleep(1000);
        driver.findElement(By
                .xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input"))
                .click();
        Thread.sleep(5000);

        WebElement row1 = driver.findElement(By.xpath(
                "//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]"));
        List<WebElement> row1c = row1.findElements(By.xpath(".//td"));
        WebElement row2 = driver.findElement(By.xpath(
                "//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[3]"));
        List<WebElement> row2c = row2.findElements(By.xpath(".//td"));
        for (WebElement cell : row1c) {
            System.out.println(cell.getText());
        }
        for (WebElement cell : row2c) {
            System.out.println(cell.getText());
        }
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
