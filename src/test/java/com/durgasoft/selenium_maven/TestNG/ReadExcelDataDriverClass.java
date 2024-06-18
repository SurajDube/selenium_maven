package com.durgasoft.selenium_maven.TestNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium_maven.java.Excel_API;


public class ReadExcelDataDriverClass {
  @Test
  public void f() throws Exception {
	  Excel_API  e = new Excel_API("F:\\Selenium Project\\LiveProject_15Dec23_8AM\\selenium_maven\\testdata\\hmslogin.xlsx");
	  System.out.println("-------Read data from excel file by using colnum index-----");
	  System.out.println(e.getCellData("Sheet1", 0, 2));
	  System.out.println(e.getCellData("Sheet1", 1, 2));
	  System.out.println(e.getCellData("Sheet1", 2, 2));
	  
	  System.out.println("-------Read data from excel file by using colnum name-----");
	  System.out.println(e.getCellData("Sheet1", "User Name", 4));
	  System.out.println(e.getCellData("Sheet1", "Password", 4));
	  System.out.println(e.getCellData("Sheet1", "Results", 4));
	  
	  System.out.println("No. of rows in excel file:"+e.getRows("Sheet1"));
	  System.out.println("No. of columns in excel file:"+e.getcolumns("Sheet1"));
  }
}