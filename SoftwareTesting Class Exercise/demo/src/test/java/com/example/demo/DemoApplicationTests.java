package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@SpringBootTest
class DemoApplicationTests {

	WebDriver driver;

	@BeforeTestMethod
	void Before_TestClass(){
		driver = new ChromeDriver();
		driver.get("https://economictimes.indiatimes.com/et-now/results");
	}

	@Test
	void contextLoads() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://economictimes.indiatimes.com/et-now/results");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/main/div[4]/nav/div[10]/a")).click();;

	}

	@AfterTestMethod
	void AfterTest(){
		driver.quit();
	}

}
