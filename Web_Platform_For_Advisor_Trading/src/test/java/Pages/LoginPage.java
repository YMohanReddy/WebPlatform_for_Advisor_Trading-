package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class LoginPage extends BaseTest {
	
//	Page Factory or Object Repository:
	@FindBy(id="txt_mobilenumber")
	WebElement text_userID_loginPage;

	@FindBy(id="accessPinModel_accsspin")
	WebElement text_password_loginPage;
	
	@FindBy(className ="navbar-brand")
	WebElement img_NeoStock_loginPage;
	
	
//	Page Factory for initializing page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
//		System.out.println("PF driver = " +driver);
	}
	
	
//	Actions: 
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateNeoStockImg() {
		System.out.println("printing img locator: "+img_NeoStock_loginPage);
		return img_NeoStock_loginPage.isDisplayed();
	}
	
	public HomePage loin() {
		driver.findElement(By.xpath("//li[@class='nav-item']/a[text()= 'Sign In']")).click();

		text_userID_loginPage.sendKeys(properties.getProperty("LoginId"));
		text_userID_loginPage.submit();


		text_password_loginPage.sendKeys(properties.getProperty("Password"));
		text_password_loginPage.submit();

		return new HomePage();
	}
}
