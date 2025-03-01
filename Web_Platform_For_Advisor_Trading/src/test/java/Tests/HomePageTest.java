package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.ReadPropertiesFile;
import Utils.ReadXLdata;

@Listeners(Utils.ExtentReportManager.class)
public class HomePageTest extends BaseTest {

	LoginPage logInPage;
	HomePage homePage;

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
	public void validateHomepageTitle() {
		Assert.assertEquals(homePage.validateTitle(), "Trade Panel :: Neostox", "Title is mismatching");
		try {
			driver.wait(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test (dataProvider = "tradeData")
	public void placeEquityOrderTest(String securityName, String securityType, String quantity, String purchaseType) {
		homePage.placeEquityOrder(securityName, securityType, quantity, purchaseType);
	}

	@DataProvider()
	public Object[][] tradeData() throws IOException {
		String excelName = ReadPropertiesFile.readDataFromPropertiesFile("testDataExcelName");
		String sheetName = ReadPropertiesFile.readDataFromPropertiesFile("testDataExcelSheetName");
		
//		System.out.println(excelName);
//		System.out.println(sheetName);

		return ReadXLdata.getData(excelName, sheetName);
	}
}
