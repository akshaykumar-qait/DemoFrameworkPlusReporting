package Tests.JsonWire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import utility.Datadecider;

public class HttpCalls {

	static Datadecider opt;


	public HttpCalls()  {

	}

	public HttpURLConnection getConnection(String urls, String type,String message) throws IOException, ParseException {

		URL url = new URL(urls);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(type);
		conn.setRequestProperty("Accept", "application/json");
		
		
		if(type.equals("POST"))
			
		{
			conn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		writer.write(message);
		writer.close();
		//conn.connect();
		}
		
		System.out.println(conn.getResponseCode() +" for "+type+"  "+urls);
		//System.out.println("Result "+this.getJson(conn).toJSONString());
		
		System.out.println();
		System.out.println();
		
		return conn;

	}

	public JSONObject getJson(HttpURLConnection conn) throws IOException, org.json.simple.parser.ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		JSONObject complete = new JSONObject();
		JSONParser parser = new JSONParser();
		
		complete = (JSONObject) parser.parse(br.readLine());
		
		System.out.println("Result is : " +complete);
		return complete;

	}

	
	public static void main(String Agrs[]) throws Exception
	{

		////////////////////////////////////////// open a browser
		////////////////////////////////////////// ////////////////////////////////////////
		String data = "{\"desiredCapabilities\" : {\"browserName\": \"chrome\"} }";
		HttpCalls object = new HttpCalls();
		HttpURLConnection conn = object.getConnection("http://localhost:4444/wd/hub/session", "POST", data);
		String sessionId = (String) ((JSONObject) (object.getJson(conn))).get("sessionId");

		///////////////////////////////////// hit a url
		////////////////////////////////////////////////////////////////////////////////////////
		JSONObject temp2 = null,temp = new JSONObject();
		temp.putIfAbsent("url", "https://www.google.com");
		conn = object.getConnection("http://localhost:4444/wd/hub/session/" + sessionId + "/url", "POST",
				temp.toJSONString());

		///////////////////////////////////// get current url
		///////////////////////////////////////////////////////////////////////////////

		conn = object.getConnection("http://localhost:4444/wd/hub/session/" + sessionId + "/url", "GET", "null");
		String currenturl = (String) ((JSONObject) (object.getJson(conn))).get("value");
		System.out.println(currenturl);

		/////////////////////////////////// find element on the page
		////////////////////////////////////////////////////////////////////////

		temp = new JSONObject();
		temp.put("using", "id");
		temp.put("value", "gsri_ok0");
		
		
		conn = object.getConnection("http://localhost:4444/wd/hub/session/" + sessionId + "/element", "POST",
				temp.toJSONString());
		temp2 = object.getJson(conn);
		String value = temp2.get("value").toString();
		temp2 = (JSONObject) new JSONParser().parse(value);
		String elementId = (String) temp2.get("ELEMENT");
		System.out.println(elementId);
		
	     ///////////////////////////////////////// click on the element ////////////////////
		conn = object.getConnection("http://127.0.0.1:4444/wd/hub/session/"+sessionId+"/element/"+elementId+"/click", "POST", temp.toJSONString());
		
	}
	
	
	
	
}
