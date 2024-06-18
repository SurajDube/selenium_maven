package com.durgasoft.selenium_maven.TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class CaptureScreenshot {
	public WebDriver driver;
	  @Test (enabled = false)
	  public void normalScreenshot() throws Exception {
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("F:\\Selenium Project\\hi.png"));
	  }
	  
	  @Test
	  public void ConditionBasedScreenshot() throws Exception {
		  List<WebElement> links=driver.findElements(By.partialLinkText("News Releases"));
		  System.out.println("Available links are:"+links.size());
		  for(int i=0;i<links.size();i++) {
			  System.out.println("Link Name:"+links.get(i).getText());
			  links.get(i).click();
			  Thread.sleep(5000);
		  }
		  if(!(links.size()==0)) {
			  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(src, new File("F:\\Selenium Project\\hi.png"));
		  }
	  }
	  @Test
	    public void dateNtimeScreenshot() throws Exception {
		  Date dt=new Date();
		  DateFormat dtformat=new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("F:\\Selenium Project\\hita.png"+dtformat.format(dt)+"sa.jpeg"));
	  }
	  @BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get("https://www.hitachi.com/");
		  driver.manage().window().maximize();
	  }
}