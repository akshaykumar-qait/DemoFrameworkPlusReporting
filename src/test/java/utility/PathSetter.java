package utility;

import java.io.IOException;

import Readers.OptionReader;

public class PathSetter {
	
	
	public void setPath(String optionValue) throws IOException
	{
		new OptionReader().writeit("currentpath", optionValue);
	}
	
	

}
