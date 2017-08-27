package Readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SpecReader {
	
	
	public static void main(String agrs[]) throws IOException
	{
		
		File f = new File("resource/data.spec");

		BufferedReader b = new BufferedReader(new FileReader(f));

		String readLine = "";
		boolean flag = false;

		String arrsplit[],temp[] = null;
		while ((readLine = b.readLine()) != null) {
			
			arrsplit = readLine.split(" ");
			//if(arrsplit.length==3)
			{
				System.out.println(arrsplit[0]+arrsplit[1]+arrsplit[2]);
			}

		
		}

	}

}
