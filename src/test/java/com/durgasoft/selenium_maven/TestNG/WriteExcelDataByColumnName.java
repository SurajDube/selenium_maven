package com.durgasoft.selenium_maven.TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByColumnName {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
	public XSSFFont font;
	public XSSFCellStyle style;
  @Test
  public void f() throws Exception {
	  fi=new FileInputStream("F:\\Selenium Project\\LiveProject_15Dec23_8AM\\selenium_maven\\testdata\\hmslogin.xlsx");
	  w=new XSSFWorkbook(fi);
	  s=w.getSheet("Sheet1");
	  r=null;
	  c=null;
	  int column=-1;
	  r=s.getRow(0);
	  for (int i=0;i<r.getLastCellNum();i++) {
		  System.out.println(r.getCell(i).getStringCellValue());
		  if(r.getCell(i).getStringCellValue().equalsIgnoreCase("Results")); {
			  column=i;
		  }		  
	  }
	  r=s.getRow(1);
	  if(r==null)
		  r=s.createRow(1);
	  c=r.getCell(column);
	  if(c==null)
		  c=r.createCell(column);
	  c.setCellValue("BLOCKED");
	  fo=new FileOutputStream("F:\\Selenium Project\\LiveProject_15Dec23_8AM\\selenium_maven\\testdata\\hmslogin.xlsx");
	  w.write(fo);  
  }
}
