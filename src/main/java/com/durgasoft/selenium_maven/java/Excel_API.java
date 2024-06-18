package com.durgasoft.selenium_maven.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_API {
	public FileInputStream fi=null;
	public FileOutputStream fo=null;
	public XSSFWorkbook w=null;
	public XSSFSheet s=null;
	public XSSFRow r=null;
	public XSSFCell c=null;
	String filepath;
	
	public Excel_API(String File) throws Exception {
		this.filepath=File;
		fi = new FileInputStream(filepath);
		w = new XSSFWorkbook(fi);
		fi.close();
	}
	//Reading cell data from excel file by using column index
	public String getCellData(String sheetname, int colnum, int rownum) {
		try {
			s = w.getSheet(sheetname);
			r = s.getRow(rownum);
			c = r.getCell(colnum);
			
			if(c.getCellType()==CellType.STRING) {
				return c.getStringCellValue();			
			} else if(c.getCellType()==CellType.NUMERIC || c.getCellType()==CellType.FORMULA) {
				return String.valueOf(c.getNumericCellValue());
			} else if(c.getCellType()==CellType.BLANK) {
				return " ";
			}
			else {
				return String.valueOf(c.getBooleanCellValue());		
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No Matching Value";
		}		
	}
	//Reading cell data from excel file by using column name
	public String getCellData(String sheetname, String colname, int rownum) {
		try {
			int colnum=-1;
			s=w.getSheet(sheetname);
			r=s.getRow(0);
			for(int i=0;i<r.getLastCellNum();i++) {
				if(r.getCell(i).getStringCellValue().equalsIgnoreCase(colname)) {
					colnum=i;
				}
			}
			r=s.getRow(rownum);
			c=r.getCell(colnum);
			if(c.getCellType()==CellType.STRING) {
				return c.getStringCellValue();			
			}else if(c.getCellType()==CellType.NUMERIC || c.getCellType()==CellType.FORMULA) {
				return String.valueOf(c.getNumericCellValue());
			}else if(c.getCellType()==CellType.BLANK) {
				return " ";
			}
			else {
				return String.valueOf(c.getBooleanCellValue());		
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No Matching Value";
		}		
	}	
	//Writing cell data to excel by using column index
	public boolean setCellData(String sheetname, int colnum, int rownum, String value) throws Exception {
		try {
			s = w.getSheet(sheetname);
			r = s.getRow(rownum);
			if(r==null)
				r=s.createRow(rownum);
			c = r.getCell(colnum);
			if(c==null)
				c=r.createCell(colnum);
			c.setCellValue(value);
			fo = new FileOutputStream(filepath);
			w.write(fo);
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//Writing cell data to excel by using column name
		public void setCellData1(String sheetname, int colname, int rowum, String value) {			
	}
	//Identify no. of rows and column in excel file
		public int getRows(String sheetname) {
			s=w.getSheet(sheetname);
			int rowcount = s.getLastRowNum()+1;
			return rowcount;			
		}
		public int getcolumns(String sheetname) {
			s=w.getSheet(sheetname);
			r=s.getRow(0);
			int colcount = r.getLastCellNum();
			return colcount;
		}		
	}