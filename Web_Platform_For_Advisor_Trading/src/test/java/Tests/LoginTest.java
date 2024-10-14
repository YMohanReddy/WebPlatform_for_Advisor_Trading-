package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utils.ReadXLdata;

public class LoginTest extends BaseTest{
	@Test(enabled = true)
	public void Login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//li[@class='nav-item']/a[text()= 'Sign In']")).click();

		WebElement mobileTextBox = driver.findElement(By.id("txt_mobilenumber"));
		mobileTextBox.sendKeys(properties.getProperty("LoginId"));
		mobileTextBox.submit();


		WebElement pinTextBox = driver.findElement(By.id("accessPinModel_accsspin"));
		pinTextBox.sendKeys(properties.getProperty("Password"));
		pinTextBox.submit();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test (dataProviderClass = ReadXLdata.class, dataProvider = "testDataFromExcel")
	public void Login1() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//li[@class='nav-item']/a[text()= 'Sign In']")).click();

		WebElement mobileTextBox = driver.findElement(By.id("txt_mobilenumber"));
		mobileTextBox.sendKeys(properties.getProperty("LoginId"));
		mobileTextBox.submit();


		WebElement pinTextBox = driver.findElement(By.id("accessPinModel_accsspin"));
		pinTextBox.sendKeys(properties.getProperty("Password"));
		pinTextBox.submit();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
