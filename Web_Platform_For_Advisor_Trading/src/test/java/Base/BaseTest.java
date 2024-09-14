package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static FileReader fr;
	
	@BeforeTest
	public void setup() throws IOException {
		if (driver == null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\Config.properties");
			properties.load(fr);
		}
		
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager .chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(properties.getProperty("URL"));
		}
		
		else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager .firefoxdriver().setup();
			driver=new ChromeDriver();
			driver.get(properties.getProperty("URL"));
		}
		
		else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager .edgedriver().setup();
			driver=new ChromeDriver();
			driver.get(properties.getProperty("URL"));
		}
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}







