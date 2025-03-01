package Base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utils.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static FileReader fr;
	
	public BaseTest() {
			FileReader fr;
			try {
				fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\Config.properties");
				properties.load(fr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void initialization() {

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicitly_Wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoadTimeOut));
	}
}







