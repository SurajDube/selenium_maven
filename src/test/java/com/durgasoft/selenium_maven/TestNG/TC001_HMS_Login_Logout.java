package com.durgasoft.selenium_maven.TestNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium_maven.java.BasePage;
import com.durgasoft.selenium_maven.java.PageUI;

import atu.testrecorder.ATUTestRecorder;

import org.testng.annotations.BeforeTest;

public class TC001_HMS_Login_Logout extends BasePage {
	
	public ATUTestRecorder recorder;
	
  @Test(description="This test case is to verify login & logout in hms.")
  public void hmsLoginLogout()  throws Exception {
	  PageUI p = new PageUI(driver);
	  p.hcServeLogin();
	  p.hcServeLogout();
	  recorder.stop();
  }
  
  @BeforeTest
  public void beforeTest() throws Exception{
	  recorder = new ATUTestRecorder("F:\\Selenium Project\\", "hcServe", false);
	  recorder.start();
	 /* browserLaunch("chrome", "https://www.seleniumbymahesh.com/");
	  browserLaunch("firefox", "https://www.seleniumbymahesh.com/");
	  browserLaunch("edge", "https://www.seleniumbymahesh.com/"); */
	  browserLaunch("chrome", "https://hcserve.com/crmprod/frmhhlilogin.aspx");  
	  browserLaunch("firefox", "https://hcserve.com/crmprod/frmhhlilogin.aspx");
	  browserLaunch("edge", "https://hcserve.com/crmprod/frmhhlilogin.aspx");
  }
}
