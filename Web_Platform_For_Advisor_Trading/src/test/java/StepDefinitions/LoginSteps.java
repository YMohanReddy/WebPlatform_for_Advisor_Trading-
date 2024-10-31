package StepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.LoginPage;

public class LoginSteps {
	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static FileReader fr;
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() throws IOException {
			if (driver == null) {
				FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\Config.properties");
				properties.load(fr);
			}
			
			if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager .chromedriver().setup();
				driver=new ChromeDriver();
				driver.get(properties.getProperty("URL"));
			}
	}

	@When("^I enter valid (.*) and (.*)$")
	public void i_enter_valid_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("user: "+username +"  , password: "+password);
		LoginPage logInPage = new LoginPage(driver);
		logInPage.enterUserId(username);
		logInPage.enterPassword(password);
		
	}

	@And("I click on the login button")
	public void i_click_on_the_login_button() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.clickOnEnterButton();
	    
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("I should see a welcome message")
	public void i_should_see_a_welcome_message() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("I enter an invalid username or password")
	public void i_enter_an_invalid_username_or_password() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("I should see an error message indicating invalid credentials")
	public void i_should_see_an_error_message_indicating_invalid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Given("I am logged in to my account")
	public void i_am_logged_in_to_my_account() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("I click on the logout button")
	public void i_click_on_the_logout_button() {
	    // Write code here that turns the phrase above into concrete actions
	    	}

	@Then("I should be redirected to the login page")
	public void i_should_be_redirected_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("I should see a logout confirmation message")
	public void i_should_see_a_logout_confirmation_message() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
