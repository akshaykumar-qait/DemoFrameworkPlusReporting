package Tests.Login;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.Datadecider;
import utility.InitWebdriver;
import utility.Wait_for_element;
import utility.WebElementUse;

public class LoginTest {

	static WebDriver driver;
	Login_help temp_Obj;
	WebElementUse useElements;
	Wait_for_element waitElements;
	Datadecider data;

	@BeforeTest
	public void Initializer() throws IOException {

		temp_Obj = new Login_help();
		driver = new InitWebdriver().Browserdecider();
		useElements = new WebElementUse();
		waitElements = new Wait_for_element();
		data = new Datadecider();

	}

	@Test
	public void TestA_user_invalid_login_check() throws Exception {

		
		driver = temp_Obj.open_the_login_page(driver, data.readit("edubaseurl", "urls"));

		driver = temp_Obj.login(driver, data.readit("eduid1", "ids"), data.readit("wrongpass", "password"));

		assertThat(driver.getCurrentUrl()).isEqualTo(data.readit("urlforinvalid2", "urls"));

		new WebElementUse().webElement_click_by_id(driver, data.readit("back_id", "locators"));

	}

	@Test(dependsOnMethods = "TestA_user_invalid_login_check")
	public void TestB_user_login_check() throws Exception {

		waitElements.waits_by_id(driver, data.readit("edulogo_id", "locators"));
		useElements.webElement_click_by_id(driver, data.readit("edulogo_id", "locators"));

		driver = temp_Obj.login(driver, data.readit("eduid1", "ids"), data.readit("correctpassid1", "password"));

		assertThat(driver.getCurrentUrl().substring(0, 48)).isEqualTo(data.readit("urlforvalid_edu", "urls"));

		

	}

	@Test(dependsOnMethods = "TestB_user_login_check")
	public void TestC_user_logout_check() throws Exception {
		waitElements.waits_by_css(driver, data.readit("logout_css", "locators"));
		useElements.webElement_click_by_css(driver, data.readit("logout_css", "locators"));

		assertThat(driver.getCurrentUrl()).isEqualTo(data.readit("edubaseurl", "urls"));



	}

	@AfterTest
	public void Closer() throws IOException {

		driver.close();

	}
	
    
}
