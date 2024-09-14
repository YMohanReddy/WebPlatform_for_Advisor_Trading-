import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org. openqa. selenium. support. locators. RelativeLocator. with;

import java.util.List;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWindownMethodsInWebDriverInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().create();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		WebElement userId = driver.findElement(By.id("user-name"));
		
		
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window() .maximize();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String title = driver.getTitle();
		System.out.println(title);
		String pagesource = driver.getPageSource();
		System.out.println(pagesource);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
//		driver.quit();
		
		List<WebElement> wbs =driver.findElements(By.cssSelector(".inventory_list>div"));
		System.out.println(wbs);
		
		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String windowhandle = driver.getWindowHandle();
		System.out. println(windowhandle);
		driver.findElement(By.cssSelector("#newTabBtn")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		System.out. println(windowhandles);

		
	}

}
