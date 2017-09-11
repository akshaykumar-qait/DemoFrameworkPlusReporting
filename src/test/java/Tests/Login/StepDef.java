package Tests.Login;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Datadecider;
import utility.InitWebdriver;
import utility.Wait_for_element;
import utility.WebElementUse;

public class StepDef {
	static WebDriver driver;
	Login_help temp_Obj;
	WebElementUse useElements;
	Wait_for_element waitElements;
	Datadecider data;

	@Given("^User intializes all the class objects$")
	public void user_intializes_all_the_class_objects() throws Throwable {
		temp_Obj = new Login_help();
		driver = new InitWebdriver().Browserdecider();
		useElements = new WebElementUse();
		waitElements = new Wait_for_element();
		data = new Datadecider();

	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver = temp_Obj.open_the_login_page(driver, data.readit("edubaseurl", "urls"));

	}



	@When("^enters wrong usernamepassword$")
	public void enters_username() throws Throwable {
		driver = temp_Obj.login(driver, data.readit("eduid1", "ids"), data.readit("wrongpass", "password"));
	}

	@Then("^user is landed to a invaid credentials url$")
	public void user_is_landed_to_a_invaid_credentials_url() throws Throwable {
		assertThat(driver.getCurrentUrl()).isEqualTo(data.readit("urlforinvalid2", "urls"));

	}

	@When("^the user click on the back button$")
	public void the_user_click_on_the_back_button() throws Throwable {

		new WebElementUse().webElement_click_by_id(driver, data.readit("back_id", "locators"));
	}

	@When("^clicks on the edulogo button$")
	public void clicks_on_the_edulogo_button() throws Throwable {

		waitElements.waits_by_id(driver, data.readit("edulogo_id", "locators"));
		useElements.webElement_click_by_id(driver, data.readit("edulogo_id", "locators"));

	}

	@When("^enter the correct username and password$")
	public void enter_the_correct_username_and_password() throws Throwable {

		driver = temp_Obj.login(driver, data.readit("eduid1", "ids"), data.readit("correctpassid1", "password"));

	}

	@Then("^the user is navigated to correct url$")
	public void the_user_is_navigated_to_correct_url() throws Throwable {

		assertThat(driver.getCurrentUrl().substring(0, 48)).isEqualTo(data.readit("urlforvalid_edu", "urls"));
	}

	@When("^the user click on the logout button$")
	public void the_user_click_on_the_logout_button() throws Throwable {
		waitElements.waits_by_css(driver, data.readit("logout_css", "locators"));
	}

	@Then("^the user is navigated to the base url$")
	public void the_user_is_navigated_to_the_base_url() throws Throwable {
		useElements.webElement_click_by_css(driver, data.readit("logout_css", "locators"));

		assertThat(driver.getCurrentUrl()).isEqualTo(data.readit("edubaseurl", "urls"));
		driver.close();

	}

}
