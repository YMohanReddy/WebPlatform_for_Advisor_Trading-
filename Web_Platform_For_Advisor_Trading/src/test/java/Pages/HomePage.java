package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;
import Utils.ExtentReportManager;
import Utils.ReadPropertiesFile;
import Utils.ReadXLdata;

public class HomePage extends BaseTest {

	@FindBy(id = "neostoxlogo")
	WebElement logo_neoStox_homePage;

	@FindBy(id = "lbl_username")
	WebElement text_userName_homePage;

	@FindBy(id = "txt_instruments1")
	WebElement text_searchBox_homePage;

	@FindBy(id = "lnk_tradepanel")
	WebElement link_tradepanel_homePage;
	
	@FindBy(className = "label-dropdown")
	WebElement dropdown_searchSuggestions_homePage;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {
		// explicit wait condition
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// presenceOfElementLocated condition
		wait.until(ExpectedConditions.visibilityOf(text_searchBox_homePage));
		return driver.getTitle();
	}

	public String validateUserName() {
		return text_userName_homePage.getText();
	}

	public Boolean validateHomePageLoading() {
		return link_tradepanel_homePage.isDisplayed();
	}
	
	public void placeEquityOrder(String securityName, String securityType, String quantity, String purchaseType) {
//		System.out.println(securityName);
//		System.out.println(securityType);
//		System.out.println(quantity);
		//Enter security name in search box
		text_searchBox_homePage.sendKeys(securityName);
		ExtentReportManager.reportLogPass("Entered text in the search box: " +securityName);
		// select the first option in the search suggestions
		dropdown_searchSuggestions_homePage.click();
		ExtentReportManager.reportLogPass("Selected security symbol");
		//clear searched text so that search suggestions will disappear
		text_searchBox_homePage.clear();
		
	}

}
