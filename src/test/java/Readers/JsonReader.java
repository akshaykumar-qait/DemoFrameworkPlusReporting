package Readers;

import java.io.FileReader;

import org.apache.bcel.generic.NEW;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

	public String readit(String key, String type) {
    
		JSONParser parser = new JSONParser();
		String resFile = "";
		JSONObject mainJsonObj;
		
		
		try {
			
			System.err.println("type is"+type);
			
		     OptionReader readopt = new OptionReader();
			if(type.equals("ids"))
			{
				
				resFile=readopt.optionFileReader("currentpath")+"Json_Files/ids.json";
			}
			else if(type.equals("locators"))
			{
				resFile=readopt.optionFileReader("currentpath")+"Json_Files/locators.json";
			}
			else if(type.equals("password"))
			{
				resFile=readopt.optionFileReader("currentpath")+"Json_Files/passwords.json";
			}
			else if(type.equals("urls"))
			{
				resFile=readopt.optionFileReader("currentpath")+"Json_Files/urls.json";
			}
			
			
			mainJsonObj = (JSONObject) parser.parse(new FileReader(resFile));

		System.err.println(mainJsonObj);
		
		JSONArray locator = (JSONArray) mainJsonObj.get(type);
		JSONObject locators = (JSONObject) locator.get(0);

		
		return locators.get(key).toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	

}
