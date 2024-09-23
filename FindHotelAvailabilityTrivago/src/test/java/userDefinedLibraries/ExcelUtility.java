/*
 * This file consist code for read and write excel file
 */
package userDefinedLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static FileInputStream fileIn;
	static FileOutputStream fileOut;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static CellStyle style;
	
	
//	Reading Excel File Data
	public static String[] readExcelData(String fileName,String sheetName) {
		
		try {
			fileIn = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workBook = new XSSFWorkbook(fileIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = workBook.getSheet(sheetName);
		
		row = sheet.getRow(1);
		
		int cellCount = row.getLastCellNum();
		
		String[] testData = new String[cellCount];
		
		for(int c=0;c<cellCount;c++) {
			testData[c] = row.getCell(c).toString(); 
		}
		
		try {
			workBook.close();
			fileIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testData;
		
	}
	
//	Writing data into Excel 
	public static void writeData(String filename,String sheetName,int rowNumber,int cellNumber, String data){
		
		try {
			fileIn = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workBook = new XSSFWorkbook(fileIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = workBook.getSheet(sheetName);
		
		row = sheet.getRow(rowNumber);
		
		cell = row.createCell(cellNumber);
		
		cell.setCellValue(data);
		
		
		try {
			fileOut = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workBook.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workBook.close();
			fileIn.close();
			fileOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
//	Filling Green colors in Exel cells
	public static void fillGreenColor(String filePath,String sheetName,int rowNumber,int cellNumber){
			try {
			fileIn = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(fileIn);
			sheet = workBook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			cell = row.getCell(cellNumber);
			
			style = workBook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			
			fileOut = new FileOutputStream(filePath);
			workBook.write(fileOut);
			
			workBook.close();
			fileIn.close();
			fileOut.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
//	Filling Red colors in Exel cells
	public static void fillRedColor (String filePath,String sheetName,int rowNumber,int cellNumber){
		try {
		fileIn = new FileInputStream(filePath);
		workBook = new XSSFWorkbook(fileIn);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(cellNumber);
		
		style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fileOut = new FileOutputStream(filePath);
		workBook.write(fileOut);
		
		workBook.close();
		fileIn.close();
		fileOut.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
