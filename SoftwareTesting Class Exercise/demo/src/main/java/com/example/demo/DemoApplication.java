package com.example.demo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Index.html");

		driver.navigate().to("https://demo.automationtesting.in/Register.html");
		FileUploadfunction file = new FileUploadfunction();
		file.uploadFile(driver);

		Thread.sleep(5000);
		driver.close();


	}

}
