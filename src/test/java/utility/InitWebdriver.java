package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Readers.OptionReader;

public class InitWebdriver {

static private WebDriver driver;

	public WebDriver Browserdecider() throws IOException {
		String machine_type = System.getProperty("os.name");
		String getbrowservalue = new OptionReader().optionFileReader("browser");
		if (getbrowservalue.equals("chrome")) 
		{
			
			System.out.println("value   "+  getbrowservalue +machine_type);
			
			if (machine_type.startsWith("Linux"))
			{
				System.setProperty("webdriver.chrome.driver", "resource/Linux_drivers/chromedriver");
			}
			else if (machine_type.startsWith("Windows")) 
			{
				System.setProperty("webdriver.chrome.driver", "resource/Windows_drivers/chromedriver.exe");
			}

			driver = new ChromeDriver();

			return driver;
		} else if (getbrowservalue.equals("firefox")) {
			
			if(machine_type.startsWith("Linux"))
			{
			System.setProperty("webdriver.gecko.driver", "resource/Linux_drivers/geckodriver");
			}
			else if(machine_type.startsWith("Windows"))
			{
				System.setProperty("webdriver.gecko.driver", "resource/Windows_drivers/geckodriver.exe");
			}
			
			driver = new FirefoxDriver();

			return driver;
		}

		return null;

	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}
