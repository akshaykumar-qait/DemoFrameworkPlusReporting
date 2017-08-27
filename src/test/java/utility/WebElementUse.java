package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementUse {
	
	public void webElement_open_url(WebDriver driver,String url)
	{
		driver.get(url);
	}
	
	public void webElement_click_by_id(WebDriver driver,String id)
	{
		driver.findElement(By.id(id)).click();
	}
	
	public void webElement_click_by_css(WebDriver driver,String css)
	{
	   driver.findElement(By.cssSelector(css)).click();;	
	}
	
	
	public void webElement_fill_by_id(WebDriver driver,String id,String keys)
	{
		
		
		driver.findElement(By.id(id)).sendKeys(keys);
	}
	
	
	public void webElement_fill_by_css(WebDriver driver,String id,String keys)
	{
		driver.findElement(By.cssSelector(id)).sendKeys(keys);
	}
	

}
