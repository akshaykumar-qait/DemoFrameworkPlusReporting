package utility;

import java.io.IOException;

import Readers.ExcelReader;
import Readers.JsonReader;
import Readers.OptionReader;
import Readers.XlsxReader;
import Readers.YamlReader;

public class Datadecider {

	public String readit(String Key, String type) throws IOException {
		String data_value = new OptionReader().optionFileReader("readfrom");

		System.out.println("datavalueeeeeeeeeeeeeeeeeeeeee  "+data_value);
		
		
		if (data_value.equals("json")) {
			String output = new JsonReader().readit(Key, type);
			return output;
		} else if (data_value.equals("ods")) {

			String output = new ExcelReader().readit(Key, type);
			return output;
		}

		else if (data_value.equals("xlsx")) {

			String output = new XlsxReader().readit(Key, type);
			return output;

		} else if (data_value.equals("yaml")) {

			String output = new YamlReader().readit(Key, type);
			return output;

		}

		return null;

	}

}
