package com.durgasoft.selenium_maven.TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BBC_DynamicsLinks_Stale {
	
	public WebDriver driver;
	
	  @Test
	  public void f() throws Exception {
		  WebElement table = driver.findElement(By.xpath("//div[@class='most-popular']"));
		  List<WebElement> links = table.findElements(By.tagName("a"));
		  System.out.println("The availablelinks are:" + links.size());
		  for (int i = 0; i < links.size(); i++) {
		   System.out.println(links.get(i).getText());
		   links.get(i).click();
		   Thread.sleep(5000);
		   System.out.println(driver.getCurrentUrl());
		   driver.navigate().back();
		   table = driver.findElement(By.xpath("//div[@class='most-popular']"));
		   links = table.findElements(By.tagName("a"));
		  }
	}
	  @BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://www.bbc.com/");
		  driver.manage().window().maximize();
	  }
}