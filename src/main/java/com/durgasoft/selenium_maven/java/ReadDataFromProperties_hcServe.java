package com.durgasoft.selenium_maven.java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromProperties_hcServe {
	public static final String path = "./hcServe.properties";
	
	public static String getData(String key) throws Exception {
		File f1 = new File(path);
		Properties p1=new Properties();
		FileInputStream fi1=new FileInputStream(f1);
		p1.load(fi1);
		return p1.getProperty(key);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getData("browser"));
		System.setProperty("webdriver.chrome.driver" , "F:\\driver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get(getData("produrl"));
		driver.manage().window().maximize();
		driver.findElement(By.name(getData("UserNameLoc"))).sendKeys(getData("txtUser"));
		driver.findElement(By.name(getData("PasswordLoc"))).sendKeys(getData("txtPass"));
		driver.findElement(By.name(getData("LoginLoc"))).click();
		driver.findElement(By.linkText(getData("LogoutLoc"))).click();	
	}

}
