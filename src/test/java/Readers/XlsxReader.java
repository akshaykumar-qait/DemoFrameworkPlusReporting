package Readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {

	private XSSFWorkbook myWorkBook;

	public String readit(String Key, String type) throws IOException {

		File myfile;

	OptionReader readopt= new OptionReader();
	
		
		
		String resFile = null;
				//"resource/Login_test/Excel_Files/urls.xlsx";
	
		
		if (type.equals("ids")) {
			resFile = readopt.optionFileReader("currentpath")+"Excel_Files/ids.xlsx";
		} else if (type.equals("locators")) {
			resFile = readopt.optionFileReader("currentpath")+"Excel_Files/locators.xlsx";
		} else if (type.equals("password")) {
			resFile = readopt.optionFileReader("currentpath")+"Excel_Files/passwords.xlsx";
		} else if (type.equals("urls")) {
			resFile = readopt.optionFileReader("currentpath")+"Excel_Files/urls.xlsx";
		}
		
		
		System.err.println(resFile);

		myfile = new File(resFile);
		FileInputStream fis = new FileInputStream(myfile);
		myWorkBook = new XSSFWorkbook(fis);

		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = mySheet.iterator();

		// Traversing over each row of XLSX file
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				if (cell.getStringCellValue().equals(Key)) {

					return cellIterator.next().toString();
				}

			}
		}
		return null;
	}

	void writeit(String Key, String value, String type) throws IOException {

		File myfile;

		
		
		String resFile = null;
		OptionReader objread = new OptionReader();
		if (type.equals("ids")) {
			resFile = objread .optionFileReader("currentpath")+"Excel_Files/ids.xlsx";
		} else if (type.equals("locators")) {
			resFile = objread.optionFileReader("currentpath")+"Excel_Files/locators.xlsx";
		} else if (type.equals("password")) {
			resFile = objread.optionFileReader("currentpath")+"Excel_Files/passwords.xlsx";
		} else if (type.equals("urls")) {
			resFile = objread.optionFileReader("currentpath")+"/Excel_Files/urls.xlsx";
		}

		myfile = new File(resFile);
		FileInputStream fis = new FileInputStream(myfile);
		myWorkBook = new XSSFWorkbook(fis);

		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		// Get iterator to all the rows in current sheet
		int rownum = mySheet.getLastRowNum();
		System.out.println(rownum);

		Row row = mySheet.createRow(++rownum);
		Cell cell = row.createCell(0);
		cell.setCellValue((String)Key);
		cell = row.createCell(1);
		cell.setCellValue((String)value);
		
		FileOutputStream os = new FileOutputStream(myfile);
		myWorkBook.write(os);

		
		
	}
	
	public static void main(String args[]) throws IOException
	{
		
	new XlsxReader().readit("Key", "type");	
		
	}


}
