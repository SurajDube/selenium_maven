package com.durgasoft.selenium_maven.TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByIndex {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
  @Test
  public void f() throws Exception {
	  fi=new FileInputStream("F:\\Selenium Project\\LiveProject_15Dec23_8AM\\selenium_maven\\testdata\\hmslogin.xlsx");
	  w=new XSSFWorkbook(fi);
	  s=w.getSheet("Sheet1");
	  r=null;
	  c=null;
	  r=s.getRow(3);
	  if(r==null)
		  r=s.createRow(3);
	  c=r.getCell(2);
	  if (c==null)
		  c=r.createCell(2);
	  c.setCellValue("Failed");
	  fo =new FileOutputStream("F:\\Selenium Project\\LiveProject_15Dec23_8AM\\selenium_maven\\testdata\\hmslogin.xlsx");
	  w.write(fo);
	  fo.close();
  }
}