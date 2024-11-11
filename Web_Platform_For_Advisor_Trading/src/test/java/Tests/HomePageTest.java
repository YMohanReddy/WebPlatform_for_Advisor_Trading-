package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Hooks.DataProvide;

@Listeners(Utils.ExtentReportManager.class)
public class HomePageTest extends BaseTest {

	LoginPage logInPage;
	HomePage homePage;

	public HomePageTest() {
		super();
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
	


	@Test
	public void validateHomepageTitleTest() throws IOException {
		homePage.handelHelloPopup();
		homePage.handelModelPopup();
		Assert.assertEquals(homePage.validateTitle(), "Trade Panel :: Neostox1", "Title is mismatching");
	}
	
	@Test
	public void validateHomePageHeaderTest() throws InterruptedException, IOException {
		homePage.handelHelloPopup();
		homePage.handelModelPopup();
		homePage.validateButtonForSideBar();
		homePage.validateExpandView();
		homePage.validateTitle();
		
	}

	@Test (dataProvider = "tradeData", dataProviderClass = DataProvide.class)
	public void addOrdersToQuickViewTest(String securityName, String securityType, String quantity, String purchaseType) {
		homePage.addOrdersToQuickView(securityName, securityType, quantity, purchaseType);
	}
	
	@Test
	public void validateNavigationMenuTest() throws IOException {
		homePage.handelHelloPopup();
		homePage.handelModelPopup();
		homePage.validateNavigationMenu();
		homePage.validateStrategiesSubLinks();
		homePage.validateScreensSubLinks();
		homePage.validateReportsSubLinks();
	}

	@Test (enabled=false)
	public void closeInfoModelPopupTest() throws IOException {
		homePage.handelModelPopup();
	}
	
	@Test (priority = 2)
	public void closeHelloPopupTest(){
		homePage.handelHelloPopup();
	}

	
	@Test (dataProvider = "tradeData", dataProviderClass = DataProvide.class, enabled = true)
	public void placeEquityOrderTest(String securityName, String securityType, String quantity, String purchaseType) throws IOException {
		homePage.handelHelloPopup();
		homePage.handelModelPopup();
		homePage.placeEquityOrder(securityName, securityType, quantity, purchaseType);
		homePage.navigateToPendingOrders();
		homePage.navigateToDaysHistory();
		homePage.logout();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void openChartsForWatchListItemsTest() throws IOException {
		homePage.handelHelloPopup();
		homePage.handelModelPopup();
		homePage.openChartsForWatchListItems();
	}
	
}
