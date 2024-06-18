package com.durgasoft.selenium_maven.TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Facebook_JSE {
	public WebDriver driver;
	
	  @Test
	  public void f() throws Exception {
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("document.getElementById('email').value='1995surajbcadubey@gmail.com'");
		  js.executeScript("document.getElementById('pass').value='QA.SurajDubey@100795'");
		  Thread.sleep(5000);
		  js.executeScript("document.getElementByName('login').click()");
	  }
	  @BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get("https://www.facebook.com/");
		  driver.manage().window().maximize();
	  }
}
