package com.durgasoft.selenium_maven.TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Mouse_KeyBoard_Operations  {
	public WebDriver driver;
	
	  @Test (enabled = false)
	  public void dragNdrop() {
		  driver.switchTo().frame(0);
		  Actions a = new Actions(driver);
		  WebElement drag = driver.findElement(By.id("draggable"));
		  WebElement drop = driver.findElement(By.id("droppable")); /*https://jqueryui.com/droppable/*/
		  a.dragAndDrop(drag, drop).perform();
		//  a.clickAndHold(drag).moveToElement(drop).release().build().perform();
	  }
	@Test (enabled = false)
	  public void resizeObject() throws Exception {
		  driver.switchTo().frame(0);
		  WebElement drag = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		  Actions a = new Actions(driver);
/*		  a.dragAndDropBy(drag, 350, 150).perform(); /*https://jqueryui.com/resizable/*/
		  a.clickAndHold(drag).moveByOffset(300, 150).release().build().perform();
	  }
	  @Test (enabled = false)
	  public void rightClickonElement() {
		  WebElement link = driver.findElement(By.linkText("Draggable")); 
		  Actions a = new Actions(driver); /*https://jqueryui.com/resizable/*/
		  a.contextClick(link).perform();	  
	  }
	  @Test 
		public void Slider() {
			driver.switchTo().frame(0);
			WebElement drag = driver.findElement(By.xpath("//div[@id='slider']/span"));
			Actions a = new Actions(driver);
			// a.clickAndHold(drag).moveByOffset(200, 0).release().build().perform();
			a.dragAndDropBy(drag, 400, 0).perform(); /*https://jqueryui.com/slider/*/
		}
	  @BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://jqueryui.com/slider/");
		  driver.manage().window().maximize();
	  }
}
