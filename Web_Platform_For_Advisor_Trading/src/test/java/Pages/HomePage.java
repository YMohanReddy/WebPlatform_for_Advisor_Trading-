package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(id = "neostoxlogo")
	WebElement logo_neoStox_homePage;

	@FindBy(id = "lbl_username")
	WebElement text_userName_homePage;

	@FindBy(id = "txt_instruments1")
	WebElement text_searchBox_homePage;

	@FindBy(id = "lnk_tradepanel")
	WebElement link_tradepanel_homePage;

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

}
