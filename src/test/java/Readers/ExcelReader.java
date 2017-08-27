package Readers;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class ExcelReader {

	public String readit(String key, String type) throws IOException {

		File file;
		OptionReader objread = new OptionReader();

		String resFile = null;
		if (type.equals("ids")) {
			resFile = objread.optionFileReader("currentpath")+"/Excel_Files/ids.ods";
		} else if (type.equals("locators")) {
			resFile = objread.optionFileReader("currentpath")+"/Excel_Files/locators.ods";
		} else if (type.equals("password")) {
			resFile = objread.optionFileReader("currentpath")+"/Excel_Files/passwords.ods";
		} else if (type.equals("urls")) {
			resFile = objread.optionFileReader("currentpath")+"/Excel_Files/urls.ods";
		}

		file = new File(resFile);

		Sheet sheet;
		try {
			// Getting the 0th sheet for manipulation| pass sheet name as string
			sheet = SpreadSheet.createFromFile(file).getSheet(0);
  
			// Get row count and column count
			int nRowCount = sheet.getRowCount();

			// Iterating through each row of the selected sheet
			MutableCell cell = null;
			for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {
				cell = sheet.getCellAt(0, nRowIndex);

				// System.out.println(cell.getValue()+" "+key);

				if (key.equals(cell.getValue().toString())) {
					cell = sheet.getCellAt(1, nRowIndex);
					return cell.getValue().toString();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String args[])
	{
		
		
		
	}
	

}
