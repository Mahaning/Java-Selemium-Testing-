package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriter {

	public DataWriter() {
	}
	public static void putData(XSSFWorkbook workbook, List<String> list, int column, String fileName, List<String> headers) throws IOException {
	    // Get the sheet from the workbook
	    XSSFSheet sheet = workbook.getSheet("Data");  // Sheet name set to "Data"
	    if (sheet == null) {
	        sheet = workbook.createSheet("Data");
	    }

	    // Create a row for headers if it doesn't exist
	    Row headerRow = sheet.getRow(0);
	    if (headerRow == null) {
	        headerRow = sheet.createRow(0);
	    }

	    // Set the header for the current column
	    Cell headerCell = headerRow.createCell(column);
	    headerCell.setCellValue(headers.get(column));

	    // Iterate through each row in the list
	    for (int i = 0; i < list.size(); i++) {
	        // Create a new row in the sheet
	        Row row = sheet.getRow(i + 1);  // Offset by 1 for the header row
	        if (row == null) {
	            row = sheet.createRow(i + 1);  // Offset by 1 for the header row
	        }

	        // Create a cell in the current row at the specified column
	        Cell cell = row.createCell(column);

	        // Write data to the cell
	        cell.setCellValue(list.get(i));
	    }
	}

	public static void saveWorkbook(XSSFWorkbook workbook, String fileName) throws IOException {
	    // Create a FileOutputStream to write data to the file
	    FileOutputStream out = new FileOutputStream(
	        new File(System.getProperty("user.dir") + "\\testData\\" + fileName + ".xlsx"));

	    // Write the workbook data to the file
	    workbook.write(out);

	    // Close the workbook and file output stream
	    workbook.close();
	    out.close();
	}

}
