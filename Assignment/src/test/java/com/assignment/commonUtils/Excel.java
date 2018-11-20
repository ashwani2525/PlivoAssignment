package com.assignment.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static  String fileName="./PropertiesFile/TestData.xlsx";
	public static  String sheetName="Sheet1";
	public static FileInputStream fis;
	public static Workbook workbook;
	public static FileOutputStream fos;
	
	
	public static String getExcelData(int rowNum,int cellNum)
	{
		File file = new File(fileName);
		
		
		try {
			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);
		    } 
		
		catch (Exception e) {
			
			e.printStackTrace();
		   }
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum); 
		Cell cell = row.getCell(cellNum);
		String data=cell.getStringCellValue();
		return data;
	}
	
	public static void setExcelData(String fileName, String sheetName, int rowNum, int cellNum, String data)
	{
		File file = new File(fileName);
				
		try {
			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);
		    } 
		
		catch (Exception e) {
			
			e.printStackTrace();
		   }
		
		Sheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(rowNum).createCell(cellNum).setCellValue("data");
		try {
			 fos= new FileOutputStream(fileName);
			 workbook.write(fos);
			 workbook.close();
     		}
	    catch(Exception e){
		  
		  e.printStackTrace();
		
	      }
		
		
	}
	public static void main(String[] args) {
	     Excel exe= new Excel();
	//	System.out.println("data is :"+exe.getExcelData(fileName,sheetName,16,13));
	}
		
}
