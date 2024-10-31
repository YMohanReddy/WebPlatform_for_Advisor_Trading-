package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By txt_userName_loginPage = By.id("txt_mobilenumber");
//	@FindBy(id="txt_mobilenumber")
//	WebElement txt_userName_loginPage;
	 
	@FindBy(id="accessPinModel_accsspin")
	WebElement txt_password_loginPage;
	

	public void enterUserId(String userName) throws InterruptedException {
		driver.findElement(txt_userName_loginPage).sendKeys(userName);
//		txt_userName_loginPage.sendKeys(userName);
//		Thread.sleep(4000);
		driver.findElement(txt_userName_loginPage).submit();
	}
	
	public void enterPassword(String pass) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		txt_password_loginPage.sendKeys(pass.replace("\"", ""));
	}
	
	public void clickOnEnterButton() {
		txt_password_loginPage.sendKeys(Keys.ENTER);
	}
}



















