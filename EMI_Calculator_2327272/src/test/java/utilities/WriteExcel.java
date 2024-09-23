package utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel 
{

	static FileInputStream fileIn;
	static FileOutputStream fileOut;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
	public String[] readExcelData(String fileName,String sheetName) throws IOException {
		
		fileIn = new FileInputStream(fileName);
		
		workBook = new XSSFWorkbook(fileIn);
		
		sheet = workBook.getSheet(sheetName);
		
		row = sheet.getRow(1);
		
		int cellCount = row.getLastCellNum();
		
		String[] testData = new String[cellCount];
		
		for(int c=0;c<cellCount;c++) {
			testData[c] = row.getCell(c).toString(); 
		}
		
		workBook.close();
		fileIn.close();
		
		return testData;
		
	}
	
	
public String[] readExcelData(String fileName,String sheetName,int rowNum) throws IOException {
		
		fileIn = new FileInputStream(fileName);
		
		workBook = new XSSFWorkbook(fileIn);
		
		sheet = workBook.getSheet(sheetName);
		
		row = sheet.getRow(rowNum);
		
		int cellCount = row.getLastCellNum();
		
		String[] testData = new String[cellCount];
		
		for(int c=0;c<cellCount;c++) {
			testData[c] = row.getCell(c).toString(); 
		}
		
		workBook.close();
		fileIn.close();
		
		return testData;
		
	}
	
	
	
	public void writeExcel(String[][] arr, String path) throws IOException {
			FileOutputStream file = new FileOutputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("Year");
			for(int i = 0; i < arr.length; i++) {
				XSSFRow row = sheet.createRow(i);
				for(int j = 0; j < arr[i].length; j++) {
					XSSFCell cell = row.createCell(j);
					cell.setCellValue(arr[i][j]);
				}
			}
			wb.write(file);
			wb.close();
			file.close();
		}
	
}
