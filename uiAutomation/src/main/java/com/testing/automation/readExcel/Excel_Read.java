package com.testing.automation.readExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read {
	
	public FileOutputStream fos = null;
	public FileInputStream fis;
	public String path;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public Excel_Read(String path){
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[][] getSheetData(String workbookName,String sheetName){
		String [][]dataSet = null;
		try {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			int totalCol = sheet.getRow(0).getLastCellNum();
			dataSet = new String[totalRow-1][totalCol];
			for(int i = 1;i<totalRow;i++){
				XSSFRow row = sheet.getRow(i);
				for(int j = 0;j<totalCol;j++){
					XSSFCell cell = row.getCell(j);
					if(cell.getCellType()==Cell.CELL_TYPE_STRING){
						dataSet[i-1][j] = cell.getStringCellValue();	
					}
					else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
						dataSet[i-1][j] = String.valueOf(cell.getNumericCellValue());	
					}
					
					else
						dataSet[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				}
			}
			return dataSet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataSet;
	}
	
	public String getCellData(String sheetName,String columnName, int rowNum){
		String cellData = null;
		try {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int totalCol = sheet.getRow(0).getLastCellNum();
			int colNum = 0;
			for(int j =0;j<totalCol;j++){

				if(row.getCell(j).getStringCellValue()==columnName){
					colNum = j;
					break;
				}
				row = sheet.getRow(rowNum-1);
				XSSFCell cell = row.getCell(colNum);
				if(cell.getCellType()==Cell.CELL_TYPE_STRING){
					cellData = cell.getStringCellValue();
					return cellData;
				}
				
				else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
					return "";
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cellData;
	}
}
