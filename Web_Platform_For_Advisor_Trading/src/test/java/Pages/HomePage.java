package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import Hooks.Hooks;
import Utils.CapturingScreenshot;

public class HomePage extends BaseTest {
	Hooks hooks = new Hooks();

	@FindBy(id ="menu-toggle")
	WebElement btn_leftSideMenu_homePage;
	
	@FindBy(xpath = "//div[@class='d-flex bg-light toggled' and @id='wrapper']")
	WebElement sideMenu_leftSideMenuHiddenState_homePage;
	
	@FindBy(className = "fullscreen")
	WebElement view_expandFunctionality_homePage;
	
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
	
	@FindBy(id ="lnk_tradepanel")
	WebElement lnk_tradepanel_homePage;
	
	@FindBy(xpath ="//ul[@class='navbar-nav']/li")
	WebElement link_navBar_homepage;
	
	@FindBy(id = "li_strategies")
	WebElement NavBarLink_strategiesNav_homepage;
	
	@FindBy(id = "li_analyzers")
	WebElement NavBarLink_screensNav_homepage;
	
	@FindBy(id = "reportsdropdown")
	WebElement NavBarLink_reportsNav_homepage;
	
	@FindBy(xpath ="//div[@id=\"modal_neostoxinfo\"]//a")
	WebElement popUp_modalDialogBox_HomePage;
	
	@FindBy(xpath = "//a[@id='lnk_userdashboard']")
	WebElement dashboardLinkUnderReports_homepage;
	
	@FindBy(xpath = "//div[@class='button-label']/div[@title='Buy']/button")
	WebElement btn_buyButtonInSearch_homepage;
	
	@FindBy(xpath = "//div[@id='div_autocalculate']/input[@id='rad_qty_auto']")
	WebElement radioBtn_AutoCalBtn_homepage;
	
	@FindBy(id = "txt_investmentpercent")
	WebElement textBox_investmentPercent_homepage;
	
	@FindBy(id = "lnk_placeorder")
	WebElement btn_buyButton_homepage;
	
	@FindBy(xpath = "//div[@id='modal_shiftedtrialnew']//div[@class='modal-content modalshadow mobbuysellmain']/div/a[@class='crossbtnmodal']")
	WebElement popUp_helloPopup_homepage;
	
	@FindBy(id = "rad_autolimit")
	WebElement radioBtn_limitAuto_BuySellModel;
	
	@FindBy(id = "lnk_pendingorders")
	WebElement link_pendingOrders_homepage;
	
	@FindBy(id = "lnk_completedorders")
	WebElement link_daysHistory_homepage;
	
	@FindBy(id = "lbl_curbalancetop")
	WebElement profileLink;
	
	@FindBy(id = "lnk_logout")
	WebElement logoutLink;
	
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateButtonForSideBar() throws InterruptedException {
		Assert.assertTrue(btn_leftSideMenu_homePage.isDisplayed());
		btn_leftSideMenu_homePage.click();

		Thread.sleep(4000);
		
		Assert.assertTrue(sideMenu_leftSideMenuHiddenState_homePage.isDisplayed(), "Side menu bar is still displaying even after clicking on hide toggle btn");
		btn_leftSideMenu_homePage.click();
	}
	
	public void validateExpandView() {
		view_expandFunctionality_homePage.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(text_searchBox_homePage.isDisplayed());
		view_expandFunctionality_homePage.click();
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

	
	public void addOrdersToQuickView(String securityName, String securityType, String quantity, String purchaseType) {
		//Enter security name in search box
		text_searchBox_homePage.sendKeys(securityName);
		// select the first option in the search suggestions
		dropdown_searchSuggestions_homePage.click();
		//clear searched text so that search suggestions will disappear
		text_searchBox_homePage.clear();
		
	}
	public void validateNavigationMenu() {
		lnk_tradepanel_homePage.click();
		for(int i=1;i<=5;i++) {
			WebElement ele = driver.findElement(By.xpath("//ul[@class='navbar-nav']/li["+i+"]"));
			hooks.mouseHoverOnElement(driver, ele);
		}
	}
	public void validateStrategiesSubLinks() {
		NavBarLink_strategiesNav_homepage.click();
		for(int i=1; i<=2; i++) {
			WebElement ele = driver.findElement(By.xpath("//li[@id='li_strategies']//li["+i+"]"));
			hooks.mouseHoverOnElement(driver, ele);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ele.click();
		}
	}
	public void validateScreensSubLinks() throws IOException {
//		popUp_modalDialogBox_HomePage.click();
		NavBarLink_screensNav_homepage.click();
		for(int i=1; i<=8; i++) {
			WebElement ele = driver.findElement(By.xpath("//li[@id='li_analyzers']//li["+i+"]"));
			hooks.mouseHoverOnElement(driver, ele);
			ele.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void handelModelPopup() throws IOException {
		CapturingScreenshot.getScreenshot();
		hooks.explicitlyWaitFor(driver, popUp_modalDialogBox_HomePage, 35);
		popUp_modalDialogBox_HomePage.click();
		hooks.waitForSeconds(3000);
	}
	public void validateReportsSubLinks() {
		NavBarLink_reportsNav_homepage.click();
		dashboardLinkUnderReports_homepage.click();
		hooks.findElementById(driver, "lnk_daywisesummary").click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		hooks.findElementById(driver, "lnk_tradehistory").click();
	}

	
	public void placeEquityOrder(String securityName, String securityType, String quantity, String purchaseType) throws IOException {
		//Enter security name in search box
		text_searchBox_homePage.sendKeys(securityName);
		// move to first option in the search suggestions
		hooks.mouseHoverOnElement(driver, dropdown_searchSuggestions_homePage);
		btn_buyButtonInSearch_homepage.click();
		hooks.waitForSeconds(3000);
//		handelModelPopup();
		radioBtn_limitAuto_BuySellModel.click();
		btn_buyButton_homepage.click();
		hooks.waitForSeconds(4000);
	}
	
	public void navigateToPendingOrders() {
		link_pendingOrders_homepage.click();
		hooks.waitForSeconds(2000);
	}
	
	public void navigateToDaysHistory() {
		link_daysHistory_homepage.click();
		hooks.waitForSeconds(1000);
	}

	public void handelHelloPopup() {
		hooks.waitForSeconds(10000);
//		hooks.acceptPopup(driver);
		popUp_helloPopup_homepage.click();
	}
	

	public void logout() {
		hooks.mouseHoverOnElement(driver, profileLink);
		logoutLink.click();
	}
	
	public void openChartsForWatchListItems() {
		for(int i=1; i<10; i++) {
			hooks.mouseHoverOnElement(driver, driver.findElement(By.xpath("//div[@id='sortable']//a["+i+"]")));
			hooks.waitForSeconds(2000);
			WebElement element = driver.findElement(By.xpath("//div[@id='sortable']//a["+i+"]//span[@title='Open Chart']"));
			if(element.isDisplayed()) {
			element.click();
			hooks.waitForSeconds(2000);
			}
			else {break;}
		}
	}
}
