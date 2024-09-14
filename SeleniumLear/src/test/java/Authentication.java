import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authentication {


	public static String username = "admin"; //Reading thing this from external XLS or CSV
	public static String password = "admin"; //Reading thing this from external XLS or CSV

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager. edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");

	}


}

