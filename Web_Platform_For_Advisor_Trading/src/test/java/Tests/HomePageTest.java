package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends BaseTest{

	LoginPage logInPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@Test
	public void validateHomepageTitle() {
		Assert.assertEquals(homePage.validateTitle(), "Trade Panel :: Neostox", "Title is mismatching");
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		logInPage = new LoginPage();
		homePage = logInPage.loin();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
