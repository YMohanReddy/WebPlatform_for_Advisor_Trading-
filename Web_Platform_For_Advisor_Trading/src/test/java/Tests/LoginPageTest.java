package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class LoginPageTest extends BaseTest{
	LoginPage loginPage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Neostox Virtual Stock Simulator | Trading Simulator | Option Simulator");
	}
	@Test(priority = 2)
	public void neoStockImgTest() {
		Assert.assertTrue(loginPage.validateNeoStockImg());
	}

	@Test(priority = 1)
	public void loginTest() {
		loginPage.loin();
	}
}
