package com.durgasoft.selenium_maven.TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class hcServe_JSE {
	public WebDriver driver ;
	  @Test
	  public void f() throws Exception {
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("document.getElementById('txtUser').value='Taylco'");
		  js.executeScript("document.getElementById('txtPass').value='T@9415112570'");
		  js.executeScript("document.getElementById('btnOk').click()");
	  }
	  @BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://hcserve.com/crmprod/frmhhlilogin.aspx");
		  driver.manage().window().maximize();
	  }
}
