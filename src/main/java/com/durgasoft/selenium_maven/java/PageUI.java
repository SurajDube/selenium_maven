package com.durgasoft.selenium_maven.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageUI {
	/*@FindBy(linkText="HMS") WebElement linkHMS;
	@FindBy(name="username") WebElement txtusername;
	@FindBy(name="password") WebElement txtpassword;
	@FindBy(name="submit") WebElement btnLogin;
	@FindBy(linkText="Logout") WebElement linkLogout; */
	
	@FindBy(name="txtUser") WebElement txtusername;
	@FindBy(name="txtPass") WebElement txtpassword;
	@FindBy(name="btnOk") WebElement btnLogin;
	@FindBy(linkText="Logout") WebElement linkLogout;
	
	
	public PageUI(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	public void hcServeLogin() {
		txtusername.sendKeys("TAYLCO");
		txtpassword.sendKeys("T@9415112570");
		btnLogin.click();
	}
	public void hcServeLogout() {
		linkLogout.click();
	}
}
